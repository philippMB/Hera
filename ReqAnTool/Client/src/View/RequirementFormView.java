package View;

import Controller_Interfaces.IViewController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;
import View_Interfaces.IRequirementFormView;
import View_Interfaces.IRequirementShowView;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;

/**
 * Created by phlippe on 30.04.17.
 */
public abstract class RequirementFormView<RequirementType extends IRequirement>
	extends FormWindow
	implements IRequirementFormView, IRequirementShowView<RequirementType>
{

	private final ViewActions[] BUTTON_ACTIONS_EDITABLE = {ViewActions.SAVE, ViewActions.CANCEL};
	private final ViewActions[] BUTTON_ACTIONS_NOT_EDITABLE = {ViewActions.EDIT, ViewActions.DELETE};

	protected IModelGetData myModel;
	protected boolean isEditable;
	protected RequirementType myReq;
	private TableSelectionPanel tableSelectRef;
	private JTable tableReferences;
	private SingleColumnTableModel refTableModel;


	public RequirementFormView(@NotNull IModelGetData model, @Nullable String ID, boolean isEditable)
	{
		super();
		Objects.requireNonNull(model);

		myModel = model;
		this.isEditable = isEditable;
		if(ID != null)
		{
			myReq = getReqFromModel(ID);
		}
		else
		{
			myReq = null;
			//If the ID is null the view has to be editable. Otherwise no data could be shown
			if(!isEditable)
			{
				this.isEditable = true;
			}
		}
		init();
	}

	protected void buildRefTable()
	{
		if(isEditable)
		{
			String[] reqReferences;
			if(myReq != null)
			{
				reqReferences = myReq.getReferenceIDs().toArray(new String[0]);
			}
			else
			{
				reqReferences = null;
			}
			tableSelectRef = myBuilder.addTableSelection(
					myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES),
					new String[0],
					reqReferences
			);
		}
		else
		{
			tableReferences = myBuilder.addTable(
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
		setActionCommands();
	}

	protected String[] getTableEntries()
	{
		String[] myTableEntries;

		if(isEditable)
		{
			myTableEntries = tableSelectRef.getTableEntries();
		}
		else
		{
			myTableEntries = new String[tableReferences.getRowCount()];

			for(int row = 0; row < tableReferences.getRowCount(); row++)
			{
				myTableEntries[row] = (String) tableReferences.getValueAt(row,0);
			}
		}
		return myTableEntries;
	}

	@Override
	public String[] getRefEntry()
	{
		return getTableEntries();
	}

	@Override
	public String getSelectedRefToAdd()
	{
		String selectedLink = null;
		if(isEditable)
		{
			selectedLink = tableSelectRef.getSelectedItemToAdd();
		}
		return selectedLink;
	}

	@Override
	public String getSelectedLinkToDelete()
	{
		String selectedLink = null;
		if(isEditable)
		{
			selectedLink = tableSelectRef.getSelectedItemToDelete();
		}
		return selectedLink;
	}

	@Override
	public void addSelectedRef()
	{
		if(isEditable)
		{
			tableSelectRef.addSelectedItemToTable();
		}
	}

	@Override
	public void deleteSelectedRef()
	{
		if(isEditable)
		{
			tableSelectRef.deleteSelectedItemFromTable();
		}
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

		if(myReq != null)
		{
			RequirementType newReq = getReqFromModel(myReq.getID());	//TODO: Ersetzen mit Include-Anweisung
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
			ArrayList<String> allReqIDs = myModel.getAllReqIDs();
			if(myReq != null)
			{
				allReqIDs.remove(myReq.getID());
			}
			tableSelectRef.setSelectables(allReqIDs.toArray(new String[0]));

		}
		else
		{
			if(refTableModel == null)
			{
				refTableModel = new SingleColumnTableModel();
				tableReferences.setModel(refTableModel);
				tableReferences.setTableHeader(null);
			}

			String[] myRefIDs = myReq.getReferenceIDs().toArray(new String[0]);
			refTableModel.setTableEntries(myRefIDs);

		}
	}

	@Override
	public RequirementType getReq()
	{
		return myReq;
	}

	@Override
	public void addController(IViewController newController)
	{
		super.addController(newController);
		if(isEditable)
		{
			tableSelectRef.addController(newController);
		}
	}

	protected abstract void updateFields();

	protected abstract void setIDEntry(String ID);

	public abstract String getIDEntry();

	protected abstract RequirementType getReqFromModel(String ID);

}
