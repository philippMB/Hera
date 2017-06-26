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
 * This class is a implementation of {@link IViewFacadeFactory} and represents the interface between the view and
 * other components.
 * <p>
 *     To standardize the interface between the view component and other components like the controller this class
 *     represents a facade for component interaction. Due to the interaction mainly focuses on creating views this
 *     facade simultaneously implements the abstract factory method. In addition to give the factory the management of
 *     all views there is only one instantiation of this class (singleton method).<br>
 *     All created views are based on {@link IView} and could be created through different functions. To simplify the
 *     functions for creating views the factory holds a instance of {@link IModelGetData} on which all views will
 *     operate.
 * </p>
 * <p>
 *     A view component itself has to contain a class implementing this interface. To retain the small linking between
 *     the different components this class provides an API for creating an instance of this facade from a specific
 *     component:
 * </p>
 * <p>
 *     <code>
 *         IViewFacadeFactory myViewFacadeFactory = IViewFacadeFactory.getInstance(<i>IModelGetData</i>);
 *     </code>
 * </p>
 * <p>
 *     For more details look at the specific functions.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see IViewFacadeFactory
 */
public class ViewFacadeFactory
	implements IViewFacadeFactory
{

	/**
	 * Singleton object
	 */
	private static ViewFacadeFactory singletonViewFF;

	private IModelGetData myModel;
	private ILogger myLogger;


	private ViewFacadeFactory(@NotNull IModelGetData model)
	{
		myModel = model;
		myLogger = ILoggerFactory.getInstance().createLogger();
	}

	/**
	 * {@inheritDoc}
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
	 * {@inheritDoc}
	 */
	@Override
	public IActualStateEditView createActualStateEditView(IView parentView)
	{
		ActualStateEditDialog myView = new ActualStateEditDialog(getFrameOfView(parentView), myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IAdditionTab createAdditionTab(@NotNull IProjectView tabView)
	{
		IAdditionTab myTab = new AdditionTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICostEstimationTab createCostEstimationTab(IProjectView tabView)
	{
		ICostEstimationTab myTab = new CostEstimationTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICostEstimationEditView createCostEstimationEditView()
	{
		ICostEstimationEditView myView = new CostEstimationEditView(myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICostEstimationShowView createCostEstimationShowView()
	{
		ICostEstimationShowView myView = new CostEstimationShowView(myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICustomerTab createCustomerTab(@NotNull IProjectView tabView)
	{
		ICustomerTab myTab = new CustomerTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException)
	{
		IErrorDialog myView = new ErrorDialog(getFrameOfView(parentView), thrownException);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull Exception thrownException,
										  @Nullable String[] placeholderInText)
	{
		IErrorDialog myView = new ErrorDialog(getFrameOfView(parentView), thrownException, placeholderInText);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull String title,@NotNull String message)
	{
		IErrorDialog myView = new ErrorDialog(getFrameOfView(parentView), title, message);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IFileChooser createFileChooser(@Nullable IView parentView, @NotNull FileAccessType accessType)
	{
		IFileChooser myView = new FileChooser(getFrameOfView(parentView),accessType);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IFRequirementEditView createIFRequirementAddView()
	{
		IFRequirementEditView myView = new FRequirementEditView(myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public INFRequirementEditView createINFRequirementAddView()
	{
		INFRequirementEditView myView = new NFRequirementEditView(myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IOptimizedWeightFactorsView createOptimizedWeightFactorsView()
	{
		IOptimizedWeightFactorsView myView = new OptimizedWeightFactorsView(myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProductDataEditView createProductDataAddView()
	{
		IProductDataEditView myView = new ProductDataEditView(myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IFRequirementTab createFRequirementTab(@NotNull IProjectView tabView)
	{
		IFRequirementTab myTab = new FRequirementTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public INFRequirementTab createNFRequirementTab(@NotNull IProjectView tabView)
	{
		INFRequirementTab myTab = new NFRequirementTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProductDataTab createProductDataTab(@NotNull IProjectView tabView)
	{
		IProductDataTab myTab = new ProductDataTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IGlossaryTab createGlossaryTab(@NotNull IProjectView tabView)
	{
		IGlossaryTab myTab = new GlossaryTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProductApplicationTab createProductApplicationTab(@NotNull IProjectView tabView)
	{
		IProductApplicationTab myTab = new ProductApplicationTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProductEnvironmentTab createProductEnvironmentTab(@NotNull IProjectView tabView)
	{
		IProductEnvironmentTab myTab = new ProductEnvironmentTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProjectCreateView createProjectCreateView()
	{
		IProjectCreateView myView = new ProjectCreateView(myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProjectTab createProjectTab(@NotNull IProjectView tabView)
	{
		IProjectTab myTab = new ProjectTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProjectView createProjectView()
	{
		IProjectView myView = new ProjectView(myModel);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IQualityRequirementTab createQualityRequirementTab(@NotNull IProjectView tabView)
	{
		IQualityRequirementTab myTab = new QualityRequirementTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStartView createStartView()
	{
		IStartView myView = new StartView();
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITargetDefinitionTab createTargetDefinitionTab(@NotNull IProjectView tabView)
	{
		ITargetDefinitionTab myTab = new TargetDefinitionTab(myModel);
		addTabToTabView(tabView,myTab);

		return myTab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String dialogPropertyName)
	{
		return createWarningDialog(parentView, dialogPropertyName, (String[])null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
											  @Nullable String[] placeholderInText)
	{
		//TODO: Put TextBundle access in warning dialog
		IWarningDialog newWarningDialog = new WarningDialog(
				getFrameOfView(parentView),
				dialogPropertyName,
				placeholderInText
		);
		return newWarningDialog;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String warnTitle,
											  @NotNull String warnDescription)
	{
		IWarningDialog myView = new WarningDialog(getFrameOfView(parentView), warnTitle, warnDescription);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName)
	{
		IInfoDialog myView = new InfoDialog(getFrameOfView(parentView), dialogPropertyName);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
										@Nullable String[] placeholderInText)
	{
		IInfoDialog myView = new InfoDialog(getFrameOfView(parentView), dialogPropertyName, placeholderInText);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String infoTitle,
										@NotNull String infoMessage)
	{
		IInfoDialog myView = new InfoDialog(getFrameOfView(parentView), infoTitle, infoMessage);
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILoadingDialog createLoadingDialog(@Nullable IView parentView)
	{
		ILoadingDialog myView = new LoadingDialog(getFrameOfView(parentView));
		return myView;
	}

	/**
	 * {@inheritDoc}
	 */
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
