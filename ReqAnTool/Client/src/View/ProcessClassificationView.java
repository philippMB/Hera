package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.*;
import View_Interfaces.IProcessClassificationView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 *
 *         <img src="doc-files/ProcessClassification.png" alt="Class diagram"><br>
 */
public abstract class ProcessClassificationView<RequirementType extends IRequirement>
	extends FormWindow
	implements IProcessClassificationView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.SAVE,
			ViewActions.CANCEL
	};
	private final String DFP_Text;
	private final String TFP_Text;
	private final String EIF_Text;
	private final String ILF_Text;
	private final String EI_Text;
	private final String EO_Text;
	private final String EQ_Text;

	protected RequirementType myReq;
	protected IModelGetData myModel;
	private JTextField fieldID;
	private SingleColumnTableModel tableRefModel;
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
		DFP_Text = myTextBundle.getParameterText(TextNameConstants.PAR_DFP);
		TFP_Text = myTextBundle.getParameterText(TextNameConstants.PAR_TFP);
		EIF_Text = myTextBundle.getParameterText(TextNameConstants.PAR_EIF);
		ILF_Text = myTextBundle.getParameterText(TextNameConstants.PAR_ILF);
		EI_Text = myTextBundle.getParameterText(TextNameConstants.PAR_EI);
		EO_Text = myTextBundle.getParameterText(TextNameConstants.PAR_EO);
		EQ_Text = myTextBundle.getParameterText(TextNameConstants.PAR_EQ);

		myReq = getRequirementFromModel(ID);

		init();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{

		buildDFPSelection();
		buildTFPSelection();

		panelHolder = new JPanel();
		panelHolder.add(panelDFP);
		panelHolder.add(panelTFP);

		String titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_PROCESS_CLASSIFICATION);
		setTitle(titleText);
		myBuilder.addTitle(titleText);
		fieldID = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_ID),
				myReq.getID(),
				false
		);
		JTable tableReferences = myBuilder.addTable(
				myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES),
				new String[0][0]
		);
		tableRefModel = new SingleColumnTableModel(getReferencesAsArray(), null);
		tableReferences.setModel(tableRefModel);

		buildReqSpecificDescription();

		comboBoxClass = myBuilder.addNamedDropdownList(
				myTextBundle.getParameterText(TextNameConstants.PAR_ELEMENTARY_PROCESSES),
				getSelectionClassNames()
		);
		myBuilder.addPanel(panelHolder);
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		setActionCommands();
		createComboBoxListener();
		getContentPane().add(myBuilder.getResult());
		pack();

		setUpForRequirement();
	}

	private String[] getReferencesAsArray()
	{
		String[] referencesID = myReq.getReferenceIDs().toArray(new String[0]);
		return referencesID;
	}

	private void buildDFPSelection()
	{
		panelDFP = new JPanel();
		panelDFP.setLayout(new BorderLayout());
		PanelBuilder myDFPBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);

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
		PanelBuilder myTFPBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);

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
		panelTFP.add(myTFPBuilder.getResult(),BorderLayout.CENTER);
	}

	private void createComboBoxListener()
	{
		comboBoxClass.addActionListener(
				(actionEvent) -> performClassChange()
		);
	}

	private void performClassChange()
	{
		String selectedItem = (String)comboBoxClass.getSelectedItem();
		if(selectedItem.equals(TFP_Text))
		{
			showTransactionFP();
		}
		else
		{
			if(selectedItem.equals(DFP_Text))
			{
				showDataFP();
			}
			else
			{
				showDefault();
			}
		}
	}

	private String[] getSelectionClassNames()
	{
		String[] selectionClassNames = new String[]{
				"---",
				TFP_Text,
				DFP_Text
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
				ILF_Text,
				EIF_Text
		};
		return selectionDFPNames;
	}

	private void setUpForRequirement()
	{
		String reqID = myReq.getID();
		ICostEstimation myCostEstimation = myModel.getCostEstimation();

		if(myCostEstimation.hasIDDataFP(reqID))
		{
			IDataFP myDataFP = myCostEstimation.getDataFPByID(reqID);
			setFieldsOnDataFP(myDataFP);
			setComboBoxOnDataFP(myDataFP);
			comboBoxClass.setSelectedItem(DFP_Text);
			showDataFP();
		}
		else
		{
			if(myCostEstimation.hasIDTransactionFP(reqID))
			{
				ITransactionFP myTransactionFP = myCostEstimation.getTransactionFPByID(reqID);
				setFieldsOnTransactionFP(myTransactionFP);
				setComboBoxOnTransactionFP(myTransactionFP);
				comboBoxClass.setSelectedItem(TFP_Text);
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
		int DET = transactionFP.getDet();
		int FTR = transactionFP.getFtr();
		fieldDET_TFP.setText(Integer.toString(DET));
		fieldFTR_TFP.setText(Integer.toString(FTR));
	}

	private void setFieldsOnDataFP(IDataFP dataFP)
	{
		int DET = dataFP.getDet();
		int RET = dataFP.getRet();
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

	private void showDataFP()
	{
		panelTFP.setVisible(false);
		panelDFP.setVisible(true);
	}

	private void showTransactionFP()
	{
		panelDFP.setVisible(false);
		panelTFP.setVisible(true);
	}

	private void showDefault()
	{
		panelDFP.setVisible(false);
		panelTFP.setVisible(false);
	}

	@Override
	public IClassOfFP getSelectedClass()
	{
		IClassOfFP selectedClass;

		String selectedItem = (String)comboBoxClass.getSelectedItem();
		if(selectedItem.equals(DFP_Text))
		{
			selectedClass = getSelectedClassOfDFP();
		}
		else
		{
			if(selectedItem.equals(TFP_Text))
			{
				selectedClass = getSelectedClassOfTFP();
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

		IClassOfFP selectedClass = getSelectedClass();
		if(selectedClass instanceof ClassOfTransactionFP)
		{
			entryDET = fieldDET_TFP.getText();
		}
		else
		{
			if(selectedClass instanceof ClassOfDataFP)
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
	public String getReqID()
	{
		return myReq.getID();
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateID();
		updateReferences();
		updateReqSpecificDescription();
	}

	@Override
	public void destruct()
	{
		super.destruct();
		myModel.deleteObserver(this);
	}

	private void updateID()
	{
		fieldID.setText(myReq.getID());
	}

	private void updateReferences()
	{
		tableRefModel.setTableEntries(getReferencesAsArray());
	}

	protected abstract RequirementType getRequirementFromModel(String ID);

	protected abstract void buildReqSpecificDescription();

	protected abstract void updateReqSpecificDescription();

}
