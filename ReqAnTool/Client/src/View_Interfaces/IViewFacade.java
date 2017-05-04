package View_Interfaces;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import View.*;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.*;

/**
 * Created by phlippe on 01.05.17.
 */
public interface IViewFacade
{

	public static IViewFacade getInstance(IModelGetData model)
	{
		return ViewFacade.getInstance(model);
	}

	public IActualStateEditView createActualStateEditView();

	public IAdditionTab createAdditionTab(@NotNull IProjectView tabView);

	public ICostEstimationEditView createCostEstimationEditView();

	public ICostEstimationShowView createCostEstimationShowView();

	public ICustomerTab createCustomerTab(@NotNull IProjectView tabView);

	public IErrorDialog createErrorDialog(@NotNull String title, @NotNull String message);

	public IFileChooser createFileChooser(@Nullable JFrame parentView, @NotNull FileAccess accessType);

	public IFRequirementEditView createIFRequirementAddView();

	public IFRequirementEditView createIFRequirementEditView(@NotNull String ID);

	public IFRequirementEditView createIFRequirementShowView(@NotNull String ID);

	public INFRequirementEditView createINFRequirementAddView();

	public INFRequirementEditView createINFRequirementEditView(@NotNull String ID);

	public INFRequirementEditView createINFRequirementShowView(@NotNull String ID);

	public IOptimizedWeightFactorsView createOptimizedWeightFactorsView();

	public IProductDataEditView createProductDataAddView();

	public IProductDataEditView createProductDataEditView(@NotNull String ID);

	public IProductDataEditView createProductDataShowView(@NotNull String ID);

	public IFRequirementTab createFRequirementTab(@NotNull IProjectView tabView);

	public INFRequirementTab createNFRequirementTab(@NotNull IProjectView tabView);

	public IProductDataTab createProductDataTab(@NotNull IProjectView tabView);

	public IGlossaryTab createGlossaryTab(@NotNull IProjectView tabView);

	public IProcessClassificationView createProcessClassificationView(@NotNull String ID);

	public IProductApplicationTab createProductApplicationTab(@NotNull IProjectView tabView);

	public IProductEnvironmentTab createProductEnvironmentTab(@NotNull IProjectView tabView);

	public IProjectCreateView createProjectCreateView();

	public IProjectTab createProjectTab(@NotNull IProjectView tabView);

	public IProjectView createProjectView();

	public IQualityRequirementTab createQualityRequirementTab(@NotNull IProjectView tabView);

	public IStartView createStartView();

	public ITargetDefinitionTab createTargetDefinitionTab(@NotNull IProjectView tabView);

	public IWarningDialog createWarningDialog(String warnTitle, String warnDescription);

	public IWarningDialog createWarningDialog(String warnTitle, String warnDescription, ViewActions[] warnButtonActions);

	public IWeightFactorEditView createWeightFactorEditView();

}
