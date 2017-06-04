package Logging;

import java.util.MissingResourceException;

/**
 * Created by phlippe on 24.05.17.
 */
public class TraceLogger
	extends java.util.logging.Logger
	implements Logging.Logger
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
	 *
	 * @throws MissingResourceException if the resourceBundleName is non-null and
	 *                                  no corresponding resource can be found.
	 */
	protected TraceLogger(String name, String resourceBundleName)
	{
		super(name, resourceBundleName);
	}

	@Override
	public void warning(String msg)
	{
		StackTraceElement[] activeFunctionTree = Thread.currentThread().getStackTrace();
		String preembel = "\n";

		for(int i=activeFunctionTree.length-1;i>=2;i--)
		{
			for(int charIndex=1;charIndex<i;charIndex++)
			{
				preembel += "+ ";
			}
			preembel += activeFunctionTree[i];
			if(i>1)
			{
				preembel += "\n";
			}
		}

		msg = preembel+"\n"+msg+"\n";

		super.warning(msg);
	}

	public void warning(String msg, Exception thrownException)
	{
		String exceptionMessage = thrownException.getClass().getName();

		String warnMessage = msg+"\nException: "+exceptionMessage;

		this.warning(warnMessage);
	}
}
