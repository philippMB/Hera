package View;

import Model_Interfaces.IAddition;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IAdditionTab;

import javax.swing.*;
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
		super(model,"Ergänzungen");
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle("Ergänzungen");
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] getTableEntries()
	{
		String[][] tableEntries;
		ArrayList<IAddition> allAdditions = myModel.getAllAdditions();

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
		return new String[]{"Titel","Beschreibung"};
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}

}
