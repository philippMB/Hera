package View;

import Model_Interfaces.IModelGetData;
import View_Interfaces.IView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 27.04.17.
 */
public abstract class TabPanel
	extends JPanel
	implements IView
{

	protected IModelGetData myModel;
	protected JPanelBuilder myBuilder;
	private String tabName;


	public TabPanel(IModelGetData model, String tabName)
	{
		myModel = model;
		this.tabName = tabName;

		setSize(500,500);	//Um dem Builder die ungefähre Größe anzugeben
		myBuilder = JPanelBuilderFactory.getInstance().createPanelBuilder(this);

		setLayout(new BorderLayout());	//Standard-Layout für zentrale Größenanpassung

		init();
	}

	public String getTabName()
	{
		return tabName;
	}

	@Override
	public void destruct()
	{
		setVisible(false);
		getParent().remove(this);
	}

	protected abstract void init();

}
