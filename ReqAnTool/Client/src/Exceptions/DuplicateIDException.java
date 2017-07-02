package Exceptions;

/**
 * This exception is thrown if an requirement should be created or its ID changed to a new ID which is already used
 * by another requirement in the system.
 * <p>
 *     Every requirement has a ID which has to be unique for the whole requirement analysis. If a different requirement
 *     should have the same ID which is not allowed this exception will be thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 *
 */
public class DuplicateIDException
	extends LoggedException
{

	private String duplicateID;

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private static final String EXCEPTION_MESSAGE = "Requirement with the following ID is already in the system and" +
			" could not be used again: ";


	/**
	 * Public constructor which initialise the message for the exception.
	 * @param duplicateID ID which should be used twice and causes this exception
	 */
	public DuplicateIDException(String duplicateID)
	{
		super(EXCEPTION_MESSAGE+duplicateID);
		this.duplicateID = duplicateID;
	}

	public String getDuplicateID()
	{
		return duplicateID;
	}

}
