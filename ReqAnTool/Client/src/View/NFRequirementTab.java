package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.INFRequirement;
import View_Interfaces.INFRequirementTab;
import View_Interfaces.ITableTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * This tab provides functionality to edit, create and delete nonfunctional requirements of a requirement analysis.
 * It is based on {@link TableTab} and shows all {@link Model_Interfaces.INFRequirement} of the current
 * {@link Model_Interfaces.IRequirementAnalysis}. The possible view actions are the same as described in
 * {@link TableTab}.
 *
 * @author 9045534
 * @version 1.0
 * @see ITableTab
 */
public class NFRequirementTab
	extends TableTab
	implements INFRequirementTab
{

	public NFRequirementTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_NFREQ);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_NFREQ));
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[][] createTableEntries()
	{
		String[][] tableEntries;
		ArrayList<INFRequirement> allNFRequirements = myModel.getAllNFReq();

		tableEntries = new String[allNFRequirements.size()][createColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			INFRequirement nfRequirementAtRow = allNFRequirements.get(row);
			tableEntries[row][0] = nfRequirementAtRow.getID();
			tableEntries[row][1] = nfRequirementAtRow.getTitle();
			tableEntries[row][2] = nfRequirementAtRow.getActor();
			tableEntries[row][3] = convertListToSingleString(nfRequirementAtRow.getReferenceIDs());
		}

		return tableEntries;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[] createColumnNames()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_ID),
				myTextBundle.getParameterText(TextNameConstants.PAR_TITLE),
				myTextBundle.getParameterText(TextNameConstants.PAR_ACTOR),
				myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES)
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}
}