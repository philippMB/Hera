package LanguageAndText;

import Controller_Interfaces.ViewActions;

import java.util.*;

/**
 * <p>
 * This class contains solely constants for the structure of common warning dialogs including
 * <ul>
 *     <li>property names for the property file "dialog" to get language-independent message</li>
 *     <li>{@link ViewActions} of the buttons in a specific dialog</li>
 * </ul>
 * Due to the unique ID of a warning is its name the belonging of {@link ViewActions} to the right dialog is
 * realised by a {@link Map}. The key is the name, and the returned value is an array of {@link ViewActions}
 * representing the button actions of the specific dialog.
 *
 * <p>
 * Error dialogs are handled by {@link Model_Interfaces.ErrorCodes} similar to the "button"-property file.
 * The usage of all name constants is the same as for {@link TextNameConstants}.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see ITextFacade
 * @see TextNameConstants
 * @see ViewActions
 * @see Map
 */
public abstract class DialogConstants
{

	/**
	 * Name constant for property file
	 */
	public static final String DIALOG_SAVE_REQAN_WARNING = "SAVE_REQAN_WARNING";
	public static final String DIALOG_SAVE_DATA_WARNING = "SAVE_DATA_WARNING";
	public static final String DIALOG_DELETE_WARNING = "DELETE_WARNING";
	public static final String DIALOG_WFOPT_WARNING = "WFOPT_WARNING";
	public static final String DIALOG_INFO_SAVING_DATA = "INFO_SAVING_DATA";
	public static final String DIALOG_INFO_SAVING_FILE = "INFO_SAVING_FILE";
	public static final String DIALOG_INFO_NOT_IMPLEMENTED = "INFO_NOT_IMPLEMENTED";
	public static final String DIALOG_LOADING = "LOADING";

	/**
	 * Defines the {@link ViewActions} for the buttons in the specific dialog
	 */
	public static final Map<String, ViewActions[]> DIALOG_NAME_TO_VIEW_ACTIONS =
			Collections.unmodifiableMap(
					new HashMap<String, ViewActions[]>()
					{{
						put(DIALOG_SAVE_REQAN_WARNING,new ViewActions[]{ ViewActions.SAVE,
																		ViewActions.DONT_SAVE,
																		ViewActions.CANCEL });
						put(DIALOG_SAVE_DATA_WARNING,new ViewActions[]{ ViewActions.SAVE,
																		ViewActions.DONT_SAVE,
																		ViewActions.CANCEL });
						put(DIALOG_DELETE_WARNING,new ViewActions[]{ ViewActions.DELETE,
																		ViewActions.CANCEL });
						put(DIALOG_WFOPT_WARNING,new ViewActions[]{ ViewActions.OPTIMIZE_WF,
																		ViewActions.CANCEL });
					}}
			);

}
