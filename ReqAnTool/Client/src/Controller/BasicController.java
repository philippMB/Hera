package Controller;

import Controller_Interfaces.IController;
import Controller_Interfaces.ViewActions;
import Logging.LogSystem;
import Model_Interfaces.IModel;
import View_Interfaces.IView;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 * Created by phlippe on 11.05.17.
 */
public abstract class BasicController <ViewType extends IView>
	implements IController
{

	protected ControllerManagement controllerManager;
	protected IModel myModel;
	protected ViewType myView;


	public BasicController(IModel modelToBeControlled, ViewType viewToBeControlled)
	{
		myModel = modelToBeControlled;
		setView(viewToBeControlled);
		controllerManager = ControllerManagement.getInstance(myModel);
	}

	public void setView(ViewType viewToBeControlled)
	{
		//TODO: Controller muss sich von View abmelden
		myView = viewToBeControlled;

		if(myView != null)
		{
			myView.addController(this);
		}
		else
		{
			System.out.println("View ist null");
		}
	}

	public ViewType getControlledView()
	{
		return myView;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		String actionCommand = event.getActionCommand();
		ViewActions viewAction = ViewActions.valueOf(actionCommand);

		switch(viewAction)
		{
			case OK:
				executeOKAction();
				break;
			case CANCEL:
				executeCancelAction();
				break;
			case SAVE:
				executeSaveAction();
				break;
			case SAVE_AS:
				executeSaveAsAction();
				break;
			case DONT_SAVE:
				executeDontSaveAction();
				break;
			case ADD:
				executeAddAction();
				break;
			case DELETE:
				executeDeleteAction();
				break;
			case EDIT:
				executeEditAction();
				break;
			case SHOW:
				executeShowAction();
				break;
			case CLOSE:
				executeCloseAction();
				break;
			case BACK:
				executeBackAction();
				break;
			case TABLE_SELECTION_ADD:
				executeTableSelectionAddAction();
				break;
			case TABLE_SELECTION_DELETE:
				executeTableSelectionDeleteAction();
				break;
			case OPEN:
				executeOpenAction();
				break;
			case NEW:
				executeNewAction();
				break;
			case NEW_PROJECT:
				executeNewProjectAction();
				break;
			case OPEN_PROJECT:
				executeOpenProjectAction();
				break;
			case TEXT_CHANGED:
				executeTextChangedAction();
				break;
			case FROM_XML:
				executeFromXMLAction();
				break;
			case TO_XML:
				executeToXMLAction();
				break;
			case TO_PDF:
				executeToPDFAction();
				break;
			case RATE:
				executeRateAction();
				break;
			case RATE_WF:
				executeRateWFAction();
				break;
			case SHOW_CE:
				executeShowCEAction();
				break;
			case EDIT_CE:
				executeEditCEAction();
				break;
			case DELETE_CE:
				executeDeleteCEAction();
				break;
			case CALC_FP:
				executeCalcFPAction();
				break;
			case OPTIMIZE_WF:
				executeOptimizeWFAction();
				break;
			case ENTER_AS:
				executeEnterASAction();
				break;
			case EDIT_EP:
				executeEditEPAction();
				break;
			case RESET:
				executeResetAction();
				break;
			case CREATE:
				executeCreateAction();
				break;
			default:
				executeDefaultAction(event);
				break;
		}
	}

	protected void executeOKAction()
	{
		logMissingActionExecution(ViewActions.OK);
	}

	protected void executeCancelAction()
	{
		logMissingActionExecution(ViewActions.CANCEL);
	}

	protected void executeSaveAction()
	{
		logMissingActionExecution(ViewActions.SAVE);
	}

	protected void executeSaveAsAction()
	{
		logMissingActionExecution(ViewActions.SAVE_AS);
	}

	protected void executeDontSaveAction()
	{
		logMissingActionExecution(ViewActions.DONT_SAVE);
	}

	protected void executeAddAction()
	{
		logMissingActionExecution(ViewActions.ADD);
	}

	protected void executeDeleteAction()
	{
		logMissingActionExecution(ViewActions.DELETE);
	}

	protected void executeEditAction()
	{
		logMissingActionExecution(ViewActions.EDIT);
	}

	protected void executeShowAction()
	{
		logMissingActionExecution(ViewActions.SHOW);
	}

	protected void executeCloseAction()
	{
		logMissingActionExecution(ViewActions.CLOSE);
	}

	protected void executeBackAction()
	{
		logMissingActionExecution(ViewActions.BACK);
	}

	protected void executeTableSelectionAddAction()
	{
		logMissingActionExecution(ViewActions.TABLE_SELECTION_ADD);
	}

	protected void executeTableSelectionDeleteAction()
	{
		logMissingActionExecution(ViewActions.TABLE_SELECTION_DELETE);
	}

	protected void executeOpenAction()
	{
		logMissingActionExecution(ViewActions.OPEN);
	}

	protected void executeNewAction()
	{
		logMissingActionExecution(ViewActions.NEW);
	}

	protected void executeNewProjectAction()
	{
		logMissingActionExecution(ViewActions.NEW_PROJECT);
	}

	protected void executeOpenProjectAction()
	{
		logMissingActionExecution(ViewActions.OPEN);
	}

	protected void executeTextChangedAction()
	{
		logMissingActionExecution(ViewActions.TEXT_CHANGED);
	}

	protected void executeFromXMLAction()
	{
		logMissingActionExecution(ViewActions.FROM_XML);
	}

	protected void executeToXMLAction()
	{
		logMissingActionExecution(ViewActions.TO_XML);
	}

	protected void executeToPDFAction()
	{
		logMissingActionExecution(ViewActions.TO_PDF);
	}

	protected void executeRateAction()
	{
		logMissingActionExecution(ViewActions.RATE);
	}

	protected void executeRateWFAction()
	{
		logMissingActionExecution(ViewActions.RATE_WF);
	}

	protected void executeShowCEAction()
	{
		logMissingActionExecution(ViewActions.SHOW_CE);
	}

	protected void executeEditCEAction()
	{
		logMissingActionExecution(ViewActions.EDIT_CE);
	}

	protected void executeDeleteCEAction()
	{
		logMissingActionExecution(ViewActions.DELETE);
	}

	protected void executeCalcFPAction()
	{
		logMissingActionExecution(ViewActions.CALC_FP);
	}

	protected void executeOptimizeWFAction()
	{
		logMissingActionExecution(ViewActions.OPTIMIZE_WF);
	}

	protected void executeEnterASAction()
	{
		logMissingActionExecution(ViewActions.ENTER_AS);
	}

	protected void executeEditEPAction()
	{
		logMissingActionExecution(ViewActions.EDIT_EP);
	}

	protected void executeResetAction()
	{
		logMissingActionExecution(ViewActions.RESET);
	}

	protected void executeCreateAction()
	{
		logMissingActionExecution(ViewActions.CREATE);
	}

	protected void executeDefaultAction(ActionEvent action)
	{

	}

	private void logMissingActionExecution(ViewActions action)
	{
		Logging.Logger myLogger = LogSystem.getLogger();
		String warningMsg = "Action "+action.toString()+" was performed without any execution by the controller.\n";
		warningMsg += "Controller:"+this.getClass().toString()+"\n";
		warningMsg += "View:"+myView.getClass().toString()+"\n";
		myLogger.warning( warningMsg );
	}

	@Override
	public void windowOpened(WindowEvent e)
	{

	}

	@Override
	public void windowClosing(WindowEvent e)
	{

	}

	@Override
	public void windowClosed(WindowEvent e)
	{

	}

	@Override
	public void windowIconified(WindowEvent e)
	{

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{

	}

	@Override
	public void windowActivated(WindowEvent e)
	{

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{

	}

	protected abstract void closeView();

}
