package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IInfoDialog;

/**
 * Created by phlippe on 16.06.17.
 */
public class InfoDialogController
	extends DialogController<IInfoDialog>
{


	public InfoDialogController(IModel model, IInfoDialog viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeOKAction()
	{
		closeView();
	}

}
