package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IProjectCreateView;

/**
 * Created by phlippe on 11.06.17.
 */
public class ProjectCreateController
	extends BasicController<IProjectCreateView>
{

	public ProjectCreateController(IModel model, IProjectCreateView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeCreateAction()
	{
		//TODO: Test values, give user feedback and create new ReqAn
		controllerManager.createControlledProjectView();
		closeView();
	}

	@Override
	protected void executeCancelAction()
	{
		controllerManager.createControlledStartView();
		closeView();
	}

}
