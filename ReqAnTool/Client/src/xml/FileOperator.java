package xml;

import Model_Interfaces.XMLErrorCodes;

import javax.xml.bind.JAXB;
import java.io.*;

public class FileOperator
{
    public FileOperator()
    {
        // Default-Constructor
    }

    // Exception handling
  public XMLErrorCodes writeToFile(String address, IXMLFormat xmlData)
  {
      XMLErrorCodes error = XMLErrorCodes.NO_ERROR;
    // trennen in neue Methode
    FileOutputStream out = openFile(address);
    if(out != null)
    {
        JAXB.marshal(xmlData, out);
    }
    else
    {
        error = XMLErrorCodes.FILE_NOT_FOUND;
    }

    // Rückgabe nutzen
    return error;
  }

  private FileOutputStream openFile(String filename)
  {
      FileOutputStream out = null;
      try {
          out = new FileOutputStream("xmlTest.xml"); // TODO: spaeter variable
      } catch (FileNotFoundException e) {
          e.printStackTrace(); // TODO: Logger die Exception reinschmeissen
      }

      return out;
  }

  public IXMLFormat readFromFile(String address, Class<? extends IXMLFormat> format)
  {
    FileInputStream in = null;
    IXMLFormat reqData = null;

    try {
        // TODO: address einsetzen
      in = new FileInputStream("xmlTest.xml");
    } catch (FileNotFoundException e) {
        // TODO: Logger
    }

    if(in != null)
    {
        reqData = JAXB.unmarshal(in, format);
    }

    return reqData;
  }
}
