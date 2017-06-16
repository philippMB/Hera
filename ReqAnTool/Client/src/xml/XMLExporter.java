package xml;

import Model_Interfaces.IRequirementAnalysis;
import Model_Interfaces.XMLErrorCodes;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

public class XMLExporter
{

  public XMLErrorCodes save(IRequirementAnalysis analysis, String address)
  {
      IXMLFormat xmlData;
    XMLErrorCodes error = XMLErrorCodes.NO_ERROR;
    xmlData = marshall(analysis);
    
    if (xmlData == null)
    {
      // TODO: Logger
      System.out.println("Failed to marshall analysis.");
      error = XMLErrorCodes.XML_FORMAT_ERROR;
    }
    else
    {
        error = saveTo(address, xmlData);
    }

    return error;
  }

  private IXMLFormat marshall(IRequirementAnalysis analysis)
  {
      XMLFormatFactory xmlFactory;
      IXMLFormat xmlData;
    xmlFactory = new XMLFormatFactory();
    // TODO picker via method/parameter
    xmlData = xmlFactory.xmlFormat(1);
    if(xmlData != null)
    {
      xmlData.createFragments(analysis);
    }

    return xmlData;
  }

  private XMLErrorCodes saveTo(String address, IXMLFormat xmlData)
  {
      XMLErrorCodes error = XMLErrorCodes.NO_ERROR;
      FileOperator fileOperator;

    fileOperator = new FileOperator();
    
    error = fileOperator.writeToFile(address, xmlData);
    
    return error;
  }
}
