package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.*;

import java.awt.event.WindowEvent;

/**
 * Created by phlippe on 11.05.17.
 */
public class ProjectViewController
		extends BasicViewController<IProjectView>
{

	boolean couldBeClosed;


	public ProjectViewController(IModel model, IProjectView projectView)
	{
		super(model, projectView);
		buildAllTabs();
	}

	private void buildAllTabs()
	{
		controllerManager.createAllTabsControlled(this);
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		controllerManager.closeProgram();
	}

	private boolean tryToSaveReqAn()
	{
		//TODO: Implement this method
		return true;
	}

	private void saveAnalysisAtPath()
	{

	}

	@Override
	protected boolean canViewBeClosed()
	{
		couldBeClosed = false && !myModel.isReqAnUnsaved();
		if(!couldBeClosed)
		{
			controllerManager.createControlledWarningDialog(
					myView,
					DialogConstants.DIALOG_SAVE_REQAN_WARNING,
					new SaveWarningController(myModel, null)
					{
						@Override
						protected void executeSaveAction()
						{
							closeView();
							couldBeClosed = tryToSaveReqAn();
						}

						@Override
						protected void executeDontSaveAction()
						{
							closeView();
							couldBeClosed = true;
						}

						@Override
						protected void executeCancelAction()
						{
							closeView();
							couldBeClosed = false;
						}
					}
			);
		}
		return couldBeClosed;
	}
}
