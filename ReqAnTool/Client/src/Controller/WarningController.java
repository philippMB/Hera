package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IWarningDialog;

/**
 * Created by phlippe on 24.05.17.
 */
public class WarningController
	extends DialogController<IWarningDialog>
{

	public WarningController(IModel model, IWarningDialog viewToBeControlled)
	{
		super(model,viewToBeControlled);
	}

}