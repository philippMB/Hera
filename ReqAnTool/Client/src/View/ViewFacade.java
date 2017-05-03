package View;

import Model_Interfaces.IModelGetData;
import View_Interfaces.*;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.*;

/**
 * Created by phlippe on 01.05.17.
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

	public static ViewFacade getInstance(@NotNull IModelGetData model)
	{
		if(singletonFacade == null)
		{
			singletonFacade = new ViewFacade(model);
		}
		return singletonFacade;
	}

	@Override
	public IActualStateEditView createActualStateEditView()
	{
		return new ActualStateEditDialog(myModel);
	}

	@Override
	public IAdditionTab createAdditionTab()
	{
		return null;
	}

	@Override
	public ICostEstimationEditView createCostEstimationEditView()
	{
		return new CostEstimationEditView(myModel);
	}

	@Override
	public ICustomerTab createCustomerDataView()
	{
		return null;
	}

	@Override
	public IErrorDialog createErrorDialog(@NotNull String title,@NotNull String message)
	{
		return new ErrorDialog(title, message);
	}

	@Override
	public IFileChooser createFileChooser(@Nullable JFrame parentView,@NotNull FileAccess accessType)
	{
		return new FileChooser(parentView,accessType);
	}

	@Override
	public IFRequirementEditView createIFRequirementAddView()
	{
		return new FRequirementEditView(myModel);
	}

	@Override
	public IFRequirementEditView createIFRequirementEditView(@NotNull String ID)
	{
		IFRequirementEditView myView;

		if(myModel.getFReqByID(ID) == null)
		{
			myView = null;
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
		return new NFRequirementEditView(myModel);
	}

	@Override
	public INFRequirementEditView createINFRequirementEditView(@NotNull String ID)
	{
		INFRequirementEditView myView;

		if(myModel.getNFReqByID(ID) == null)
		{
			myView = null;
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
	public IProductDataEditView createProductDataAddView()
	{
		return new ProductDataEditView(myModel);
	}

	@Override
	public IProductDataEditView createProductDataEditView(@NotNull String ID)
	{
		IProductDataEditView myView;

		if(myModel.getProductDataByID(ID) == null)
		{
			myView = null;
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


}
