package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 29.04.17.
 */
public abstract class TableTab
	extends TabPanel
{

	private JTable fReqTable;
	private JButton buttonAdd;
	private JButton buttonEdit;
	private JButton buttonDelete;


	public TableTab(String tabName)
	{
		super(tabName);
	}


	@Override
	protected void init()
	{
		String[] buttonNames = {"Hinzufügen", "Bearbeiten", "Löschen"};

		myBuilder.addTitle(getTitle());
		fReqTable = myBuilder.addTable(null, getTableEntries(), getColumnNames());
		JButton[] myButtons = myBuilder.addButtonBar(buttonNames);
		buttonAdd = myButtons[0];
		buttonEdit = myButtons[1];
		buttonDelete = myButtons[2];

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	protected abstract String[][] getTableEntries();

	protected abstract String[] getColumnNames();

	protected abstract String getTitle();

}