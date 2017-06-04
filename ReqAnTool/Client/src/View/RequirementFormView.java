package View;

import Controller_Interfaces.IController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;
import View_Interfaces.IRequirementFormView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Array;
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
		String[] tableEntries;
		IRequirement myReq = getMyRequirement();

		if(myReq != null)
		{
			tableEntries = getMyRequirement().getReferenceIDs().toArray(new String[0]);
		}
		else
		{
			tableEntries = new String[0];
		}

		if(isEditable)
		{

			tableSelectionLinks = myBuilder.addTableSelection(
					myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES),
					new String[0],
					new String[0]
			);
		}
		else
		{
			tableLinks = myBuilder.addTable(
					myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES),
					new String[0][0],
					new String[0]
			);
		}

		updateTable();	//Füllt Tabelle mit aktuellen Daten
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
			IRequirement newReq = getReqFromModel();	//TODO: Ersetzen mit Include-Anweisung

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

//			tableSelectionLinks.setTableEntries((String[])(tableEntries.toArray()));
			ArrayList<String> allReqIDs = myModel.getAllReqIDs();
			IRequirement myReq = getMyRequirement();
			if(myReq != null)
			{
				allReqIDs.remove(myReq.getID());
			}

			tableSelectionLinks.setSelectables(allReqIDs.toArray(new String[0]));
		}
		else
		{
			String[] myLinkIDs = getMyRequirement().getReferenceIDs().toArray(new String[0]);
			String[][] wideTableEntries = new String[1][myLinkIDs.length];
			wideTableEntries[0] = myLinkIDs;

			tableLinks.setModel(new DefaultTableModel(wideTableEntries,null));
		}
	}

	@Override
	public void addController(IController newController)
	{
		super.addController(newController);
		tableSelectionLinks.addController(newController);
	}

	protected abstract void updateFields();

	public abstract IRequirement getMyRequirement();

	protected abstract void setIDEntry(String ID);

	public abstract String getIDEntry();

	protected abstract IRequirement getReqFromModel();

}
