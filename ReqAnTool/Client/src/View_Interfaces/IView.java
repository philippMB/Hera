package View_Interfaces;

import Controller_Interfaces.IViewController;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.util.Observer;


/**
 * Basic interface which provides a standard structure for views.
 * <p>
 *     To simplify and support the compatibility and modularity of model, view and controller, this interface
 *     contains certain methods which every view has to implement. This includes:<br>
 *     <ul>
 *         <li><b>{@link IView#showView()}</b> - makes the view visible on the screen</li>
 *         <li><b>{@link IView#bringToFront()}</b> - brings view to the front of all views.
 *         Used for show the user a certain view that is already open.</li>
 *         <li><b>{@link IView#destruct()}</b> - sets view invisible and disposes it. </li>
 *         <li><b>{@link IView#getViewMenu()}</b> - gives the menu bar which belongs to this view.</li>
 *     </ul>
 *     Please look at the corresponding methods for details.
 * <p>
 *     The usage of views can be summed up in a short API (see below)<br>
 *     <b>API:</b><br>
 *     <code>
 *         //Creating model object as "myModel" and pass it to the view<br>
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
 * <p>
 *     Every view need a model object to get the data which it should present to the user. In order to update its
 *     fields if the model changes this interface extends the standard {@link Observer} interface. The model itself
 *     has to inherit from {@link java.util.Observable} to let the views observe the model.
 * </p>
 * <p>
 *     A {@link IMenuBar} belongs to each view. Due to mostly the menu bar is shared between different views they both
 *     are separated and should be separately controlled. The function {@link IView#getViewMenu()} returns the menu bar
 *     which belongs to this view object.
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
	public void addController(@NotNull IViewController newController);

	/**
	 * Sets a created view visible. Splits the creation and setting visible to give the controller more flexibility.
	 * <p>
	 *     <b>Caution:</b><br>
	 *     This method can internally be executed either in a different thread for performance or by blocking the
	 *     current thread (e.g. for {@link IErrorDialog}). Please have a look at the belonging documentation of
	 *     the certain view interface.
	 * </p>
	 */
	public void showView();

	/**
	 * Sets view invisible and disposes it. Should be called if it not needed anymore.
	 * <p>
	 *     <b>Caution:</b><br>
	 *     This method is not called if the user closes the view by himself. If the controller needs to react on
	 *     such an event it can do so by implementing the {@link java.awt.event.WindowListener} and overwritting
	 *     the corresponding methods.
	 * </p>
	 */
	public void destruct();

	/**
	 * Brings view to the front to be shown to the user.
	 * <p>
	 *     <b>Caution:</b><br>
	 *     This method has only functionality if the view is shown already ({@link IView#showView()} has to be executed).
	 *     Otherwise it will stay invisible for the user.
	 * </p>
	 */
	public void bringToFront();

	/**
	 * Returns the menu bar which belongs to this view.
	 * <p>
	 *     <b>Caution:</b><br>
	 *     If no menu bar is used for a view this method will return a null value. Please test this value on null before
	 *     using it further.
	 * </p>
	 * @return Menu bar which belongs to the view
	 * @see IMenuBar
	 */
	public @Nullable IMenuBar getViewMenu();

}
