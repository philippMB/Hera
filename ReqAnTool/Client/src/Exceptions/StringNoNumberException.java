package Exceptions;

/**
 * This exception is thrown if a given string could not be converted to double.
 * <p>
 *     Due to the most inputs of the user are strings there is often the need to convert them to numbers like double.
 *     If a string could not converted to a number because of the incorrect pattern then this exception will be thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 */
public class StringNoNumberException
	extends Exception
{

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private static final String EXCEPTION_MESSAGE = "Could not convert string to double: ";

	private NumberType neededNumberType;
	private String givenString;


	/**
	 * Public constructor which initialise the message for the exception and saves the type of number, which was
	 * expected (based on {@link NumberType}, and the string input which could not be converted.
	 * @param neededNumberType Type of number which was needed (integer, double,...)
	 * @param givenString String which
	 */
	public StringNoNumberException(NumberType neededNumberType, String givenString)
	{
		super(EXCEPTION_MESSAGE + givenString + " - needed " + neededNumberType.toString());
		this.neededNumberType = neededNumberType;
		this.givenString = givenString;
	}

	/**
	 * Returns the number type which was needed but not given
	 * @return number type to which the string could not be converted
	 */
	public NumberType getNeededNumberType()
	{
		return neededNumberType;
	}

	/**
	 * Returns given string which could not be converted to a double
	 * @return given string which could not be converted to a double
	 */
	public String getGivenString()
	{
		return givenString;
	}
}
