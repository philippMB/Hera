package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IRequirementFormView;

import java.awt.event.WindowEvent;
import java.util.Arrays;

/**
 * Created by phlippe on 04.06.17.
 */
public abstract class RequirementEditController<ViewType extends IRequirementFormView>
	extends BasicController<ViewType>
{

	private boolean readyForBeClosed;


	public RequirementEditController(IModel model, ViewType viewToBeControlled)
	{
		super(model, viewToBeControlled);
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
		//TODO: Ask if changes should be deleted
	}

	@Override
	protected boolean canViewBeClosed()
	{
		readyForBeClosed = isReqEqualsViewEntries();
		controllerManager.createControlledWarningDialog(
				DialogConstants.DIALOG_SAVE_REQAN_WARNING,
				new String[]{

				},
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

	private boolean isReqEqualsViewEntries()
	{
		//TODO: Compare given Requirement to the entries in view (if req null, everytime false)
		return false;
	}

	protected abstract boolean tryToSaveReq();

}
