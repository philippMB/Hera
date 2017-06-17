package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IAdditionTab;

/**
 * Created by phlippe on 17.06.17.
 */
public class AdditionTabController
	extends BasicController<IAdditionTab>
{


	public AdditionTabController(IModel model, IAdditionTab viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeAddAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeEditAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeShowAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}
}
