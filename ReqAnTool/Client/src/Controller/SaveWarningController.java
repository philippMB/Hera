package Controller;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.FileAccessType;
import View_Interfaces.IFileChooser;
import View_Interfaces.IViewFacadeFactory;
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
		ErrorCodes errorCode = myModel.saveReqAn(null);
		handleErrorCode(errorCode);
		if(errorCode == ErrorCodes.NO_ERROR)
		{
			closeProgram();
		}
	}

	@Override
	protected void executeSaveAsAction()
	{
		IFileChooser myFileChooser = controllerManager.createFileChooser(FileAccessType.SAVE);
		myFileChooser.showView();
		String filePath = myFileChooser.getChosenFilePath();

		if(filePath != null)
		{
			ErrorCodes errorCode = myModel.saveReqAn(filePath);
			handleErrorCode(errorCode);
			if(errorCode == ErrorCodes.NO_ERROR)
			{
				closeProgram();
			}
		}
		else
		{
			closeView();
		}
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
