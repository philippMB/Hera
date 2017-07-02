package Exceptions;

/**
 * This exception is thrown if a parameter is not given although the execution requires it.
 * <p>
 *     Some algorithms in the cost estimation like optimizing the weight factors have as a precondition that e.g. the
 *     function points have to be calculated. To handle the cases when a parameter is not determined although it is
 *     a precondition of the current function this execution should be thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 */
public class MissingParameterException
	extends LoggedException
{

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private static final String EXCEPTION_MESSAGE = "Parameter must be determined before executing this function: ";

	private MissingParameter missingParameter;


	/**
	 * Public constructor which initialise the message for the exception.
	 * @param parameter Missing parameter causing this exception
	 */
	public MissingParameterException(MissingParameter parameter)
	{
		super(EXCEPTION_MESSAGE + parameter.toString());
		missingParameter = parameter;
	}

	/**
	 * Returns missing parameter which is required for execution and causes this exception
	 * @return Missing parameter causing this exception
	 */
	public MissingParameter getMissingParameter()
	{
		return missingParameter;
	}

}
