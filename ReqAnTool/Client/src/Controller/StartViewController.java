package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.FileAccessType;
import View_Interfaces.IFileChooser;
import View_Interfaces.IStartView;

/**
 * Created by phlippe on 11.06.17.
 */
public class StartViewController
	extends BasicViewController<IStartView>
{

	public StartViewController(IModel model, IStartView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeNewProjectAction()
	{
		controllerManager.createControlledProjectCreateView();
		closeView();
	}

	@Override
	protected void executeOpenProjectAction()
	{
		accessFile(
				(absolutePath) ->
				{
					//myModel.openReqAn(absolutePath);
					controllerManager.createControlledProjectView();
					closeView();
				},
				FileAccessType.OPEN,
				null
		);
	}

	@Override
	protected void executeFromXMLAction()
	{
		accessFile(
				(absolutePath) ->
				{
					//myModel.importReqAn(absolutePath);
					controllerManager.createControlledProjectView();
					closeView();
				},
				FileAccessType.IMPORT,
				null
		);
	}

	@Override
	protected void executeCloseAction()
	{
		controllerManager.closeProgram();
	}
}
