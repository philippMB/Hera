package View_Interfaces;

import Controller_Interfaces.ViewActions;

/**
 * This interface is used for dialogs to inform the user about a error occurred in execution the program.
 * It is based on {@link IDialog} and does not need further functionality. An error dialog can correlate to a thrown
 * exception in the system and represents the interface of the internal exceptions to communicating it to the user.
 * <p>
 *     <b>Usage</b><br>
 *     In this dialog the user is informed by a message and a title about the occurred error.
 *     The view is shown by {@link IView#showView()} and could be manually closed by {@link IView#destruct()}.
 *     <br>
 *     <b><i>Caution:</i></b><br>
 *     By making the view visible by calling {@link IView#showView()} the current thread will be blocked!
 *     This is done to simplify the usage of such error dialogs by a controller, because the program mostly stops when
 *     an error occurred. If the thread should not be blocked start this function in a new {@link Thread}.
 * </p>
 * <p>
 *     <b>View actions on view</b><br>
 *         The standard buttons of this dialog are:
 *         <ul>
 *             <li>{@link ViewActions#OK} - Accepting this error</li>
 *             <li>{@link ViewActions#CANCEL} - Cancel the execution</li>
 *         </ul>
 *         Further the controller could listen on closing this dialog.
 *
 * <p>
 *     <b>Creation</b><br>
 *     For creating such an dialog please see following functions:
 * 	   <ul>
 *     	<li>{@link IViewFacadeFactory#createErrorDialog(IView, Exception)}</li>
 *      <li>{@link IViewFacadeFactory#createErrorDialog(IView, String, String)} </li>
 *      <li>{@link IViewFacadeFactory#createErrorDialog(IView, Exception, String[])}</li>
 *     </ul>
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 * @see IViewFacadeFactory
 * @see IViewFacadeFactory#createErrorDialog(IView, Exception)
 * @see IViewFacadeFactory#createErrorDialog(IView, String, String)
 * @see IViewFacadeFactory#createErrorDialog(IView, Exception, String[])
 */
public interface IErrorDialog
	extends IDialog
{

}
