package LanguageAndText;

import Controller_Interfaces.ViewActions;

import java.util.Locale;

/**
 *
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
	 * {@link ITextFacade#setLocalisation(Locale newLocalisation)} with this object as input.
	 * @param language 	The new language, to which it should be set.
	 * @param country	The new country, to which it should be set.
	 * @return If the localisation is successfully set, this return value is true. Otherwise it´s false.
	 * @see ITextFacade#setLocalisation(Locale newLocalisation)
	 */
	public boolean setLocalisation(String language, String country);

	/**
	 * Returns the text, which is defined under the parameter buttonName in the button-properties file.
	 * @param buttonName Property-name, for which the value is returned. Possible
	 * @return
	 * @see TextNameConstants
	 */
	public String getButtonText(String buttonName);

	/**
	 *
	 * @param action
	 * @return
	 * @see TextNameConstants , ViewActions
	 */
	public String getButtonText(ViewActions action);

	/**
	 *
	 * @param dialogName
	 * @return
	 * @see TextNameConstants
	 */
	public String getDialogText(String dialogName);

	/**
	 *
	 * @param parameterName
	 * @return
	 * @see TextNameConstants
	 */
	public String getParameterText(String parameterName);

	/**
	 * Returns the
	 * @param titleName
	 * @return
	 * @see TextNameConstants
	 */
	public String getTitleText(String titleName);

}
