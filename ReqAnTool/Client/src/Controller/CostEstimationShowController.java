package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.ICostEstimationShowView;

/**
 * Created by phlippe on 29.06.17.
 */
public class CostEstimationShowController
	extends BasicViewController<ICostEstimationShowView>
{

	public CostEstimationShowController(IModel modelToBeControlled, ICostEstimationShowView viewToBeControlled)
	{
		super(modelToBeControlled, viewToBeControlled);
	}

	@Override
	protected void executeEditAction()
	{
		controllerManager.createControlledCostEstEditView();
		closeView();
	}

	@Override
	protected void executeCloseAction()
	{
		closeView();
	}
}
