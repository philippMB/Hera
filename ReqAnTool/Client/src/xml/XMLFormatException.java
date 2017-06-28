package xml;


import Model_Interfaces.XMLFormatType;

/**
 * Created by Philipp on 24.06.17.
 */

/**
 * This Exception is thrown whenever the requested XML format is not supported.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see XMLFormatFactory
 * @see XMLFormatType
 */
public class XMLFormatException
        extends Exception
{
    private final static String EXCEPTION_MESSAGE = "Unknown XML Format:  ";

    /**
     * The constructor of the XMLFormatException
     * The exception message should provide information about the requested XML format which is
     * not supported.
     * @param type The XML format, which is not supported.
     */
    public XMLFormatException(XMLFormatType type)
    {
        super(EXCEPTION_MESSAGE + type.toString());
    }
}
