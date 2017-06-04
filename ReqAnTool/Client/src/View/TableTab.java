package View;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ITableTab;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by phlippe on 29.04.17.
 */
public abstract class TableTab
	extends TabPanel
	implements ITableTab
{

	private static final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.ADD,
			ViewActions.SHOW,
			ViewActions.EDIT,
			ViewActions.DELETE
	};

	private JTable myTable;


	public TableTab(IModelGetData model, String titleConstant)
	{
		super(model, titleConstant);
	}

	protected void buildTablePanel()
	{
		setButtonActions(BUTTON_ACTIONS);

		myTable = myBuilder.addTable(null, getTableEntries(), getColumnNames());
		myButtons = myBuilder.addButtonBar(myButtonActions);

		setActionCommands();
	}

	@Override
	public String[] getSelectedRow()
	{
		String[] rowContent;
		int rowIndex = myTable.getSelectedRow();

		if(rowIndex >= 0)
		{
			rowContent = new String[myTable.getColumnCount()];

			for(int column = 0;column<myTable.getColumnCount();column++)
			{
				rowContent[column] = (String)myTable.getValueAt(rowIndex,column);
			}
		}
		else
		{
			rowContent = null;
		}

		return rowContent;
	}

	protected void updateTable()
	{
		String[][] tableEntries = getTableEntries();
		String[] columnNames = getColumnNames();

		DefaultTableModel defaultTableModel = new DefaultTableModel(tableEntries,columnNames);
		myTable.setModel(defaultTableModel);
	}

	protected abstract String[][] getTableEntries();

	protected abstract String[] getColumnNames();

	protected static String convertListToSingleString(String[] arrayOfStrings)
	{
		ArrayList<String> listOfStrings = new ArrayList<>(Arrays.asList(arrayOfStrings));
		return convertListToSingleString(listOfStrings);
	}

	protected static String convertListToSingleString(ArrayList<String> listOfStrings)
	{
		String convertedString = "";

		for(int i = 0; i < listOfStrings.size(); i++)
		{
			if(i > 0)
			{
				convertedString += ", ";
			}
			convertedString += listOfStrings.get(i);
		}

		return convertedString;
	}

}