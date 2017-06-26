package Controller;

import Exceptions.NumberType;
import Exceptions.StringNoNumberException;
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
			handleException(new StringNoNumberException(NumberType.DOUBLE, actualStateEntry));
		}
	}

	private void saveActualState(double actualState)
	{
		try{
			myModel.setActualState(actualState);
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
