package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IGlossaryEntry;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IProductData;
import View.TableTab;
import View_Interfaces.IGlossaryTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class GlossaryTab
	extends TableTab
	implements IGlossaryTab
{

	public GlossaryTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_GLOSSARY);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_GLOSSARY));
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] getTableEntries()
	{
		String[][] tableEntries;
		ArrayList<IGlossaryEntry> allGlossaryEntries = myModel.getAllGlossEntries();

		tableEntries = new String[allGlossaryEntries.size()][getColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IGlossaryEntry glossaryEntryAtRow = allGlossaryEntries.get(row);
			tableEntries[row][0] = glossaryEntryAtRow.getTerm();
			tableEntries[row][1] = glossaryEntryAtRow.getSense();
			tableEntries[row][2] = convertListToSingleString(glossaryEntryAtRow.getReferenceTerms());
		}

		return tableEntries;
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_TERM),
				myTextBundle.getParameterText(TextNameConstants.PAR_SENSE),
				myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES)
		};
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}
}
