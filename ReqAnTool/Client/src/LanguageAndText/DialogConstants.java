package LanguageAndText;

import Controller_Interfaces.ViewActions;

/**
 * Created by phlippe on 24.05.17.
 */
public abstract class DialogConstants
{

	public static final int DIALOG_TYPE_SAVE_WARNING = 0;

	public static final String DIALOG_SAVE_WARNING = "SAVE_WARNING";

	public static final ViewActions[] DIALOG_BUTTONS_SAVE_WARNING = new ViewActions[]{	ViewActions.SAVE,
																						ViewActions.SAVE_AS,
																						ViewActions.CANCEL };

}
