package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IWarningDialog;

/**
 * Created by phlippe on 13.06.17.
 */
public abstract class DeleteWarningController
	extends WarningController
{

	public DeleteWarningController(IModel model, IWarningDialog viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeDeleteAction()
	{
		deleteObject();
	}

	@Override
	protected void executeCancelAction()
	{
		cancelDeletion();
	}

	protected abstract void deleteObject();

	protected abstract void cancelDeletion();

}
