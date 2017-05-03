package View;

import View_Interfaces.FileAccess;
import View_Interfaces.IFileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created by phlippe on 01.05.17.
 */
public class FileChooser
	extends JFileChooser
	implements IFileChooser
{

	private JFrame myParentView;
	private FileAccess myAccessType;
	private int dialogReturn;


	public FileChooser(JFrame parentView, FileAccess accessType)
	{
		super();
		myParentView = parentView;
		myAccessType = accessType;
		dialogReturn = 0;
	}

	@Override
	public void showFileChooser()
	{
		FileFilter myFileFilter = null;
		switch (myAccessType)
		{
			case OPEN:
				dialogReturn = this.showOpenDialog(myParentView);
				myFileFilter = new FileNameExtensionFilter("ReqAn-Format",".reqan");
				break;
			case SAVE:
				dialogReturn = this.showSaveDialog(myParentView);
				myFileFilter = new FileNameExtensionFilter("ReqAn-Format",".reqan");
				break;
			case EXPORT:
				dialogReturn = this.showDialog(myParentView,"Exportieren");
				myFileFilter = new FileNameExtensionFilter("XML Format",".xml",".reqif");
				break;
			case IMPORT:
				dialogReturn = this.showDialog(myParentView,"Importieren");
				myFileFilter = new FileNameExtensionFilter("XML Format",".xml","reqif");
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

	@Override
	public String getChosenFile()
	{
		String selectedFile;

		if(dialogReturn == JFileChooser.APPROVE_OPTION)
		{
			selectedFile = getSelectedFile().getName();
		}
		else
		{
			selectedFile = null;
		}

		return selectedFile;
	}

}
