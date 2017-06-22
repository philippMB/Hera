package View_Interfaces;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModelGetData;
import View.ViewFacadeFactory;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.*;

/**
 * Created by phlippe on 01.05.17.
 */
public interface IViewFacadeFactory
{

	public static IViewFacadeFactory getInstance(@NotNull IModelGetData model)
	{
		return ViewFacadeFactory.getInstance(model);
	}

	public IActualStateEditView createActualStateEditView(@Nullable IView parentView);

	public IAdditionTab createAdditionTab(@NotNull IProjectView tabView);

	public ICostEstimationTab createCostEstimationTab(@NotNull IProjectView tabView);

	public ICostEstimationEditView createCostEstimationEditView();

	public ICostEstimationShowView createCostEstimationShowView();

	public ICustomerTab createCustomerTab(@NotNull IProjectView tabView);

	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull ErrorCodes errorCode);

	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull ErrorCodes errorCode,
										  @Nullable String[] placeholderInText);

	public IErrorDialog createErrorDialog(@Nullable IView parentView, @NotNull String title,
										  @NotNull String message);

	public IFileChooser createFileChooser(@Nullable IView parentView, @NotNull FileAccessType accessType);

	public IFRequirementEditView createIFRequirementAddView();

	public IFRequirementEditView createIFRequirementEditView(@NotNull String ID);

	public IFRequirementShowView createIFRequirementShowView(@NotNull String ID);

	public INFRequirementEditView createINFRequirementAddView();

	public INFRequirementEditView createINFRequirementEditView(@NotNull String ID);

	public INFRequirementShowView createINFRequirementShowView(@NotNull String ID);

	public IOptimizedWeightFactorsView createOptimizedWeightFactorsView();

	public IProductDataEditView createProductDataAddView();

	public IProductDataEditView createProductDataEditView(@NotNull String ID);

	public IProductDataShowView createProductDataShowView(@NotNull String ID);

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

	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String dialogPropertyName);

	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
											  @Nullable String[] placeholderInText);

	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String warnTitle,
											  @NotNull String warnDescription);

	public IWarningDialog createWarningDialog(@Nullable IView parentView, @NotNull String warnTitle,
											  @NotNull String warnDescription,
											  @NotNull ViewActions[] warnButtonActions);

	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName);

	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String dialogPropertyName,
										@Nullable String[] placeholderInText);

	public IInfoDialog createInfoDialog(@Nullable IView parentView, @NotNull String warnTitle,
										@NotNull String warnDescription);

	public ILoadingDialog createLoadingDialog(@Nullable IView parentView);

	public IWeightFactorEditView createWeightFactorEditView();

}
