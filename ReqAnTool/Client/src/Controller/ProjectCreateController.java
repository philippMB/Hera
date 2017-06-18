package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IProjectCreateView;

import static java.lang.Thread.sleep;

/**
 * Created by phlippe on 11.06.17.
 */
public class ProjectCreateController
	extends BasicController<IProjectCreateView>
{

	private LoadingController loadingController;


	public ProjectCreateController(IModel model, IProjectCreateView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeCreateAction()
	{
		//TODO: Test values, give user feedback and create new ReqAn
		loadingController = controllerManager.createControlledLoadingDialog();
		loadingController.startLoadingDialog();
		new Thread(
				() -> {
					try
					{
						sleep(2000);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					loadingController.stopLoadingDialog();
					controllerManager.createControlledProjectView();
					closeView();
				}
		).start();
	}

	@Override
	protected void executeCancelAction()
	{
		controllerManager.createControlledStartView();
		closeView();
	}

}
