package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IProductApplicationTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 25.06.17.
 */
public class ProductApplicationTabController
	extends TextTabController<IProductApplicationTab>
{


	public ProductApplicationTabController(IModel model, IView parentView, IProductApplicationTab viewToBeControlled)
	{
		super(model, parentView, viewToBeControlled);
	}

	@Override
	protected void editDescriptionInModel(String newDescription)
	{
		myModel.editProdApp(newDescription);
	}

	@Override
	protected String getParameterPropertyName()
	{
		return TextNameConstants.PAR_PRODUCT_APPLICATION;
	}

}
