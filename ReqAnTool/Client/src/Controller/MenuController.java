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
		try
		{
			myModel.saveReqAn(null);
		}
		catch(Exception saveException)
		{
			handleException(saveException);
		}
	}

	@Override
	protected void executeSaveAsAction()
	{
		accessFile(
				(absoluteFile) -> myModel.saveReqAn(absoluteFile),
				FileAccessType.SAVE,
				DialogConstants.DIALOG_INFO_SAVING_FILE
		);
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
			accessFile(
					(absolutePath) -> {
						//myModel.openReqAn(absolutePath);
						controllerManager.forceQuitAllViews();
						controllerManager.createControlledProjectView();
					},
					FileAccessType.OPEN,
					null
			);
		}
	}

	@Override
	protected void executeFromXMLAction()
	{
		if (controllerManager.canAllViewsBeClosed())
		{
			accessFile(
					(absolutePath) -> {
						//myModel.importReqAn(absolutePath);
						controllerManager.forceQuitAllViews();
						controllerManager.createControlledProjectView();
					},
					FileAccessType.IMPORT,
					null
			);
		}
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
