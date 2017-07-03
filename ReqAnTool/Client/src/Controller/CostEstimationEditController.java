package Controller;

import Exceptions.NoItemSelectedException;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.ICostEstimationEditView;

/**
 * Created by phlippe on 29.06.17.
 */
public class CostEstimationEditController
	extends BasicViewController<ICostEstimationEditView>
{

	public CostEstimationEditController(IModel modelToBeControlled, ICostEstimationEditView viewToBeControlled)
	{
		super(modelToBeControlled, viewToBeControlled);
	}

	@Override
	protected void executeEditEPAction()
	{
		String reqID = myView.getSelectedID();
		if(reqID == null)
		{
			handleException(new NoItemSelectedException(TextNameConstants.PAR_ELEMENTARY_PROCESSES));
		}
		else
		{
			controllerManager.createControlledProcClassView(reqID);
		}
	}

	@Override
	protected void executeRateWFAction()
	{
		controllerManager.createControlledWFEditView();
	}

	@Override
	protected void executeShowAction()
	{
		controllerManager.createControlledCostEstShowView();
		closeView();
	}

	@Override
	protected void executeCloseAction()
	{
		closeView();
	}
}
