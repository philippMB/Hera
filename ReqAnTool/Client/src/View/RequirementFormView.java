package View;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;
import View_Interfaces.IRequirementFormView;
import com.sun.org.glassfish.gmbal.ManagedObject;

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

	private final ViewActions[] BUTTON_ACTIONS_EDITABLE = {ViewActions.ADD, ViewActions.CANCEL};
	private final ViewActions[] BUTTON_ACTIONS_NOT_EDITABLE = {ViewActions.EDIT, ViewActions.DELETE, ViewActions.CANCEL};

	protected IModelGetData myModel;
	protected boolean isEditable;
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
		String[] tableEntries = getMyRequirement().getReferenceIDs();

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
		if(isEditable)
		{
			setButtonActions(BUTTON_ACTIONS_EDITABLE);
		}
		else
		{
			setButtonActions(BUTTON_ACTIONS_NOT_EDITABLE);
		}
		myButtons = myBuilder.addButtonBar(myButtonActions);
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
	public void destruct()
	{

	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateAll();
	}

	protected void updateAll()
	{
		if(!isReqDeleted())
		{
			updateFields();
			updateTable();
		}
		else
		{
			destruct();
		}
	}

	private boolean isReqDeleted()
	{
		boolean isReqDeleted;
		IRequirement myReq = getMyRequirement();

		if(myReq != null)
		{
			String ID = myReq.getID();
			IRequirement newReq = myModel.getReqByID(ID);	//TODO: Ersetzen mit Include-Anweisung

			isReqDeleted = (newReq == null);
		}
		else
		{
			isReqDeleted = false;
		}

		return isReqDeleted;
	}

	protected void updateTable()
	{
		if(isEditable)
		{
			ArrayList<String> tableEntries = new ArrayList<>(Arrays.asList(tableSelectionLinks.getTableEntries()));

			for(String ID: tableEntries)
			{
				//TODO: IModelGetData-Interface mit einer Include-Anweisung versehen
				/*
				if(myModel.getReqByID(ID) == null)
				{
					tableEntries.remove(ID);
				}
				*/
			}

			tableSelectionLinks.setTableEntries((String[])tableEntries.toArray());

			tableSelectionLinks.setSelectables((String[])myModel.getAllReqIDs().toArray());
		}
		else
		{
			String[] myLinkIDs = getMyRequirement().getReferenceIDs();
			String[][] wideTableEntries = new String[1][myLinkIDs.length];
			wideTableEntries[0] = myLinkIDs;

			tableLinks.setModel(new DefaultTableModel(wideTableEntries,null));
		}
	}

	@Override
	public void addController(ActionListener newListener)
	{
		super.addController(newListener);
		tableSelectionLinks.addController(newListener);
	}

	protected abstract void updateFields();

	public abstract IRequirement getMyRequirement();

	protected abstract void setIDEntry(String ID);

	public abstract String getIDEntry();

}
