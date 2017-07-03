package Exceptions;

/**
 * This class represents a basis structure for exceptions which are called by error while saving or loading.
 * <p>
 *     To give a basis structure for reacting to handle an error during Loading or Saving an Requirement Analysis this
 *     abstract class handles saving and providing:
 *     <ul>
 *         <li>the path which failed</li>
 *     </ul>
 * </p>
 * @author 7532274
 * @version 1.0
 * @see Exception
 */
public class DataAccessException
		extends Exception
{
	private final static String EXCEPTION_MESSAGE = "Access to the given path was not succesful: ";
	private String path;

	/**
	 * Constructor saving the given path, which ddoes not lead to an successful loading or saving.
	 * @param path path for which an error occured while loading or saving
	 */
	public DataAccessException(String path)
	{
		super(EXCEPTION_MESSAGE + path);
		this.path = path;
	}

	/**
	 * Returns the failed path to the Requirement which should be loaded or saved.
	 * @return Given path which failed
	 */
	public String getPath()
	{
		return path;
	}


}
