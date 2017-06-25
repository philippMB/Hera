package xml;

import Model_Interfaces.XMLFormatType;

public final class XMLFormatFactory
{
    private static XMLFormatFactory instance = null;
    private XMLFormatFactory() {
        // Exists only to defeat instantiation.
    }

    public static XMLFormatFactory getInstance() {
        if(instance == null) {
            instance = new XMLFormatFactory();
        }
        return instance;
    }

    // TODO: singleton
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
