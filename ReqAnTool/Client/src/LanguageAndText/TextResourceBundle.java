package LanguageAndText;

import Logging.LogSystem;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by phlippe on 02.05.17.
 */
public class TextResourceBundle
{

	private String baseName;
	private ClassLoader myLoader;
	private ResourceBundle myResourceBundle;

	public TextResourceBundle(String baseName, Locale localisation, ClassLoader loader)
	{
		this.baseName = baseName;
		this.myLoader = loader;
		setLocalisation(localisation);
	}

	public String getString(String propertyName)
	{
		String ret = "";
		try
		{
			ret = myResourceBundle.getString(propertyName);
		}
		catch (MissingResourceException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
			LogSystem.getLogger().warning("Could not find Resource for "+propertyName);
		}
		catch(NullPointerException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
			LogSystem.getLogger().warning("Could not find property for "+propertyName);
		}
		return ret;
	}

	public boolean isLocalisationPossible(Locale localisation)
	{
		boolean fileExists;

		try
		{
			ResourceBundle.getBundle(baseName,localisation,myLoader);
			fileExists = true;
		}
		catch(MissingResourceException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
			fileExists = false;
		}
		catch(NullPointerException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
			fileExists = false;
		}

		return fileExists;
	}

	public boolean setLocalisation(Locale localisation)
	{
		boolean fileExists;

		try
		{
			myResourceBundle = ResourceBundle.getBundle(baseName,localisation,myLoader);
			fileExists = true;
		}
		catch(MissingResourceException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
			fileExists = false;
		}
		catch(NullPointerException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
			fileExists = false;
		}

		return fileExists;
	}

}
