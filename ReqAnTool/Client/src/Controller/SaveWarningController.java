package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.FileAccessType;
import View_Interfaces.IWarningDialog;

/**
 * Created by phlippe on 24.05.17.
 */
public class SaveWarningController
	extends WarningController
{

	public SaveWarningController(IModel model, IWarningDialog viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{
		if(myModel.isFirstUseOfOpenedReqAn())
		{
			executeSaveAsAction();
		}
		else
		{
			if(tryToSaveReqAn())
			{
				closeProgram();
			}
		}
	}

	@Override
	protected void executeSaveAsAction()
	{
		closeView();
		accessFile(
				absoluteFilePath -> {myModel.saveReqAn(absoluteFilePath); closeProgram();},
				FileAccessType.SAVE,
				DialogConstants.DIALOG_INFO_SAVING_FILE
		);
	}

	@Override
	protected void executeDontSaveAction()
	{
		closeProgram();
	}

	@Override
	protected void executeCancelAction()
	{
		closeView();
	}

	/**
	 * Function which is executed if file is saved or should not be saved. Could be overwritten when needed.
	 * Default action is closing whole application.
	 */
	protected void closeProgram()
	{
		controllerManager.closeProgram();
	}

}
