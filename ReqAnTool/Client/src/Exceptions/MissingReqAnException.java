package Exceptions;

/**
 * This exception is thrown when a needed object of {@link Model_Interfaces.IRequirementAnalysis} is null.
 * <p>
 *     When a class needs to store an object of {@link Model_Interfaces.IRequirementAnalysis} then it has to be ensured
 *     that it has been initialised before and is not null. Otherwise this exception will be thrown.
 * </p>
 * <p>
 *     The interface {@link IException} is implemented here to guarantee a standard for working with {@link Exception}
 *     on string basis.
 * </p>
 * @author 9045534
 * @version 1.0
 * @see IException
 */
public class MissingReqAnException
	extends Exception
	implements IException
{

	/**
	 * A unique String which identifies this exception. For details see {@link MissingReqAnException#getExceptionID()}.
	 */
	private final static String EXCEPTION_ID = "EXC_MISSING_REQAN";
	/**
	 * Message which will be shown in log-files and/or standard output/error. Should give a description why the
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

	/**
	 * This method returns a unique string as identifier for the exception.
	 * <p>
	 * To separate exceptions on string basis each class should provide a unique string identifier that is returned
	 * via this method. Such a string is needed e.g. for finding the matching property name in resource
	 * files (see <a href="{@docRoot}/LanguageAndText/package-summary.html">LanguageAndText</a> for details).
	 * </p>
	 * <b><i>Caution:</i></b><br>
	 *     The string identifier is for every object in a class the same. It should just simplify the conversion of
	 *     {@link Exception} to strings.
	 * @return Unique string identifier of the exception class
	 */
	@Override
	public String getExceptionID()
	{
		return EXCEPTION_ID;
	}

}
