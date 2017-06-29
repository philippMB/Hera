package Exceptions;

/**
 * This exception is thrown if for a string requirement ID no matching requirement could be found in the requirement
 * analysis.
 * <p>
 *     Every requirement has a ID which identifies it in a requirement analysis. Due to the views work with strings
 *     there is always a conversion from requirement to string and other way round. If a string ID should be converted
 *     to a requirement on but no requirement exists with the specified ID this exception is thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 *
 */
public class UnknownIDException
        extends Exception
{

    /**
     * Message which will be shown in log-files and/or standard output/error. Gives a description why the
     * error is thrown and how to fix it.
     */
    private static final String EXCEPTION_MESSAGE = "Got ID which could not be matched to a requirement: ";

    private String unkownID;


    /**
     * Public constructor which initialise the message for the exception and saves the ID for which no requirement could
     * be found.
     * @param referenceID ID for which no matching requirement could be found
     */
    public UnknownIDException(String referenceID)
    {
        super(EXCEPTION_MESSAGE+referenceID);
        unkownID = referenceID;
    }

    /**
     * Returns the ID which could not be matched to a requirement
     * @return ID which could not be matched to a requirement
     */
    public String getUnkownID()
    {
        return unkownID;
    }

}