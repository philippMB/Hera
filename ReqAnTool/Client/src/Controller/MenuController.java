package Controller;

import Controller_Interfaces.IMenuController;
import LanguageAndText.DialogConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.FileAccessType;
import View_Interfaces.IFileChooser;

/**
 * Created by phlippe on 18.06.17.
 */
public class MenuController
	extends BasicController
	implements IMenuController
{

	public MenuController(IModel modelToBeControlled)
	{
		super(modelToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{
		ErrorCodes saveError = myModel.saveReqAn(null);
		if(saveError != ErrorCodes.NO_ERROR)
		{
			handleErrorCode(saveError);
		}
	}

	@Override
	protected void executeSaveAsAction()
	{
		IFileChooser fileChooser = controllerManager.createFileChooser(FileAccessType.SAVE);
		fileChooser.showView();
		String savePath = fileChooser.getChosenFilePath();
		if (savePath != null)
		{
			LoadingController loadingController = controllerManager.createControlledLoadingDialog(null);
			loadingController.startLoadingDialog();
			ErrorCodes openError = myModel.saveReqAn(savePath);
			loadingController.stopLoadingDialog();
			if(openError == ErrorCodes.NO_ERROR)
			{
				controllerManager.createControlledInfoDialog(
						null,
						DialogConstants.DIALOG_INFO_SAVING_FILE,
						new String[]{
								savePath
						}
				);
			}
			else
			{
				handleErrorCode(openError);
			}
		}
	}

	@Override
	protected void executeNewProjectAction()
	{
		if(controllerManager.tryClosingAllActiveViews())
		{
			controllerManager.createControlledProjectCreateView();
		}
	}

	@Override
	protected void executeOpenProjectAction()
	{
		if(controllerManager.canAllViewsBeClosed())
		{
			IFileChooser fileChooser = controllerManager.createFileChooser(FileAccessType.OPEN);
			fileChooser.showView();
			String filePath = fileChooser.getChosenFilePath();
			if (filePath != null)
			{
				//LoadingController loadingController = controllerManager.createControlledLoadingDialog();
				//loadingController.startLoadingDialog();
				ErrorCodes openError = ErrorCodes.NO_ERROR;//TODO: myModel.openReqAn(filePath);
				//loadingController.stopLoadingDialog();
				if(openError == ErrorCodes.NO_ERROR)
				{
					controllerManager.tryClosingAllActiveViews();
					controllerManager.createControlledProjectView();
				}
				else
				{
					handleErrorCode(openError);
				}
			}
		}
	}

	@Override
	protected void executeFromXMLAction()
	{
		if (controllerManager.canAllViewsBeClosed())
		{
			IFileChooser fileChooser = controllerManager.createFileChooser(FileAccessType.IMPORT);
			fileChooser.showView();
			String chosenPath = fileChooser.getChosenFilePath();
			if (chosenPath != null)
			{
				LoadingController loadingController = controllerManager.createControlledLoadingDialog(null);
				loadingController.startLoadingDialog();
				ErrorCodes importError = ErrorCodes.NO_ERROR;//TODO: myModel.import(chosenPath);
				loadingController.stopLoadingDialog();
				if (importError == ErrorCodes.NO_ERROR)
				{
					controllerManager.tryClosingAllActiveViews();
					controllerManager.createControlledProjectView();
				}
				else
				{
					handleErrorCode(importError);
					controllerManager.createControlledStartView();
				}
			}
		}
	}

	@Override
	protected void executeToXMLAction()
	{
		IFileChooser fileChooser = controllerManager.createFileChooser(FileAccessType.EXPORT);
		fileChooser.showView();
		String exportPath = fileChooser.getChosenFilePath();
		if (exportPath != null)
		{
			LoadingController loadingController = controllerManager.createControlledLoadingDialog(null);
			loadingController.startLoadingDialog();
			ErrorCodes openError = myModel.saveReqAn(exportPath);
			loadingController.stopLoadingDialog();
			if(openError == ErrorCodes.NO_ERROR)
			{
				controllerManager.createControlledInfoDialog(
						null,
						DialogConstants.DIALOG_INFO_EXPORT_FILE,
						new String[]{
								exportPath
						}
				);
			}
			else
			{
				handleErrorCode(openError);
			}
		}
	}

	@Override
	protected void executeToPDFAction()
	{
		controllerManager.createControlledInfoDialog(null, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeRateWFAction()
	{
		super.executeRateWFAction();
	}

	@Override
	protected void executeShowCEAction()
	{
		super.executeShowCEAction();
	}

	@Override
	protected void executeEditCEAction()
	{
		super.executeEditCEAction();
	}

	@Override
	protected void executeDeleteCEAction()
	{
		super.executeDeleteCEAction();
	}

	@Override
	protected void executeCalcFPAction()
	{
		super.executeCalcFPAction();
	}

	@Override
	protected void executeOptimizeWFAction()
	{
		super.executeOptimizeWFAction();
	}

	@Override
	protected void executeEnterASAction()
	{
		super.executeEnterASAction();
	}

	@Override
	protected void executeAddFReqAction()
	{
		controllerManager.createControlledFRequirementEditView(null);
	}

	@Override
	protected void executeAddNFReqAction()
	{
		controllerManager.createControlledNFRequirementEditView(null);
	}

	@Override
	protected void executeAddProdDataAction()
	{
		controllerManager.createControlledProductDataEditView(null);
	}

	@Override
	protected void executeAddQRAction()
	{
		controllerManager.createControlledInfoDialog(null, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeAddGlossaryAction()
	{
		controllerManager.createControlledInfoDialog(null, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeAddAdditionAction()
	{
		controllerManager.createControlledInfoDialog(null, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}
}
