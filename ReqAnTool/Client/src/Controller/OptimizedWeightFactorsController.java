package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IOptimizedWeightFactorsView;

/**
 * Created by phlippe on 02.07.17.
 */
public class OptimizedWeightFactorsController
	extends BasicViewController<IOptimizedWeightFactorsView>
{


	public OptimizedWeightFactorsController(IModel modelToBeControlled, IOptimizedWeightFactorsView viewToBeControlled)
	{
		super(modelToBeControlled, viewToBeControlled);
	}

	@Override
	protected void executeCloseAction()
	{
		closeView();
	}
}
