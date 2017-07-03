package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IFRequirementTab;
import View_Interfaces.ITableTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * This tab provides functionality to edit, create and delete functional requirements of a requirement analysis.
 * It is based on {@link TableTab} and shows all {@link Model_Interfaces.IFRequirement} of the current
 * {@link Model_Interfaces.IRequirementAnalysis}. The possible view actions are the same as described in
 * {@link TableTab}.
 *
 * @author 9045534
 * @version 1.0
 * @see ITableTab
 */
public class FRequirementTab
	extends TableTab
	implements IFRequirementTab
{


	public FRequirementTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_FREQ);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_FREQ));
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
		ArrayList<IFRequirement> allFRequirements = myModel.getAllFReq();

		tableEntries = new String[allFRequirements.size()][createColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IFRequirement fRequirementAtRow = allFRequirements.get(row);
			tableEntries[row][0] = fRequirementAtRow.getID();
			tableEntries[row][1] = fRequirementAtRow.getTitle();
			tableEntries[row][2] = fRequirementAtRow.getActor();
			tableEntries[row][3] = convertListToSingleString(fRequirementAtRow.getReferenceIDs());
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
