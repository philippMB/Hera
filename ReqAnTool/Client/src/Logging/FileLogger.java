package Logging;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This logger sets a basic structure for handling with logfiles. The loggers output will be written in a file,
 * named as the logger itself, and continual updated.
 * <p>
 *     For customizing the file design two methods are implemented which could be overwritten:
 *     <ul>
 *         <li>
 *             {@link FileLogger#createFormatter()} - defines the {@link Formatter}, which is used for the file.
 *         </li>
 *         <li>
 *             {@link FileLogger#writeStartMessage()} - writes an start message to mark the beginning of new logging
 *             session.
 *         </li>
 *     </ul>
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see java.util.logging.Logger
 * @see java.util.logging.Formatter
 * @see java.util.logging.FileHandler
 */
public abstract class FileLogger
	extends Logger
	implements ILogger
{

	/**
	 * Protected method to construct a logger for a named subsystem.
	 * <p>
	 * The logger will be initially configured with a null Level
	 * and with useParentHandlers set to true.
	 *
	 * @param name               A name for the logger.  This should
	 *                           be a dot-separated name and should normally
	 *                           be based on the package name or class name
	 *                           of the subsystem, such as java.net
	 *                           or javax.swing.  It may be null for anonymous Loggers.
	 * @param resourceBundleName name of ResourceBundle to be used for localizing
	 *                           messages for this logger.  May be null if none
	 *                           of the messages require localization.
	 * @param appendOldFile      Defines if an old logfile should be continued or overwritten.
	 *
	 * @throws MissingResourceException if the resourceBundleName is non-null and
	 *                                  no corresponding resource can be found.
	 */
	protected FileLogger(String name, String resourceBundleName, boolean appendOldFile)
	{
		super(name, resourceBundleName);
		buildFileHandler(name, appendOldFile);
		writeStartMessage();
	}

	/**
	 * Creates the file handler with a formatter provided by {@link FileLogger#createFormatter()} for this logger.
	 * @param filename Name of the logfile without the extension ".log"
	 * @param append   Defines if an old logfile should be continued or overwritten.
	 */
	private void buildFileHandler(String filename, boolean append)
	{
		FileHandler fh;
		try
		{
			// This block configure the loggers handler and formatter
			fh = new FileHandler(filename + ".log", append);
			addHandler(fh);
			fh.setFormatter( createFormatter() );
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the formatter for the logfile. Could be overwritten by child-classes, if a different formatter should
	 * be used.
	 * @return Formatter for logfile
	 */
	protected Formatter createFormatter()
	{
		SimpleFormatter formatter = new SimpleFormatter();
		return formatter;
	}

	/**
	 * Writes an start message to mark the beginning of the logging (especially while appending the file).
	 */
	protected void writeStartMessage()
	{
		info("********** Logger started **********");
	}


}
