package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.ICostEstimationTab;
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
		//TODO: Implement this method
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
			myModel.calcOptWeightFactor();
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
		//TODO:Implement this method
	}

	@Override
	protected void executeEnterASAction()
	{
		controllerManager.createControlledActualStateEditView(parentView);
	}

}
