package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by phlippe on 28.04.17.
 */
public class TableSelectionPanel
	extends JPanel
{
	private String[] options;
	private JComboBox<String> myDropdownList;
	private JTable myTable;
	private SingleColumnTableModel myTableModel;
	private JButton buttonAdd;
	private JButton buttonDelete;
	private ITextFacade myTextBundle;


	public TableSelectionPanel(String[] selectables)
	{
		super(new GridBagLayout());
		options = selectables;
		myTableModel = new SingleColumnTableModel();
		myTextBundle = ITextFacade.getInstance();

		init();
	}

	public TableSelectionPanel(String[] selectables, String[] tableEntries)
	{
		super(new GridBagLayout());
		options = selectables;
		myTableModel = new SingleColumnTableModel(tableEntries, null);
		myTextBundle = ITextFacade.getInstance();

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
		myTable = new JTable(myTableModel);
		myTable.setTableHeader(null);
		JScrollPane scrollableTable = new JScrollPane(myTable);
		scrollableTable.setPreferredSize(new Dimension(100,100));
		scrollableTable.setMaximumSize(new Dimension(100,100));
		add(scrollableTable,constraints);

		constraints.gridx = 1;
		constraints.gridy = 0;
		buttonAdd = new JButton(myTextBundle.getButtonText(ViewActions.TABLE_SELECTION_ADD));
		add(buttonAdd, constraints);

		constraints.gridy = 1;
		buttonDelete = new JButton(myTextBundle.getButtonText(ViewActions.TABLE_SELECTION_DELETE));
		constraints.anchor = GridBagConstraints.PAGE_START;
		add(buttonDelete,constraints);

		setActionCommands();
	}

	public String getSelectedItemToAdd()
	{
		return (String)myDropdownList.getSelectedItem();
	}

	public String getSelectedItemToDelete()
	{
		String selectedItem;
		int selectedRowIndex = myTable.getSelectedRow();

		if(selectedRowIndex == -1)
		{
			selectedItem = null;
		}
		else
		{
			selectedItem = myTableModel.getValueAt(selectedRowIndex);
		}

		return selectedItem;
	}

	public void addSelectedItemToTable()
	{
		myTableModel.addRow((String)myDropdownList.getSelectedItem());
	}

	public void deleteSelectedItemFromTable()
	{
		myTableModel.deleteRow(myTable.getSelectedRow());
	}

	public void setSelectables(String[] selectables)
	{
		myDropdownList.setModel(new DefaultComboBoxModel<>(selectables));
		checkTableEntries();
	}

	private void checkTableEntries()
	{
		String[] tableEntries = myTableModel.getOneColumnTableEntries();

		for(int rowIndex=0;rowIndex<tableEntries.length;rowIndex++)
		{
			if(!isStringInDropdownList(tableEntries[rowIndex]))
			{
				myTableModel.deleteRow(rowIndex);
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
		myTableModel.deleteRow(rowIndex);
	}

	public void setTableEntries(String[] tableEntriesArray)
	{
		myTableModel.setTableEntries(tableEntriesArray);
	}

	public String[] getTableEntries()
	{
		return myTableModel.getOneColumnTableEntries();
	}

	private void setActionCommands()
	{
		buttonAdd.setActionCommand(ViewActions.TABLE_SELECTION_ADD.toString());
		buttonDelete.setActionCommand(ViewActions.TABLE_SELECTION_DELETE.toString());
	}

	public void addController(ActionListener actionListener)
	{
		buttonAdd.addActionListener(actionListener);
		buttonDelete.addActionListener(actionListener);
	}

}
