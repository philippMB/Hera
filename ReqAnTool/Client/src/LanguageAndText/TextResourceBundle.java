package LanguageAndText;

import Logging.ILogger;
import Logging.ILoggerFactory;
import Logging.TraceLoggerFactory;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * To deal in an efficient way with a property file objects of this method necessary actions and bundle the access
 * to them in this class. For this a function for getting a property value ({@link TextResourceBundle#getString(String)})
 * and testing ({@link TextResourceBundle#isLocalisationPossible(Locale)}) and setting
 * {@link TextResourceBundle#setLocalisation(Locale)}) a new localisation is provided.
 * For logging like {@link MissingResourceException} the {@link ILoggerFactory} is used.
 *
 * @author 9045534
 * @version 1.0
 * @see TextFacade
 * @see ResourceBundle
 */
public class TextResourceBundle
{

	private String baseName;
	private ClassLoader myLoader;
	private ResourceBundle myResourceBundle;
	private ILogger myLogger;

	/**
	 * Public constructor setting up and loading the property file.
	 * @param baseName Base name of the property file
	 * @param localisation Localisation which should be loaded for the property file
	 * @param loader Loader for the property file (see {@link ResourceBundle#getBundle(String, Locale, ClassLoader)}
	 */
	public TextResourceBundle(String baseName, Locale localisation, ClassLoader loader)
	{
		this.baseName = baseName;
		myLoader = loader;
		myLogger = ILoggerFactory.getInstance().createLogger();
		setLocalisation(localisation);
	}

	/**
	 * Returns the value of the property given by propertyName. If no property file is loaded or the property name
	 * not exists in this file the empty string <code>""</code> is returned.
	 * @param propertyName Property for which the value should be returned
	 * @return Value of property in file. By default or exception <code>""</code> is returned.
	 */
	public String getString(String propertyName)
	{
		String ret = "";
		try
		{
			ret = myResourceBundle.getString(propertyName);
		}
		catch (MissingResourceException ex)
		{
			myLogger.warning("Could not find Resource for "+propertyName, ex);
		}
		catch(NullPointerException ex)
		{
			myLogger.warning("Could not find property for "+propertyName, ex);
		}
		return ret;
	}

	/**
	 * Tests if the given localisation of the property file is existing.
	 * @param localisation Localisation to test
	 * @return If the property file could be loaded successfully this return value is <code>true</code>.
	 * Otherwise <code>false</code> is returned and the exception is logged in an {@link ILogger}.
	 * @see TextResourceBundle#setLocalisation(Locale)
	 * @see ILogger
	 */
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
			myLogger.warning("Localisation is not possible",ex);
			fileExists = false;
		}
		catch(NullPointerException ex)
		{
			myLogger.warning("Localisation is not possible",ex);
			fileExists = false;
		}

		return fileExists;
	}

	/**
	 * Sets the localisation of the property file to given {@link Locale} object.
	 * @param localisation New localisation set to
	 * @return If the property file could be loaded successfully this return value is <code>true</code>.
	 * Otherwise <code>false</code> is returned and the exception is logged in an {@link ILogger}. Don´t use
	 * this method for just testing because the last property file might be not readable anymore. So in this purpose
	 * use {@link TextResourceBundle#isLocalisationPossible(Locale)} instead.
	 * @see TextResourceBundle#isLocalisationPossible(Locale)
	 * @see ILogger
	 */
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
			myLogger.warning("Localisation could not be set",ex);
			fileExists = false;
		}
		catch(NullPointerException ex)
		{
			myLogger.warning("Localisation could not be set",ex);
			fileExists = false;
		}

		return fileExists;
	}

}
