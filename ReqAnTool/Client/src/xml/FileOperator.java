package xml;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;

public class FileOperator
{
  // Exception handling
  public int writeToFile(String address, IXMLFormat xmlData) throws JAXBException, FileNotFoundException
  {
    // trennen in neue Methode
    FileOutputStream out = null;
    out = new FileOutputStream("xmlTest.xml");
    
    JAXBContext jc = JAXBContext.newInstance(CustomXMLFormat.class);
    JAXB.marshal(xmlData, out);
    // Rückgabe nutzen
    return 0;
  }

  public CustomXMLFormat readFromFile(String address)
    throws FileNotFoundException
  {
    FileInputStream in = null;
    in = new FileInputStream("xmlTest.xml");

    CustomXMLFormat reqData;
    reqData = JAXB.unmarshal(in, CustomXMLFormat.class);
    
    return reqData;
  }
}
