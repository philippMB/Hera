package View;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ITableTab;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by phlippe on 29.04.17.
 */
public abstract class TableTab
	extends TabPanel
	implements ITableTab
{

	protected IModelGetData myModel;
	private JTable myTable;
	private JButton buttonAdd;
	private JButton buttonEdit;
	private JButton buttonDelete;


	public TableTab(IModelGetData model, String tabName)
	{
		super(model, tabName);
	}

	protected void buildTablePanel()
	{
		String[] buttonNames = {"Hinzufügen", "Bearbeiten", "Löschen"};

		myTable = myBuilder.addTable(null, getTableEntries(), getColumnNames());
		JButton[] myButtons = myBuilder.addButtonBar(buttonNames);
		buttonAdd = myButtons[0];
		buttonEdit = myButtons[1];
		buttonDelete = myButtons[2];

		setActionCommands();
	}

	private void setActionCommands()
	{
		buttonAdd.setActionCommand(ViewActions.ADD.toString());
		buttonEdit.setActionCommand(ViewActions.EDIT.toString());
		buttonDelete.setActionCommand(ViewActions.DELETE.toString());
	}

	@Override
	public void addController(ActionListener actionListener)
	{
		buttonAdd.addActionListener(actionListener);
		buttonEdit.addActionListener(actionListener);
		buttonDelete.addActionListener(actionListener);
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
		myTable.setModel(new DefaultTableModel(getTableEntries(),getColumnNames()));
	}

	protected abstract String[][] getTableEntries();

	protected abstract String[] getColumnNames();

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