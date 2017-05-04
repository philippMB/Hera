package View;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.*;
import View_Interfaces.*;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.*;

/**
 * @author Phillip Lippe
 * @see View_Interfaces.IViewFacade
 */
public class ViewFacade
	implements IViewFacade
{

	private static ViewFacade singletonFacade;

	private IModelGetData myModel;


	private ViewFacade(@NotNull IModelGetData model)
	{
		myModel = model;
	}

	/**
	 *
	 * @param model
	 * @return
	 */
	public static ViewFacade getInstance(@NotNull IModelGetData model)
	{
		if(singletonFacade == null)
		{
			singletonFacade = new ViewFacade(model);
		}
		return singletonFacade;
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
		tabView.addTab(myTab);

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
		tabView.addTab(myTab);

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

		if(myModel.getNFReqByID(ID) == null)
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
		tabView.addTab(myTab);

		return myTab;
	}

	@Override
	public INFRequirementTab createNFRequirementTab(IProjectView tabView)
	{
		INFRequirementTab myTab = new NFRequirementTab(myModel);
		tabView.addTab(myTab);

		return myTab;
	}

	@Override
	public IProductDataTab createProductDataTab(IProjectView tabView)
	{
		IProductDataTab myTab = new ProductDataTab(myModel);
		tabView.addTab(myTab);

		return myTab;
	}

	@Override
	public IGlossaryTab createGlossaryTab(IProjectView tabView)
	{
		IGlossaryTab myTab = new GlossaryTab(myModel);
		tabView.addTab(myTab);

		return myTab;
	}

	@Override
	public IProcessClassificationView createProcessClassificationView(String ID)
	{
		IProcessClassificationView myView = null;
		IRequirement myReq = myModel.getReqByID(ID);

		if(myReq instanceof IFRequirement)
		{
			myView = new ProcessClassificationFReqView(myModel, ID);
		}
		if(myReq instanceof INFRequirement)
		{
			myView = new ProcessClassificationNFReqView(myModel, ID);
		}
		if(myReq instanceof IProductData)
		{
			myView = new ProcessClassificationProdDataView(myModel, ID);
		}

		return myView;
	}

	@Override
	public IProductApplicationTab createProductApplicationTab(IProjectView tabView)
	{
		IProductApplicationTab myTab = new ProductApplicationTab(myModel);
		tabView.addTab(myTab);

		return myTab;
	}

	@Override
	public IProductEnvironmentTab createProductEnvironmentTab(IProjectView tabView)
	{
		IProductEnvironmentTab myTab = new ProductEnvironmentTab(myModel);
		tabView.addTab(myTab);

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
		tabView.addTab(myTab);

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
		tabView.addTab(myTab);

		return myTab;
	}

	@Override
	public IStartView createStartView()
	{
		IStartView myView = new StartView();
		return myView;
	}

	@Override
	public ITargetDefinitionTab createTargetDefinitionTab(IProjectView tabView)
	{
		ITargetDefinitionTab myTab = new TargetDefinitionTab(myModel);
		tabView.addTab(myTab);

		return myTab;
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

}
