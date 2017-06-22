package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.*;
import View_Interfaces.ICostEstimationShowView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 04.05.17.
 */
public class CostEstimationShowView
	extends FormWindow
	implements ICostEstimationShowView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.OK,
			ViewActions.CLOSE
	};

	private IModelGetData myModel;
	private JTable tableDataFP;
	private JTable tableTransactionFP;
	private JTable tableWeightFactors;
	private JTextField fieldFunctionPoint;
	private JTextField fieldManMonth;

	public CostEstimationShowView(IModelGetData model)
	{
		super();
		myModel = model;
		setButtonActions(BUTTON_ACTIONS);

		init();
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_COST_ESTIMATION)
		);

		tableDataFP = myBuilder.addTable(
				myTextBundle.getParameterText(TextNameConstants.PAR_DFP),
				calcTableEntriesDFP(),
				getColumnNamesDFP()
		);
		tableTransactionFP = myBuilder.addTable(
				myTextBundle.getParameterText(TextNameConstants.PAR_TFP),
				calcTableEntriesTFP(),
				getColumnNamesTFP()
		);
		tableWeightFactors = myBuilder.addTable(
				myTextBundle.getParameterText(TextNameConstants.PAR_WEIGHT_FACTORS),
				calcTableEntriesWF(),
				getColumnNamesWF()
		);
		fieldFunctionPoint = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_FP),
				"",
				false
		);
		fieldManMonth = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_MM),
				"",
				false
		);
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		getContentPane().add(myBuilder.getResult());
	}

	private String[][] calcTableEntriesWF()
	{
		String[][] tableEntries;
		ICostEstimation myCostEstimation = myModel.getCostEstimation();
		ArrayList<IWeightFactor> myWeightFactors = myCostEstimation.getWeightFactors();
		String[] columnNames = getColumnNamesWF();
		int rowCount = myWeightFactors.size();
		int columnCount = columnNames.length;

		tableEntries = new String[rowCount][columnCount];

		for(int row = 0; row < rowCount; row++)
		{
			IWeightFactor weightFactor = myWeightFactors.get(row);

			tableEntries[row][0] = weightFactor.getTitle();
			tableEntries[row][1] = Integer.toString(weightFactor.getValue());
		}

		return tableEntries;
	}

	private String[][] calcTableEntriesTFP()
	{
		String[][] tableEntries;
		ICostEstimation myCostEstimation = myModel.getCostEstimation();
		ArrayList<ITransactionFP> myTransactionFPs = myCostEstimation.getTransactionFPs();
		String[] columnNames = getColumnNamesTFP();
		int rowCount = myTransactionFPs.size();
		int columnCount = columnNames.length;

		tableEntries = new String[rowCount][columnCount];

		for(int row = 0; row < rowCount; row++)
		{
			ITransactionFP transactionFP = myTransactionFPs.get(row);
			String classOfTransactionFP;
			switch(transactionFP.getType())
			{
				case EI_INPUT:
					classOfTransactionFP = myTextBundle.getParameterText(TextNameConstants.PAR_EI);
					break;
				case EO_OUTPUT:
					classOfTransactionFP = myTextBundle.getParameterText(TextNameConstants.PAR_EO);
					break;
				case EQ_QUERY:
					classOfTransactionFP = myTextBundle.getParameterText(TextNameConstants.PAR_EQ);
					break;
				default:
					classOfTransactionFP = "---";
					break;
			}

			tableEntries[row][0] = transactionFP.getRequirement().getID();
			tableEntries[row][1] = classOfTransactionFP;
			tableEntries[row][2] = Integer.toString(transactionFP.getDET());
			tableEntries[row][3] = Integer.toString(transactionFP.getFTR());
		}

		return tableEntries;
	}

	private String[][] calcTableEntriesDFP()
	{
		String[][] tableEntries;
		ICostEstimation myCostEstimation = myModel.getCostEstimation();
		ArrayList<IDataFP> myDataFPs = myCostEstimation.getDataFPs();
		String[] columnNames = getColumnNamesDFP();
		int rowCount = myDataFPs.size();
		int columnCount = columnNames.length;

		tableEntries = new String[rowCount][columnCount];

		for(int row = 0; row < rowCount; row++)
		{
			IDataFP dataFP = myDataFPs.get(row);
			String classOfDataFP;
			switch(dataFP.getType())
			{
				case EIF_EXTERNAL_INPUT_FILE:
					classOfDataFP = myTextBundle.getParameterText(TextNameConstants.PAR_EIF);
					break;
				case ILF_INTERNAL_LOGICAL_FILE:
					classOfDataFP = myTextBundle.getParameterText(TextNameConstants.PAR_ILF);
					break;
				default:
					classOfDataFP = "---";
					break;
			}

			tableEntries[row][0] = dataFP.getRequirement().getID();
			tableEntries[row][1] = classOfDataFP;
			tableEntries[row][2] = Integer.toString(dataFP.getDET());
			tableEntries[row][3] = Integer.toString(dataFP.getRET());
		}

		return tableEntries;
	}

	private String[] getColumnNamesDFP()
	{
		String[] columnNames = {
				myTextBundle.getParameterText(TextNameConstants.PAR_ID),
				myTextBundle.getParameterText(TextNameConstants.PAR_TYP),
				myTextBundle.getParameterText(TextNameConstants.PAR_DET),
				myTextBundle.getParameterText(TextNameConstants.PAR_RET)
		};

		return columnNames;
	}

	private String[] getColumnNamesTFP()
	{
		String[] columnNames = {
				myTextBundle.getParameterText(TextNameConstants.PAR_ID),
				myTextBundle.getParameterText(TextNameConstants.PAR_TYP),
				myTextBundle.getParameterText(TextNameConstants.PAR_DET),
				myTextBundle.getParameterText(TextNameConstants.PAR_FTR)
		};

		return columnNames;
	}

	private String[] getColumnNamesWF()
	{
		String[] columnNames = {
				myTextBundle.getParameterText(TextNameConstants.PAR_TITLE),
				myTextBundle.getParameterText(TextNameConstants.PAR_VALUATION)
		};

		return columnNames;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTableDFP();
		updateTableTFP();
		updateTableWeightFactors();
		updateFields();
	}

	private void updateTableTFP()
	{
		String[][] tableEntries = calcTableEntriesTFP();
		String[] columnNames = getColumnNamesTFP();

		DefaultTableModel defaultTableModel = new DefaultTableModel(tableEntries,columnNames);
		tableTransactionFP.setModel(defaultTableModel);
	}

	private void updateTableDFP()
	{
		String[][] tableEntries = calcTableEntriesDFP();
		String[] columnNames = getColumnNamesDFP();

		DefaultTableModel defaultTableModel = new DefaultTableModel(tableEntries,columnNames);
		tableDataFP.setModel(defaultTableModel);
	}

	private void updateTableWeightFactors()
	{
		String[][] tableEntries = calcTableEntriesWF();
		String[] columnNames = getColumnNamesWF();

		DefaultTableModel defaultTableModel = new DefaultTableModel(tableEntries,columnNames);
		tableWeightFactors.setModel(defaultTableModel);
	}

	private void updateFields()
	{
		ICostEstimation myCostEstimation = myModel.getCostEstimation();
		double functionPoints = myCostEstimation.getFunctionPoints();
		double manMonths = myCostEstimation.getManMonth();
		String textFP;
		String textMM;

		if(functionPoints <= 0)
		{
			textFP = myTextBundle.getParameterText(TextNameConstants.PAR_NOT_CALCULATED);
			textMM = myTextBundle.getParameterText(TextNameConstants.PAR_NOT_CALCULATED);
		}
		else
		{
			textFP = myTextBundle.convertDoubleToString(functionPoints);
			if(manMonths <= 0)
			{
				textMM = myTextBundle.getParameterText(TextNameConstants.PAR_NOT_CALCULATED);
			}
			else
			{
				textMM = myTextBundle.convertDoubleToString(manMonths);
			}
		}

		fieldFunctionPoint.setText(textFP);
		fieldManMonth.setText(textMM);
	}

}
