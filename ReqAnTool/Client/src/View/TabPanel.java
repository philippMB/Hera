package View;

import Controller_Interfaces.IViewController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IMenuBar;
import View_Interfaces.ITab;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 27.04.17.
 */
public abstract class TabPanel
	extends JPanel
	implements ITab
{

	protected ViewActions[] myButtonActions;
	protected JButton[] myButtons;
	protected IModelGetData myModel;
	protected PanelBuilder myBuilder;
	protected ITextFacade myTextBundle;
	private String tabName;


	public TabPanel(IModelGetData model, String titleConstant)
	{
		myModel = model;
		myTextBundle = ITextFacade.getInstance();
		this.tabName = myTextBundle.getTitleText(titleConstant);

		setSize(500,500);	//Um dem Builder die ungefähre Größe anzugeben
		myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);

		setLayout(new BorderLayout());	//Standard-Layout für zentrale Größenanpassung

		init();
	}

	protected void setButtonActions(ViewActions[] buttonActions)
	{
		myButtonActions = buttonActions;
		myButtons = new JButton[myButtonActions.length];
	}

	protected void setActionCommands()
	{
		for(int i=0;i<myButtonActions.length;i++)
		{
			myButtons[i].setActionCommand(myButtonActions[i].toString());
		}
	}

	protected String[] getButtonNames()
	{
		String[] buttonNames = new String[myButtonActions.length];

		for(int i=0;i<buttonNames.length;i++)
		{
			buttonNames[i] = myTextBundle.getButtonText(myButtonActions[i]);
		}

		return getButtonNames();
	}

	@Override
	public void addController(IViewController newController)
	{
		for(JButton b: myButtons)
		{
			b.addActionListener(newController);
		}
	}

	@Override
	public String getTabName()
	{
		return tabName;
	}

	@Override
	public void showView()
	{
		//Nothing to do because JTabbedPane in ProjectView regulates the visibility of the tabs
	}

	@Override
	public void destruct()
	{
		setVisible(false);
		getParent().remove(this);
	}

	@Override
	public void bringToFront()
	{
		((JTabbedPane)this.getParent()).setSelectedComponent(this);
	}

	@Override
	public JPanel getPanel()
	{
		return this;
	}

	/**
	 * Returns the belonging menu bar
	 *
	 * @return Menu bar which belongs to the view
	 */
	@Override
	public IMenuBar getViewMenu()
	{
		return null;
	}

	protected abstract void init();

}
