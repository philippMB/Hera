package xml;

import Model_Interfaces.IRequirementAnalysis;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

public class XMLExporter
{

  private FileOperator fileOperator;
  private IXMLFormat xmlData;
  private XMLFormatFactory xmlFactory;
  private int ret = 0;
  
  public int save(IRequirementAnalysis analysis, String address) throws JAXBException, FileNotFoundException
  {
    xmlData = marshall(analysis);
    
    if (xmlData == null)
    {
      System.out.println("Failed to marshall analysis.");
      return -1 ;
    }
    
    ret = saveTo(address, xmlData);
    
    return ret;
  }

  private IXMLFormat marshall(IRequirementAnalysis analysis)
  {
    xmlFactory = new XMLFormatFactory();
    if(xmlFactory == null)
    {
      System.out.println("Failed to create xml factory.");
      return null;
    }
    // TODO picker via method/parameter
    xmlData = xmlFactory.xmlFormat(1);
    if(xmlData == null)
    {
      System.out.println("Failed to create xml formatter.");
      return null;
    }
    // Rückgabe
    ret = xmlData.createFragments(analysis);
    
    return xmlData;
  }

  private int saveTo(String address, IXMLFormat xmlData)
    throws JAXBException, FileNotFoundException
  {
    fileOperator = new FileOperator();
    if(fileOperator == null)
    {
      System.out.println("Failed to create file operator.");
      return -1;
    }
    
    ret = fileOperator.writeToFile(address, xmlData);
    
    return ret;
  }
}
