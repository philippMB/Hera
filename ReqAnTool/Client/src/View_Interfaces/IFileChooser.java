package View_Interfaces;

/**
 * Classes implementing this interface provide a simple mechanism to let the user choose a file.
 * To simplify the progress of selecting a file this interface builds up a standard structure for GUI managing this
 * including an API for usage (see below).
 * <p>
 *     <b>Usage</b><br>
 *     Due to the fact that choosing a file is a progress which should run in front
 * 	   of all other views this view has to be a {@link IDialog}.<br>
 *     To get the selected file after processing, the method {@link IFileChooser#getChosenFilePath()} will return the
 *     absolute path of the file chosen by the user. If the user has not chosen a file the null value is returned.<br>
 *     To provide different layouts for the reason of choosing a file the parameter {@link FileAccessType} in
 *     <i>Creating</i> is for selecting between open, save, import and export.
 *
 *     <b><i>Caution</i></b><br>
 *     By making the view visible by calling {@link IView#showView()} the current thread will be blocked until the user
 *     closes the view, cancels or chooses a file! This is done to simplify the usage of such file chooser by a
 *     controller, because the program mostly stops until the user has chosen a file. If the thread should not be
 *     blocked start this function in a new {@link Thread}.
 * </p>
 * <p>
 *
 * <b>API:</b><br>
 * 	<code>
 *     //Assuming: "myFileChooser" is object of {@link IFileChooser}<br>
 *     myFileChooser.showView();	//Blocks execution<br>
 *     String filePath = myFileChooser.getChosenFilePath();	//Gets absolute path to chosen file<br>
 * 	</code>
 * 	</p>
 * 	<p>
 * 	    <b>View actions in view</b><br>
 * 	        This view holds an internal controller so that no view actions are needed to be controlled.
 * 	</p>
 * 	<p>
 * 	    <b>Creating</b><br>
 *     For creating a IFileChooser please refer to {@link IViewFacadeFactory#createFileChooser(IView, FileAccessType)}.
 * 	</p>
 * @author 9045534
 * @version 1.0
 * @see IDialog
 * @see IViewFacadeFactory#createFileChooser(IView, FileAccessType)
 * @see FileAccessType
 */
public interface IFileChooser
	extends IDialog
{

	/**
	 * Returns the file chosen by the user. If the user canceled or closed the window null will be returned.
	 * @return Absolute file path chosen by user. If no file chosen null is returned.
	 */
	public String getChosenFilePath();

}
