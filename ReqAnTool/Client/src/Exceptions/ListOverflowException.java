package Exceptions;

/**
 * This exception is thrown if a list has a greater size than the maximum value.
 * <p>
 *     A maximum size for a list helps to limit the needed memory of it. If a element should be added although there are
 *     already the maximum amount of elements in the list this exception is thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 */
public class ListOverflowException
	extends LoggedException
{

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private static final String EXCEPTION_MESSAGE = "Overflow for list ";

	private Class listContentType;


	/**
	 * Public constructor which initialise the message for the exception and saves list parameters for debugging.
	 * @param listContentType Class of objects which the list contains
	 * @param listName Name of the list
	 */
	public ListOverflowException(Class listContentType, String listName)
	{
		super(EXCEPTION_MESSAGE+listName);
		this.listContentType = listContentType;
	}

	/**
	 * Returns the class of the objects which the list contains.
	 * @return Class of objects in list
	 */
	public Class getListContentType()
	{
		return listContentType;
	}
}
