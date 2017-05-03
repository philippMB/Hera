package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.*;
import View_Interfaces.IProcessClassificationView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

/**
 * Created by phlippe on 01.05.17.
 */
public abstract class ProcessClassificationView
	extends FormWindow
	implements IProcessClassificationView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.SAVE,
			ViewActions.CANCEL
	};

	protected IModelGetData myModel;
	private JTextField fieldID;
	private JTable tableReferences;
	private JComboBox<String> comboBoxClass;
	private JComboBox<String> comboBoxTyp_DFP;
	private JComboBox<String> comboBoxTyp_TFP;
	private JTextField fieldRET_DFP;
	private JTextField fieldDET_DFP;
	private JTextField fieldFTR_TFP;
	private JTextField fieldDET_TFP;
	private JPanel panelDFP;
	private JPanel panelTFP;
	private JPanel panelHolder;


	public ProcessClassificationView(IModelGetData model, String ID)
	{
		super();
		myModel = model;
		setButtonActions(BUTTON_ACTIONS);

		loadInternRequirement(ID);

		init();
	}

	@Override
	protected void init()
	{

		buildDFPSelection();
		buildTFPSelection();

		panelHolder = new JPanel();
		panelHolder.add(panelDFP);
		panelHolder.add(panelTFP);

		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_PROCESS_CLASSIFICATION));
		fieldID = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_ID),
				getMyRequirement().getID(),
				false
		);
		tableReferences = myBuilder.addTable(
				myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES),
				calcReferenceTableEntries()
		);

		buildReqSpecificDescription();

		comboBoxClass = myBuilder.addNamedDropdownList(
				myTextBundle.getParameterText(TextNameConstants.PAR_ELEMENTARY_PROCESSES),
				getSelectionClassNames()
		);
		myBuilder.addPanel(panelHolder);
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		getContentPane().add(myBuilder.getResult());

		setUpForRequirement();
	}

	private String[][] calcReferenceTableEntries()
	{
		String[][] tableEntries;
		ArrayList<String> referencesID = new ArrayList<>(Arrays.asList(getMyRequirement().getReferenceIDs()));
		int amountReferences = referencesID.size();
		tableEntries = new String[amountReferences][1];

		for(int row = 0; row < amountReferences; row++)
		{
			tableEntries[row][0] = referencesID.get(row);
		}

		return tableEntries;
	}

	private void buildDFPSelection()
	{
		panelDFP = new JPanel();
		panelDFP.setLayout(new BorderLayout());
		panelDFP.setSize(200,400);	//Formula-Size
		PanelBuilder myDFPBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(panelDFP);

		comboBoxTyp_DFP = myDFPBuilder.addNamedDropdownList(
				myTextBundle.getParameterText(TextNameConstants.PAR_TYP),
				getSelectionDFPNames()
		);
		fieldDET_DFP = myDFPBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_DET),
				""
		);
		fieldRET_DFP = myDFPBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_RET),
				""
		);

		panelDFP.add(myDFPBuilder.getResult(),BorderLayout.CENTER);
	}

	private void buildTFPSelection()
	{
		panelTFP = new JPanel();
		panelTFP.setLayout(new BorderLayout());
		panelTFP.setSize(200,400);	//Formula-Size
		PanelBuilder myTFPBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(panelTFP);

		comboBoxTyp_TFP = myTFPBuilder.addNamedDropdownList(
				myTextBundle.getParameterText(TextNameConstants.PAR_TYP),
				getSelectionTFPNames()
		);
		fieldDET_TFP = myTFPBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_DET),
				""
		);
		fieldFTR_TFP = myTFPBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_FTR),
				""
		);

		panelDFP.add(myTFPBuilder.getResult(),BorderLayout.CENTER);
	}

	private String[] getSelectionClassNames()
	{
		String[] selectionClassNames = new String[]{
				"---",
				myTextBundle.getParameterText(TextNameConstants.PAR_TFP),
				myTextBundle.getParameterText(TextNameConstants.PAR_DFP)
		};
		return selectionClassNames;
	}

	private String[] getSelectionTFPNames()
	{
		String[] selectionTFPNames = new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_EI),
				myTextBundle.getParameterText(TextNameConstants.PAR_EO),
				myTextBundle.getParameterText(TextNameConstants.PAR_EQ)
		};
		return selectionTFPNames;
	}

	private String[] getSelectionDFPNames()
	{
		String[] selectionDFPNames = new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_ILF),
				myTextBundle.getParameterText(TextNameConstants.PAR_EIF)
		};
		return selectionDFPNames;
	}

	private void setUpForRequirement()
	{
		IRequirement myReq = getMyRequirement();
		String reqID = myReq.getID();
		ICostEstimation myCostEstimation = myModel.getCostEstimation();

		if(myCostEstimation.hasIDDataFP(reqID))
		{
			IDataFP myDataFP = myCostEstimation.getDataFPByID(reqID);
			setFieldsOnDataFP(myDataFP);
			setComboBoxOnDataFP(myDataFP);
			showDataFP();
		}
		else
		{
			if(myCostEstimation.hasIDTransaktionFP(reqID))
			{
				ITransactionFP myTransactionFP = myCostEstimation.getTransactionFPByID(reqID);
				setFieldsOnTransactionFP(myTransactionFP);
				setComboBoxOnTransactionFP(myTransactionFP);
				showTransactionFP();
			}
			else
			{
				showDefault();
			}
		}
	}

	private void setFieldsOnTransactionFP(ITransactionFP transactionFP)
	{
		int DET = transactionFP.getDET();
		int FTR = transactionFP.getFTR();
		fieldDET_TFP.setText(Integer.toString(DET));
		fieldFTR_TFP.setText(Integer.toString(FTR));
	}

	private void setFieldsOnDataFP(IDataFP dataFP)
	{
		int DET = dataFP.getDET();
		int RET = dataFP.getRET();
		fieldDET_DFP.setText(Integer.toString(DET));
		fieldRET_DFP.setText(Integer.toString(RET));
	}

	private void setComboBoxOnDataFP(IDataFP dataFP)
	{
		ClassOfDataFP classOfDataFP = dataFP.getType();
		switch(classOfDataFP)
		{
			case EIF_EXTERNAL_INPUT_FILE:
				comboBoxTyp_DFP.setSelectedIndex(0);
				break;
			case ILF_INTERNAL_LOGICAL_FILE:
				comboBoxTyp_DFP.setSelectedIndex(1);
				break;
		}
	}

	private void setComboBoxOnTransactionFP(ITransactionFP transactionFP)
	{
		ClassOfTransactionFP classOfTransactionFP = transactionFP.getType();
		switch(classOfTransactionFP)
		{
			case EI_INPUT:
				comboBoxTyp_DFP.setSelectedIndex(0);
				break;
			case EO_OUTPUT:
				comboBoxTyp_DFP.setSelectedIndex(1);
				break;
			case EQ_QUERY:
				comboBoxTyp_DFP.setSelectedIndex(2);
				break;
		}
	}

	@Override
	public void showDataFP()
	{
		panelTFP.setVisible(false);
		panelDFP.setVisible(true);
	}

	@Override
	public void showTransactionFP()
	{
		panelDFP.setVisible(false);
		panelTFP.setVisible(true);
	}

	@Override
	public void showDefault()
	{
		panelDFP.setVisible(false);
		panelTFP.setVisible(false);
	}

	@Override
	public Class getSelectedClass()
	{
		Class selectedClass;

		String selectedItem = (String)comboBoxClass.getSelectedItem();
		final String DFP_Text = myTextBundle.getParameterText(TextNameConstants.PAR_DFP);
		final String TFP_Text = myTextBundle.getParameterText(TextNameConstants.PAR_TFP);

		if(selectedItem.equals(DFP_Text))
		{
			selectedClass = IDataFP.class;
		}
		else
		{
			if(selectedItem.equals(TFP_Text))
			{
				selectedClass = ITransactionFP.class;
			}
			else
			{
				selectedClass = null;
			}
		}

		return selectedClass;
	}

	@Override
	public ClassOfDataFP getSelectedClassOfDFP()
	{
		ClassOfDataFP selectedClass;

		String selectedItem = (String)comboBoxTyp_DFP.getSelectedItem();
		final String EIF_Text = myTextBundle.getParameterText(TextNameConstants.PAR_EIF);
		final String ILF_Text = myTextBundle.getParameterText(TextNameConstants.PAR_ILF);

		if(selectedItem.equals(EIF_Text))
		{
			selectedClass = ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE;
		}
		else
		{
			if(selectedItem.equals(ILF_Text))
			{
				selectedClass = ClassOfDataFP.ILF_INTERNAL_LOGICAL_FILE;
			}
			else
			{
				selectedClass = null;
			}
		}

		return selectedClass;
	}

	@Override
	public ClassOfTransactionFP getSelectedClassOfTFP()
	{
		ClassOfTransactionFP selectedClass;

		String selectedItem = (String)comboBoxTyp_TFP.getSelectedItem();
		final String EI_Text = myTextBundle.getParameterText(TextNameConstants.PAR_EI);
		final String EO_Text = myTextBundle.getParameterText(TextNameConstants.PAR_EO);
		final String EQ_Text = myTextBundle.getParameterText(TextNameConstants.PAR_EQ);

		if(selectedItem.equals(EI_Text))
		{
			selectedClass = ClassOfTransactionFP.EI_INPUT;
		}
		else
		{
			if(selectedItem.equals(EO_Text))
			{
				selectedClass = ClassOfTransactionFP.EO_OUTPUT;
			}
			else
			{
				if(selectedItem.equals(EQ_Text))
				{
					selectedClass = ClassOfTransactionFP.EQ_QUERY;
				}
				else
				{
					selectedClass = null;
				}
			}
		}

		return selectedClass;
	}

	@Override
	public String getDET()
	{
		String entryDET;

		Class selectedClass = getSelectedClass();
		if(selectedClass.equals(ITransactionFP.class))
		{
			entryDET = fieldDET_TFP.getText();
		}
		else
		{
			if(selectedClass.equals(IDataFP.class))
			{
				entryDET = fieldDET_DFP.getText();
			}
			else
			{
				entryDET = null;
			}
		}

		return entryDET;
	}

	@Override
	public String getRET()
	{
		String entryRET;
		entryRET = fieldRET_DFP.getText();

		return entryRET;
	}

	@Override
	public String getFTR()
	{
		String entryFTR;
		entryFTR = fieldFTR_TFP.getText();

		return entryFTR;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateID();
		updateReferences();
		updateReqSpecificDescription();
	}

	private void updateID()
	{
		IRequirement myRequirement = getMyRequirement();
		fieldID.setText(myRequirement.getID());
	}

	private void updateReferences()
	{
		String[][] tableReferenceEntries;
		tableReferenceEntries = calcReferenceTableEntries();

		DefaultTableModel tableModel = new DefaultTableModel(tableReferenceEntries,null);
		tableReferences.setModel(tableModel);
	}

	protected abstract void loadInternRequirement(String ID);

	protected abstract void buildReqSpecificDescription();

	protected abstract void updateReqSpecificDescription();

	public abstract IRequirement getMyRequirement();

}
