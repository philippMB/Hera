package View_Interfaces;

import Controller_Interfaces.IViewController;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.util.Observer;


/**
 *
 * <p>
 *     API:<br>
 *     <code>
 *         //Creating new model object as "myModel"
 *         IView myView = new IView(myModel,...);<br>
 *         ...//preparations before view is shown<br>
 *         myView.showView();<br>
 *         ...<br>
 *         //if view should get in front again <br>
 *         myView.bringToFront();<br>
 *         ...<br>
 *         //if view is no longer needed und should be closed<br>
 *         myView.destruct();<br>
 *     </code>
 * </p>
 * @author 9045534
 * @version 1.1
 * @see IViewController
 * @see java.awt.event.ActionListener
 * @see java.awt.event.WindowListener
 * @see Observer
 */
public interface IView
	extends Observer
{

	/**
	 * Adds a controller as {@link java.awt.event.ActionListener} to every button and as
	 * {@link java.awt.event.WindowListener} to the frame if supported by the view.
	 * @param newController Controller that should be added to the view
	 */
	public void addController(IViewController newController);

	/**
	 * Sets a created view visible. Splits the creation and setting visible (for performance)
	 */
	public void showView();

	/**
	 * Sets view invisible and disposes it
	 */
	public void destruct();

	/**
	 * Brings view to the front
	 */
	public void bringToFront();

	/**
	 * Returns the belonging menu bar
	 * @return Menu bar which belongs to the view
	 */
	public @Nullable IMenuBar getViewMenu();

}
