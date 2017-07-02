package Exceptions;

import Controller.LoadingController;
import Logging.ILogger;
import Logging.ILoggerFactory;

/**
 * Base class for all exception in this package.
 * <p>
 *     This class is a subclass of {@link Exception} and extends it with the functionality of being logged by
 *     initialization. Especially for big projects a good log file is very important. To find the core of a problem all
 *     exceptions carry a {@link StackTraceElement} array where the complete function tree of the creation of itself
 *     is traced. A logger will take this and write it to an own logfile for all exceptions in the project.
 * </p>
 * @author 9045534
 * @version 1.0
 * @see Exception
 */
public class LoggedException
	extends Exception
{

	/**
	 * Name of the logger and its logfile in which all messages will be written.
	 */
	public static final String LOG_FILE_NAME = "ReqAn_exceptions";


	/**
	 * Standard constructor for initializing a logged exception. This automatically creates a log entry in the standard
	 * log file {@link LoggedException#LOG_FILE_NAME}.
	 * @param exceptionMessage Message/Description of exception (see {@link Exception#getMessage()})
	 */
	public LoggedException(String exceptionMessage)
	{
		super(exceptionMessage);
		logException(exceptionMessage);
	}

	/**
	 * Writes the exception in the standard log file.
	 * @param exceptionMessage Message/Description of exception that is also added to the log file
	 *                         (see {@link Exception#getMessage()})
	 */
	private void logException(String exceptionMessage)
	{
		ILogger myLogger = ILoggerFactory.getInstance().createLogger(LOG_FILE_NAME);
		myLogger.warning("Exception "+getClass().getName()+" is thrown: "+exceptionMessage, this);
	}

}
