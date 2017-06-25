package View_Interfaces;

/**
 * Views implementing this interface provide a simple mechanism to show loading dialogs.
 * The interface is based on {@link IDialog} and does not need further functionality due to the usage is provided
 * with the given functions.
 * <p>
 *     <b>Usage</b><br>
 *     To inform the user that the program is running/loading in the background a loading view of this interface
 *     provides with the standard methods {@link IView#showView()} and {@link IView#destruct()} a simple mechanism
 *     to start and stop a loading dialog.
 *     </p>
 *     <p>
 *         To give the user the feedback that the program is still running and working an animation or progress bar
 *         is shown in such dialogs. Other functionality is not needed so that this interface has no extra methods.
 *     </p>
 *     <p>
 *     <b>Caution:</b><br>
 *     By making the view visible by calling {@link IView#showView()} the current thread will <b>not</b> be blocked.
 *     This is done to simplify the usage of such loading dialogs by a controller.
 * </p>
 * <p>
 *     <b>View actions on view</b><br>
 *        This view does not provide any buttons for the user. The only action which could happen is closing the window.
 * </p>
 * <p>
 *     <b>Creation</b><br>
 *     For creating such an dialog please see following functions:
 * <ul>
 *     <li>{@link IViewFacadeFactory#createLoadingDialog(IView)}</li>
 * </ul>
 *
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 * @see IViewFacadeFactory
 * @see IViewFacadeFactory#createLoadingDialog(IView)
 */
public interface ILoadingDialog
	extends IDialog
{

}
