package Exceptions;

/**
 * This exception is thrown if an entry in a view is not given although the execution requires it.
 * <p>
 *     Some functions requires a entry in a view of the user. If this is not given the function could not be executed
 *     and this exception is thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 */
public class MissingEntryException
		extends LoggedException
{

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private static final String EXCEPTION_MESSAGE = "Entry must be given to execute this function: ";

	private MissingParameter missingEntry;


	/**
	 * Public constructor which initialise the message for the exception.
	 * @param missingEntry Missing entry causing this exception
	 */
	public MissingEntryException(MissingParameter missingEntry)
	{
		super(EXCEPTION_MESSAGE + missingEntry.toString());
		this.missingEntry = missingEntry;
	}

	/**
	 * Returns missing entry which is required for execution and causes this exception
	 * @return Missing entry causing this exception
	 */
	public MissingParameter getMissingEntry()
	{
		return missingEntry;
	}

}

