package Exceptions;

/**
 * This exception is thrown when a needed object of {@link Model_Interfaces.IRequirementAnalysis} is null.
 * <p>
 *     When a class needs to store an object of {@link Model_Interfaces.IRequirementAnalysis} then it has to be ensured
 *     that it has been initialised before and is not null. Otherwise this exception will be thrown.
 * </p>
 * @author 9045534
 * @version 1.0
 */
public class MissingReqAnException
        extends Exception
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
    public MissingReqAnException()
    {
        super(EXCEPTION_MESSAGE);
    }

}