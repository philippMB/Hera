package xml;

/**
 * Created by Philipp on 24.06.17.
 */

/**
 * This Exception is thrown whenever there is an error while recreating a requirement analysis class from the XML file.
 * This Exception is an addition to the {@link javax.xml.bind.JAXBException} and covers all errors that are now
 * caught in the JAXBException.
 *
 * @author 3852430
 * @version 1.0
 */
public class XMLUnmarschallException
        extends Exception
{
    private final static String EXCEPTION_MESSAGE = "Could not unmarschall requirement analysis from: ";

    /**
     * The constructor for the XMLUnmarschallException.
     * The exception message should provide the file that causes the error.
     * @param address The address in the filesystem of the file that causes the error
     */
    public XMLUnmarschallException(String address)
    {
        super(EXCEPTION_MESSAGE + address.toString());
    }
}