package View;

import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.INFRequirement;
import View_Interfaces.INFRequirementTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class NFRequirementTab
	extends TableTab
	implements INFRequirementTab
{

	public NFRequirementTab(IModelGetData model)
	{
		super(model, "Nichtfunktionale Anforderungen");
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle("Nichtfunktionale Anforderungen");
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] getTableEntries()
	{
		String[][] tableEntries;
		ArrayList<INFRequirement> allNFRequirements = myModel.getAllNFReqs();

		tableEntries = new String[allNFRequirements.size()][getColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			INFRequirement nfRequirementAtRow = allNFRequirements.get(row);
			tableEntries[row][0] = nfRequirementAtRow.getID();
			tableEntries[row][1] = nfRequirementAtRow.getTitle();
			tableEntries[row][2] = nfRequirementAtRow.getActor();
			tableEntries[row][3] = convertListToSingleString(nfRequirementAtRow.getReferencesID());
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