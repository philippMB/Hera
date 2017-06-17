package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.IProjectTab;

/**
 * Created by phlippe on 17.06.17.
 */
public class ProjectTabController
	extends BasicController<IProjectTab>
{

	public ProjectTabController(IModel modelToBeControlled, IProjectTab viewToBeControlled)
	{
		super(modelToBeControlled, viewToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{

	}

	@Override
	protected void executeToPDFAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledWarningDialog(
				DialogConstants.DIALOG_DELETE_WARNING,
				new String[]{
					myTextBundle.getParameterText(TextNameConstants.PAR_REQAN) +
							" \""+myModel.getReqAnalysis().getTitle()+"\""
				},
				new DeleteWarningController(myModel, null)
				{
					@Override
					protected void deleteObject()
					{
						deleteReqAn();
					}

					@Override
					protected void cancelDeletion()
					{

					}
				}
		);
	}

	@Override
	protected void executeCloseAction()
	{
		changeToStartView();
	}

	private void deleteReqAn()
	{
		ErrorCodes deleteError = myModel.deleteReqAn();

		if(deleteError != ErrorCodes.NO_ERROR)
		{
			handleErrorCode(deleteError);
		}
		else
		{
			changeToStartView();
		}
	}

	private void changeToStartView()
	{
		boolean viewsClosed = controllerManager.closeAllActiveViews();
		if(viewsClosed)
		{
			controllerManager.createControlledStartView();
		}
	}
}
