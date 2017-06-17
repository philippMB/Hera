package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IErrorDialog;

/**
 * Created by phlippe on 09.06.17.
 */
public class ErrorController
	extends DialogController<IErrorDialog>
{

	public ErrorController(IModel model, IErrorDialog dialogToBeControlled)
	{
		super(model, dialogToBeControlled);
	}

	@Override
	protected void executeOKAction()
	{
		closeView();
	}

	@Override
	protected void executeCancelAction()
	{
		closeView();
	}

}
