package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Logging.ILogger;
import Logging.ILoggerFactory;
import View_Interfaces.IDialog;
import View_Interfaces.IView;
import View_Interfaces.IViewFacadeFactory;
import View_Interfaces.IWarningDialog;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This dialog is based on {@link IWarningDialog} to warn the user about a consequence of the action he want to take.
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
 *     <li>{@link ViewFacadeFactory#createWarningDialog(IView, String)}</li>
 *     <li>{@link ViewFacadeFactory#createWarningDialog(IView, String, String)}</li>
 *     <li>{@link ViewFacadeFactory#createWarningDialog(IView, String, String[])}</li>
 *     <li>{@link ViewFacadeFactory#createWarningDialog(IView, String, String, ViewActions[])}</li>
 * </ul>
 *
 * @author 9045534
 * @version 1.0
 * @see IWarningDialog
 * @see ViewFacadeFactory
 * @see ViewFacadeFactory#createWarningDialog(IView, String)
 * @see ViewFacadeFactory#createWarningDialog(IView, String, String)
 * @see ViewFacadeFactory#createWarningDialog(IView, String, String[])
 * @see ViewFacadeFactory#createWarningDialog(IView, String, String, ViewActions[])
 */
public class WarningDialog
	extends DialogView
	implements IWarningDialog
{

	private static final Color WARN_COLOR = new Color(238,190,40);
	private static final ViewActions[] DEFAULT_BUTTON_ACTIONS = {
		ViewActions.OK,
		ViewActions.CANCEL
	};

	private String title;
	private String description;
	private ILogger myLogger;


	/**
	 * Creates a warning dialog with the specified Frame as its owner and customizes its title, message and buttons on
	 * the given property name (used for {@link LanguageAndText.ITextFacade} and {@link DialogConstants}).
	 * @param parentView Sets the view as the owner of this view
	 * @param propertyName Property name which specifies title, message and buttons
	 */
	public WarningDialog(@Nullable JFrame parentView, String propertyName)
	{
		this(parentView, propertyName,(String[])null);
	}

	/**
	 * Creates a warning dialog with the specified Frame as its owner and customizes its title, message and buttons on
	 * the given property name (used for {@link LanguageAndText.ITextFacade} and {@link DialogConstants}). The message
	 * is customized further with the placeholder which are replaced in the text
	 * (see {@link LanguageAndText.ITextFacade#getDialogText(String, String[])}).
	 * @param parentView Sets the view as the owner of this view
	 * @param propertyName Property name which specifies title, message and buttons
	 * @param placeholderInText Text with which the placeholder should be replaced in the message
	 */
	public WarningDialog(@Nullable JFrame parentView, String propertyName, @Nullable String[] placeholderInText)
	{
		super(parentView, propertyName);
		myLogger = ILoggerFactory.getInstance().createLogger();
		if(DialogConstants.containsMapDialogPropertyName(propertyName, myLogger))
		{
			title = myTextBundle.getTitleText(propertyName);
			if(placeholderInText != null)
			{
				description = myTextBundle.getDialogText(propertyName, placeholderInText);
			}
			else
			{
				description = myTextBundle.getDialogText(propertyName);
			}
			setButtonActions(DialogConstants.getViewActionsByPropertyName(propertyName));
		}
		else
		{
			myLogger.error("Given property name "+propertyName+" was unknown in DialogConstants map");
			title = "";
			description = "";
			setButtonActions(new ViewActions[0]);
		}

		init();
	}

	/**
	 * Creates a warning dialog with the specified Frame as its owner and the given title and description. The view
	 * actions are set as default to {@link ViewActions#OK} and {@link ViewActions#CANCEL}.
	 * @param parentView Sets the view as the owner of this view
	 * @param warnTitle Title of dialog
	 * @param warnDescription Message of dialog
	 */
	public WarningDialog(@Nullable JFrame parentView, String warnTitle, String warnDescription){
		this(parentView, warnTitle, warnDescription, null);
	}

	/**
	 * Creates a warning dialog with the specified Frame as its owner and the given title and description. The buttons
	 * are set to the given {@link ViewActions}.
	 * @param parentView Sets the view as the owner of this view
	 * @param warnTitle Title of dialog
	 * @param warnDescription Message of dialog
	 * @param warnButtonActions Buttons of dialog
	 */
	public WarningDialog(@Nullable JFrame parentView, String warnTitle, String warnDescription,
						 @Nullable ViewActions[] warnButtonActions){
		super(parentView, TextNameConstants.TITLE_WARNING);
		title = warnTitle;
		description = warnDescription;
		if(warnButtonActions != null)
		{
			setButtonActions(warnButtonActions);
		}
		else
		{
			setButtonActions(DEFAULT_BUTTON_ACTIONS);
		}
		myLogger = ILoggerFactory.getInstance().createLogger();

		init();
	}

	private Path getWarnImagePath()
	{
		return Paths.get(ImagePathConstants.WARN_IMAGE_PATH_STRING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		buildDefaultDialogStructure(title, description, getWarnImagePath());
		getContentPane().add(
				new BorderDecorater(
						myBuilder.getResult(),
						WARN_COLOR,
						myTextBundle.getTitleText(TextNameConstants.TITLE_WARNING)
				)
		);

		pack();
	}

}
