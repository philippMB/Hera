package Controller;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.ITab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 18.06.17.
 */
public class TabController<TabType extends ITab>
	extends BasicViewController<TabType>
{

	protected IView parentView;


	public TabController(IModel model, IView parentView, TabType viewToBeControlled)
	{
		super(model, viewToBeControlled);
		this.parentView = parentView;
	}

	@Override
	protected void handleExByDialog(Exception thrownException)
	{
		controllerManager.createControlledErrorDialog(parentView, thrownException);
	}
}
