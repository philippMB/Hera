package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.ErrorCodes;
import View_Interfaces.IErrorDialog;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;

/**
 * Created by phlippe on 27.04.17.
 */
public class ErrorDialog
	extends DialogView
	implements IErrorDialog
{

	private static final String ERROR_IMAGE_PATH_STRING =
			"/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/Fehlerschild.png";
	private static final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.OK,
			ViewActions.CANCEL
	};

	private String descriptionText;
	private String title;


	public ErrorDialog(ErrorCodes errorCode){
		super(TextNameConstants.TITLE_ERROR);

		String errorCodeString = errorCode.toString();
		this.title = myTextBundle.getTitleText(errorCodeString);
		this.descriptionText = myTextBundle.getDialogText(errorCodeString);

		init();
	}

	public ErrorDialog(ErrorCodes errorCode, String[] placeholderInText){
		super(TextNameConstants.TITLE_ERROR);

		String errorCodeString = errorCode.toString();
		this.title = myTextBundle.getTitleText(errorCodeString);
		this.descriptionText = myTextBundle.getDialogText(errorCodeString, placeholderInText);

		init();
	}

	public ErrorDialog(String title, String errorDescription){
		super(TextNameConstants.TITLE_ERROR);
		this.title = title;
		descriptionText = errorDescription;

		init();
	}

	private Path getErrorImagePath()
	{
		return Paths.get(ERROR_IMAGE_PATH_STRING);
	}

	@Override
	protected void init()
	{
		setButtonActions(BUTTON_ACTIONS);
		buildDefaultStructure(title, descriptionText, getErrorImagePath());
		getContentPane().add(
				new BorderDecorater(
						myBuilder.getResult(),
						Color.RED,
						myTextBundle.getTitleText(TextNameConstants.TITLE_ERROR)
				)
		);

		pack();
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

}
