package View;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;
import View_Interfaces.IRequirementFormView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

/**
 * Created by phlippe on 30.04.17.
 */
public abstract class RequirementFormView
	extends FormWindow
	implements IRequirementFormView
{

	protected IModelGetData myModel;
	protected boolean isEditable;
	private JButton buttonSave;
	private JButton buttonCancel;
	private JButton buttonEdit;
	private JButton buttonDelete;
	private JButton buttonClose;
	private TableSelectionPanel tableSelectionLinks;
	private JTable tableLinks;


	public RequirementFormView(IModelGetData model, boolean isEditable)
	{
		super();
		myModel = model;
		this.isEditable = isEditable;
	}

	protected void buildLinkTable()
	{
		final String tagedName = "Verweise";
		String[] tableEntries = (String[])getMyRequirement().getReferencesID().toArray();

		if(isEditable)
		{
			tableSelectionLinks = myBuilder.addTableSelection(tagedName,
																tableEntries,
																(String[])myModel.getAllReqIDs().toArray());
		}
		else
		{
			String[][] wideTableEntries = new String[1][tableEntries.length];
			wideTableEntries[0] = tableEntries;
			tableLinks = myBuilder.addTable(tagedName,wideTableEntries);
		}
	}

	protected void buildButtonBar()
	{
		final String[] buttonNamesEditable = {"Speichern","Abbrechen"};
		final String[] buttonNamesNotEditable = {"Bearbeiten","Löschen","Schließen"};

		if(isEditable)
		{
			JButton[] lButton = myBuilder.addButtonBar(buttonNamesEditable);
			buttonSave = lButton[0];
			buttonCancel = lButton[1];
		}
		else
		{
			JButton[] lButton = myBuilder.addButtonBar(buttonNamesNotEditable);
			buttonEdit = lButton[0];
			buttonDelete = lButton[1];
			buttonClose = lButton[2];
		}
	}

	protected String[] getTableEntries()
	{
		String[] myTableEntries;

		if(isEditable)
		{
			myTableEntries = tableSelectionLinks.getTableEntries();
		}
		else
		{
			myTableEntries = new String[tableLinks.getRowCount()];

			for(int row=0;row<tableLinks.getRowCount();row++)
			{
				myTableEntries[row] = (String)tableLinks.getValueAt(row,0);
			}
		}
		return myTableEntries;
	}

	@Override
	public String getSelectedLink()
	{
		String selectedLink = null;
		if(isEditable)
		{
			selectedLink = tableSelectionLinks.getSelectedItem();
		}
		return selectedLink;
	}

	@Override
	public void addSelectedLink()
	{
		if(isEditable)
		{
			tableSelectionLinks.addSelectedItemToTable();
		}
	}

	@Override
	public void deleteSelectedLink()
	{
		if(isEditable)
		{
			tableSelectionLinks.deleteSelectedItemFromTable();
		}
	}

	@Override
	public void addController(ActionListener actionListener)
	{

		if(isEditable)
		{
			buttonSave.addActionListener(actionListener);
			buttonSave.setActionCommand(ViewActions.SAVE.toString());

			buttonCancel.addActionListener(actionListener);
			buttonCancel.setActionCommand(ViewActions.CANCEL.toString());

			tableSelectionLinks.addController(actionListener);
		}
		else
		{
			buttonEdit.addActionListener(actionListener);
			buttonEdit.setActionCommand(ViewActions.EDIT.toString());

			buttonDelete.addActionListener(actionListener);
			buttonDelete.setActionCommand(ViewActions.DELETE.toString());

			buttonClose.addActionListener(actionListener);
			buttonClose.setActionCommand(ViewActions.CLOSE.toString());
		}

	}

	@Override
	public void destruct()
	{

	}

	@Override
	public void update(Observable o, Object arg)
	{
		if(o instanceof IModelGetData)
		{
			updateAll();
		}
	}

	protected void updateAll()
	{
		if(isEditable)
		{
			checkGeneratedID();
		}
		updateFields();
		updateTable();
	}

	protected void checkGeneratedID()
	{
		if(isEditable)
		{
			String enteredID = getIDEntry();
			if(enteredID.equals("") ||
					(getMyRequirement() == null && myModel.getReqByID(enteredID)==null))
			{
				setIDEntry(myModel.generateNewID());
			}
		}
	}

	protected void updateTable()
	{
		if(isEditable)
		{
			ArrayList<String> tableEntries = new ArrayList<>(Arrays.asList(tableSelectionLinks.getTableEntries()));

			for(String ID: tableEntries)
			{
				if(myModel.getReqByID(ID) == null)
				{
					tableEntries.remove(ID);
				}
			}

			tableSelectionLinks.setTableEntries((String[])tableEntries.toArray());

			tableSelectionLinks.setSelectables((String[])myModel.getAllReqIDs().toArray());
		}
		else
		{
			String[] myLinkIDs = (String[])getMyRequirement().getReferencesID().toArray();
			String[][] wideTableEntries = new String[1][myLinkIDs.length];
			wideTableEntries[0] = myLinkIDs;

			tableLinks.setModel(new DefaultTableModel(wideTableEntries,null));
		}
	}

	protected abstract void updateFields();

	public abstract IRequirement getMyRequirement();

	protected abstract void setIDEntry(String ID);

	public abstract String getIDEntry();

}
