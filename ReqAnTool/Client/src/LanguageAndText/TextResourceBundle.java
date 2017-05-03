package LanguageAndText;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by phlippe on 02.05.17.
 */
public class TextResourceBundle
{

	private String baseName;
	private Locale currentLocalisation;
	private ClassLoader myLoader;
	private ResourceBundle myResourceBundle;

	public TextResourceBundle(String baseName, Locale localisation, ClassLoader loader)
	{
		this.baseName = baseName;
		this.myLoader = loader;
		setLocalisation(localisation);
	}

	public String getString(String name)
	{
		String ret = null;
		try
		{
			ret = myResourceBundle.getString(name);
		}
		catch (MissingResourceException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
		catch(NullPointerException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
		return ret;
	}

	public boolean setLocalisation(Locale localisation)
	{
		boolean fileExists = false;
		try
		{
			myResourceBundle = ResourceBundle.getBundle(baseName,localisation,myLoader);
			currentLocalisation = localisation;
			fileExists = true;
		}
		catch(MissingResourceException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
		catch(NullPointerException ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
		return fileExists;
	}

}
