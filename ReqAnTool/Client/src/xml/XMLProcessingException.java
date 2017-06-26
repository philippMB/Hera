package xml;

import javax.xml.bind.JAXBException;

/**
 * Created by Philipp on 24.06.17.
 */

/**
 * This Exception is thrown whenever an error occurs in the processing of the XML file back to the
 * data or the other way around and this error is reported by the underlying XML converter.
 * In this case all {@link JAXBException} are caught and converted to this exception type to
 * hide the actual implementation.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see JAXBException
 */
public class XMLProcessingException
        extends Exception
{
    private final static String EXCEPTION_MESSAGE = "Error in XML processing. Exited with the following error: ";

    /**
     * The constructor of the XMLProcessingException.
     * The exception message of the underlying exception is added to the exception message to provide
     * all necessary information.
     * @param exception The exception that threw the original exception
     */
    public XMLProcessingException(Exception exception)
    {
        super(EXCEPTION_MESSAGE + exception.getMessage());
    }
}
