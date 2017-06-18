package Controller;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.IActualStateEditView;

/**
 * Created by phlippe on 17.06.17.
 */
public class ActualStateEditController
	extends BasicController<IActualStateEditView>
{


	public ActualStateEditController(IModel model, IActualStateEditView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{
		String actualStateEntry = myView.getActualState();
		Double actualState = parseToDouble(actualStateEntry);
		if(actualState != null)
		{
			saveActualState(actualState);
		}
		else
		{
			controllerManager.createControlledErrorDialog(
					ErrorCodes.STRING_NO_DOUBLE,
					new String[]{
						actualStateEntry
					}
			);
		}
	}

	private Double parseToDouble(String castToDouble)
	{
		Double result = null;
		try{
			result = Double.parseDouble(castToDouble);
		}
		catch(NumberFormatException ex)
		{
			myLogger.info("Tried to parse \""+castToDouble+"\" to double but it was not possible:\n"+
							ex.getMessage());
		}
		catch(NullPointerException ex)
		{
			myLogger.warning("Tried to parse a string to double but it was null", ex);
		}
		return result;
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
