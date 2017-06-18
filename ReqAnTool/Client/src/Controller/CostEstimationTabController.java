package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.ICostEstimationTab;

/**
 * Created by phlippe on 17.06.17.
 */
public class CostEstimationTabController
	extends BasicController<ICostEstimationTab>
{

	public CostEstimationTabController(IModel model, ICostEstimationTab viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeShowCEAction()
	{
		//TODO: Implement this method
		if(myModel.getCostEstimation() == null)
		{
			myModel.addCostEstimation();
		}
		controllerManager.createControlledCostEstShowView();
	}

	@Override
	protected void executeCalcFPAction()
	{
		//TODO: Implement this method
	}

	@Override
	protected void executeEditCEAction()
	{
		//TODO: Implement this method
	}

	@Override
	protected void executeOptimizeWFAction()
	{
		controllerManager.createControlledWarningDialog(
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
		ErrorCodes optimizeError = myModel.calcOptWeightFactor();
		handleErrorCode(optimizeError);
	}

	@Override
	protected void executeDeleteCEAction()
	{
		//TODO: Implement this method
	}

	@Override
	protected void executeEnterASAction()
	{
		controllerManager.createControlledActualStateEditView();
	}

}
