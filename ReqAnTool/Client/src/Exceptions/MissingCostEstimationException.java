package Exceptions;

/**
 * This exception is thrown when a needed object of {@link Model_Interfaces.ICostEstimation} is null because no
 * estimation was created for the related requirement analysis.
 * <p>
 *     When the model has to execute a function on the cost estimation of the opened requirement analysis then it has
 *     to be ensured that the cost estimation has been created before and is not null. Otherwise this exception will
 *     be thrown.
 * </p>
 * @author 9045534
 * @version 1.0
 */
public class MissingCostEstimationException
		extends LoggedException
{

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private final static String EXCEPTION_MESSAGE = "Given Requirement Analysis was null. "+
			"Please provide a object before calling it";


	/**
	 * Public constructor which initialise the message for the exception.
	 */
	public MissingCostEstimationException()
	{
		super(EXCEPTION_MESSAGE);
	}

}