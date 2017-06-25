package Exceptions;

/**
 * This exception is thrown if an elementary process was not found to the matching ID although it was needed.
 * <p>
 *     A data and transaction function point belongs to a requirement that's ID is also the identifier for its
 *     elementary process. If for a given ID no elementary process was found although the function needs to have one
 *     this exception will be thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 *
 */
public class UnknownEPException
	extends Exception
{

	private String givenRequirementID;

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private static final String EXCEPTION_MESSAGE = "Could not find matching elementary process for ID ";


	/**
	 * Public constructor which initialise the message for the exception.
	 */
	public UnknownEPException(String reqID)
	{
		super(EXCEPTION_MESSAGE+reqID);
		givenRequirementID = reqID;
	}

	/**
	 * Returns given requirement ID for which no elementary process could be found
	 * @return given requirement ID for which no elementary process could be found
	 */
	public String getGivenRequirementID()
	{
		return givenRequirementID;
	}

}
