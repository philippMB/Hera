package Controller;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.IActualStateEditView;

/**
 * Created by phlippe on 17.06.17.
 */
public class ActualStateEditController
	extends BasicViewController<IActualStateEditView>
{


	public ActualStateEditController(IModel model, IActualStateEditView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{
		String actualStateEntry = myView.getActualState();
		Number actualStateNumber = myTextBundle.convertStringToNumber(actualStateEntry);
		if(actualStateNumber != null)
		{
			saveActualState(actualStateNumber.doubleValue());
		}
		else
		{
			controllerManager.createControlledErrorDialog(
					myView,
					ErrorCodes.STRING_NO_DOUBLE,
					new String[]{
						actualStateEntry
					}
			);
		}
	}

	private void saveActualState(double actualState)
	{
		ErrorCodes saveError = myModel.setActualState(actualState);
		if (saveError != ErrorCodes.NO_ERROR)
		{
			handleErrorCode(saveError);
		}
		else
		{
			closeView();
		}
	}

	@Override
	protected void executeCancelAction()
	{
		closeView();
	}

}
