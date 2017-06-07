package Logging;

/**
 * This interface represents an abstract factory for creating and managing {@link ILogger} in a system. It features
 * a public interface over which a client from other packages can interact and create logger (type {@link ILogger}).
 * <p>
 * If a client want to use a default logger, its code could look like this:<br>
 *     <p>
 *     <code>
 *         ILoggerFactory myLoggerFactory = ILoggerFactory.getInstance(); //get factory (most time singleton)<br>
 *         ILogger myLogger = myLoggerFactory.createLogger(); //create default logger <br>
 *         myLogger.info("This logger was created by an ILoggerFactory"); //example info message  <br>
 *     </code>
 *     </p>
 * </p>
 * Which concrete factory is returned, is defined in {@link ILoggerFactory#getInstance()}. The selection is static,
 * but could be extended with parameters for decision making in future.
 * <p>
 *     For creating a logger, an {@link ILoggerFactory} provides three different methods:
 *     <ul>
 *         <li><b>{@link ILoggerFactory#createLogger()}</b> - creating a default logger with a default name. </li>
 *         <li><b>{@link ILoggerFactory#createLogger(int)}</b> - creating a logger based on priority. This feature
 *         could be implemented with for example generating a different logger name or customizing
 *         the logger entries. </li>
 *         <li><b>{@link ILoggerFactory#createLogger(String)}</b> - creating a logger with the given name.</li>
 *     </ul>
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see ILogger
 */
public interface ILoggerFactory
{

	/**
	 * With this method a client can get access to an ILoggerFactory. The specification which factory will be returned
	 * is determined in this code section. As till now only the {@link TraceLoggerFactory} is supported, this one is
	 * returned.
	 * <p>
	 *     It is recommended to use a singleton method in the concrete factories.
	 * </p>
	 * @return An ILoggerFactory with which the client can create logger for itself.
	 */
	public static ILoggerFactory getInstance()
	{
		return TraceLoggerFactory.getInstance();
	}

	/**
	 * Returns a logger with the default name.
	 * @return Logger with default name
	 */
	public ILogger createLogger();

	/**
	 * Returns a logger specified by a priority level.
	 * @param priority Importance of logging entries
	 * @return Logger fitting to given priority
	 */
	public ILogger createLogger(int priority);

	/**
	 * Returns a logger with given name
	 * @param loggerName Name of the new logger
	 * @return Logger with given name
	 */
	public ILogger createLogger(String loggerName);

}
