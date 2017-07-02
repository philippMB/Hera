package Controller;

import Controller_Interfaces.IMenuController;
import Exceptions.MissingCostEstimationException;
import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
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
		if(myModel.isFirstUseOfOpenedReqAn())
		{
			executeSaveAsAction();
		}
		else
		{
			tryToSaveReqAn();
		}
	}

	@Override
	protected void executeSaveAsAction()
	{
		accessFile(
				(absoluteFilePath) -> myModel.saveReqAn(absoluteFilePath),
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
	protected void executeCreateCEAction()
	{
		boolean creationSuccessful = tryToCreateCE();
		if(creationSuccessful)
		{
			controllerManager.createControlledCostEstimationTab(null);
		}
	}

	private boolean tryToCreateCE()
	{
		boolean costEstimationCreated = false;
		if(myModel.getCostEstimation() == null)
		{
			try
			{
				myModel.addCostEstimation();
				costEstimationCreated = true;
			}
			catch (Exception ex)
			{
				handleException(ex);
			}
		}
		return costEstimationCreated;
	}

	@Override
	protected void executeRateWFAction()
	{
		if(myModel.getCostEstimation() != null)
		{
			controllerManager.createControlledWFEditView();
		}
		else
		{
			handleException(new MissingCostEstimationException());
		}
	}

	@Override
	protected void executeShowCEAction()
	{
		if(myModel.getCostEstimation() != null)
		{
			controllerManager.createControlledCostEstShowView();
		}
		else
		{
			handleException(new MissingCostEstimationException());
		}
	}

	@Override
	protected void executeEditCEAction()
	{
		if(myModel.getCostEstimation() != null)
		{
			controllerManager.createControlledCostEstEditView();
		}
		else
		{
			handleException(new MissingCostEstimationException());
		}
	}

	@Override
	protected void executeDeleteCEAction()
	{
		if(myModel.getCostEstimation() != null)
		{
			controllerManager.createControlledWarningDialog(
					null,
					DialogConstants.DIALOG_DELETE_WARNING,
					new String[]{
							myTextBundle.getParameterText(TextNameConstants.PAR_COST_EST)
					},
					new WarningController(myModel, null)
					{
						@Override
						protected void executeDeleteAction()
						{
							try
							{
								controllerManager.removeCostEstimationViews();
								myModel.remCostEstimation();
							}
							catch (Exception ex)
							{
								handleException(ex);
							}
							closeView();
						}

						@Override
						protected void executeCancelAction()
						{
							closeView();
						}
					}
			);
		}
		else
		{
			handleException(new MissingCostEstimationException());
		}
	}

	@Override
	protected void executeCalcFPAction()
	{
		if(myModel.getCostEstimation() != null)
		{
			try
			{
				myModel.calcFPCount();
				myModel.calcManMonth();
				controllerManager.createControlledCostEstShowView();
			}
			catch (Exception ex)
			{
				handleException(ex);
			}
		}
		else
		{
			handleException(new MissingCostEstimationException());
		}
	}

	@Override
	protected void executeOptimizeWFAction()
	{
		if(myModel.getCostEstimation() != null)
		{
			controllerManager.createControlledWarningDialog(
					null,
					DialogConstants.DIALOG_WFOPT_WARNING,
					new WarningController(myModel, null)
					{
						@Override
						protected void executeOptimizeWFAction()
						{
							try
							{
								myModel.adjustWeightFactor();
							}
							catch (Exception ex)
							{
								handleException(ex);
							}
							closeView();
						}

						@Override
						protected void executeCancelAction()
						{
							closeView();
						}
					}
			);
		}
		else
		{
			handleException(new MissingCostEstimationException());
		}
	}

	@Override
	protected void executeEnterASAction()
	{
		if(myModel.getCostEstimation() != null)
		{
			controllerManager.createControlledActualStateEditView(null);
		}
		else
		{
			handleException(new MissingCostEstimationException());
		}
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
