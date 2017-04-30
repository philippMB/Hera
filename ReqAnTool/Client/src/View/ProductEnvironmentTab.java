package View;

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

	public ProductEnvironmentTab()
	{
		super("Produktumgebung");
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle("Produktumgebung");
		buildTextPanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

}

