package View_Interfaces;

import Controller_Interfaces.ViewActions;

/**
 * This interface is used for dialogs to inform the user about the state of the system.
 * It is based on {@link IDialog} and does not need further functionality.
 * <p>
 *     <b>Usage</b><br>
 *     In this dialog the user is informed by a message and a title.
 *     The view is shown by {@link IView#showView()} and could be manually closed by {@link IView#destruct()}.
 *     <br>
 *     <b><i>Caution:</i></b><br>
 *     By making the view visible by calling {@link IView#showView()} the current thread will be blocked!
 *     This is done to simplify the usage of such info dialogs by a controller. If the thread should not be blocked
 *     start this function in a new {@link Thread}.
 * </p>
 * <p>
 *     <b>View actions on view</b><br>
 *         The standard buttons of this dialog are:
 *         <ul>
 *             <li>{@link ViewActions#OK} - Accepting the information as read</li>
 *         </ul>
 *         Further the controller could listen on closing this dialog.
 * <p>
 *     <b>Creation</b><br>
 *     For creating such an dialog please see following functions:
 * <ul>
 *     <li>{@link IViewFacadeFactory#createInfoDialog(IView, String)}</li>
 *     <li>{@link IViewFacadeFactory#createInfoDialog(IView, String, String)}</li>
 *     <li>{@link IViewFacadeFactory#createInfoDialog(IView, String, String[])}</li>
 * </ul>
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 * @see IViewFacadeFactory
 * @see IViewFacadeFactory#createInfoDialog(IView, String)
 * @see IViewFacadeFactory#createInfoDialog(IView, String, String)
 * @see IViewFacadeFactory#createInfoDialog(IView, String, String[])
 */
public interface IInfoDialog
	extends IDialog
{

}
