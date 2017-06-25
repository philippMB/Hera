package View_Interfaces;

import Controller_Interfaces.ViewActions;

/**
 * This interface is used for dialogs to interact with the user by blocking all other views.
 * It is based on {@link IDialog} and informs the controller that all views implementing this interface are modal.
 *
 * <p>
 *     Subclasses of this interface provide different types of dialogs like:
 *     <ul>
 *         <li>{@link IErrorDialog} - informs user about error</li>
 *         <li>{@link IInfoDialog} - informs user about state of system</li>
 *         <li>{@link IWarningDialog} - warns user and gives him a choose of multiple options</li>
 *         <li>{@link ILoadingDialog} - informs user about loading process</li>
 *         <li>{@link IFileChooser} - let the user choose a file</li>
 *     </ul>
 *	   <img src="doc-files/DialogInterfaceDiagram.png" alt="Dialog structure"><br>
 *
 * <p>
 *     The further description of all dialogs are structured as follows:
 *     <ul>
 *         <li><i>Usage</i> - how to use the dialog</li>
 *         <li><i>View actions on view</i> - which {@link ViewActions} are provided to the user</li>
 *         <li><i>Creation</i> - how to create such a dialog</li>
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
 * @see IView
 * @see IErrorDialog
 * @see IInfoDialog
 * @see IWarningDialog
 * @see ILoadingDialog
 */
public interface IDialog
	extends IView
{
}
