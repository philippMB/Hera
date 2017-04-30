package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 27.04.17.
 */
public abstract class TabPanel
	extends JPanel
{

	protected JPanelBuilder myBuilder;
	private String tabName;


	public TabPanel(String tabName)
	{
		this.tabName = tabName;
		setSize(500,500);
		myBuilder = JPanelBuilderFactory.getInstance().createPanelBuilder(this);
		setLayout(new BorderLayout());
		init();
	}

	public String getTabName()
	{
		return tabName;
	}

	protected abstract void init();

}
