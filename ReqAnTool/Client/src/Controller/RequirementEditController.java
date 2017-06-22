package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.IRequirementFormView;

import java.awt.event.WindowEvent;
import java.util.Arrays;

/**
 * Created by phlippe on 04.06.17.
 */
public abstract class RequirementEditController<ViewType extends IRequirementFormView>
	extends BasicViewController<ViewType>
{

	private boolean readyForBeClosed;
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
			//TODO: ErrorDialog, that no Link is selected in the table
		}
		else
		{
			myView.deleteSelectedRef();
		}
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		canViewBeClosed();
		super.windowClosing(e);
		//TODO: Stop closing
	}

	@Override
	protected boolean canViewBeClosed()
	{
		readyForBeClosed = isReqEqualsViewEntries();
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
						readyForBeClosed = tryToSaveReq();
					}

					@Override
					protected void executeDontSaveAction()
					{
						closeView();
						readyForBeClosed = true;
					}

					@Override
					protected void executeCancelAction()
					{
						closeView();
						readyForBeClosed = false;
					}
				}
		);
		return readyForBeClosed;
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

	@Override
	protected void handleECDuplicate(int errorID)
	{
		controllerManager.createControlledErrorDialog(
				myView,
				ErrorCodes.DUPLICATE,
				new String[]{
						myReqID
				}
		);
	}

	private boolean isReqEqualsViewEntries()
	{
		//TODO: Compare given Requirement to the entries in view (if req null, everytime false)
		return false;
	}

	protected abstract boolean tryToSaveReq();

	protected abstract String[] createSaveDataWarningPlaceholder();

}
