package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IProductEnvironmentTab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by phlippe on 28.04.17.
 */
public class ProductEnvironmentTab
	extends TextTab
	implements IProductEnvironmentTab
{

	public ProductEnvironmentTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_PRODUCT_ENVIRONMENT);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_PRODUCT_ENVIRONMENT));
		buildTextPanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String getDescriptionFromModel()
	{
		return myModel.getProdApp().getDescription();	//TODO: CHANGE TO PRODUCT ENVIRONMENT
	}
}

