package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IFRequirementShowView;
import View_Interfaces.IProductDataShowView;

/**
 * Created by phlippe on 18.06.17.
 */
public class ProductDataShowController
	extends RequirementShowController<IProductDataShowView>
{

	public ProductDataShowController(IModel model, IProductDataShowView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	protected void deleteRequirement(String reqID)
	{
		myModel.remProdDataByID(reqID);
		closeView();
	}

	protected void editRequirement(String reqID)
	{
		controllerManager.createControlledProductDataEditView(reqID);
		closeView();
	}

	@Override
	protected String[] createDeletePlaceholderArray()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_PRODUCTDATA) + " " + getReqID()
		};
	}

}
