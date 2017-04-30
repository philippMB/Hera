package View;

import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IFRequirementTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 28.04.17.
 */
public class FRequirementTab
	extends TableTab
	implements IFRequirementTab
{


	public FRequirementTab(IModelGetData model)
	{
		super(model, "Funktionale Anforderungen");
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle("Funktionale Anforderungen");
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] getTableEntries()
	{
		String[][] tableEntries;
		ArrayList<IFRequirement> allFRequirements = myModel.getAllFReqs();

		tableEntries = new String[allFRequirements.size()][getColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IFRequirement fRequirementAtRow = allFRequirements.get(row);
			tableEntries[row][0] = fRequirementAtRow.getID();
			tableEntries[row][1] = fRequirementAtRow.getTitle();
			tableEntries[row][2] = fRequirementAtRow.getActor();
			tableEntries[row][3] = convertListToSingleString(fRequirementAtRow.getReferencesID());
		}

		return tableEntries;
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{"ID","Titel","Akteur","Verweise"};
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}

}
