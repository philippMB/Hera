package View_Interfaces;

import Controller_Interfaces.ViewActions;

/**
 * This interface is used for dialogs to warn the user about a consequence of the action he want to take.
 * It is based on {@link IDialog} and does not need further functionality.
 * <p>
 *     <b>Usage</b><br>
 *     In this dialog the user is warned by a message and a title and could choose multiple options to proceed.
 *     The view is shown by {@link IView#showView()} and could be manually closed by {@link IView#destruct()}.
 *     <br>
 *     <b><i>Caution:</i></b><br>
 *     By making the view visible by calling {@link IView#showView()} the current thread will be blocked!
 *     This is done to simplify the usage of such warning dialogs by a controller, because the program mostly stops when
 *     a warning occurred. If the thread should not be blocked start this function in a new {@link Thread}.
 * </p>
 * <p>
 *     <b>View actions on view</b><br>
 *         The buttons of this dialog are customized to the property name (see {@link LanguageAndText.DialogConstants})
 *         or are given as parameter. Further the controller could listen on closing this dialog.
 * </p>
 * <p>
 *     <b>Creation</b><br>
 *     For creating such an dialog please see following functions:
 * <ul>
 *     <li>{@link IViewFacadeFactory#createWarningDialog(IView, String)}</li>
 *     <li>{@link IViewFacadeFactory#createWarningDialog(IView, String, String)}</li>
 *     <li>{@link IViewFacadeFactory#createWarningDialog(IView, String, String[])}</li>
 *     <li>{@link IViewFacadeFactory#createWarningDialog(IView, String, String, ViewActions[])}</li>
 * </ul>
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 * @see IViewFacadeFactory
 * @see IViewFacadeFactory#createWarningDialog(IView, String)
 * @see IViewFacadeFactory#createWarningDialog(IView, String, String)
 * @see IViewFacadeFactory#createWarningDialog(IView, String, String[])
 * @see IViewFacadeFactory#createWarningDialog(IView, String, String, ViewActions[])
 */
public interface IWarningDialog
	extends IDialog
{

}
