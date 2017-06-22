package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import View_Interfaces.ILoadingDialog;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by phlippe on 17.06.17.
 */
public class LoadingDialog
	extends DialogView
	implements ILoadingDialog
{

	private static final String PATH_TO_LOADING_GIF =
			"/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/loading_small.gif";

	private boolean isDestructed;


	public LoadingDialog(JFrame parentView)
	{
		super(parentView, DialogConstants.DIALOG_LOADING);
		isDestructed = false;
		init();
	}

	private Path getLoadingGIF()
	{
		return Paths.get(PATH_TO_LOADING_GIF);
	}

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
	 * Will not be blocking the current thread but is still modal and in front of all views.
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

	@Override
	public void destruct()
	{
		isDestructed = true;
		super.destruct();
	}
}
