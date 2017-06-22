package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IAdditionTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 17.06.17.
 */
public class AdditionTabController
	extends TabController<IAdditionTab>
{


	public AdditionTabController(IModel model, IView parentView, IAdditionTab viewToBeControlled)
	{
		super(model, parentView, viewToBeControlled);
	}

	@Override
	protected void executeAddAction()
	{
		controllerManager.createControlledInfoDialog(parentView, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeEditAction()
	{
		controllerManager.createControlledInfoDialog(parentView, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeShowAction()
	{
		controllerManager.createControlledInfoDialog(parentView, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledInfoDialog(parentView, DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}
}
