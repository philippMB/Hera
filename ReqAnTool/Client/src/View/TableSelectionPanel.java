package View;

import Controller_Interfaces.ViewActions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created by phlippe on 28.04.17.
 */
public class TableSelectionPanel
	extends JPanel
{

	private String[] options;
	private JComboBox<String> myDropdownList;
	private JTable myTable;
	private Vector<String> tableEntries;
	private JButton buttonAdd;
	private JButton buttonDelete;


	public TableSelectionPanel(String[] selectables)
	{
		super(new GridBagLayout());
		options = selectables;
		tableEntries = new Vector<>();

		init();
	}

	public TableSelectionPanel(String[] selectables, String[] tableEntries)
	{
		super(new GridBagLayout());
		options = selectables;
		this.tableEntries = new Vector<>(Arrays.asList(tableEntries));

		init();
	}

	public TableSelectionPanel(String[] selectables, Vector<String> tableEntries)
	{
		super(new GridBagLayout());
		options = selectables;
		this.tableEntries = tableEntries;

		init();
	}

	private void init()
	{
		setSize(200,150);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(5,5,5,5);

		myDropdownList = new JComboBox<>(options);
		add(myDropdownList,constraints);

		constraints.gridy = 1;
		myTable = new JTable(tableEntries,null);
		JScrollPane scrollableTable = new JScrollPane(myTable);
		scrollableTable.setPreferredSize(new Dimension(100,100));
		scrollableTable.setMaximumSize(new Dimension(100,100));
		add(scrollableTable,constraints);

		constraints.gridx = 1;
		constraints.gridy = 0;
		buttonAdd = new JButton("Hinzufügen");
		add(buttonAdd, constraints);

		constraints.gridy = 1;
		buttonDelete = new JButton("Löschen");
		constraints.anchor = GridBagConstraints.PAGE_START;
		add(buttonDelete,constraints);
	}

	public String getSelectedItem()
	{
		return (String)myDropdownList.getSelectedItem();
	}

	public void addSelectedItemToTable()
	{
		tableEntries.add((String)myDropdownList.getSelectedItem());
		repaint();
	}

	public void deleteSelectedItemFromTable()
	{
		tableEntries.remove(myTable.getSelectedRow());
		repaint();
	}

	public void setSelectables(String[] selectables)
	{
		myDropdownList.setModel(new DefaultComboBoxModel<>(selectables));
		checkTableEntries();
	}

	private void checkTableEntries()
	{
		String[] tableEntries = getTableEntries();

		int removedRows = 0;
		for(int row=0;row<tableEntries.length;row++)
		{
			if(!isStringInDropdownList(tableEntries[row]))
			{
				removeTableRow(row-removedRows);
				removedRows++;
			}
		}
	}

	private boolean isStringInDropdownList(String element)
	{
		DefaultComboBoxModel<String> myDropdownModel = (DefaultComboBoxModel<String>)myDropdownList.getModel();
		return (myDropdownModel.getIndexOf(element) != -1);
	}

	private void removeTableRow(int rowIndex)
	{
		DefaultTableModel myTableModel = (DefaultTableModel)myTable.getModel();
		myTableModel.removeRow(rowIndex);
	}

	public String[] getTableEntries()
	{
		String[] myEntries = new String[myTable.getRowCount()];

		for (int row=0; row<myTable.getRowCount(); row++)
		{
			myEntries[row] = (String)myTable.getValueAt(row,0);
		}

		return myEntries;
	}

	public void setTableEntries(String[] tableEntries)
	{
		String[][] widerTableEntries = new String[1][tableEntries.length];
		widerTableEntries[0] = tableEntries;
		myTable.setModel(new DefaultTableModel(widerTableEntries,null));
	}

	public void addController(ActionListener actionListener)
	{
		buttonAdd.addActionListener(actionListener);
		buttonAdd.setActionCommand(ViewActions.TABLE_SELECTION_ADD.toString());

		buttonDelete.addActionListener(actionListener);
		buttonDelete.setActionCommand(ViewActions.TABLE_SELECTION_DELETE.toString());
	}

}
