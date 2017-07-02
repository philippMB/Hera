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

	private boolean couldBeClosed;


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

	private boolean saveReqAn()
	{
		boolean isSaved;
		if(myModel.isFirstUseOfOpenedReqAn())
		{
			isSaved = accessFile(
					absoluteFilePath -> myModel.saveReqAn(absoluteFilePath),
					FileAccessType.SAVE,
					DialogConstants.DIALOG_INFO_SAVING_FILE);
		}
		else
		{
			isSaved = tryToSaveReqAn();
		}
		return isSaved;
	}

	@Override
	protected boolean canViewBeClosed()
	{
		couldBeClosed = !myModel.isReqAnUnsaved();
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
							couldBeClosed = saveReqAn();
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
