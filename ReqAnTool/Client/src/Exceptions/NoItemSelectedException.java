package Exceptions;

/**
 * This exception is thrown when a action is performed which requires an item being selected in a table but no element
 * was selected.
 * <p>
 *     If a table contains elements which could be edited by pressing a button it is necessary that a table element is
 *     selected. When this is not the case this exception is thrown.
 * </p>
 * @author 9045534
 * @version 1.0
 */
public class NoItemSelectedException
	extends LoggedException
{

	/**
	 * Message which will be shown in log-files and/or standard output/error. Gives a description why the
	 * error is thrown and how to fix it.
	 */
	private final static String EXCEPTION_MESSAGE = "No item was selected in table although it has to: ";


	/**
	 * Public constructor which initialise the message for the exception.
	 */
	public NoItemSelectedException(String tableForSelecting)
	{
		super(EXCEPTION_MESSAGE + tableForSelecting);
	}


}
