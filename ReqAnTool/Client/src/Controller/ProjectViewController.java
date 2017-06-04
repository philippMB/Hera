package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View.ProjectView;
import View_Interfaces.*;

import java.awt.event.WindowEvent;

/**
 * Created by phlippe on 11.05.17.
 */
public class ProjectViewController
		extends BasicController <IProjectView>
{

	private WarningController controller;

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
		if(true || myModel.isReqAnUnsaved())
		{
			controller = controllerManager.createControlledWarningDialog(DialogConstants.DIALOG_TYPE_SAVE_WARNING);
		}
		else
		{
			closeView();
		}
	}

	@Override
	protected void closeView()
	{

	}

	private void saveAnalysis()
	{

	}

	private void saveAnalysisAtPath()
	{

	}

}
