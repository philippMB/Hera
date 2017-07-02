package Controller;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import Logging.ILogger;
import Logging.ILoggerFactory;
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

	private ArrayList<BasicViewController> allViewControllers;	//List of all view controllers for system overview
	private MenuController menuController;
	private IModel myModel;
	private IViewFacadeFactory myViewFacadeFactory;
	private ILogger myLogger;
	private ILogger managerLogger;


	private ControllerManager(IModel model)
	{
		myModel = model;
		myViewFacadeFactory = IViewFacadeFactory.getInstance(myModel);
		myLogger = ILoggerFactory.getInstance().createLogger();
		managerLogger = ILoggerFactory.getInstance().createLogger("ReqAn_controllerManagement");
		allViewControllers = new ArrayList<>();
	}

	public static ControllerManager getInstance(IModel model)
	{
		if(singleton == null)
		{
			singleton = new ControllerManager(model);
			singleton.createMenuController();
		}
		return singleton;
	}

	private void createMenuController()
	{
		menuController = new MenuController(myModel);
	}

	public void createControlledStartView()
	{
		managerLogger.info("Creating StartView");
		IStartView startView = myViewFacadeFactory.createStartView();
		StartViewController controller = new StartViewController(myModel, startView);
		addControllerToSystem(controller);
	}

	public void createControlledProjectCreateView()
	{
		managerLogger.info("Creating ProjectCreateView");
		IProjectCreateView projectCreateView = myViewFacadeFactory.createProjectCreateView();
		ProjectCreateController controller = new ProjectCreateController(myModel, projectCreateView);
		addControllerToSystem(controller);
	}

	public void createControlledProjectView()
	{
		managerLogger.info("Creating ProjectView");
		IProjectView projectView = myViewFacadeFactory.createProjectView();
		ProjectViewController controller = new ProjectViewController(myModel, projectView);
		addControllerToSystem(controller);
	}

	public void createControlledProjectTab(IProjectView tabView)
	{
		managerLogger.info("Creating ProjectTab");
		IProjectTab projectTab = myViewFacadeFactory.createProjectTab(tabView);
		ProjectTabController controller = new ProjectTabController(myModel, tabView, projectTab);
		addControllerToSystem(controller);
	}

	public void createControlledCustomerTab(IProjectView tabView)
	{
		managerLogger.info("Creating CustomerTab");
		ICustomerTab customerTab = myViewFacadeFactory.createCustomerTab(tabView);
		CustomerTabController controller = new CustomerTabController(myModel, tabView, customerTab);
		addControllerToSystem(controller);
	}

	public void createControlledProductApplicationTab(IProjectView tabView)
	{
		managerLogger.info("Creating ProductApplicationTab");
		IProductApplicationTab productApplicationTab = myViewFacadeFactory.createProductApplicationTab(tabView);
		ProductApplicationTabController controller = new ProductApplicationTabController(
				myModel,
				tabView,
				productApplicationTab
		);
		addControllerToSystem(controller);
	}

	public void createControlledProductEnvironmentTab(IProjectView tabView)
	{
		managerLogger.info("Creating ProductEnvironmentTab");
		IProductEnvironmentTab productEnvironmentTab = myViewFacadeFactory.createProductEnvironmentTab(tabView);
		ProductEnvironmentTabController controller = new ProductEnvironmentTabController(
				myModel,
				tabView,
				productEnvironmentTab
		);
		addControllerToSystem(controller);
	}

	public void createControlledTargetDefinitionTab(IProjectView tabView)
	{
		managerLogger.info("Creating TargetDefinitionTab");
		ITargetDefinitionTab targetDefinitionTab = myViewFacadeFactory.createTargetDefinitionTab(tabView);
		TargetDefinitionTabController controller = new TargetDefinitionTabController(
				myModel,
				tabView,
				targetDefinitionTab
		);
		addControllerToSystem(controller);
	}

	public void createControlledFRequirementTab(IProjectView tabView)
	{
		managerLogger.info("Creating FRequirementTab");
		IFRequirementTab fRequirementTab = myViewFacadeFactory.createFRequirementTab(tabView);
		FRequirementTabController controller = new FRequirementTabController(myModel, tabView, fRequirementTab);
		addControllerToSystem(controller);
	}

	public void createControlledNFRequirementTab(IProjectView tabView)
	{
		managerLogger.info("Creating NFRequirementTab");
		INFRequirementTab nfRequirementTab = myViewFacadeFactory.createNFRequirementTab(tabView);
		NFRequirementTabController controller = new NFRequirementTabController(myModel, tabView, nfRequirementTab);
		addControllerToSystem(controller);
	}

	public void createControlledProductDataTab(IProjectView tabView)
	{
		managerLogger.info("Creating ProductDataTab");
		IProductDataTab productDataTab = myViewFacadeFactory.createProductDataTab(tabView);
		ProductDataTabController controller = new ProductDataTabController(myModel, tabView, productDataTab);
		addControllerToSystem(controller);
	}

	public void createControlledQualityRequirementTab(IProjectView tabView)
	{
		managerLogger.info("Creating QualityRequirementTab");
		IQualityRequirementTab qualityRequirementTab = myViewFacadeFactory.createQualityRequirementTab(tabView);
		QualityReqTabController controller = new QualityReqTabController(myModel, tabView, qualityRequirementTab);
		addControllerToSystem(controller);
	}

	public void createControlledGlossaryTab(IProjectView tabView)
	{
		managerLogger.info("Creating GlossaryTab");
		IGlossaryTab glossaryTab = myViewFacadeFactory.createGlossaryTab(tabView);
		GlossaryTabController controller = new GlossaryTabController(myModel, tabView, glossaryTab);
		addControllerToSystem(controller);
	}

	public void createControlledAdditionTab(IProjectView tabView)
	{
		managerLogger.info("Creating AdditionTab");
		IAdditionTab additionTab = myViewFacadeFactory.createAdditionTab(tabView);
		AdditionTabController controller = new AdditionTabController(myModel, tabView, additionTab);
		addControllerToSystem(controller);
	}

	public void createControlledCostEstimationTab(@Nullable IProjectView tabView)
	{
		managerLogger.info("Creating CostEstimationTab");
		boolean searchForTabView = (tabView == null);
		if(searchForTabView)
		{
			tabView = findTabViewInControllerList();
		}
		if(tabView != null)
		{
			ICostEstimationTab costEstimationTab = myViewFacadeFactory.createCostEstimationTab(tabView);
			CostEstimationTabController controller = new CostEstimationTabController(myModel, tabView, costEstimationTab);
			addControllerToSystem(controller);
			if(searchForTabView)
			{
				costEstimationTab.bringToFront();
			}
		}
	}

	private IProjectView findTabViewInControllerList()
	{
		IProjectView tabView = null;
		for(BasicViewController controller: allViewControllers)
		{
			if(controller instanceof ProjectViewController)
			{
				tabView = ((ProjectViewController)controller).getControlledView();
			}
		}
		return tabView;
	}

	public void createAllTabsControlled(ProjectViewController projectViewController)
	{
		managerLogger.info("Creating all tabs for ProjectView");
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
			if(myModel.getCostEstimation() != null)
			{
				createControlledCostEstimationTab(tabView);
			}
		}
		else
		{
			myLogger.warning("ProjectViewController has no tabView (tabView == null).");
			managerLogger.warning("ProjectViewController has no tabView (tabView == null).");
		}
	}

	public void createControlledActualStateEditView(@Nullable IView parentView)
	{
		managerLogger.info("Creating ActualStateEditView");
		IActualStateEditView editView = myViewFacadeFactory.createActualStateEditView(parentView);
		ActualStateEditController controller = new ActualStateEditController(myModel, editView);
		addControllerToSystem(controller);
	}

	public void createControlledFRequirementEditView(String reqID)
	{
		IFRequirementEditView reqEditView;
		if(reqID != null)
		{
			managerLogger.info("Creating FRequirementEditView with ID "+reqID);
			reqEditView = myViewFacadeFactory.createIFRequirementEditView(reqID);
		}
		else
		{
			managerLogger.info("Creating FRequirementAddView");
			reqEditView = myViewFacadeFactory.createIFRequirementAddView();
		}
		FRequirementEditController controller = new FRequirementEditController(myModel, reqEditView);
		addControllerToSystem(controller);
	}

	public void createControlledFRequirementShowView(String reqID)
	{
		if(reqID != null)
		{
			if(!isReqAlreadyShown(reqID))
			{
				managerLogger.info("Creating FRequirementShowView for ID "+reqID);
				IFRequirementShowView newShowView = myViewFacadeFactory.createIFRequirementShowView(reqID);
				FRequirementShowController controller = new FRequirementShowController(myModel, newShowView);
				addControllerToSystem(controller);
			}
		}
	}

	public void createControlledNFRequirementEditView(String reqID)
	{
		INFRequirementEditView reqEditView;
		if(reqID != null)
		{
			managerLogger.info("Creating NFRequirementEditView with ID "+reqID);
			reqEditView = myViewFacadeFactory.createINFRequirementEditView(reqID);
		}
		else
		{
			managerLogger.info("Creating NFRequirementAddView");
			reqEditView = myViewFacadeFactory.createINFRequirementAddView();
		}
		NFRequirementEditController controller = new NFRequirementEditController(myModel, reqEditView);
		addControllerToSystem(controller);
	}

	public void createControlledNFRequirementShowView(String reqID)
	{
		if(reqID != null)
		{
			if(!isReqAlreadyShown(reqID))
			{
				managerLogger.info("Creating NFRequirementShowView for ID "+reqID);
				INFRequirementShowView newShowView = myViewFacadeFactory.createINFRequirementShowView(reqID);
				NFRequirementShowController controller = new NFRequirementShowController(myModel, newShowView);
				addControllerToSystem(controller);
			}
		}
	}

	public void createControlledProductDataEditView(String reqID)
	{
		IProductDataEditView reqEditView;
		if(reqID != null)
		{
			managerLogger.info("Creating ProductDataEditView with ID "+reqID);
			reqEditView = myViewFacadeFactory.createProductDataEditView(reqID);
		}
		else
		{
			managerLogger.info("Creating ProductDataAddView");
			reqEditView = myViewFacadeFactory.createProductDataAddView();
		}
		ProductDataEditController controller = new ProductDataEditController(myModel, reqEditView);
		addControllerToSystem(controller);
	}

	public void createControlledProductDataShowView(String reqID)
	{
		if(reqID != null)
		{
			if(!isReqAlreadyShown(reqID))
			{
				managerLogger.info("Creating ProductDataShowView for ID "+reqID);
				IProductDataShowView newShowView = myViewFacadeFactory.createProductDataShowView(reqID);
				ProductDataShowController controller = new ProductDataShowController(myModel, newShowView);
				addControllerToSystem(controller);
			}
		}
	}

	private boolean isReqAlreadyShown(String reqID)
	{
		boolean isAlreadyShown = false;
		if(reqID != null)
		{
			RequirementShowController existingShowController = lookForExistingReqShowViewForID(reqID);
			if (existingShowController != null)
			{
				managerLogger.info("Bring RequirementShowView for ID " + reqID + " to front");
				existingShowController.bringViewToFront();
				isAlreadyShown = true;
			}
		}
		return isAlreadyShown;
	}

	private RequirementShowController lookForExistingReqShowViewForID(String reqID)
	{
		RequirementShowController existingShowController = null;

		for(BasicViewController controller: allViewControllers)
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
		managerLogger.info("Creating CostEstimationShowView");
		ICostEstimationShowView costEstimationShowView = myViewFacadeFactory.createCostEstimationShowView();
		CostEstimationShowController controller = new CostEstimationShowController(myModel, costEstimationShowView);
		addControllerToSystem(controller);
	}

	public void createControlledCostEstEditView()
	{
		managerLogger.info("Creating CostEstimationEditView");
		ICostEstimationEditView costEstimationShowView = myViewFacadeFactory.createCostEstimationEditView();
		CostEstimationEditController controller = new CostEstimationEditController(myModel, costEstimationShowView);
		addControllerToSystem(controller);
	}

	public void createControlledProcClassView(String reqID)
	{
		managerLogger.info("Creating ProcessClassificationView for requirement " + reqID);
		IProcessClassificationView processClassificationView = myViewFacadeFactory.createProcessClassificationView(reqID);
		ProcessClassificationController controller = new ProcessClassificationController(myModel, processClassificationView);
		addControllerToSystem(controller);
	}

	public void createControlledWFEditView()
	{
		managerLogger.info("Creating WeightFactorEditView");
		IWeightFactorEditView weightFactorEditView = myViewFacadeFactory.createWeightFactorEditView();
		WeightFactorEditController controller = new WeightFactorEditController(myModel, weightFactorEditView);
		addControllerToSystem(controller);
	}

	public void createControlledWarningDialog(@Nullable IView parentView, String dialogPropertyName)
	{
		managerLogger.info("Creating warning "+dialogPropertyName);
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
			IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(parentView, dialogPropertyName);
			controller.setView(myWarningDialog);
		}
		addControllerToSystem(controller);
	}

	public void createControlledWarningDialog(@Nullable IView parentView, String dialogPropertyName,
											  WarningController controller)
	{
		managerLogger.info("Creating warning "+dialogPropertyName+" with given controller");
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(parentView, dialogPropertyName);
		controller.setView(myWarningDialog);
		addControllerToSystem(controller);
	}

	public void createControlledWarningDialog(@Nullable IView parentView, String dialogPropertyName,
											  String[] placeholderInText, WarningController controller)
	{
		managerLogger.info("Creating warning "+dialogPropertyName+" with given controller and "+
				placeholderInText.length+" placeholder elements");
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(
				parentView,
				dialogPropertyName,
				placeholderInText
		);
		controller.setView(myWarningDialog);
		addControllerToSystem(controller);
	}

	public void createControlledWarningDialog(@Nullable IView parentView, String warningTitle, String warningMessage,
											  WarningController controller)
	{
		managerLogger.info("Creating warning "+warningTitle+" - "+warningMessage+" -||- Given controller");
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(
				parentView,
				warningTitle,
				warningMessage
		);
		controller.setView(myWarningDialog);
		addControllerToSystem(controller);
	}

	public void createControlledWarningDialog(@Nullable IView parentView, String warningTitle, String warningMessage,
											  ViewActions[] buttonActions, WarningController controller)
	{
		managerLogger.info("Creating warning "+warningTitle+" - "+warningMessage+" -||- Given controller"+
							"and ViewActions");
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(
				parentView,
				warningTitle,
				warningMessage,
				buttonActions
		);
		controller.setView(myWarningDialog);
		addControllerToSystem(controller);
	}

	/**
	 * Creates an {@link View.ErrorDialog} corresponding to the thrown exception and a default {@link ErrorController}
	 * to control this dialog.
	 * <p>
	 *     <b>Caution:</b> calling this method will block the running thread until the generated dialog is closed.
	 *     The belonging controller which is created here will not be added to the overall controller list due to
	 *     the view is destructed after this method.
	 * </p>
	 * @param parentView View which calls this dialog. Could be null
	 * @param thrownException Exception/Error which the dialog should show
	 */
	public void createControlledErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException)
	{
		managerLogger.info("Creating ErrorDialog for error "+thrownException.toString());
		IErrorDialog myErrorDialog = myViewFacadeFactory.createErrorDialog(parentView, thrownException);
		ErrorController controller = new ErrorController(myModel, myErrorDialog);
	}

	/**
	 * Creates an {@link View_Interfaces.IErrorDialog} corresponding to the thrown exception and a default
	 * {@link ErrorController} to control this dialog. The placeholder in the dialog text are replaced by elements of
	 * the given string array.
	 * <p>
	 *     <b>Caution:</b> calling this method will block the running thread until the generated dialog is closed.
	 *     The belonging controller which is created here will not be added to the overall controller list due to
	 *     the view is destructed after this method.
	 * </p>
	 * @param parentView View which calls this dialog. Could be null
	 * @param thrownException Exception/Error which the dialog should show
	 * @param placeholderInText Strings with which the placeholder in the dialog text should be replaced
	 *                          (see {@link LanguageAndText.ITextFacade#getDialogText(String, String[])})
	 * @see View_Interfaces.IErrorDialog
	 * @see LanguageAndText.ITextFacade#getDialogText(String, String[])
	 */
	public void createControlledErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException,
											@Nullable String[] placeholderInText)
	{
		managerLogger.info("Creating ErrorDialog for error "+thrownException.toString()+
				" with "+placeholderInText.length+" placeholder");
		IErrorDialog myErrorDialog = myViewFacadeFactory.createErrorDialog(parentView, thrownException, placeholderInText);
		ErrorController controller = new ErrorController(myModel, myErrorDialog);
	}

	/**
	 * Creates an {@link View_Interfaces.IErrorDialog} corresponding to the thrown exception. To this dialog the given
	 * {@link ErrorController} will be set as the controller. The controller will also be added to the list of all
	 * controllers in the system.
	 * <p>
	 *     <b>Caution:</b> calling this method will block the running thread until the generated dialog is closed.
	 *     The belonging controller which is given as parameter will not be added to the overall controller list due to
	 *     the view is destructed after this method.
	 * </p>
	 * @param parentView View which calls this dialog. Could be null
	 * @param thrownException Error which the dialog should show
	 * @param controllerForErrorDialog Controller which will control the dialog
	 * @see View_Interfaces.IErrorDialog
	 */
	public void createControlledErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException,
											@NotNull ErrorController controllerForErrorDialog)
	{
		managerLogger.info("Creating ErrorDialog for error "+thrownException.toString()+" with given controller");
		IErrorDialog myErrorDialog = myViewFacadeFactory.createErrorDialog(parentView, thrownException);
		controllerForErrorDialog.setView(myErrorDialog);
	}

	/**
	 * Creates an {@link View_Interfaces.IErrorDialog} corresponding to the thrown exception. To this dialog the given
	 * {@link ErrorController} will be set as the controller. The controller will also be added to the list of all
	 * controllers in the system. The placeholder in the dialog text are replaced by elements of the given string array.
	 * <p>
	 *     <b>Caution:</b> calling this method will block the running thread until the generated dialog is closed.
	 *     The belonging controller which is given as parameter will not be added to the overall controller list due to
	 *     the view is destructed after this method.
	 * </p>
	 * @param parentView View which calls
	 * @param thrownException Exception/Error which the dialog should show
	 * @param placeholderInText Strings with which the placeholder in the dialog text should be replaced
	 *                          (see {@link LanguageAndText.ITextFacade#getDialogText(String, String[])})
	 * @param controllerForErrorDialog Controller which will control the dialog
	 * @see View_Interfaces.IErrorDialog
	 * @see LanguageAndText.ITextFacade#getDialogText(String, String[])
	 */
	public void createControlledErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException,
											@Nullable String[] placeholderInText,
											@NotNull ErrorController controllerForErrorDialog)
	{
		managerLogger.info("Creating ErrorDialog for error "+thrownException.toString()+
				" with "+placeholderInText.length+" placeholder and given controller");
		IErrorDialog myErrorDialog = myViewFacadeFactory.createErrorDialog(parentView, thrownException, placeholderInText);
		controllerForErrorDialog.setView(myErrorDialog);
	}

	public void createControlledInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName)
	{
		managerLogger.info("Creating InfoDialog "+dialogPropertyName);
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(parentView, dialogPropertyName);
		InfoDialogController controller = new InfoDialogController(myModel, myInfoDialog);
	}

	public void createControlledInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
										   @NotNull InfoDialogController controllerForInfoDialog)
	{
		managerLogger.info("Creating InfoDialog "+dialogPropertyName+" with given controller");
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(parentView, dialogPropertyName);
		controllerForInfoDialog.setView(myInfoDialog);
	}

	public void createControlledInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
										   @Nullable String[] placeholderInDialogText)
	{
		managerLogger.info("Creating InfoDialog "+dialogPropertyName+
				" with "+placeholderInDialogText.length+" placeholder");
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(
				parentView,
				dialogPropertyName,
				placeholderInDialogText
		);
		InfoDialogController controller = new InfoDialogController(myModel, myInfoDialog);
	}

	public void createControlledInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
										   @Nullable String[] placeholderInDialogText,
										   @NotNull InfoDialogController controllerForInfoDialog)
	{
		managerLogger.info("Creating InfoDialog "+dialogPropertyName+
				" with "+placeholderInDialogText.length+" placeholder and given controller");
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(
				parentView,
				dialogPropertyName,
				placeholderInDialogText
		);
		controllerForInfoDialog.setView(myInfoDialog);
	}

	public void createControlledInfoDialog(@Nullable IView parentView, @NotNull String dialogTitle,
										   @NotNull String dialogInfoMessage)
	{
		managerLogger.info("Creating InfoDialog with title "+dialogTitle+" and message "+dialogInfoMessage);
		IInfoDialog myInfoDialog = myViewFacadeFactory.createInfoDialog(parentView, dialogTitle, dialogInfoMessage);
		InfoDialogController controller = new InfoDialogController(myModel, myInfoDialog);
	}

	public LoadingController createControlledLoadingDialog(@Nullable IView parentView)
	{
		managerLogger.info("Creating LoadingDialog");
		ILoadingDialog myLoadingDialog = myViewFacadeFactory.createLoadingDialog(parentView);
		LoadingController controller = new LoadingController(myModel, myLoadingDialog);
		addControllerToSystem(controller);
		return controller;
	}

	/**
	 * Removes the given controller from the list of all controller. Should be done if controller is not used anymore.
	 * @param controllerToBeRemoved Controller which should be removed from the list
	 */
	public void removeController(BasicViewController controllerToBeRemoved)
	{
		allViewControllers.remove(controllerToBeRemoved);
		managerLogger.info("Removed controller "+controllerToBeRemoved.getClass().toString());
	}


	public void forceQuitAllViews()
	{
		managerLogger.info("Force quit all views");
		closeViewsOfAllControllers();
	}

	/**
	 * Calls every controller to close his view and terminates the program afterwards.
	 */
	public boolean closeProgram()
	{
		managerLogger.info("Try to close program with following active controller:\n"+
				getOverviewOfActiveController());
		boolean canBeClosed = tryClosingAllActiveViews();
		if(canBeClosed)
		{
			managerLogger.info("Close Program");
			System.exit(0);
		}
		else
		{
			managerLogger.info("Could not close Program");
		}
		return canBeClosed;
	}

	public boolean tryClosingAllActiveViews()
	{
		boolean canBeClosed = canAllViewsBeClosed();
		if(canBeClosed)
		{
			closeViewsOfAllControllers();
		}
		return canBeClosed;
	}

	public boolean canAllViewsBeClosed()
	{
		boolean canBeClosed = true;
		for(int controllerIndex = 0; controllerIndex < allViewControllers.size(); controllerIndex++)
		{
			canBeClosed = canBeClosed & allViewControllers.get(controllerIndex).canViewBeClosed();
			if(!canBeClosed)
			{
				managerLogger.info("Controller "+allViewControllers.get(controllerIndex).toString()+
						" could not be closed");
				break;
			}
		}
		return canBeClosed;
	}

	private void closeViewsOfAllControllers()
	{
		while (allViewControllers.size() != 0)
		{
			BasicViewController controllerToClose = allViewControllers.get(0);
			controllerToClose.closeView();
			if(allViewControllers.contains(controllerToClose))
			{
				removeController(controllerToClose);
			}
		}
	}

	public IFileChooser createFileChooser(FileAccessType accessType)
	{
		managerLogger.info("Creating FileChooser with accessType "+accessType.name());
		IFileChooser myFileChooser = myViewFacadeFactory.createFileChooser(null, accessType);
		return myFileChooser;
	}

	private String getOverviewOfActiveController()
	{
		String controllerOverview = "";
		for(BasicViewController controller: allViewControllers)
		{
			controllerOverview += controller.getClass().toString() + "\n";
		}
		return controllerOverview;
	}

	private void assignMenuController(IView viewToBeAssigned)
	{
		if(viewToBeAssigned != null && viewToBeAssigned.getViewMenu() != null)
		{
			viewToBeAssigned.getViewMenu().addController(menuController);
		}
	}

	private void addControllerToSystem(BasicViewController controller)
	{
		assignMenuController(controller.getControlledView());
		allViewControllers.add(controller);
	}

	public void removeCostEstimationViews()
	{
		System.out.println("Remove cost estimation views");
		int listIndex = 0;
		while(listIndex < allViewControllers.size())
		{
			BasicViewController controller = allViewControllers.get(listIndex);
			IView controllerView = controller.getControlledView();
			if(controllerView instanceof ICostEstimationTab ||
					controllerView instanceof ICostEstimationEditView ||
					controllerView instanceof ICostEstimationShowView ||
					controllerView instanceof IWeightFactorEditView ||
					controllerView instanceof IActualStateEditView ||
					controllerView instanceof IOptimizedWeightFactorsView ||
					controllerView instanceof IProcessClassificationView)
			{
				System.out.println("True");
				controller.closeView();
			}
			else
			{
				System.out.println("False");
				listIndex++;
			}
		}
	}


}
