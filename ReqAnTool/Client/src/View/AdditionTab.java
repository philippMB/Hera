package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IAddition;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IAdditionTab;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class AdditionTab
	extends TableTab
	implements IAdditionTab
{


	public AdditionTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_ADDITION);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_ADDITION));
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] getTableEntries()
	{
		String[][] tableEntries;
		ArrayList<IAddition> allAdditions = myModel.getAllAddition();

		tableEntries = new String[allAdditions.size()][getColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IAddition additionAtRow = allAdditions.get(row);
			tableEntries[row][0] = additionAtRow.getTitle();
			tableEntries[row][1] = additionAtRow.getDescription();
		}

		return tableEntries;
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_TITLE),
				myTextBundle.getParameterText(TextNameConstants.PAR_DESC)
		};
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}

}
