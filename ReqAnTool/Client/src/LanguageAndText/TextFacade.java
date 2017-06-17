package LanguageAndText;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.ErrorCodes;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class is a realisation of {@link ITextFacade} and handles the different property files with objects of
 * {@link TextResourceBundle}. In these the file is loaded and accessed for finding the property names. The methods
 * like {@link TextFacade#getButtonText(String)} are just passing the request to the responsible textBundles.
 *
 * @author 9045534
 * @version 1.0
 * @see ITextFacade
 * @see TextResourceBundle
 */
public class TextFacade
	implements ITextFacade
{

	private static final String BASE_NAME = "ReqAn";				//Base name of all property files
	private static final String PATH_TO_RESOURCES = "resources";	//Path to folder with property files
	private static final String DEFAULT_LANGUAGE = "de";
	private static final String DEFAULT_COUNTRY = "DE";

	private static TextFacade singletonTextFacade;

	/**
	 * For each property file an own {@link TextResourceBundle} is created.
	 */
	private TextResourceBundle buttonTextBundle;
	private TextResourceBundle dialogTextBundle;
	private TextResourceBundle parameterTextBundle;
	private TextResourceBundle titleTextBundle;
	private Locale currentLocalisation;

	/**
	 * Private constructor loading property files in textBundles.
	 */
	private TextFacade()
	{
		File file = new File(PATH_TO_RESOURCES);
		URL[] urls = null;
		try
		{
			urls = new URL[]{file.toURI().toURL()};
		}
		catch(Exception ex)
		{
			ex.printStackTrace();	// No logger exists => Where to put exception?
		}
		ClassLoader loader = new URLClassLoader(urls);
		currentLocalisation = new Locale(DEFAULT_LANGUAGE,DEFAULT_COUNTRY);
		buttonTextBundle = new TextResourceBundle(BASE_NAME+"_button_converted", currentLocalisation,loader);
		dialogTextBundle = new TextResourceBundle(BASE_NAME+"_dialog_converted", currentLocalisation,loader);
		parameterTextBundle = new TextResourceBundle(BASE_NAME+"_parameter_converted", currentLocalisation,loader);
		titleTextBundle = new TextResourceBundle(BASE_NAME+"_title_converted", currentLocalisation,loader);
	}

	/**
	 * Singleton-method to get the only instance of this class. If no one exists a new object is created and returned.
	 * @return Singleton instance of this class
	 */
	public static TextFacade getInstance()
	{
		if(singletonTextFacade == null)
		{
			singletonTextFacade = new TextFacade();
		}
		return singletonTextFacade;
	}

	/**
	 * This method is used to set a new localisation (language and country). In the first part it will be tested
	 * if every textBundle supports a property file with the given localisation. If just one of them does not, the
	 * localisation will be not set and the return value is false. Otherwise the localisation of all textBundles will
	 * be updated to the new one.
	 *
	 * @param newLocalisation localisation, to which it should be set.
	 * @return	If the localisation could be set to the new one (given in parameter newLocalisation), this method returns true.
	 * Otherwise the return value is false. A possible reason for this are missing files or wrong localisation.
	 */
	public boolean setLocalisation(Locale newLocalisation)
	{
		//To set the new localisation for all textBundles the localisation has to be tested
		boolean isLocalisationPossible = true;
		isLocalisationPossible = isLocalisationPossible && buttonTextBundle.isLocalisationPossible(newLocalisation);
		isLocalisationPossible = isLocalisationPossible && dialogTextBundle.isLocalisationPossible(newLocalisation);
		isLocalisationPossible = isLocalisationPossible && parameterTextBundle.isLocalisationPossible(newLocalisation);
		isLocalisationPossible = isLocalisationPossible && titleTextBundle.isLocalisationPossible(newLocalisation);

		//Only if all textBundles have a fitting propery file, the new localisation will be set.
		if(isLocalisationPossible)
		{
			buttonTextBundle.setLocalisation(newLocalisation);
			dialogTextBundle.setLocalisation(newLocalisation);
			parameterTextBundle.setLocalisation(newLocalisation);
			titleTextBundle.setLocalisation(newLocalisation);
			currentLocalisation = newLocalisation;
		}

		return isLocalisationPossible;
	}

	/**
	 * This method is similar to {@link TextFacade#setLocalisation(Locale newLocalisation)}, but takes as parameters
	 * the language and country as string. These are converted to a {@link Locale}-object and calls
	 * {@link TextFacade#setLocalisation(Locale newLocalisation)} taking this object as input.
	 * @param language 	The new language to which it should be set.
	 * @param country	The new country to which it should be set.
	 * @return If the localisation is successfully set, this return value is true. Otherwise it´s false.
	 * @see TextFacade#setLocalisation(Locale newLocalisation)
	 */
	public boolean setLocalisation(String language, String country)
	{
		return setLocalisation(new Locale(language,country));
	}

	/**
	 * Returns the text defined for the parameter buttonName in the button-properties file.
	 * @param buttonName Property name for which the value is returned.
	 * @return String saved in the property file for the given name
	 * @see TextNameConstants
	 */
	public String getButtonText(String buttonName)
	{
		return buttonTextBundle.getString(buttonName);
	}

	/**
	 * This method is similar to {@link TextFacade#getButtonText(String)}, but converts the given {@link ViewActions}
	 * to a string. This string serves as the parameter looking for in the button-properties file. Usually used for
	 * buttons which take standard names for their action.
	 * @param action Action for which the property should be return
	 * @return String saved in the property file for the given action
	 * @see TextFacade#getButtonText(String)
	 * @see Controller_Interfaces.ViewActions
	 */
	public String getButtonText(ViewActions action)
	{
		return getButtonText(action.toString());
	}

	/**
	 * Returns the text defined for the parameter dialogName in the dialog-properties file. Used for the description
	 * messages in Dialogs like {@link View_Interfaces.IErrorDialog} and {@link View_Interfaces.IWarningDialog}.
	 * @param dialogName Property name for which the value is returned
	 * @return String saved in the property file for the given name
	 * @see TextNameConstants
	 * @see View_Interfaces.IErrorDialog
	 * @see View_Interfaces.IWarningDialog
	 */
	public String getDialogText(String dialogName)
	{
		return dialogTextBundle.getString(dialogName);
	}

	/**
	 * In addition to {@link ITextFacade#getDialogText(String)} the returned string is examined for placeholders
	 * like <code>{PLACEHOLDER0}</code> and replaces them with the given ones in placeholderReplacer. The number
	 * behind the placeholder-tag defines the index in the array.
	 *
	 * @param dialogName          Property name for which the value is returned
	 * @param placeholderReplacer Array of strings with which the placeholder should be replaced. The index specifies
	 *                            the concrete placeholder <code>{PLACEHOLDER<b><i>INDEX</i></b>}</code>.
	 *
	 * @return String saved in the property file for the given name with replaced placeholders
	 *
	 * @see ITextFacade#getDialogText(String)
	 */
	@Override
	public String getDialogText(String dialogName, String[] placeholderReplacer)
	{
		String dialogText = null;
		if(placeholderReplacer == null || placeholderReplacer.length == 0)
		{
			dialogText = getDialogText(dialogName);
		}
		else
		{
			String textWithPlaceholder = dialogTextBundle.getString(dialogName);
			for(int placeholderIndex=0;placeholderIndex<placeholderReplacer.length;placeholderIndex++)
			{
				textWithPlaceholder = textWithPlaceholder.replaceAll(
						"\\{PLACEHOLDER"+placeholderIndex+"}",
						placeholderReplacer[placeholderIndex]
				);
			}
			dialogText = textWithPlaceholder;
		}
		return dialogText;
	}

	/**
	 * Returns the text defined for the parameter parameterName in the parameter-properties file.
	 * Used for the description of text fields in formula views like {@link View_Interfaces.IFRequirementEditView}.
	 * @param parameterName Property name for which the value is returned
	 * @return String saved in the property file for the given name
	 * @see TextNameConstants
	 */
	public String getParameterText(String parameterName)
	{
		return parameterTextBundle.getString(parameterName);
	}

	/**
	 * Returns the text defined for the parameter titleName in the title-properties file. Used for the titles in
	 * all kind of {@link View_Interfaces.IView}.
	 * @param titleName Property name for which the value is returned
	 * @return String saved in the property file for the given name
	 * @see TextNameConstants
	 */
	public String getTitleText(String titleName)
	{
		return titleTextBundle.getString(titleName);
	}

}
