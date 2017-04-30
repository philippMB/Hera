package View;

import Model_Interfaces.IModelGetData;
import Model_Interfaces.IQualityRequirement;
import View_Interfaces.IQualityRequirementTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class QualityRequirementTab
	extends TableTab
	implements IQualityRequirementTab
{

	public QualityRequirementTab(IModelGetData model)
	{
		super(model, "Qualitätsanforderungen");
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle("Qualitätsanforderungen");
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] getTableEntries()
	{
		String[][] tableEntries;
		ArrayList<IQualityRequirement> allQualityRequirements = myModel.getAllQualityReqs();

		tableEntries = new String[allQualityRequirements.size()][getColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IQualityRequirement qualityReqAtRow = allQualityRequirements.get(row);
			tableEntries[row][0] = qualityReqAtRow.getCriteria();
			tableEntries[row][1] = qualityReqAtRow.getValue().toString();	//TODO: Implement ".toString()" in enum Score
		}

		return tableEntries;
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{"Name","Bewertung"};
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}
}
