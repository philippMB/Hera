package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IWeightFactor;
import View_Interfaces.IOptimizedWeightFactorsView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 03.05.17.
 */
public class OptimizedWeightFactorsView
	extends FormWindow
	implements IOptimizedWeightFactorsView
{

	private IModelGetData myModel;
	private JTable tableWeightFactor;

	public OptimizedWeightFactorsView(IModelGetData model)
	{
		super();
		myModel = model;

		init();
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_OPTIMIZED_WF)
		);
		myBuilder.addTable(
				"",
				calcTableEntries(),
				getColumnNames()
		);
	}

	private String[] getColumnNames()
	{
		String[] columnNames;
		columnNames = new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_TITLE),
				myTextBundle.getParameterText(TextNameConstants.PAR_OPTIMIZED),
				myTextBundle.getParameterText(TextNameConstants.PAR_CURRENT)
		};

		return columnNames;
	}

	private String[][] calcTableEntries()
	{
		String[][] tableEntries;

		ArrayList<IWeightFactor> allWeightFactors;
		allWeightFactors = myModel.getAllWeightFactor();
		int amountWeightFactors = allWeightFactors.size();
		tableEntries = new String[amountWeightFactors][3];

		for(int row = 0; row < amountWeightFactors; row++)
		{
			IWeightFactor weightFactor = allWeightFactors.get(row);
			String factorTitle = weightFactor.getTitle();
			IWeightFactor optimizedFactor = myModel.getOptWeightFactorByTitle(factorTitle);
			int currentValue = weightFactor.getValue();
			int optimizedValue = optimizedFactor.getValue();
			tableEntries[row][0] = factorTitle;
			tableEntries[row][1] = Integer.toString(currentValue);
			tableEntries[row][2] = Integer.toString(optimizedValue);
		}

		return tableEntries;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}

	private void updateTable()
	{
		String[][] tableEntries = calcTableEntries();
		String[] columnNames = getColumnNames();

		DefaultTableModel tableModel = new DefaultTableModel(tableEntries,columnNames);
		tableWeightFactor.setModel(tableModel);
	}

}
