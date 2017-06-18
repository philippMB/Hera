package Controller;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.*;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;


import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * Created by phlippe on 11.05.17.
 */
public class ControllerManager
{

	private static ControllerManager singleton;

	private ArrayList<BasicController> allControllers;	//List of all controllers for system overview
	private IModel myModel;
	private IViewFacadeFactory myViewFacadeFactory;
	private ILogger myLogger;


	private ControllerManager(IModel model)
	{
		myModel = model;
		myViewFacadeFactory = IViewFacadeFactory.getInstance(myModel);
		myLogger = ILoggerFactory.getInstance().createLogger();
		allControllers = new ArrayList<>();

		Thread myThread = new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				for(BasicController controller:allControllers)
				{
					controller.myView.update(null,null);
				}
				try
				{
					sleep(10000);
				}
				catch(Exception e)
				{

				}
				run();
			}
		});
		myThread.start();

	}

	public static ControllerManager getInstance(IModel model)
	{
		if(singleton == null)
		{
			singleton = new ControllerManager(model);
		}
		return singleton;
	}

	public void createControlledStartView()
	{
		IStartView startView = myViewFacadeFactory.createStartView();
		StartViewController controller = new StartViewController(myModel, startView);
		allControllers.add(controller);
	}

	public void createControlledProjectCreateView()
	{
		IProjectCreateView projectCreateView = myViewFacadeFactory.createProjectCreateView();
		ProjectCreateController controller = new ProjectCreateController(myModel, projectCreateView);
		allControllers.add(controller);
	}

	public void createControlledProjectView()
	{
		IProjectView projectView = myViewFacadeFactory.createProjectView();
		ProjectViewController controller = new ProjectViewController(myModel, projectView);
		allControllers.add(controller);
	}

	public void createControlledProjectTab(IProjectView tabView)
	{
		IProjectTab projectTab = myViewFacadeFactory.createProjectTab(tabView);
		ProjectTabController controller = new ProjectTabController(myModel, projectTab);
		allControllers.add(controller);
	}

	public void createControlledCustomerTab(IProjectView tabView)
	{
		ICustomerTab customerTab = myViewFacadeFactory.createCustomerTab(tabView);
		CustomerTabController controller = new CustomerTabController(myModel, customerTab);
		allControllers.add(controller);
	}

	public void createControlledProductApplicationTab(IProjectView tabView)
	{
		IProductApplicationTab productApplicationTab = myViewFacadeFactory.createProductApplicationTab(tabView);

	}

	public void createControlledProductEnvironmentTab(IProjectView tabView)
	{
		IProductEnvironmentTab productEnvironmentTab = myViewFacadeFactory.createProductEnvironmentTab(tabView);

	}

	public void createControlledTargetDefinitionTab(IProjectView tabView)
	{
		ITargetDefinitionTab targetDefinitionTab = myViewFacadeFactory.createTargetDefinitionTab(tabView);

	}

	public void createControlledFRequirementTab(IProjectView tabView)
	{
		IFRequirementTab fRequirementTab = myViewFacadeFactory.createFRequirementTab(tabView);
		FRequirementTabController controller = new FRequirementTabController(myModel, fRequirementTab);
		allControllers.add(controller);
	}

	public void createControlledNFRequirementTab(IProjectView tabView)
	{
		INFRequirementTab nfRequirementTab = myViewFacadeFactory.createNFRequirementTab(tabView);

	}

	public void createControlledProductDataTab(IProjectView tabView)
	{
		IProductDataTab productDataTab = myViewFacadeFactory.createProductDataTab(tabView);

	}

	public void createControlledQualityRequirementTab(IProjectView tabView)
	{
		IQualityRequirementTab qualityRequirementTab = myViewFacadeFactory.createQualityRequirementTab(tabView);
		QualityReqTabController controller = new QualityReqTabController(myModel, qualityRequirementTab);
		allControllers.add(controller);
	}

	public void createControlledGlossaryTab(IProjectView tabView)
	{
		IGlossaryTab glossaryTab = myViewFacadeFactory.createGlossaryTab(tabView);
		GlossaryTabController controller = new GlossaryTabController(myModel, glossaryTab);
		allControllers.add(controller);
	}

	public void createControlledAdditionTab(IProjectView tabView)
	{
		IAdditionTab additionTab = myViewFacadeFactory.createAdditionTab(tabView);
		AdditionTabController controller = new AdditionTabController(myModel, additionTab);
		allControllers.add(controller);
	}

	public void createControlledCostEstimationTab(IProjectView tabView)
	{
		ICostEstimationTab costEstimationTab = myViewFacadeFactory.createCostEstimationTab(tabView);
		CostEstimationTabController controller = new CostEstimationTabController(myModel, costEstimationTab);
		allControllers.add(controller);
	}

	public void createAllTabsControlled(ProjectViewController projectViewController)
	{
		IProjectView tabView = projectViewController.getControlledView();
		if(tabView != null)
		{
			createControlledProjectTab(tabView);
			createControlledCustomerTab(tabView);
			createControlledProductApplicationTab(tabView);
			createControlledProductEnvironmentTab(tabView);
			createControlledTargetDefinitionTab(tabView);
			createControlledFRequirementTab(tabView);
			createControlledNFRequirementTab(tabView);
			createControlledProductDataTab(tabView);
			createControlledQualityRequirementTab(tabView);
			createControlledGlossaryTab(tabView);
			createControlledAdditionTab(tabView);
			createControlledCostEstimationTab(tabView);
		}
		else
		{
			myLogger.warning("ProjectViewController has no tabView (tabView == null).");
		}
	}

	public void createControlledActualStateEditView()
	{
		IActualStateEditView editView = myViewFacadeFactory.createActualStateEditView();
		ActualStateEditController controller = new ActualStateEditController(myModel, editView);
		allControllers.add(controller);
	}

	public void createControlledFRequirementEditView(String reqID)
	{
		IFRequirementEditView reqEditView;
		if(reqID != null)
		{
			reqEditView = myViewFacadeFactory.createIFRequirementEditView(reqID);
		}
		else
		{
			reqEditView = myViewFacadeFactory.createIFRequirementAddView();
		}
		FRequirementEditController controller = new FRequirementEditController(myModel, reqEditView);
		allControllers.add(controller);
	}

	public void createControlledFRequirementShowView(String reqID)
	{
		if(reqID != null)
		{
			RequirementShowController existingShowController = lookForExistingReqShowViewForID(reqID);
			if(existingShowController != null)
			{
				existingShowController.bringViewToFront();
			}
			else
			{
				IFRequirementShowView newShowView = myViewFacadeFactory.createIFRequirementShowView(reqID);
				FRequirementShowController controller = new FRequirementShowController(myModel, newShowView);
				allControllers.add(controller);
			}
		}
	}

	private RequirementShowController lookForExistingReqShowViewForID(String reqID)
	{
		RequirementShowController existingShowController = null;

		for(BasicController controller:allControllers)
		{
			if(controller instanceof RequirementShowController &&
					((RequirementShowController)controller).getReqID().equals(reqID))
			{
				existingShowController = (RequirementShowController)controller;
				break;
			}
		}

		return existingShowController;
	}

	public void createControlledCostEstShowView()
	{
		ICostEstimationShowView costEstimationShowView = myViewFacadeFactory.createCostEstimationShowView();
		costEstimationShowView.showView();
	}

	public void createControlledWarningDialog(String dialogPropertyName)
	{
		myLogger.info("Creating warning "+dialogPropertyName);
		WarningController controller;
		switch(dialogPropertyName)
		{
			case DialogConstants.DIALOG_SAVE_REQAN_WARNING:
				controller = new SaveWarningController(myModel,null);
				break;
			default:
				controller = null;
				break;
		}
		if(controller != null)
		{
			IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(dialogPropertyName);
			controller.setView(myWarningDialog);
		}
		allControllers.add(controller);
	}

	public void createControlledWarningDialog(String dialogPropertyName, WarningController controller)
	{
		myLogger.info("Creating warning "+dialogPropertyName+" with given controller");
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(dialogPropertyName);
		controller.setView(myWarningDialog);
		allControllers.add(controller);
	}

	public void createControlledWarningDialog(String dialogPropertyName, String[] placeholderInText, WarningController controller)
	{
		myLogger.info("Creating warning "+dialogPropertyName+" with given controller and "+
				placeholderInText.length+" placeholder elements");
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(dialogPropertyName, placeholderInText);
		controller.setView(myWarningDialog);
		allControllers.add(controller);
	}

	public void createControlledWarningDialog(String warningTitle, String warningMessage, WarningController controller)
	{
		myLogger.info("Creating warning "+warningTitle+" - "+warningMessage+" -||- Given controller");
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(warningTitle,warningMessage);
		controller.setView(myWarningDialog);
		allControllers.add(controller);
	}

	//TODO: needed and useful? text will not be generated by controller
	public void createControlledWarningDialog(String warningTitle, String warningMessage,
											  ViewActions[] buttonActions, WarningController controller)
	{
		myLogger.info("Creating warning "+warningTitle+" - "+warningMessage+" -||- Given controller"+
							"and ViewActions");
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(
																			warningTitle,
																			warningMessage,
																			buttonActions
																	);
		controller.setView(myWarningDialog);
		allControllers.add(controller);
	}

	/**
	 * Creates an {@link View.ErrorDialog} corresponding to the given errorCode and a default {@link ErrorController}
	 * to control this dialog.
	 * <p>
	 *     <b>Caution:</b> calling this method will block the running thread until the generated dialog is closed.
	 *     The belonging controller which is created here will not be added to the overall controller list due to
	 *     the view is destructed after this method.
	 * </p>
	 * @param errorCode Error which the dialog should show
	 */
	public void createControlledErrorDialog(@NotNull ErrorCodes errorCode)
	{
		IErrorDialog myErrorDialog = myViewFacadeFactory.createErrorDialog(errorCode);
		ErrorController controller = new ErrorController(myModel, myErrorDialog);
	}

	/**
	 * Creates an {@link View_Interfaces.IErrorDialog} corresponding to the given errorCode and a default
	 * {@link ErrorController} to control this dialog. The placeholder in the dialog text are replaced by elements of
	 * the given string array.
	 * <p>
	 *     <b>Caution:</b> calling this method will block the running thread until the generated dialog is closed.
	 *     The belonging controller which is created here will not be added to the overall controller list due to
	 *     the view is destructed after this method.
	 * </p>
	 * @param errorCode Error which the dialog should show
	 * @param placeholderInText Strings with which the placeholder in the dialog text should be replaced
	 *                          (see {@link LanguageAndText.ITextFacade#getDialogText(String, String[])})
	 * @see View_Interfaces.IErrorDialog
	 * @see LanguageAndText.ITextFacade#getDialogText(String, String[])
	 */
	public void createControlledErrorDialog(@NotNull ErrorCodes errorCode,@Nullable String[] placeholderInText)
	{
		IErrorDialog myErrorDialog = myViewFacadeFactory.createErrorDialog(errorCode, placeholderInText);
		ErrorController controller = new ErrorController(myModel, myErrorDialog);
	}

	/**
	 * Creates an {@link View_Interfaces.IErrorDialog} corresponding to the given errorCode. To this dialog the given
	 * {@link ErrorController} will be set as the controller. The controller will also be added to the list of all
	 * controllers in the system.
	 * <p>
	 *     <b>Caution:</b> calling this method will block the running thread until the generated dialog is closed.
	 *     The belonging controller which is given as parameter will not be added to the overall controller list due to
	 *     the view is destructed after this method.
	 * </p>
	 * @param errorCode Error which the dialog should show
	 * @param controllerForErrorDialog Controller which will control the dialog
	 * @see View_Interfaces.IErrorDialog
	 */
	public void createControlledErrorDialog(@NotNull ErrorCodes errorCode,
											@NotNull ErrorController controllerForErrorDialog)
	{
		IErrorDialog myErrorDialog = myViewFacadeFactory.createErrorDialog(errorCode);
		controllerForErrorDialog.setView(myErrorDialog);
	}

	/**
	 * Creates an {@link View_Interfaces.IErrorDialog} corresponding to the given errorCode. To this dialog the given
	 * {@link ErrorController} will be set as the controller. The controller will also be added to the list of all
	 * controllers in the system. The placeholder in the dialog text are replaced by elements of the given string array.
	 * <p>
	 *     <b>Caution:</b> calling this method will block the running thread until the generated dialog is closed.
	 *     The belonging controller which is given as parameter will not be added to the overall controller list due to
	 *     the view is destructed after this method.
	 * </p>
	 * @param errorCode Error which the dialog should show
	 * @param placeholderInText Strings with which the placeholder in the dialog text should be replaced
	 *                          (see {@link LanguageAndText.ITextFacade#getDialogText(String, String[])})
	 * @param controllerForErrorDialog Controller which will control the dialog
	 * @see View_Interfaces.IErrorDialog
	 * @see LanguageAndText.ITextFacade#getDialogText(String, String[])
	 */
	public void createControlledErrorDialog(@NotNull ErrorCodes errorCode,@Nullable String[] placeholderInText,
											@NotNull ErrorController controllerForErrorDialog)
	{
		IErrorDialog myErrorDialog = myViewFacadeFactory.createErrorDialog(errorCode, placeholderInText);
		controllerForErrorDialog.setView(myErrorDialog);
	}

	public void createControlledInfoDialog(@NotNull String dialogPropertyName)
	{
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(dialogPropertyName);
		InfoDialogController controller = new InfoDialogController(myModel, myInfoDialog);
	}

	public void createControlledInfoDialog(@NotNull String dialogPropertyName,
										   @NotNull InfoDialogController controllerForInfoDialog)
	{
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(dialogPropertyName);
		controllerForInfoDialog.setView(myInfoDialog);
	}

	public void createControlledInfoDialog(@NotNull String dialogPropertyName,
										   @Nullable String[] placeholderInDialogText)
	{
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(dialogPropertyName, placeholderInDialogText);
		InfoDialogController controller = new InfoDialogController(myModel, myInfoDialog);
	}

	public void createControlledInfoDialog(@NotNull String dialogPropertyName,
										   @Nullable String[] placeholderInDialogText,
										   @NotNull InfoDialogController controllerForInfoDialog)
	{
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(dialogPropertyName, placeholderInDialogText);
		controllerForInfoDialog.setView(myInfoDialog);
	}

	public void createControlledInfoDialog(@NotNull String dialogTitle,@NotNull String dialogInfoMessage)
	{
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(dialogTitle, dialogInfoMessage);
		InfoDialogController controller = new InfoDialogController(myModel, myInfoDialog);
	}

	public LoadingController createControlledLoadingDialog()
	{
		ILoadingDialog myLoadingDialog = myViewFacadeFactory.createLoadingDialog();
		LoadingController controller = new LoadingController(myModel, myLoadingDialog);
		allControllers.add(controller);
		return controller;
	}

	/**
	 * Removes the given controller from the list of all controller. Should be done if controller is not used anymore.
	 * @param controllerToBeRemoved Controller which should be removed from the list
	 */
	public void removeController(BasicController controllerToBeRemoved)
	{
		allControllers.remove(controllerToBeRemoved);
		myLogger.info("Removed controller "+controllerToBeRemoved.getClass().toString());
	}


	/**
	 * Calls every controller to close his view and terminates the program afterwards.
	 */
	public boolean closeProgram()
	{
		boolean canBeClosed = closeAllActiveViews();
		if(canBeClosed)
		{
			System.out.println("Close Program");
			System.exit(0);
		}
		else
		{
			System.out.println("Could not close Program");
		}
		return canBeClosed;
	}

	public boolean closeAllActiveViews()
	{
		boolean canBeClosed = canAllViewsBeClosed();
		if(canBeClosed)
		{
			while (allControllers.size() != 0)
			{
				BasicController controllerToClose = allControllers.get(0);
				controllerToClose.closeView();
				if(allControllers.contains(controllerToClose))
				{
					removeController(controllerToClose);
				}
			}
		}
		return canBeClosed;
	}

	public boolean canAllViewsBeClosed()
	{
		boolean canBeClosed = true;
		for(int controllerIndex = 0; controllerIndex < allControllers.size(); controllerIndex++)
		{
			canBeClosed = canBeClosed & allControllers.get(controllerIndex).canViewBeClosed();
		}
		return canBeClosed;
	}

	public IFileChooser createFileChooser(FileAccessType accessType)
	{
		IFileChooser myFileChooser = myViewFacadeFactory.createFileChooser(null, accessType);
		return myFileChooser;
	}


}
