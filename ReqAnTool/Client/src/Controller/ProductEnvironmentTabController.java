package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IProductEnvironmentTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 25.06.17.
 */
public class ProductEnvironmentTabController
	extends TextTabController<IProductEnvironmentTab>
{


	public ProductEnvironmentTabController(IModel model, IView parentView, IProductEnvironmentTab viewToBeControlled)
	{
		super(model, parentView, viewToBeControlled);
	}

	@Override
	protected void editDescriptionInModel(String newDescription)
	{
		//TODO: Uncomment this
		//myModel.editProdEnv(newDescription);
	}

	@Override
	protected String getParameterPropertyName()
	{
		return TextNameConstants.PAR_PRODUCT_ENVIRONMENT;
	}
}
