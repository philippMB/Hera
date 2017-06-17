package Logging;

import java.util.ArrayList;
import java.util.logging.FileHandler;

/**
 * This factory class provides an exclusively single object that manages all {@link ILogger}
 * (based on {@link TraceLogger}) in the project. This for it checks the constraint that the name of the
 * consisting loggers are exclusively and unique.
 * <p>
 * When a class or object wants to use a logger, it can get one with calling one of the three possible methods
 * <code>createLogger</code>, while each of them is generating a name for the logger. If a logger with the
 * same name already exists, it returns this one. Otherwise a new one is build up. Until now only
 * {@link TraceLogger} are supported.
 * </p>
 * <p>
 * For each logger the TraceLoggerFactory sets up a {@link FileHandler}, which automatically writes the logs into a logfile
 * and updating it while execution. If the program stops and starts later again, a logger with the same name
 * will append to the same file from the earlier logger.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see ILogger
 * @see ILoggerFactory
 * @see TraceLogger
 */
public class TraceLoggerFactory
		implements ILoggerFactory
{

	private static final String DEFAULT_LOGGER_NAME = "ReqAnLog";

	private static TraceLoggerFactory singletonTraceLoggerFactory;

	private ArrayList<ILogger> allLogger;


	/**
	 * Singleton-method, to get the only instance of the class.
	 * @return Instance of class
	 */
	public static TraceLoggerFactory getInstance()
	{
		if (singletonTraceLoggerFactory == null)
		{
			singletonTraceLoggerFactory = new TraceLoggerFactory();
		}
		return singletonTraceLoggerFactory;
	}

	/**
	 * Private constructor (Singleton-method)
	 * @see TraceLoggerFactory#getInstance()
	 */
	private TraceLoggerFactory()
	{
		allLogger = new ArrayList<>();
	}

	/**
	 * Returns a logger with the default name. If he does not already exist,
	 * a new one of type {@link TraceLogger} is created.
	 * @return Logger with default name
	 * @see TraceLoggerFactory#buildTraceLogger(String)
	 * @see TraceLoggerFactory#createLogger(String)
	 */
	@Override
	public ILogger createLogger()
	{
		return createLogger(DEFAULT_LOGGER_NAME);
	}

	/**
	 * Returns a logger with the default name appended with "_Prio_<i>Number</i>".
	 * If he does not already exist, a new one of type {@link TraceLogger} is created.
	 * @param priority Priority-number, which is added to the name
	 * @return Logger with given name
	 * @see TraceLoggerFactory#buildTraceLogger(String)
	 * @see TraceLoggerFactory#createLogger(String)
	 */
	@Override
	public ILogger createLogger(int priority)
	{
		String loggerName = DEFAULT_LOGGER_NAME + "_Prio_" + priority;
		return createLogger(loggerName);
	}

	/**
	 * Returns a logger with given name. If he does not already exist, a new one of type {@link TraceLogger} is created.
	 * @param loggerName Name of the logger, which should be returned
	 * @return Logger with the given name
	 * @see TraceLoggerFactory#buildTraceLogger(String)
	 */
	@Override
	public ILogger createLogger(String loggerName)
	{
		ILogger newLogger = getLoggerByName(loggerName);
		if (newLogger == null)
		{
			newLogger = buildTraceLogger(loggerName);
			allLogger.add(newLogger);
		}
		return newLogger;
	}

	/**
	 * If a logger with the given name already exists, it is returned. Otherwise the returned value is null.
	 * Only used for inner purpose.
	 * @param loggerName Name of the logger, which should be returned
	 * @return The logger with the given name. If he does not exist, null is returned.
	 */
	private ILogger getLoggerByName(String loggerName)
	{
		ILogger loggerByName = null;

		for (ILogger l : allLogger)
		{
			if (l.getName().equals(loggerName))
			{
				loggerByName = l;
			}
		}

		return loggerByName;
	}

	/**
	 * Builds up a {@link TraceLogger} with the given name. Next to it a {@link FileHandler} will set up to
	 * control the log-file.
	 * @param loggerName Name of the logger, which should be build up
	 * @return Build-up logger
	 * @see TraceLogger
	 */
	private TraceLogger buildTraceLogger(String loggerName)
	{
		TraceLogger newLogger = new TraceLogger(loggerName, null);
		return newLogger;
	}

}
