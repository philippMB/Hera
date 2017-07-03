package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IAddition;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IAdditionTab;
import View_Interfaces.ITableTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * This tab provides functionality to edit, create and delete additions of a requirement analysis.
 * It is based on {@link TableTab} and shows all {@link Model_Interfaces.IAddition} of the current
 * {@link Model_Interfaces.IRequirementAnalysis}. The possible view actions are the same as described in
 * {@link ITableTab}. For comments on the structure please see {@link TableTab}
 *
 * @author 9045534
 * @version 1.0
 * @see IAddition
 * @see ITableTab
 * @see TableTab
 * @see IAdditionTab
 */
public class AdditionTab
	extends TableTab
	implements IAdditionTab
{


	public AdditionTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_ADDITION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_ADDITION));
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
		ArrayList<IAddition> allAdditions = myModel.getAllAddition();

		tableEntries = new String[allAdditions.size()][createColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IAddition additionAtRow = allAdditions.get(row);
			tableEntries[row][0] = additionAtRow.getTitle();
			tableEntries[row][1] = additionAtRow.getDescription();
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
				myTextBundle.getParameterText(TextNameConstants.PAR_TITLE),
				myTextBundle.getParameterText(TextNameConstants.PAR_DESC)
		};
	}

	/**
	 * {@inheritDoc}
	 * For this the table of {@link IAddition} is updated to the additions of the model.
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}

}
