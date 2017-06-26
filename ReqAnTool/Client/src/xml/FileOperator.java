package xml;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import java.io.*;

public class FileOperator
{
    public FileOperator()
    {
        // Default-Constructor
    }

    // TODO: Exception handling
    public void writeToFile(String address, IXMLFormat xmlData)
            throws FileNotFoundException, JAXBException {
      FileOutputStream out = openFile(address);

      JAXB.marshal(xmlData, out);
    }

  private FileOutputStream openFile(String filename)
          throws FileNotFoundException {
      FileOutputStream out = null;

      out = new FileOutputStream(filename);

      return out;
  }

  public IXMLFormat readFromFile(String address, Class<? extends IXMLFormat> format)
          throws FileNotFoundException, JAXBException
  {
    FileInputStream in;
    IXMLFormat reqData = null;
    in = openFileForReading(address);
    reqData = JAXB.unmarshal(in, format);

    return reqData;
  }

  private FileInputStream openFileForReading(String filename)
          throws FileNotFoundException {
      FileInputStream in = null;

      in = new FileInputStream(filename);

      return in;
  }
}
