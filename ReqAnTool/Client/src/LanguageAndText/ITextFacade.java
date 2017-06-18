package LanguageAndText;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.ErrorCodes;

import java.util.Locale;

/**
 * This interface represents a facade of the LanguageAndText package for accessing the property values.
 * <p>
 * TODO: further comments
 *
 * @author 9045534
 * @version 1.0
 * @see Logging.ILogger
 */
public interface ITextFacade
{

	/**
	 * Returns a Text-Facade-Object, which implements this interface.
	 * The pattern SINGLETON is used, so that only one TextFacade exists and the text is loaded once.
	 * @return	Instance of a TextFacade (singleton)
	 */
	public static ITextFacade getInstance(){
		return TextFacade.getInstance();
	}

	/**
	 * This method is used to set a new localisation (language and country).
	 * If the localisation could be set to the new one (given in parameter newLocalisation), this method returns true.
	 * Otherwise the return value is false. A possible reason for this are missing files or wrong localisation.
	 * @param newLocalisation localisation, to which it should be set.
	 * @return	If the localisation is successfully set, this return value is true. Otherwise it´s false.
	 */
	public boolean setLocalisation(Locale newLocalisation);

	/**
	 * This method is similar to {@link ITextFacade#setLocalisation(Locale newLocalisation)}, but takes as parameters
	 * the language and country as string. These are converted to a {@link Locale}-object and calls
	 * {@link ITextFacade#setLocalisation(Locale newLocalisation)} taking this object as input.
	 * @param language 	The new language to which it should be set.
	 * @param country	The new country to which it should be set.
	 * @return If the localisation is successfully set, this return value is true. Otherwise it´s false.
	 * @see ITextFacade#setLocalisation(Locale newLocalisation)
	 */
	public boolean setLocalisation(String language, String country);

	/**
	 * Returns the text defined for the parameter buttonName in the button-properties file.
	 * @param buttonName Property name for which the value is returned.
	 * @return String saved in the property file for the given name
	 * @see TextNameConstants
	 */
	public String getButtonText(String buttonName);

	/**
	 * This method is similar to {@link ITextFacade#getButtonText(String)}, but converts the given {@link ViewActions}
	 * to a string. This string serves as the parameter looking for in the button-properties file. Usually used for
	 * buttons which take standard names for their action.
	 * @param action Action for which the property should be return
	 * @return String saved in the property file for the given action
	 * @see ITextFacade#getButtonText(String)
	 * @see Controller_Interfaces.ViewActions
	 */
	public String getButtonText(ViewActions action);

	/**
	 * Returns the text defined for the parameter dialogName in the dialog-properties file. Used for the description
	 * messages in Dialogs like {@link View_Interfaces.IErrorDialog} and {@link View_Interfaces.IWarningDialog}.
	 * @param dialogName Property name for which the value is returned
	 * @return String saved in the property file for the given name
	 * @see TextNameConstants
	 * @see View_Interfaces.IErrorDialog
	 * @see View_Interfaces.IWarningDialog
	 */
	public String getDialogText(String dialogName);

	/**
	 * In addition to {@link ITextFacade#getDialogText(String)} the returned string is examined for placeholders
	 * like <code>{PLACEHOLDER0}</code> and replaces them with the given ones in placeholderReplacer. The number
	 * behind the placeholder-tag defines the index in the array.
	 * @param dialogName Property name for which the value is returned
	 * @param placeholderReplacer Array of strings with which the placeholder should be replaced. The index specifies
	 *                            the concrete placeholder <code>{PLACEHOLDER<b><i>INDEX</i></b>}</code>.
	 * @return String saved in the property file for the given name with replaced placeholders
	 * @see ITextFacade#getDialogText(String)
	 */
	public String getDialogText(String dialogName, String[] placeholderReplacer);

	/**
	 * Returns the text defined for the parameter parameterName in the parameter-properties file.
	 * Used for the description of text fields in formula views like {@link View_Interfaces.IFRequirementEditView}.
	 * @param parameterName Property name for which the value is returned
	 * @return String saved in the property file for the given name
	 * @see TextNameConstants
	 */
	public String getParameterText(String parameterName);

	/**
	 * Returns the text defined for the parameter titleName in the title-properties file. Used for the titles in
	 * all kind of {@link View_Interfaces.IView}.
	 * @param titleName Property name for which the value is returned
	 * @return String saved in the property file for the given name
	 * @see TextNameConstants
	 */
	public String getTitleText(String titleName);

}
