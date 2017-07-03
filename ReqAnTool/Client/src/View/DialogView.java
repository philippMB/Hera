package View;

import Controller_Interfaces.IViewController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import View_Interfaces.*;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.nio.file.Path;
import java.util.Observable;

/**
 * This basic class is used for dialogs to interact with the user by blocking all other views.
 * It is based on {@link IDialog} and informs the controller that all views implementing this interface are modal.
 *
 * <p>
 *     Subclasses of this interface provide different types of dialogs like:
 *     <ul>
 *         <li>{@link ErrorDialog} - informs user about error</li>
 *         <li>{@link InfoDialog} - informs user about state of system</li>
 *         <li>{@link WarningDialog} - warns user and gives him a choose of multiple options</li>
 *         <li>{@link LoadingDialog} - informs user about loading process</li>
 *         <li>{@link FileChooser} - let the user choose a file</li>
 *     </ul>
 *
 * <p>
 *     <b><i>Caution:</i></b><br>
 *     Some dialogs block by calling {@link IView#showView()} the current running thread. Please see under <i>Usage</i>
 *     of the specific dialog for further information.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see View_Interfaces.IDialog
 */
public abstract class DialogView
	extends JDialog
	implements IDialog
{

	protected ViewActions[] myButtonActions;
	protected JButton[] myButtons;
	protected ITextFacade myTextBundle;
	protected PanelBuilder myBuilder;


	/**
	 * Standard constructor which builds up the view.
	 * @param parentView View which is used as parent for this dialog. Could be null
	 * @param titleConstant Property name like from {@link LanguageAndText.TextNameConstants} under which the title
	 *                      text is found
	 */
	public DialogView(@Nullable JFrame parentView, String titleConstant){
		super(parentView);

		setSize(300,200);   //approx. size so that the correct factory can be build.
		setResizable(false);


		myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);
		myTextBundle = ITextFacade.getInstance();

		setTitle(myTextBundle.getTitleText(titleConstant));
	}

	/**
	 * Builds up the default structure for a dialog. This contains:
	 * <ul>
	 *     <li>Title</li>
	 *     <li>Image on the left</li>
	 *     <li>Text message on the right</li>
	 *     <li>Buttons from {@link DialogView#myButtonActions} which has to be set before calling this function</li>
	 * </ul>
	 * @param titleText Text which should be displayed as title
	 * @param descriptionText Message of dialog which is displayed right to the image
	 * @param imagePath Path to the image which is shown left to the message
	 */
	protected void buildDefaultDialogStructure(String titleText, String descriptionText, Path imagePath)
	{
		myBuilder.addTitle(titleText);
		myBuilder.addImage(imagePath);
		JTextArea textArea = myBuilder.addText(descriptionText);
		textArea.setColumns((getWidth()-80)/8);
		myButtons = myBuilder.addButtonBar(myButtonActions);
		setActionCommands();
	}

	/**
	 * Sets the button actions to the ones used for {@link DialogView#buildDefaultDialogStructure(String, String, Path)}
	 * and {@link DialogView#setActionCommands()}.
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
			if(myButtons[i] != null)
			{
				myButtons[i].setActionCommand(myButtonActions[i].toString());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addController(IViewController newController)
	{
		if(myButtons != null)
		{
			for (JButton b : myButtons)
			{
				b.addActionListener(newController);
			}
		}
		addWindowListener(newController);
	}

	/**
	 * {@inheritDoc}
	 * <br><b>CAUTION</b> - Will block the running thread!
	 */
	@Override
	public void showView()
	{
		if(getParent() != null)
		{
			setLocationRelativeTo(getParent());
		}
		setModal(true);
		setVisible(true);
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
		this.toFront();
	}

	/**
	 * This method is called whenever the observed object is changed. An
	 * application calls an <tt>Observable</tt> object's
	 * <code>notifyObservers</code> method to have all the object's
	 * observers notified of the change.
	 *
	 * @param o   the observable object.
	 * @param arg an argument passed to the <code>notifyObservers</code>
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		//As default dialogs do not have to be updated
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
