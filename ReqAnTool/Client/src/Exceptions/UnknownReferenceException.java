package Exceptions;

/**
 * This exception is thrown if an reference on a requirement should be created by a given string as ID but no requirement
 * in the requirement analysis has this ID.
 * <p>
 *     Every requirement has a ID which identifies it in a requirement analysis. Due to the views work with strings
 *     there is always a conversion from requirement to string and other way round. If a string ID should be converted
 *     to a requirement to reference on but no requirement exists with the specified ID this exception is thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 *
 */
public class UnknownReferenceException
        extends Exception
{

    /**
     * Message which will be shown in log-files and/or standard output/error. Gives a description why the
     * error is thrown and how to fix it.
     */
    private static final String EXCEPTION_MESSAGE = "Got a reference ID which could not be matched to a requirement: ";

    private String unkownReferenceID;


    /**
     * Public constructor which initialise the message for the exception and saves the ID for which no requirement could
     * be found.
     * @param referenceID ID which was given as reference but has no matching requirement
     */
    public UnknownReferenceException(String referenceID)
    {
        super(EXCEPTION_MESSAGE+referenceID);
        unkownReferenceID = referenceID;
    }

    /**
     * Returns the reference ID which could not be matched to a requirement
     * @return Reference ID which could not be matched to a requirement
     */
    public String getUnkownReferenceID()
    {
        return unkownReferenceID;
    }

}