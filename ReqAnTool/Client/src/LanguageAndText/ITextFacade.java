package LanguageAndText;

import Controller_Interfaces.ViewActions;

import java.util.Locale;

/**
 * Created by phlippe on 02.05.17.
 */
public interface ITextFacade
{

	public static ITextFacade getInstance(){
		return TextFacade.getInstance();
	}

	public boolean setLocalisation(Locale newLocalisation);

	public boolean setLocalisation(String language, String country);

	public String getButtonText(String buttonName);

	public String getButtonText(ViewActions action);

	public String getDialogText(String dialogName);

	public String getParameterText(String parameterName);

	public String getTitleText(String titleName);

}
