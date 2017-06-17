package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import LanguageAndText.TextNameConstants;
import View_Interfaces.FileAccessType;
import View_Interfaces.IFileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class provides a simple mechanism to let the user choose a file. It is based on {@link JFileChooser}
 * and adjusts its design to the action which should be done with the file (open, save, etc.) -
 * based on {@link FileAccessType}.
 * <p>
 * API:<br>
 *
 * 	<code>
 *     //Creating and execute a dialog to choose a file to open<br>
 *     FileChooser myFileChooser = new FileChooser(parentView, FileAccessType.OPEN);	//parentView for dialog<br>
 *     myFileChooser.showView();	//Blocks execution<br>
 *     String filePath = myFileChooser.getChosenFilePath();	//Gets absolute path to chosen file<br>
 * 	</code>
 * </p>
 * @author 9045534
 * @version 1.0
 * @see JFileChooser
 * @see FileAccessType
 */
public class FileChooser
	extends JFileChooser
	implements IFileChooser
{

	private JFrame myParentView;
	private FileAccessType myAccessType;
	private int dialogReturn;
	private ITextFacade myTextBundle;


	/**
	 * Constructor for setting up file chooser.
	 * @param parentView View from which this file chooser is called
	 * @param accessType What to be done with the file (open, save, etc - just design). Based on {@link FileAccessType}
	 */
	public FileChooser(JFrame parentView, FileAccessType accessType)
	{
		super();
		myParentView = parentView;
		myAccessType = accessType;
		dialogReturn = 0;
		myTextBundle = ITextFacade.getInstance();
		setFileFilter();
	}

	/**
	 * Opens the view and blocks the current thread in execution until user chose a file or closed the window.
	 */
	@Override
	public void showView()
	{
		switch (myAccessType)
		{
			case OPEN:
				dialogReturn = this.showOpenDialog(myParentView);
				break;
			case SAVE:
				dialogReturn = this.showSaveDialog(myParentView);
				break;
			case EXPORT:
				dialogReturn = this.showDialog(
						myParentView,
						myTextBundle.getButtonText(ViewActions.TO_XML)
				);
				break;
			case IMPORT:
				dialogReturn = this.showDialog(
						myParentView,
						myTextBundle.getButtonText(ViewActions.FROM_XML)
				);
				break;
			default:
				break;
		}
	}

	/**
	 * Setting filter for selecting files depending on file access type
	 */
	private void setFileFilter()
	{
		FileFilter myFileFilter = null;
		switch (myAccessType)
		{
			case OPEN:
				myFileFilter = new FileNameExtensionFilter(
						myTextBundle.getParameterText(TextNameConstants.PAR_REQAN_FORMAT),
						".reqan"
				);
				break;
			case SAVE:
				myFileFilter = new FileNameExtensionFilter(
						myTextBundle.getParameterText(TextNameConstants.PAR_REQAN_FORMAT),
						".reqan"
				);
				break;
			case EXPORT:
				myFileFilter = new FileNameExtensionFilter(
						myTextBundle.getParameterText(TextNameConstants.PAR_XML_FORMAT),
						".xml",".reqif"
				);
				break;
			case IMPORT:
				myFileFilter = new FileNameExtensionFilter(
						myTextBundle.getParameterText(TextNameConstants.PAR_XML_FORMAT),
						".xml","reqif"
				);
				break;
			default:
				break;
		}

		setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(myFileFilter != null)
		{
			setFileFilter(myFileFilter);
		}
	}

	/**
	 * Returns the file chosen by the user. If the user pressed the "cancel"-button or closed the window,
	 * the return value is null.
	 * @return Absolute file path chosen by user. If no file chosen null is returned.
	 */
	@Override
	public String getChosenFilePath()
	{
		String selectedFile;

		if(dialogReturn == JFileChooser.APPROVE_OPTION)
		{
			selectedFile = getSelectedFile().getAbsolutePath();
		}
		else	//Cancel-action or closed window
		{
			selectedFile = null;
		}

		return selectedFile;
	}

}
