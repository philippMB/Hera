package xml;

import Model_Interfaces.XMLFormatType;

/**
 * Creates an instance of the given {@link XMLFormatType}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see XMLFormatType
 */
public final class XMLFormatFactory
{
    private static XMLFormatFactory instance = null;
    private XMLFormatFactory() {
        /**
         * Exists only to defeat instantiation.
         */
    }

    public static XMLFormatFactory getInstance() {
        if(instance == null) {
            instance = new XMLFormatFactory();
        }
        return instance;
    }

    /**
     * Creates an instance of the given type.
     * Right now only two types are supported. Fully implemented is the {@link CustomXMLFormat}.
     * Not yet implemented is the {@link RequirementsInterchangeFormat}, but an instance of this type can
     * still be created.
     * @param type The {@link XMLFormatType} from whom an instance should be created.
     * @return If the creation was succesfull an instance of the requested type is returned.
     * If the option is not known, an {@link XMLFormatException} is thrown.
     * @throws XMLFormatException Is thrown when the XML format is not supported.
     *
     * @see CustomXMLFormat
     * @see RequirementsInterchangeFormat
     */
    public IXMLFormat xmlFormat(XMLFormatType type)
            throws XMLFormatException
    {
        IXMLFormat format;
        switch(type)
        {
            case CUSTOM_XML_FORMAT:
                format = new CustomXMLFormat();
                break;
            case REQUIREMENT_INTERCHANGE_FORMAT:
                format = new RequirementsInterchangeFormat();
                break;
            default:
                throw new XMLFormatException(type);
        }

        return format;
    }
}
