package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IProductApplication;
import View_Interfaces.IProductApplicationTab;

import java.awt.*;

/**
 * Created by phlippe on 28.04.17.
 */
public class ProductApplicationTab
	extends TextTab
	implements IProductApplicationTab
{

	public ProductApplicationTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_PRODUCT_APPLICATION);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_PRODUCT_APPLICATION)
		);
		buildTextPanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String getDescriptionFromModel()
	{
		IProductApplication myProductApplication = myModel.getProdApp();
		return myProductApplication.getDescription();
	}

}
