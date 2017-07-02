package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.ICostEstimationTab;
import View_Interfaces.ILoadingDialog;
import View_Interfaces.IView;

/**
 * Created by phlippe on 17.06.17.
 */
public class CostEstimationTabController
	extends TabController<ICostEstimationTab>
{

	public CostEstimationTabController(IModel model, IView parentView, ICostEstimationTab viewToBeControlled)
	{
		super(model, parentView, viewToBeControlled);
	}

	@Override
	protected void executeShowCEAction()
	{
		controllerManager.createControlledCostEstShowView();
	}

	@Override
	protected void executeCalcFPAction()
	{
		boolean isFPCalculated;
		LoadingController loadingController = controllerManager.createControlledLoadingDialog(parentView);
		loadingController.startLoadingDialog();
		try
		{
			myModel.calcFPCount();
			isFPCalculated = true;
		}
		catch (Exception ex)
		{
			loadingController.stopLoadingDialog();
			isFPCalculated = false;
			handleException(ex);
		}
		if(isFPCalculated)
		{
			loadingController.stopLoadingDialog();
			controllerManager.createControlledCostEstShowView();
		}
	}

	@Override
	protected void executeEditCEAction()
	{
		controllerManager.createControlledCostEstEditView();
	}

	@Override
	protected void executeOptimizeWFAction()
	{
		controllerManager.createControlledWarningDialog(
				parentView,
				DialogConstants.DIALOG_WFOPT_WARNING,
				new WarningController(myModel, null)
				{
					@Override
					protected void executeOptimizeWFAction()
					{
						closeView();
						optimizeWF();
					}

					@Override
					protected void executeCancelAction()
					{
						closeView();
					}
				}
		);
	}

	private void optimizeWF()
	{
		try
		{
			myModel.adjustWeightFactor();	//TODO: Namen ändern
		}
		catch(Exception optimizeError)
		{
			handleException(optimizeError);
		}
	}

	@Override
	protected void executeDeleteCEAction()
	{
		controllerManager.createControlledWarningDialog(
				parentView,
				DialogConstants.DIALOG_DELETE_WARNING,
				new String[]{
						myTextBundle.getParameterText(TextNameConstants.PAR_COST_EST)
				},
				new WarningController(myModel, null)
				{
					@Override
					protected void executeDeleteAction()
					{
						deleteCostEstimation();
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

	private void deleteCostEstimation()
	{
		boolean isRemoved;
		try
		{
			controllerManager.removeCostEstimationViews();
			myModel.remCostEstimation();
			isRemoved = true;
		}
		catch(Exception ex)
		{
			isRemoved = false;
			handleException(ex);
		}
		if(!isRemoved)
		{
			controllerManager.createControlledCostEstimationTab(null);
		}
	}

	@Override
	protected void executeEnterASAction()
	{
		controllerManager.createControlledActualStateEditView(parentView);
	}

}
