package Controller;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import Logging.LogSystem;
import Model_Interfaces.IModel;
import View_Interfaces.*;

/**
 * Created by phlippe on 11.05.17.
 */
public class ControllerManagement
{

	private static ControllerManagement singleton;

	//private ArrayList<IController> allControllers;	- Is List of all Controllers necessary?
	private IModel myModel;
	private IViewFacadeFactory myViewFacadeFactory;
	private Logging.Logger myLogger;


	private ControllerManagement(IModel model)
	{
		myModel = model;
		myViewFacadeFactory = IViewFacadeFactory.getInstance(myModel);
		myLogger = LogSystem.getLogger();
	}

	public static ControllerManagement getInstance(IModel model)
	{
		if(singleton == null)
		{
			singleton = new ControllerManagement(model);
		}
		return singleton;
	}

	public void createControlledProjectView()
	{
		IProjectView projectView = myViewFacadeFactory.createProjectView();
		ProjectViewController projectViewController = new ProjectViewController(myModel, projectView);
	}

	public void createControlledProjectTab(IProjectView tabView)
	{
		IProjectTab projectTab = myViewFacadeFactory.createProjectTab(tabView);

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

	}

	public void createControlledGlossaryTab(IProjectView tabView)
	{
		IGlossaryTab glossaryTab = myViewFacadeFactory.createGlossaryTab(tabView);

	}

	public void createControlledAdditionTab(IProjectView tabView)
	{
		IAdditionTab additionTab = myViewFacadeFactory.createAdditionTab(tabView);

	}

	public void createControlledCostEstimationTab(IProjectView tabView)
	{
		ICostEstimationTab costEstimationTab = myViewFacadeFactory.createCostEstimationTab(tabView);

	}

	public void createAllTabsControlled(ProjectViewController projectViewController)
	{
		IProjectView tabView = projectViewController.getControlledView();
		if(tabView != null)
		{
			createControlledProjectTab(tabView);
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

	public void createControlledFRequirementEditView(String ID)
	{

		if(ID != null)
		{
			myViewFacadeFactory.createIFRequirementEditView(ID);
		}
		else
		{
			myViewFacadeFactory.createIFRequirementAddView();
		}

	}

	public void createControlledFRequirementShowView(String ID)
	{
		if(ID != null)
		{
			myViewFacadeFactory.createIFRequirementShowView(ID);
		}
	}

	public WarningController createControlledWarningDialog(int dialogType)
	{
		WarningController controller;
		switch(dialogType)
		{
			case DialogConstants.DIALOG_TYPE_SAVE_WARNING:
				controller = new SaveWarningController(myModel,null);
				break;
			default:
				controller = null;
				break;
		}
		if(controller != null)
		{
			System.out.println("ControlledWarningDialog");
			IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(dialogType);
			System.out.println("Was ist Dialog?"+(myWarningDialog==null?"Null":"Ein Dialog"));
			controller.setView(myWarningDialog);
		}
		return controller;
	}

	public void createControlledWarningDialog(String warningTitle, String warningMessage, BasicController<IWarningDialog> controller)
	{
		IWarningDialog myWarningDialog = myViewFacadeFactory.createWarningDialog(warningTitle,warningMessage);
		controller.setView(myWarningDialog);
	}

	public void createControlledWarningDialog(String warningTitle, String warningMessage, ViewActions[] buttonActions, BasicController controller)
	{

	}

}
