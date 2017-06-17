package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.FileAccessType;
import View_Interfaces.IFileChooser;
import View_Interfaces.IStartView;

/**
 * Created by phlippe on 11.06.17.
 */
public class StartViewController
	extends BasicController<IStartView>
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
		IFileChooser myFileChooser = controllerManager.createFileChooser(FileAccessType.OPEN);
		myFileChooser.showView();
		String filePath = myFileChooser.getChosenFilePath();

		if(filePath != null)
		{
			//TODO: Model open ReqAn
			controllerManager.createControlledProjectView();
			closeView();
		}
		else
		{

		}
	}

	@Override
	protected void executeCloseAction()
	{
		controllerManager.closeProgram();
	}
}
