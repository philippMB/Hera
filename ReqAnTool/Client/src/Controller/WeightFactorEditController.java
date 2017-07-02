package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IWeightFactorEditView;

/**
 * Created by phlippe on 01.07.17.
 */
public class WeightFactorEditController
	extends BasicViewController<IWeightFactorEditView>
{


	public WeightFactorEditController(IModel modelToBeControlled, IWeightFactorEditView viewToBeControlled)
	{
		super(modelToBeControlled, viewToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{
		try
		{
			myModel.rateWeightFactor(myView.getAllWeightFactorValues());
			closeView();
		}
		catch(Exception ex)
		{
			handleException(ex);
		}
	}

	@Override
	protected void executeCancelAction()
	{
		closeView();
	}
}
