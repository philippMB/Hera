package Logging;

import com.sun.istack.internal.Nullable;

/**
 * A Logger object is used to log messages for a specific system or application component.
 * To organize all log messages a logger provides methods for creating log messages and handles the organization intern.
 * The structure of a entry in the log file is delegated to the class implementing this interface. All Logger, an
 * {@link ILoggerFactory} provides, are based on this Interface.
 *
 * <p>
 *     A logger is identified by his name. Therefore the name for a logger should be unique in a project.
 *     A similar approach is used in {@link java.util.logging.Logger}.
 * </p>
 * <p>
 *     To give the log-file a structure, the listed messages are divided in three levels:
 *     <i>Info</i>, <i>Warning</i> and <i>Error</i>.
 *     <ul>
 *         <li><b>Info</b> - An information, which could be helpful for debugging. Even many messages could be useful
 *         for debugging use it rarely.
 *         <li><b>Warning</b> - A message to give notice that something unexpected has happened.
 *         <li><b>Error</b> - An error, which occurred while executing. Necessary for debugging.
 *     </ul>
 *	   Every logger provides methods for each of this message-levels.
 *
 *
 * @author 9045534
 * @version 1.0
 * @see ILoggerFactory
 * @see java.util.logging.Logger
 */
public interface ILogger
{

	/**
	 * Returns the loggers name.
	 * @return name of the logger
	 */
	public String getName();

	/**
	 * Writes a message on the level INFO in the log file. It should be used for any message which could be helpful
	 * for debugging.
	 * @param msg Description/Message of the information
	 */
	public void info(String msg);

	/**
	 * Writes a message on the level WARNING in the log file. It should be used for unexpected events.
	 * @param msg Description/Message of the warning
	 * @see ILogger#warning(String, Exception)
	 */
	public void warning(String msg);

	/**
	 * Writes a message on the level WARNING in the log file. It should be used for unexpected events.
	 * @param msg Description/Message of the warning
	 * @param thrownException Exception, which was thrown. If no exception was thrown,
	 *                        use {@link ILogger#warning(String)} instead.
	 * @see ILogger#warning(String)
	 */
	public void warning(String msg,@Nullable Exception thrownException);

	/**
	 * Writes a message on the level ERROR in the log file. It should be used for any error in the project.
	 * @param msg Description/Message of the error
	 * @see ILogger#error(String, Exception)
	 */
	public void error(String msg);

	/**
	 * Writes a message on the level ERROR in the log file. It should be used for any error in the project.
	 * @param msg Description/Message of the error
	 * @param thrownException Exception, which was thrown. If no exception was thrown,
	 *                        use {@link ILogger#error(String)} instead.
	 * @see ILogger#error(String)
	 */
	public void error(String msg,@Nullable Exception thrownException);

}
