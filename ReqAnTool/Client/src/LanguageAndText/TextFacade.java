package LanguageAndText;

import Controller_Interfaces.ViewActions;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by phlippe on 02.05.17.
 */
public class TextFacade
	implements ITextFacade
{

	private static final String BASE_NAME = "ReqAn";
	private static final String PATH_TO_RESOURCES = "resources";

	private static TextFacade singletonTextFacade;

	private TextResourceBundle buttonTextBundle;
	private TextResourceBundle dialogTextBundle;	//Dialog-Nachrichten (Warnungen, Fehler...)
	private TextResourceBundle parameterTextBundle;	//Namen der Parameter von Objekten
	private TextResourceBundle titleTextBundle;		//Titel von Views
	private Locale currentLocalisation;

	private TextFacade()
	{
		File file = new File(PATH_TO_RESOURCES);
		System.out.println(file.getAbsoluteFile().toString());
		URL[] urls = null;
		try
		{
			urls = new URL[]{file.toURI().toURL()};
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		ClassLoader loader = new URLClassLoader(urls);
		currentLocalisation = new Locale("de","DE");
		buttonTextBundle = new TextResourceBundle(BASE_NAME+"_button_converted", currentLocalisation,loader);
		dialogTextBundle = new TextResourceBundle(BASE_NAME+"_dialog_converted", currentLocalisation,loader);
		parameterTextBundle = new TextResourceBundle(BASE_NAME+"_parameter_converted", currentLocalisation,loader);
		titleTextBundle = new TextResourceBundle(BASE_NAME+"_title_converted", currentLocalisation,loader);
	}

	public static TextFacade getInstance()
	{
		if(singletonTextFacade == null)
		{
			singletonTextFacade = new TextFacade();
		}
		return singletonTextFacade;
	}

	public boolean setLocalisation(Locale newLocalisation)
	{
		//Es muss überprüft werden, ob es bei allen TextBundles die Lokalisationssetzung funktioniert
		boolean isLocalisationPossible = true;
		isLocalisationPossible = isLocalisationPossible && buttonTextBundle.isLocalisationPossible(newLocalisation);
		isLocalisationPossible = isLocalisationPossible && dialogTextBundle.isLocalisationPossible(newLocalisation);
		isLocalisationPossible = isLocalisationPossible && parameterTextBundle.isLocalisationPossible(newLocalisation);
		isLocalisationPossible = isLocalisationPossible && titleTextBundle.isLocalisationPossible(newLocalisation);

		if(isLocalisationPossible)	//Falls bei einem es nicht funktioniert hat => zurücksetzen
		{
			buttonTextBundle.setLocalisation(currentLocalisation);
			dialogTextBundle.setLocalisation(currentLocalisation);
			parameterTextBundle.setLocalisation(currentLocalisation);
			titleTextBundle.setLocalisation(currentLocalisation);
		}
		else
		{
			currentLocalisation = newLocalisation;
		}

		return isLocalisationPossible;
	}

	public boolean setLocalisation(String language, String country)
	{
		return setLocalisation(new Locale(language,country));
	}

	public String getButtonText(String buttonName)
	{
		return buttonTextBundle.getString(buttonName);
	}

	public String getButtonText(ViewActions action)
	{
		return getButtonText(action.toString());
	}

	public String getDialogText(String dialogName)
	{
		return dialogTextBundle.getString(dialogName);
	}

	public String getParameterText(String parameterName)
	{
		return parameterTextBundle.getString(parameterName);
	}

	public String getTitleText(String titleName)
	{
		return titleTextBundle.getString(titleName);
	}

}
