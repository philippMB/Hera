package Controller;

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
		//TODO: Implement this method
	}

	@Override
	protected void executeDeleteCEAction()
	{
		//TODO: Implement this method
	}

	@Override
	protected void executeEnterASAction()
	{
		//TODO: Implement this method
	}

}
