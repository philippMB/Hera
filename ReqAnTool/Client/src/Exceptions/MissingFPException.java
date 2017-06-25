package Exceptions;

/**
 * This exception is thrown if the function points are not calculated although the execution requires it.
 * <p>
 *     Some algorithms in the cost estimation like optimizing the weight factors have as a precondition that the
 *     function points have to be calculated. If this is not fulfilled this exception is thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 */
public class MissingFPException
	extends Exception
{

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private static final String EXCEPTION_MESSAGE = "Function Points must be calculated before executing this function";

	/**
	 * Public constructor which initialise the message for the exception.
	 */
	public MissingFPException()
	{
		super(EXCEPTION_MESSAGE);
	}

}
