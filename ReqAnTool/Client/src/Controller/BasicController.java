package Controller;

import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import com.sun.istack.internal.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by phlippe on 18.06.17.
 */
public class BasicController
	implements ActionListener
{

	protected ControllerManager controllerManager;
	protected IModel myModel;
	protected ILogger myLogger;
	private ILogger actionLogger;
	protected ITextFacade myTextBundle;


	public BasicController(@NotNull IModel modelToBeControlled)
	{
		myModel = modelToBeControlled;
		myLogger = ILoggerFactory.getInstance().createLogger();
		actionLogger = ILoggerFactory.getInstance().createLogger("ReqAn_actionLogger");
		controllerManager = ControllerManager.getInstance(myModel);
		myTextBundle = ITextFacade.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		String actionCommand = event.getActionCommand();
		ViewActions viewAction = null;
		try
		{
			viewAction = ViewActions.fromString(actionCommand);
		}
		catch(IllegalArgumentException ex)
		{
			String logMessage = "Controller "+this.getClass().toString()+
					" got ActionCommand \""+actionCommand+"\" which is no viewAction.";
			myLogger.error(logMessage, ex);
			actionLogger.error(logMessage, ex);
		}

		if(viewAction != null)
		{
			actionLogger.info(this.getClass().toString()+": performing "+viewAction.toString());
			switch (viewAction)
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
				case ADD_FREQ:
					executeAddFReqAction();
					break;
				case ADD_NFREQ:
					executeAddNFReqAction();
					break;
				case ADD_PROD:
					executeAddProdDataAction();
					break;
				case ADD_QR:
					executeAddQRAction();
					break;
				case ADD_GLOS:
					executeAddGlossaryAction();
					break;
				case ADD_ADDIT:
					executeAddAdditionAction();
					break;
				default:
					executeDefaultAction(event);
					break;
			}
		}
		else
		{
			actionLogger.warning("Default action will be executed for command "+actionCommand);
			executeDefaultAction(event);
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

	protected void executeAddFReqAction()
	{
		logMissingActionExecution(ViewActions.ADD_FREQ);
	}

	protected void executeAddNFReqAction()
	{
		logMissingActionExecution(ViewActions.ADD_NFREQ);
	}

	protected void executeAddProdDataAction()
	{
		logMissingActionExecution(ViewActions.ADD_PROD);
	}

	protected void executeAddQRAction()
	{
		logMissingActionExecution(ViewActions.ADD_QR);
	}

	protected void executeAddGlossaryAction()
	{
		logMissingActionExecution(ViewActions.ADD_GLOS);
	}

	protected void executeAddAdditionAction()
	{
		logMissingActionExecution(ViewActions.ADD_ADDIT);
	}

	protected void executeDefaultAction(ActionEvent action)
	{

	}

	private void logMissingActionExecution(ViewActions action)
	{
		String warningMsg = "Action "+action.toString()+" was performed without any execution by the controller.\n";
		warningMsg += "Controller:"+this.getClass().toString()+"\n";
		myLogger.warning( warningMsg );
		actionLogger.warning( warningMsg );
	}

	protected void handleErrorCode(ErrorCodes errorCode)
	{
		handleErrorCode(errorCode, 0);
	}

	protected void handleErrorCode(ErrorCodes errorCode, int errorID)
	{

		switch(errorCode)
		{
			case NO_ERROR:
				handleECNoError(errorID);
				break;
			case NO_REQAN:
				handleECNoReqan(errorID);
				break;
			case DUPLICATE:
				handleECDuplicate(errorID);
				break;
			case INVALID_ID:
				handleECInvalidID(errorID);
				break;
			case INVALID_MAIL:
				handleECInvalidMail(errorID);
				break;
			case INVALID_PHONE:
				handleECInvalidPhone(errorID);
				break;
			case INVALID_ADDRESS:
				handleECInvalidAddress(errorID);
				break;
			case INVALID_ARGUMENT:
				handleECInvalidArgument(errorID);
				break;
			case NOT_EXISTENT:
				handleECNotExistent(errorID);
				break;
			case NULL_POINTER:
				handleECNullPointer(errorID);
				break;
			case LIST_OVERFLOW:
				handleECListOverflow(errorID);
				break;
			case FP_NOT_EXISTENT:
				handleECFPNotExistent(errorID);
				break;
			case NO_COST_ESTIMATION:
				handleECNoCostEstimation(errorID);
				break;
			case REFERENCES_NOT_SOLVED:
				handleECRefNotSolved(errorID);
				break;
			case REFERENCES_ON_ITEM_DELETED:
				handleECRefOnItemDeleted(errorID);
				break;
			default:
				handleDefaultEC();
				break;
		}

	}

	protected void handleECNoError(int errorID)
	{
		//No action, when no error occurred
	}

	protected void handleECNoReqan(int errorID)
	{
		handleECByDefault(ErrorCodes.NO_REQAN, errorID);
	}

	protected void handleECDuplicate(int errorID)
	{
		handleECByDefault(ErrorCodes.DUPLICATE, errorID);
	}

	protected void handleECInvalidID(int errorID)
	{
		handleECByDefault(ErrorCodes.INVALID_ID, errorID);
	}

	protected void handleECInvalidMail(int errorID)
	{
		handleECByDefault(ErrorCodes.INVALID_MAIL, errorID);
	}

	protected void handleECInvalidPhone(int errorID)
	{
		handleECByDefault(ErrorCodes.INVALID_PHONE, errorID);
	}

	protected void handleECInvalidAddress(int errorID)
	{
		handleECByDefault(ErrorCodes.INVALID_ADDRESS, errorID);
	}

	protected void handleECInvalidArgument(int errorID)
	{
		handleECByDefault(ErrorCodes.INVALID_ARGUMENT, errorID);
	}

	protected void handleECNotExistent(int errorID)
	{
		handleECByDefault(ErrorCodes.NOT_EXISTENT, errorID);
	}

	protected void handleECNullPointer(int errorID)
	{
		handleECByDefault(ErrorCodes.NULL_POINTER, errorID);
	}

	protected void handleECListOverflow(int errorID)
	{
		handleECByDefault(ErrorCodes.LIST_OVERFLOW,errorID);
	}

	protected void handleECFPNotExistent(int errorID)
	{
		handleECByDefault(ErrorCodes.NOT_EXISTENT,errorID);
	}

	protected void handleECNoCostEstimation(int errorID)
	{
		handleECByDefault(ErrorCodes.NO_COST_ESTIMATION,errorID);
	}

	protected void handleECRefNotSolved(int errorID)
	{
		handleECByDefault(ErrorCodes.REFERENCES_NOT_SOLVED,errorID);
	}

	protected void handleECRefOnItemDeleted(int errorID)
	{
		handleECByDefault(ErrorCodes.REFERENCES_ON_ITEM_DELETED,errorID);
	}

	protected void handleDefaultEC()
	{

	}

	protected void handleECByDefault(ErrorCodes errorCode, int errorID)
	{
		handleECByDialog(errorCode);
		logErrorCode(errorCode, errorID);
	}

	protected void handleECByDialog(ErrorCodes errorCode)
	{
		controllerManager.createControlledErrorDialog(null, errorCode);
	}

	protected void logErrorCode(ErrorCodes errorCode, int errorID)
	{
		String warningMsg = "ErrorCode "+errorCode.toString()+" (ID = "+errorID+")"
				+" occurred with default execution of BasicController.\n";
		warningMsg += "Controller:"+this.getClass().toString()+"\n";
		myLogger.warning( warningMsg );
	}

}
