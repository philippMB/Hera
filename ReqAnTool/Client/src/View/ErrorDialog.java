package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import LanguageAndText.ExceptionToTextConverter;
import LanguageAndText.TextNameConstants;
import View_Interfaces.IErrorDialog;

import javax.swing.*;
import java.awt.*;
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

	private static final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.OK,
			ViewActions.CANCEL
	};

	private String descriptionText;
	private String title;


	public ErrorDialog(JFrame parentView, Exception thrownException){
		super(parentView, TextNameConstants.TITLE_ERROR);
		ExceptionToTextConverter exceptionConverter = ExceptionToTextConverter.getInstance();

		initText(
				myTextBundle.getTitleText(exceptionConverter.getExTitleProperty(thrownException)),
				myTextBundle.getDialogText(exceptionConverter.getExMessageProperty(thrownException),
						exceptionConverter.getExPlaceholders(myTextBundle, thrownException))
		);


		init();
	}

	public ErrorDialog(JFrame parentView, Exception thrownException, String[] placeholderInText){
		super(parentView, TextNameConstants.TITLE_ERROR);
		ExceptionToTextConverter exceptionConverter = ExceptionToTextConverter.getInstance();

		initText(
				myTextBundle.getTitleText(exceptionConverter.getExTitleProperty(thrownException)),
				myTextBundle.getDialogText(exceptionConverter.getExMessageProperty(thrownException),
						placeholderInText)
		);

		init();
	}

	public ErrorDialog(JFrame parentView, String title, String errorDescription){
		super(parentView, TextNameConstants.TITLE_ERROR);

		initText(title, errorDescription);
		init();
	}

	private void initText(String title, String descriptionText)
	{
		this.title = title;
		this.descriptionText = descriptionText;
	}

	private Path getErrorImagePath()
	{
		return Paths.get(ImagePathConstants.ERROR_IMAGE_PATH_STRING);
	}

	@Override
	protected void init()
	{
		setButtonActions(BUTTON_ACTIONS);
		buildDefaultDialogStructure(title, descriptionText, getErrorImagePath());
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
