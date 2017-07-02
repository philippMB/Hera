package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IProjectCreateView;

import java.awt.event.WindowEvent;

import static java.lang.Thread.sleep;

/**
 * Created by phlippe on 11.06.17.
 */
public class ProjectCreateController
	extends BasicViewController<IProjectCreateView>
{

	private LoadingController loadingController;


	public ProjectCreateController(IModel model, IProjectCreateView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeCreateAction()
	{
		loadingController = controllerManager.createControlledLoadingDialog(myView);
		loadingController.startLoadingDialog();
		tryToCreateNewReqAn();
		loadingController.stopLoadingDialog();
	}

	private void tryToCreateNewReqAn()
	{
		boolean creationSuccessful;
		try
		{
			createNewReqAn();
			creationSuccessful = true;
		}
		catch(Exception ex)
		{
			creationSuccessful = false;
			handleException(ex);
		}
		if(creationSuccessful)
		{
			controllerManager.createControlledProjectView();
			closeView();
		}
	}

	private void createNewReqAn() throws Exception
	{
		myModel.makeNewReqAn(
				myView.getProjectTitle(),
				myView.getSuppName(),
				myView.getSuppEMail(),
				myView.getSuppPhoneNumber(),
				myView.getCompName(),
				myView.getCompCity(),
				myView.getCompStreet(),
				myView.getCompCountry(),
				myView.getCompPLZ(),
				myView.getCustName(),
				myView.getCustEMail(),
				myView.getCustPhoneNumber()
		);
	}

	@Override
	protected void executeCancelAction()
	{
		controllerManager.createControlledStartView();
		closeView();
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		executeCancelAction();
	}

	@Override
	protected void handleExByDialog(Exception thrownException)
	{
		if(loadingController != null)
		{
			loadingController.stopLoadingDialog();
		}
		super.handleExByDialog(thrownException);
	}
}
