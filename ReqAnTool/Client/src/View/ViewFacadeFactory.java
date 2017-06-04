package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import LanguageAndText.ITextFacade;
import LanguageAndText.TextNameConstants;
import LanguageAndText.TextResourceBundle;
import Model_Interfaces.*;
import View_Interfaces.*;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import sun.tools.jconsole.Tab;

import javax.swing.*;

/**
 * @author Phillip Lippe
 * @see IViewFacadeFactory
 */
public class ViewFacadeFactory
	implements IViewFacadeFactory
{

	private static ViewFacadeFactory singletonViewFF;

	private IModelGetData myModel;


	private ViewFacadeFactory(@NotNull IModelGetData model)
	{
		myModel = model;
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
	public IActualStateEditView createActualStateEditView()
	{
		IActualStateEditView myView = new ActualStateEditDialog(myModel);
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
	public IErrorDialog createErrorDialog(@NotNull String title,@NotNull String message)
	{
		IErrorDialog myView = new ErrorDialog(title, message);
		return myView;
	}

	@Override
	public IFileChooser createFileChooser(@Nullable JFrame parentView,@NotNull FileAccess accessType)
	{
		IFileChooser myView = new FileChooser(parentView,accessType);

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
	public IFRequirementEditView createIFRequirementShowView(@NotNull String ID)
	{
		IFRequirementEditView myView;

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
	public INFRequirementEditView createINFRequirementShowView(@NotNull String ID)
	{
		INFRequirementEditView myView;

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
	public IProductDataEditView createProductDataShowView(@NotNull String ID)
	{
		IProductDataEditView myView;

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
	public IFRequirementTab createFRequirementTab(IProjectView tabView)
	{
		IFRequirementTab myTab = new FRequirementTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public INFRequirementTab createNFRequirementTab(IProjectView tabView)
	{
		INFRequirementTab myTab = new NFRequirementTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IProductDataTab createProductDataTab(IProjectView tabView)
	{
		IProductDataTab myTab = new ProductDataTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IGlossaryTab createGlossaryTab(IProjectView tabView)
	{
		IGlossaryTab myTab = new GlossaryTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IProcessClassificationView createProcessClassificationView(String ID)
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
	public IProductApplicationTab createProductApplicationTab(IProjectView tabView)
	{
		IProductApplicationTab myTab = new ProductApplicationTab(myModel);
		addTabToTabView(tabView, myTab);

		return myTab;
	}

	@Override
	public IProductEnvironmentTab createProductEnvironmentTab(IProjectView tabView)
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
	public IProjectTab createProjectTab(IProjectView tabView)
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
	public IQualityRequirementTab createQualityRequirementTab(IProjectView tabView)
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
	public IWarningDialog createWarningDialog(int dialogType)
	{
		ITextFacade myTextBundle = ITextFacade.getInstance();
		String warnTitle = myTextBundle.getTitleText(TextNameConstants.TITLE_SAVE_WARNING);
		String warnDescription = myTextBundle.getDialogText(DialogConstants.DIALOG_SAVE_WARNING);
		ViewActions[] warnButtonActions = DialogConstants.DIALOG_BUTTONS_SAVE_WARNING;

		return createWarningDialog(warnTitle,warnDescription,warnButtonActions);
	}

	@Override
	public IWarningDialog createWarningDialog(String warnTitle, String warnDescription)
	{
		IWarningDialog myView = new WarningDialog(warnTitle, warnDescription);
		return myView;
	}

	@Override
	public IWarningDialog createWarningDialog(String warnTitle, String warnDescription, ViewActions[] warnButtonActions)
	{
		IWarningDialog myView = new WarningDialog(warnTitle, warnDescription, warnButtonActions);
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

}
