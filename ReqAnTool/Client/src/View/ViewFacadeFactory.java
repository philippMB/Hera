package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import LanguageAndText.ITextFacade;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Model_Interfaces.*;
import View_Interfaces.*;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.*;

/**
 * @author 9045534
 * @see IViewFacadeFactory
 */
public class ViewFacadeFactory
	implements IViewFacadeFactory
{

	private static ViewFacadeFactory singletonViewFF;

	private IModelGetData myModel;
	private ILogger myLogger;
	private JFrame mainView;	//Holds the main view to which the dialogs positions are adjusted


	private ViewFacadeFactory(@NotNull IModelGetData model)
	{
		myModel = model;
		myLogger = ILoggerFactory.getInstance().createLogger();
		mainView = null;
	}

	/**
	 *
	 * @param model
	 * @return
	 */
	public static ViewFacadeFactory getInstance(@NotNull IModelGetData model)
	{
		if(singletonViewFF == null)
		{
			singletonViewFF = new ViewFacadeFactory(model);
		}
		return singletonViewFF;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public IActualStateEditView createActualStateEditView(IView parentView)
	{
		ActualStateEditDialog myView = new ActualStateEditDialog(getFrameOfView(parentView), myModel);
		return myView;
	}

	/**
	 *
	 * @param tabView
	 * @return
	 */
	@Override
	public IAdditionTab createAdditionTab(@NotNull IProjectView tabView)
	{
		IAdditionTab myTab = new AdditionTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public ICostEstimationTab createCostEstimationTab(IProjectView tabView)
	{
		ICostEstimationTab myTab = new CostEstimationTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public ICostEstimationEditView createCostEstimationEditView()
	{
		ICostEstimationEditView myView = new CostEstimationEditView(myModel);
		return myView;
	}

	@Override
	public ICostEstimationShowView createCostEstimationShowView()
	{
		ICostEstimationShowView myView = new CostEstimationShowView(myModel);
		return myView;
	}

	@Override
	public ICustomerTab createCustomerTab(@NotNull IProjectView tabView)
	{
		ICustomerTab myTab = new CustomerTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException)
	{
		IErrorDialog myView = new ErrorDialog(getFrameOfView(parentView), thrownException);
		return myView;
	}

	@Override
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException,
										  @Nullable String[] placeholderInText)
	{
		IErrorDialog myView = new ErrorDialog(getFrameOfView(parentView), thrownException, placeholderInText);
		return myView;
	}

	@Override
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull String title,@NotNull String message)
	{
		IErrorDialog myView = new ErrorDialog(getFrameOfView(parentView), title, message);
		return myView;
	}

	@Override
	public IFileChooser createFileChooser(@Nullable IView parentView, @NotNull FileAccessType accessType)
	{
		IFileChooser myView = new FileChooser(getFrameOfView(parentView),accessType);
		return myView;
	}

	@Override
	public IFRequirementEditView createIFRequirementAddView()
	{
		IFRequirementEditView myView = new FRequirementEditView(myModel);
		return myView;
	}

	@Override
	public IFRequirementEditView createIFRequirementEditView(@Nullable String ID)
	{
		IFRequirementEditView myView;

		if(myModel.getFReqByID(ID) == null)
		{
			myView = createIFRequirementAddView();
		}
		else
		{
			myView = new FRequirementEditView(myModel,ID,true);
		}

		return myView;
	}

	@Override
	public IFRequirementShowView createIFRequirementShowView(@NotNull String ID)
	{
		IFRequirementShowView myView;

		if(myModel.getFReqByID(ID) == null)
		{
			myView = null;
		}
		else
		{
			myView = new FRequirementEditView(myModel,ID,false);
		}

		return myView;
	}

	@Override
	public INFRequirementEditView createINFRequirementAddView()
	{
		INFRequirementEditView myView = new NFRequirementEditView(myModel);
		return myView;
	}

	@Override
	public INFRequirementEditView createINFRequirementEditView(@Nullable String ID)
	{
		INFRequirementEditView myView;

		if(myModel.getNFReqByID(ID) == null)
		{
			myView = createINFRequirementAddView();
		}
		else
		{
			myView = new NFRequirementEditView(myModel,ID,true);
		}

		return myView;
	}

	@Override
	public INFRequirementShowView createINFRequirementShowView(@NotNull String ID)
	{
		INFRequirementShowView myView;

		if(myModel.getNFReqByID(ID) == null)
		{
			myView = null;
		}
		else
		{
			myView = new NFRequirementEditView(myModel,ID,false);
		}

		return myView;
	}

	@Override
	public IOptimizedWeightFactorsView createOptimizedWeightFactorsView()
	{
		IOptimizedWeightFactorsView myView = new OptimizedWeightFactorsView(myModel);
		return myView;
	}

	@Override
	public IProductDataEditView createProductDataAddView()
	{
		IProductDataEditView myView = new ProductDataEditView(myModel);
		return myView;
	}

	@Override
	public IProductDataEditView createProductDataEditView(@Nullable String ID)
	{
		IProductDataEditView myView;

		if(myModel.getProductDataByID(ID) == null)
		{
			myView = createProductDataAddView();
		}
		else
		{
			myView = new ProductDataEditView(myModel,ID,true);
		}

		return myView;
	}

	@Override
	public IProductDataShowView createProductDataShowView(@NotNull String ID)
	{
		IProductDataShowView myView;

		if(myModel.getProductDataByID(ID) == null)
		{
			myView = null;
		}
		else
		{
			myView = new ProductDataEditView(myModel,ID,false);
		}

		return myView;
	}

	@Override
	public IFRequirementTab createFRequirementTab(@NotNull IProjectView tabView)
	{
		IFRequirementTab myTab = new FRequirementTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public INFRequirementTab createNFRequirementTab(@NotNull IProjectView tabView)
	{
		INFRequirementTab myTab = new NFRequirementTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IProductDataTab createProductDataTab(@NotNull IProjectView tabView)
	{
		IProductDataTab myTab = new ProductDataTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IGlossaryTab createGlossaryTab(@NotNull IProjectView tabView)
	{
		IGlossaryTab myTab = new GlossaryTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IProcessClassificationView createProcessClassificationView(@NotNull String ID)
	{
		IProcessClassificationView myView = null;

		if(myModel.getFReqByID(ID) != null)
		{
			myView = new ProcessClassificationFReqView(myModel, ID);
		}
		if(myModel.getNFReqByID(ID) != null)
		{
			if(myView != null)
			{
				myView = new ProcessClassificationNFReqView(myModel, ID);
			}
			else
			{
				//TODO: LOGINFO, DUPLICATE ID
			}
		}
		if(myModel.getProductDataByID(ID) != null)
		{
			if(myView != null)
			{
				myView = new ProcessClassificationProdDataView(myModel, ID);
			}
			else
			{
				//TODO: LOGINFO, DUPLICATE ID
			}
		}

		return myView;
	}

	@Override
	public IProductApplicationTab createProductApplicationTab(@NotNull IProjectView tabView)
	{
		IProductApplicationTab myTab = new ProductApplicationTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IProductEnvironmentTab createProductEnvironmentTab(@NotNull IProjectView tabView)
	{
		IProductEnvironmentTab myTab = new ProductEnvironmentTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IProjectCreateView createProjectCreateView()
	{
		IProjectCreateView myView = new ProjectCreateView(myModel);
		return myView;
	}

	@Override
	public IProjectTab createProjectTab(@NotNull IProjectView tabView)
	{
		IProjectTab myTab = new ProjectTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IProjectView createProjectView()
	{
		IProjectView myView = new ProjectView(myModel);
		return myView;
	}

	@Override
	public IQualityRequirementTab createQualityRequirementTab(@NotNull IProjectView tabView)
	{
		IQualityRequirementTab myTab = new QualityRequirementTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IStartView createStartView()
	{
		IStartView myView = new StartView();
		return myView;
	}

	@Override
	public ITargetDefinitionTab createTargetDefinitionTab(@NotNull IProjectView tabView)
	{
		ITargetDefinitionTab myTab = new TargetDefinitionTab(myModel);
		addTabToTabView(tabView,myTab);

		return myTab;
	}

	@Override
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String dialogPropertyName)
	{
		return createWarningDialog(parentView, dialogPropertyName, (String[])null);
	}

	@Override
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
											  @Nullable String[] placeholderInText)
	{
		//TODO: Put TextBundle access in warning dialog
		IWarningDialog newWarningDialog = null;
		if(containsMapDialogPropertyName(dialogPropertyName))
		{
			ITextFacade myTextBundle = ITextFacade.getInstance();
			String warnTitle = myTextBundle.getTitleText(dialogPropertyName);
			String warnDescription;
			if(placeholderInText != null)
			{
				warnDescription = myTextBundle.getDialogText(dialogPropertyName, placeholderInText);
			}
			else
			{
				warnDescription = myTextBundle.getDialogText(dialogPropertyName);
			}
			ViewActions[] warnButtonActions = DialogConstants.DIALOG_NAME_TO_VIEW_ACTIONS.get(dialogPropertyName);

			newWarningDialog = createWarningDialog(parentView, warnTitle, warnDescription, warnButtonActions);
		}
		return newWarningDialog;
	}

	private boolean containsMapDialogPropertyName(String dialogPropertyName)
	{
		boolean containing = true;
		try
		{
			DialogConstants.DIALOG_NAME_TO_VIEW_ACTIONS.get(dialogPropertyName);
		}
		catch(NullPointerException ex)
		{
			myLogger.warning("Given key is null.", ex);
			containing = false;
		}
		catch(ClassCastException ex)
		{
			myLogger.warning("Given key has wrong class for dialog-Map in DialogConstants. Class: "+
							dialogPropertyName.getClass().toString(), ex);
			containing = false;
		}
		return containing;
	}

	@Override
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String warnTitle,
											  @NotNull String warnDescription)
	{
		IWarningDialog myView = new WarningDialog(getFrameOfView(parentView), warnTitle, warnDescription);
		return myView;
	}

	@Override
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String warnTitle,
											  @NotNull String warnDescription,
											  @NotNull ViewActions[] warnButtonActions)
	{
		IWarningDialog myView = new WarningDialog(
				getFrameOfView(parentView),
				warnTitle,
				warnDescription,
				warnButtonActions
		);
		return myView;
	}

	@Override
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName)
	{
		IInfoDialog myView = new InfoDialog(getFrameOfView(parentView), dialogPropertyName);
		return myView;
	}

	@Override
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
										@Nullable String[] placeholderInText)
	{
		IInfoDialog myView = new InfoDialog(getFrameOfView(parentView), dialogPropertyName, placeholderInText);
		return myView;
	}

	@Override
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String infoTitle,
										@NotNull String infoMessage)
	{
		IInfoDialog myView = new InfoDialog(getFrameOfView(parentView), infoTitle, infoMessage);
		return myView;
	}

	@Override
	public ILoadingDialog createLoadingDialog(@Nullable IView parentView)
	{
		ILoadingDialog myView = new LoadingDialog(getFrameOfView(parentView));
		return myView;
	}

	@Override
	public IWeightFactorEditView createWeightFactorEditView()
	{
		IWeightFactorEditView myView = new WeightFactorEditView(myModel);
		return myView;
	}

	private ErrorCodes addTabToTabView(IProjectView tabView, ITab tab)
	{
		ErrorCodes myErrorCode = ErrorCodes.NO_ERROR;

		if(tabView != null)
		{
			tabView.addTab(tab);
		}
		else
		{
			myErrorCode = ErrorCodes.NULL_POINTER; //TODO: LOGINFO GIVEN TABVIEW NULL
		}

		return myErrorCode;
	}

	private @Nullable JFrame getFrameOfView(IView view)
	{
		JFrame frameOfView = null;
		if(view instanceof JFrame)
		{
			frameOfView = (JFrame)view;
		}
		return frameOfView;
	}

}
