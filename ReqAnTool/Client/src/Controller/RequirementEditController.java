package Controller;

import Exceptions.ListOverflowException;
import Exceptions.MissingReqAnException;
import Exceptions.NoItemSelectedException;
import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IRequirementFormView;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by phlippe on 04.06.17.
 */
public abstract class RequirementEditController<ViewType extends IRequirementFormView>
	extends BasicViewWithTextController<ViewType>
{

	private boolean readyToBeClosed;
	protected String myReqID;


	public RequirementEditController(IModel model, ViewType viewToBeControlled)
	{
		super(model, viewToBeControlled);
		myReqID = myView.getIDEntry();
	}

	@Override
	protected void executeTableSelectionAddAction()
	{

		String refToAdd = myView.getSelectedRefToAdd();
		String[] existingLinks = myView.getRefEntry();

		if( Arrays.asList(existingLinks).contains(refToAdd) )
		{
			//TODO: ErrorDialog, that Link is already included
		}
		else
		{
			myView.addSelectedRef();
		}
	}

	@Override
	protected void executeTableSelectionDeleteAction()
	{
		String refToDelete = myView.getSelectedLinkToDelete();

		if( refToDelete == null )
		{
			handleException(new NoItemSelectedException(getClass().getName()));
		}
		else
		{
			myView.deleteSelectedRef();
		}
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		if(canViewBeClosed())
		{
			closeView();
			controllerManager.removeController(this);
		}
	}

	@Override
	protected boolean canViewBeClosed()
	{
		readyToBeClosed = !textController.hasTextChangedSinceSaving();
		if(!readyToBeClosed)
		{
			controllerManager.createControlledWarningDialog(
					myView,
					DialogConstants.DIALOG_SAVE_DATA_WARNING,
					createSaveDataWarningPlaceholder(),
					new SaveWarningController(myModel, null)
					{
						@Override
						protected void executeSaveAction()
						{
							closeView();
							readyToBeClosed = tryToSaveReq();
						}

						@Override
						protected void executeDontSaveAction()
						{
							closeView();
							readyToBeClosed = true;
						}

						@Override
						protected void executeCancelAction()
						{
							closeView();
							readyToBeClosed = false;
						}
					}
			);
		}
		return readyToBeClosed;
	}

	@Override
	protected void executeSaveAction()
	{
		boolean couldBeSaved = tryToSaveReq();
		if(couldBeSaved)
		{
			closeView();
		}
	}

	@Override
	protected void executeCancelAction()
	{
		closeView();
	}

	protected boolean tryToSaveReq()
	{
		boolean reqIsSaved = true;
		ArrayList<String> referenceList = new ArrayList<>( Arrays.asList(myView.getRefEntry()) );

		try
		{
			if(myReqID == null || myReqID.equals(""))
			{
				addRequirementToModel(referenceList);
			}
			else
			{
				editRequirementFromModel(referenceList);
			}
			textController.setSaved();
		}
		catch (Exception saveException)
		{
			handleException(saveException);
			reqIsSaved = false;
		}

		return reqIsSaved;
	}

	//TODO: Change to "MissingReqAnException, ListOverflowException"
	protected abstract void addRequirementToModel(ArrayList<String> referenceList) throws Exception;

	//TODO: Look for specific Exceptions!
	protected abstract void editRequirementFromModel(ArrayList<String> referenceList) throws Exception;

	protected abstract String[] createSaveDataWarningPlaceholder();

}
