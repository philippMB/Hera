package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.FileAccessType;
import View_Interfaces.IProjectTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 17.06.17.
 */
public class ProjectTabController
	extends TabController<IProjectTab>
{

	public ProjectTabController(IModel modelToBeControlled, IView parentView, IProjectTab viewToBeControlled)
	{
		super(modelToBeControlled, parentView, viewToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{
		if (myModel.isFirstUseOfOpenedReqAn())
		{
			accessFile(
					(absoluteFilePath) -> myModel.saveReqAn(absoluteFilePath),
					FileAccessType.SAVE,
					DialogConstants.DIALOG_INFO_SAVING_FILE
			);
		}
		else
		{
			tryToSaveReqAn();
		}
	}

	@Override
	protected void executeToPDFAction()
	{
		controllerManager.createControlledInfoDialog(parentView, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeToXMLAction()
	{
		accessFile(
				(absolutePath) -> {},//myModel.exportReqAn(absolutePath),
				FileAccessType.EXPORT,
				DialogConstants.DIALOG_INFO_EXPORT_FILE
		);
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledWarningDialog(
				parentView,
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
						closeView();
					}

					@Override
					protected void cancelDeletion()
					{
						closeView();
					}
				}
		);
	}

	@Override
	protected void executeCloseAction()
	{
		boolean viewsClosed = controllerManager.tryClosingAllActiveViews();
		if(viewsClosed)
		{
			controllerManager.createControlledStartView();
		}
	}

	private void deleteReqAn()
	{
		boolean isDeleted;
		try
		{
			myModel.deleteReqAn();
			isDeleted = true;
		}
		catch(Exception deleteException)
		{
			isDeleted = false;
			handleException(deleteException);
		}

		if(isDeleted)
		{
			controllerManager.forceQuitAllViews();
			controllerManager.createControlledStartView();
		}
	}
}
