package Logging;

import java.util.MissingResourceException;

/**
 * A logger based on {@link FileLogger}. While printing info and warning in the same way as its superclass,
 * a preamble showing the calling functions is added. An error is written like an warning,
 * but it is marked with a <code>"=====...ERROR...======"</code>-tag in the beginning.
 *
 * @author 9045534
 * @version 1.0
 * @see java.util.logging.Logger
 * @see ILogger
 */
public class TraceLogger
	extends FileLogger
{

	private static final int MAX_TRACE_DEPTH = 8;	//Maximal depth of function tree which is printed

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
		super(name, resourceBundleName, true);
	}

	/**
	 * Writes an info like {@link java.util.logging.Logger}.
	 * @param msg Description/Message of the information
	 * @see java.util.logging.Logger
	 */
	@Override
	public void info(String msg)
	{
		super.info(msg);
	}

	/**
	 * Writes a warning like {@link java.util.logging.Logger} with the function tree
	 * from {@link TraceLogger#makeFunctionTreePreamble()} as preamble.
	 * @param msg Description/Message of the warning
	 * @see TraceLogger#makeFunctionTreePreamble()
	 * @see java.util.logging.Logger#warning(String)
	 */
	@Override
	public void warning(String msg)
	{
		String preamble = makeFunctionTreePreamble();
		msg = preamble+"\n"+msg+"\n";

		super.warning(msg);
	}

	/**
	 * Writes a warning like {@link java.util.logging.Logger} with the function tree
	 * from {@link TraceLogger#makeFunctionTreePreamble()} as preamble and a description
	 * of the exception from {@link TraceLogger#makeExceptionText(Exception)} as closing.
	 * @param msg Description/Message of the warning
	 * @param thrownException Exception, which was thrown. If no exception was thrown,
	 *                        use {@link TraceLogger#warning(String)} instead.
	 * @see TraceLogger#warning(String)
	 * @see java.util.logging.Logger#warning(String)
	 * @see TraceLogger#makeFunctionTreePreamble()
	 * @see TraceLogger#makeExceptionText(Exception)
	 */
	@Override
	public void warning(String msg, Exception thrownException)
	{
		String warnMessage = msg+"\n"+makeExceptionText(thrownException);

		this.warning(warnMessage);
	}

	/**
	 * Writes an error like {@link TraceLogger#warning(String)} but adds the error-mark
	 * from {@link TraceLogger#makeErrorPreamble()}.
	 * @param msg Description/Message of the error
	 * @see TraceLogger#warning(String)
	 * @see TraceLogger#makeErrorPreamble()
	 */
	@Override
	public void error(String msg)
	{
		String preambel = makeErrorPreamble() + makeFunctionTreePreamble();

		this.warning(preambel);
	}

	/**
	 * Writes an error like {@link TraceLogger#warning(String,Exception)} but adds the error-mark
	 * from {@link TraceLogger#makeErrorPreamble()}.
	 * @param msg Description/Message of the error
	 * @param thrownException Exception, which was thrown. If no exception was thrown,
	 *                        use {@link TraceLogger#error(String)} instead.
	 * @see TraceLogger#warning(String,Exception)
	 * @see TraceLogger#makeErrorPreamble()
	 */
	@Override
	public void error(String msg, Exception thrownException)
	{
		String errorMessage = msg+"\n"+makeExceptionText(thrownException);

		this.error(errorMessage);
	}

	/**
	 * Generates a description to a given exception.
	 * @param exceptionToText Exception which should be described
	 * @return Generated description of the exception
	 */
	private String makeExceptionText(Exception exceptionToText)
	{
		String exceptionMessage = exceptionToText.getClass().getName();
		return "Exception: "+exceptionMessage;
	}

	/**
	 * Generates a function tree, from which the warning/error was called. As a result it
	 * makes a string looking like this:
	 * <p>
	 *     + + + + function1<br>
	 *     + + + function2<br>
	 *     + + function3<br>
	 *     + function4<br>
	 * </p>
	 * <i>function1</i> is the highest function, which called <i>function2</i> and so on. With the help of this
	 * it is easier to detect the code part which caused this warning/error.
	 * @return Function tree as string
	 */
	private String makeFunctionTreePreamble()
	{
		final int DEPTH_OFFSET = 3;

		StackTraceElement[] activeFunctionTree = Thread.currentThread().getStackTrace();
		String preamble = "\n";

		int startDepth = activeFunctionTree.length-1;
		startDepth = Math.min(startDepth, MAX_TRACE_DEPTH+DEPTH_OFFSET);

		for(int i=startDepth;i>=DEPTH_OFFSET;i--)
		{
			preamble += duplicateString("+ ",i-DEPTH_OFFSET+1);
			preamble += activeFunctionTree[i];
			if(i>1)
			{
				preamble += "\n";
			}
		}

		return preamble;
	}

	/**
	 * Returns a preamble to mark an error. It looks like following:
	 * <p>
	 *     ==================================================
	 *     ==================================================
	 *     ======================ERROR=======================
	 *     ==================================================
	 *     ==================================================
	 * </p>
	 * @return The preamble as string
	 */
	private String makeErrorPreamble()
	{
		String preamble = duplicateString("=",50) + "\n" +
				duplicateString("=",50) + "\n" +
				duplicateString("=",22) + "ERROR" +
				duplicateString("=",23) + "\n" +
				duplicateString("=",50) + "\n" +
				duplicateString("=",50) + "\n";

		return preamble;
	}

	/**
	 * Returns a string which is a n-times duplicate of a given one.
	 * @param stringToDuplicate String which should be duplicated
	 * @param amount Number declaring how often the string should be duplicated
	 * @return New String consisting of <code>amount</code>-times <code>stringToDuplicate</code>.
	 * 			If <code>amount</code> is smaller or equal 0, it returns an empty string "".
	 */
	private String duplicateString(String stringToDuplicate, int amount)
	{
		String newString = "";
		for(int i=0;i<amount;i++)
		{
			newString += stringToDuplicate;
		}
		return newString;
	}

}
