package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import View_Interfaces.ILoadingDialog;
import View_Interfaces.IView;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This loading dialog based on {@link ILoadingDialog} provide a simple mechanism to show loading processes as GUI.
 * <p>
 *     To inform the user that the program is running/loading in the background a loading view of this class
 *     could be started with {@link LoadingDialog#showView()} and stopped with {@link LoadingDialog#destruct()}.
 *     During it is visible a GIF animation is played to show the user that the program is still working.
 *     </p>
 *     <p>
 *     <b>Caution:</b><br>
 *     By making the view visible by calling {@link LoadingDialog#showView()} the current thread will <b>not</b> be
 *     blocked although it extends {@link DialogView}. This is done to simplify the usage of such
 *     loading dialogs by a controller.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see ILoadingDialog
 */
public class LoadingDialog
	extends DialogView
	implements ILoadingDialog
{

	/**
	 * Attribute that stores if the method {@link LoadingDialog#destruct()} is already called. Needed because showing
	 * the dialog takes place in another thread.
	 */
	private boolean isDestructed;


	/**
	 * Constructor which initialize the object without setting it visible.
	 * @param parentView Frame/View which calls this dialog to set in front of this.
	 */
	public LoadingDialog(@Nullable JFrame parentView)
	{
		super(parentView, DialogConstants.DIALOG_LOADING);
		isDestructed = false;
		init();
	}

	/**
	 * Converts the final string path {@link ImagePathConstants#LOADING_GIF_PATH_STRING} into a {@link Path} object.
	 * @return {@link Path} object of the string path {@link ImagePathConstants#LOADING_GIF_PATH_STRING}
	 */
	private Path getLoadingGIF()
	{
		return Paths.get(ImagePathConstants.LOADING_GIF_PATH_STRING);
	}

	//TODO: Get comments on init
	@Override
	protected void init()
	{
		setButtonActions(new ViewActions[0]);
		setActionCommands();
		myBuilder.addImage(getLoadingGIF(),true);
		myBuilder.addText(myTextBundle.getTitleText(DialogConstants.DIALOG_LOADING));
		getContentPane().add(myBuilder.getResult());
		pack();
	}

	/**
	 * Sets a created view visible. Splits the creation and setting visible to give the controller more flexibility.<br>
	 * Showing the view will not be blocking the current thread because it is loaded in an own thread
	 * but the dialog is still modal and in front of all views. If the method {@link LoadingDialog#destruct()} is called
	 * before the inner thread is executed the view will not be shown anymore.
	 */
	@Override
	public void showView()
	{
		SwingUtilities.invokeLater(
				() -> {
					if(!isDestructed)
					{
						super.showView();
					}
				}
		);
	}

	/**
	 * Sets view invisible and disposes it. Should be called if it not needed anymore.
	 * It sets <code>isDestructed</code> on true to inform other thread that the dialog should not be set visible
	 * anymore if it has not started yet.
	 */
	@Override
	public void destruct()
	{
		isDestructed = true;
		super.destruct();
	}

}
