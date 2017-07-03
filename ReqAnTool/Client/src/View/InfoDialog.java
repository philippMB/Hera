package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import View_Interfaces.IDialog;
import View_Interfaces.IInfoDialog;
import View_Interfaces.IView;
import View_Interfaces.IViewFacadeFactory;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This interface is used for dialogs to inform the user about the state of the system.
 * It is based on {@link DialogView} and does not need further functionality.
 * <p>
 *     <b>Usage</b><br>
 *     In this dialog the user is informed by a message and a title.
 *     The view is shown by {@link IView#showView()} and could be manually closed by {@link IView#destruct()}.
 *     <br>
 *     <b><i>Caution:</i></b><br>
 *     By making the view visible by calling {@link IView#showView()} the current thread will be blocked!
 *     This is done to simplify the usage of such info dialogs by a controller. If the thread should not be blocked
 *     start this function in a new {@link Thread}.
 * </p>
 * <p>
 *     <b>View actions on view</b><br>
 *         The standard buttons of this dialog are:
 *         <ul>
 *             <li>{@link ViewActions#OK} - Accepting the information as read</li>
 *         </ul>
 *         Further the controller could listen on closing this dialog.
 * <p>
 *     <b>Creation</b><br>
 *     For creating such an dialog please see following functions:
 * <ul>
 *     <li>{@link ViewFacadeFactory#createInfoDialog(IView, String)}</li>
 *     <li>{@link ViewFacadeFactory#createInfoDialog(IView, String, String)}</li>
 *     <li>{@link ViewFacadeFactory#createInfoDialog(IView, String, String[])}</li>
 * </ul>
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 * @see ViewFacadeFactory
 * @see ViewFacadeFactory#createInfoDialog(IView, String)
 * @see ViewFacadeFactory#createInfoDialog(IView, String, String)
 * @see ViewFacadeFactory#createInfoDialog(IView, String, String[])
 */
public class InfoDialog
	extends DialogView
	implements IInfoDialog
{

	private static final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.OK
	};

	private String descriptionText;
	private String titleText;


	/**
	 * Constructor setting up parentView of dialog and property name which specifies title and message.
	 * @param parentView ParentView of Dialog (see {@link DialogView#DialogView(JFrame, String)}
	 * @param dialogPropertyName Property name of title and dialog text.
	 */
	public InfoDialog(JFrame parentView, String dialogPropertyName)
	{
		super(parentView, TextNameConstants.TITLE_INFO);

		initText(
				myTextBundle.getTitleText(dialogPropertyName),
				myTextBundle.getDialogText(dialogPropertyName)
		);
		init();
	}

	/**
	 * Constructor setting up parentView of dialog and property name which specifies title and message. The placeholder
	 * are used for the message.
	 * @param parentView ParentView of Dialog (see {@link DialogView#DialogView(JFrame, String)}
	 * @param dialogPropertyName Property name of title and dialog text.
	 * @param placeholderInText Text which should replace the placeholder in the dialog message
	 */
	public InfoDialog(JFrame parentView, String dialogPropertyName, String[] placeholderInText)
	{
		super(parentView, TextNameConstants.TITLE_INFO);

		initText(
				myTextBundle.getTitleText(dialogPropertyName),
				myTextBundle.getDialogText(dialogPropertyName, placeholderInText)
		);
		init();
	}

	/**
	 * Constructor setting up parentView of dialog and title and message by string.
	 * @param parentView ParentView of Dialog (see {@link DialogView#DialogView(JFrame, String)}
	 * @param title Title of dialog
	 * @param informationMessage Description text of info
	 */
	public InfoDialog(JFrame parentView, String title, String informationMessage)
	{
		super(parentView, TextNameConstants.TITLE_INFO);

		initText(title, informationMessage);
		init();
	}

	private void initText(String titleText, String descriptionText)
	{
		this.titleText = titleText;
		this.descriptionText = descriptionText;
	}

	private Path getInfoImagePath()
	{
		return Paths.get(ImagePathConstants.INFO_IMAGE_PATH_STRING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		setButtonActions(BUTTON_ACTIONS);
		buildDefaultDialogStructure(titleText, descriptionText, getInfoImagePath());
		getContentPane().add(
				new BorderDecorater(myBuilder.getResult())
		);
		pack();
	}

}
