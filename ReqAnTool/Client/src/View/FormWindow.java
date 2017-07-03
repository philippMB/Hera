package View;

import Controller_Interfaces.IViewController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import Logging.ILogger;
import Logging.ILoggerFactory;
import View_Interfaces.IMenuBar;
import View_Interfaces.IView;

import javax.swing.*;

/**
 * This class is a standard for all form views in this package. It is based on {@link JFrame} and {@link IView} while
 * providing basic functionality for form windows. Subclasses of this class should specialize to a needed view.
 * <br>
 *     This class also manages {@link ViewActions} of its buttons. This is done to simplify the connection to the
 *     controller.
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 */
public abstract class FormWindow
    extends JFrame
	implements IView
{

	protected ViewActions[] myButtonActions;
	protected JButton[] myButtons;
	protected PanelBuilder myBuilder;
    protected ITextFacade myTextBundle;
    protected ILogger myLogger;


	/**
	 * Basic default constructor. Sets up all parameters. Please notice that the form window itself does not hold
	 * an instance of {@link Model_Interfaces.IModelGetData}. This is done to generalize it as much as possible.
	 */
	public FormWindow()
    {
        setSize(250,500);
        myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);
        myTextBundle = ITextFacade.getInstance();
        myLogger = ILoggerFactory.getInstance().createLogger();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
    }

	/**
	 * Sets the button actions to manage.
	 * @param buttonActions Actions of buttons
	 */
	protected void setButtonActions(ViewActions[] buttonActions)
	{
		myButtonActions = buttonActions;
		myButtons = new JButton[myButtonActions.length];
	}

	/**
	 * Sets the action commands of all buttons to their belonging {@link ViewActions#toString()}.
	 */
	protected void setActionCommands()
	{
		for(int i=0;i<myButtonActions.length;i++)
		{
			myButtons[i].setActionCommand(myButtonActions[i].toString());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addController(IViewController newController)
	{
		for(JButton b: myButtons)
		{
			b.addActionListener(newController);
		}
		addWindowListener(newController);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showView()
	{
		SwingUtilities.invokeLater(
				() -> setVisible(true)	//Lamda expression of Runnable. By calling run the view is set visible
		);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void destruct()
	{
		setVisible(false);
		dispose();
	}

	/**
	 * {@inheritDoc}
	 */
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

	/**
	 * Function which should build up the dialog. Although it is not called in this class it gives the subclasses a
	 * standard structure.
	 */
	protected abstract void init();

}
