package Exceptions;

/**
 * This interface ensures a standard capability for using {@link Exception} on string basis.
 * <p>
 *     Some times e.g. for property files
 *     (see <a href="{@docRoot}/LanguageAndText/package-summary.html">LanguageAndText</a>) it is needed to convert
 *     an internal exception to a string to choose the right message displayed to the user. To apply a standard for
 *     such cases this interface provides a method with which a exception is easily converted to string. It is done
 *     by giving each exception class a unique string identifier which separates them from each other. This identifier
 *     could be used as the property tag in a resource file like mentioned above or similar.
 * </p>
 * <p>
 *     The string identifier is for every object in a class the same. It does not make sense to generate for each
 *     exception object an own string identifier if it should just simplify the conversion to string. Of course it
 *     is also possible to use the classname by calling <code><i>exception</i>.getClass().toString()</code>, but
 *     on the one side it is not capable to read for property files and on the other side when having deeper package
 *     structures the class name could depends on this and changes by modification of the structure while a constant
 *     string identifier for each exception always stays the same.
 * </p>
 * @author 9045534
 * @version 1.0
 * @see Exception
 */
public interface IException
{

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
	public String getExceptionID();

}
