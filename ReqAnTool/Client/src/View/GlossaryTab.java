package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IGlossaryEntry;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IGlossaryTab;
import View_Interfaces.ITableTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * This tab provides functionality to edit, create and delete glossary entries of a requirement analysis.
 * It is based on {@link TableTab} and shows all {@link Model_Interfaces.IGlossaryEntry} of the current
 * {@link Model_Interfaces.IRequirementAnalysis}. The possible view actions are the same as described in
 * {@link ITableTab}.
 *
 * @author 9045534
 * @version 1.0
 * @see ITableTab
 */
public class GlossaryTab
	extends TableTab
	implements IGlossaryTab
{

	public GlossaryTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_GLOSSARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_GLOSSARY));
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
		ArrayList<IGlossaryEntry> allGlossaryEntries = myModel.getAllGlossEntries();

		tableEntries = new String[allGlossaryEntries.size()][createColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IGlossaryEntry glossaryEntryAtRow = allGlossaryEntries.get(row);
			tableEntries[row][0] = glossaryEntryAtRow.getTerm();
			tableEntries[row][1] = glossaryEntryAtRow.getSense();
			tableEntries[row][2] = convertListToSingleString(glossaryEntryAtRow.getReferenceTerms());
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
				myTextBundle.getParameterText(TextNameConstants.PAR_TERM),
				myTextBundle.getParameterText(TextNameConstants.PAR_SENSE),
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
