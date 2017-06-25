package xml;


import Model_Interfaces.XMLFormatType;

/**
 * Created by Philipp on 24.06.17.
 */
public class XMLFormatException
        extends Exception
{
    private final static String EXCEPTION_MESSAGE = "Unknown XML Format:  ";

    public XMLFormatException(XMLFormatType type)
    {
        super(EXCEPTION_MESSAGE + type.toString());
    }
}
