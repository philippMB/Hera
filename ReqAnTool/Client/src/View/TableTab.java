package View;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ITableTab;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
	private StandardTableModel myTableModel;


	public TableTab(IModelGetData model, String titleConstant)
	{
		super(model, titleConstant);
	}

	protected void buildTablePanel()
	{
		setButtonActions(BUTTON_ACTIONS);

		myTable = myBuilder.addTable(
				null,
				new String[0][0],
				new String[0]
		);
		myTableModel = new StandardTableModel(createTableEntries(), createColumnNames());
		myTable.setModel(myTableModel);
		myButtons = myBuilder.addButtonBar(myButtonActions);

		setActionCommands();
	}

	@Override
	public String[] getSelectedRow()
	{
		String[] rowContent = myTableModel.getRow(myTable.getSelectedRow());
		return rowContent;
	}

	protected void updateTable()
	{
		myTableModel.setTableEntries(createTableEntries());
	}

	protected abstract String[][] createTableEntries();

	protected abstract String[] createColumnNames();

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