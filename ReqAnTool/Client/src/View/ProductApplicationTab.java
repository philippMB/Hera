package View;

import View_Interfaces.IProductApplicationTab;

import java.awt.*;

/**
 * Created by phlippe on 28.04.17.
 */
public class ProductApplicationTab
	extends TextTab
	implements IProductApplicationTab
{

	public ProductApplicationTab()
	{
		super("Produkteinsatz");
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle("Produkteinsatz");
		buildTextPanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

}
