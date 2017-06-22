package View;

import Controller_Interfaces.IViewController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import View_Interfaces.IMenuBar;
import View_Interfaces.IView;

import javax.swing.*;

public abstract class FormWindow
    extends JFrame
	implements IView
{

	protected ViewActions[] myButtonActions;
	protected JButton[] myButtons;
	protected PanelBuilder myBuilder;
    protected ITextFacade myTextBundle;


    public FormWindow()
    {
        setSize(250,500);   //Ungefähre Größe, damit Factory richtigen Builder erzeugen kann
        myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);
        myTextBundle = ITextFacade.getInstance();
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

		return buttonNames;
	}

	@Override
	public void addController(IViewController newController)
	{
		for(JButton b: myButtons)
		{
			b.addActionListener(newController);
		}
		addWindowListener(newController);
	}

	@Override
	public void showView()
	{
		SwingUtilities.invokeLater(
				() -> setVisible(true)
		);
	}

	@Override
	public void destruct()
	{
		setVisible(false);
		dispose();
	}

	@Override
	public void bringToFront()
	{
		toFront();
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
