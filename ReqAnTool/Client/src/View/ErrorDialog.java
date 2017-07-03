package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import LanguageAndText.ExceptionToTextConverter;
import LanguageAndText.TextNameConstants;
import View_Interfaces.IDialog;
import View_Interfaces.IErrorDialog;
import View_Interfaces.IView;
import View_Interfaces.IViewFacadeFactory;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;

/**
 * This class is used for dialogs to inform the user about an error occurred in execution the program.
 * It is based on {@link DialogView} and does not need further functionality. An error dialog can correlate to a thrown
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
 *     	<li>{@link ViewFacadeFactory#createErrorDialog(IView, Exception)}</li>
 *      <li>{@link ViewFacadeFactory#createErrorDialog(IView, String, String)} </li>
 *      <li>{@link ViewFacadeFactory#createErrorDialog(IView, Exception, String[])}</li>
 *     </ul>
 *
 * @author 9045534
 * @version 1.0
 * @see DialogView
 * @see ViewFacadeFactory
 * @see ViewFacadeFactory#createErrorDialog(IView, Exception)
 * @see ViewFacadeFactory#createErrorDialog(IView, String, String)
 * @see ViewFacadeFactory#createErrorDialog(IView, Exception, String[])
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


	/**
	 * Standard constructor for creating an error dialog for a given exception.
	 * @param parentView Parent view for Dialog (see {@link DialogView#DialogView(JFrame, String)})
	 * @param thrownException Exception for which this error dialog should be adjusted (title and message)
	 */
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

	/**
	 * Standard constructor for creating an error dialog for a given exception with specified placeholder for
	 * message.
	 * @param parentView Parent view for Dialog (see {@link DialogView#DialogView(JFrame, String)})
	 * @param thrownException Exception for which this error dialog should be adjusted (title and message)
	 * @param placeholderInText Placeholder which should be used for message
	 */
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

	/**
	 * Standard constructor for creating an error dialog with given title and message.
	 * @param parentView Parent view for Dialog (see {@link DialogView#DialogView(JFrame, String)})
	 * @param title Property name of dialog's title
	 * @param errorDescription Property name of dialog's message
	 */
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

	/**
	 * {@inheritDoc}
	 */
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

}
