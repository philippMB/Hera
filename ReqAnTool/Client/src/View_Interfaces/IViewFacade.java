package View_Interfaces;

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

	public IAdditionTab createAdditionTab();

	public ICostEstimationEditView createCostEstimationEditView();

	public ICustomerTab createCustomerDataView();

	public IErrorDialog createErrorDialog(@NotNull String title, @NotNull String message);

	public IFileChooser createFileChooser(@Nullable JFrame parentView, @NotNull FileAccess accessType);

	public IFRequirementEditView createIFRequirementAddView();

	public IFRequirementEditView createIFRequirementEditView(@NotNull String ID);

	public IFRequirementEditView createIFRequirementShowView(@NotNull String ID);

	public INFRequirementEditView createINFRequirementAddView();

	public INFRequirementEditView createINFRequirementEditView(@NotNull String ID);

	public INFRequirementEditView createINFRequirementShowView(@NotNull String ID);

	public IProductDataEditView createProductDataAddView();

	public IProductDataEditView createProductDataEditView(@NotNull String ID);

	public IProductDataEditView createProductDataShowView(@NotNull String ID);

}
