package xml;

import Model_Interfaces.IRequirementAnalysis;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FilePermission;


/**
 * Imports a requirement analysis from a given address.
 * The XMLImporter is called from the {@link XMLManager}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see FileOperator
 * @see SecurityManager
 */
public class XMLImporter
{
  /**
   * A requirement analysis is read and imported from the given address.
   * The method {@link XMLImporter#loadFormat(String)} is used to get the actual requirement analysis.
   * @param address The address in the filesystem, where the XML file is stored.
   * @return A requirement analysis confirming to the {@link IRequirementAnalysis} format is returned.
   * @throws FileNotFoundException Is thrown, when the XML file is not found.
   * @throws XMLUnmarschallException Is thrown, when the unmarshalling of the XML file failes.
   * @throws SingletonRecreationException Is thrown, whenever there is an attempt to create two instances of a
   * singleton
   * @throws SecurityException Is thrown, when there is no read permission for the given file
   * @throws JAXBException Is thrown, when an error occurred while processing the file to the
   * requirement analysis in JAXB
   */
  public IRequirementAnalysis loadAnalysis(String address)
          throws FileNotFoundException, XMLUnmarschallException, JAXBException, SingletonRecreationException,
          SecurityException
  {
    IRequirementAnalysis reqData = null;
    reqData = loadFormat(address);
    if (reqData == null)
    {
      throw new XMLUnmarschallException(address);
    }
    return reqData;
  }

  /**
   * The requirement analysis is read from the given address.
   * The {@link FileOperator} is used to retrieve the data stored in the XML file. Therefore its
   * {@link FileOperator#readFromFile(String, Class)} is called with the class in which the data was formatted.
   * @param address The address in the filesystem, where the XML file is stored.
   * @return A requirement analysis in the {@link IXMLFormat} is returned. This is the universal format used for XML
   * formats in the {@link XMLManager}.
   * @throws FileNotFoundException Is thrown, when the XML file is not found.
   * @throws JAXBException Is thrown, when an error occurred while processing the file to the
   * requirement analysis in JAXB
   * @throws SecurityException Is thrown, when there is no read permission for the given file
   */
  private IXMLFormat loadFormat(String address)
          throws FileNotFoundException, JAXBException, SecurityException {
    /**
     * The {@link SecurityManager} is used to check the permission regarding the given address
     */
    SecurityManager securityManager = new SecurityManager();
    /**
     * A {@link SecurityException} is thrown, if there is no permission to read the file.
     */
    securityManager.checkPermission(new FilePermission(address, "read"));

    FileOperator fileOperator = new FileOperator();
    IXMLFormat customData;
    /**
     * At this point in development only the {@link CustomXMLFormat} is supported, so only
     * this class is passed to the {@link FileOperator#readFromFile(String, Class)} method
     */
    customData = fileOperator.readFromFile(address, CustomXMLFormat.class);

    return customData;
  }
}
