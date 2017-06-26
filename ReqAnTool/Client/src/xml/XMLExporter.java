package xml;

import Model_Interfaces.IRequirementAnalysis;
import Model_Interfaces.XMLFormatType;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FilePermission;

/**
 * Exports requirement analysis to given address in given format.
 * The XMLExporter is called from the {@link XMLManager}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see FileOperator
 * @see SecurityManager
 */
public class XMLExporter
{

    /**
     * A requirement analysis is marshaled and exported in a given format.
     * The method {@link XMLExporter#marshall(IRequirementAnalysis, XMLFormatType)} is used to
     * create a new requirement analysis in a format that JAXB can process.
     * This requirement analysis is converted by JAXB to the XML file in the
     * {@link XMLExporter#saveTo(String, IXMLFormat)} method.
     * @param analysis The requirement analysis to be converted.
     * @param address The address in the filesystem where the XML file should be stored.
     * @param type The XML format in which the requirement analysis should be formatted.
     * @throws XMLMarschallingException Is thrown, when the given requirement analysis could not be parsed to the given
     * type
     * @throws FileNotFoundException Is thrown, when the XML file is not found.
     * @throws XMLFormatException Is thrown, when the given format is invalid.
     * @throws SingletonRecreationException Is thrown, whenever there is an attempt to create two instances of a
     * singleton
     * @throws JAXBException Is thrown, when an error occurred while processing the requirement analysis to
     * the file in JAXB
     * @throws SecurityException Is thrown, when there is no write permission for the given file
     */
    public void save(IRequirementAnalysis analysis, String address, XMLFormatType type)
            throws XMLMarschallingException, FileNotFoundException, XMLFormatException, SingletonRecreationException,
            JAXBException, SecurityException
    {
      IXMLFormat xmlData;
      xmlData = marshall(analysis, type);

      if (xmlData == null)
      {
          throw new XMLMarschallingException(analysis);
      }
      else
      {
          saveTo(address, xmlData);
      }
    }

    /**
     * The given requirement analysis is converted to a requirement analysis of the given type.
     * To convert the requirement analysis by JAXB, the requirement analysis has to confirm to certain
     * conditions, so the given requirement analysis is converted loss free to a type that is compatible
     * with JAXB.
     * The method {@link IXMLFormat#createFragments(IRequirementAnalysis)} is used to fill the new
     * requirement analysis class with the data from the original requirement analysis.
     * @param analysis The given analysis that has to be converted.
     * @param type The type of the format in which the XML file should be formatted and the type of the
     *             requirement analysis which is JAXB conform.
     * @return If the conversion was successful a requirement analysis of generic {@link IXMLFormat}
     * type is returned. If the conversion is not successful null is returned.
     * @throws XMLFormatException Is thrown, when the given format is invalid.
     * @throws SingletonRecreationException Is thrown whenever the {@link XMLFormatFactory} could not
     * be instantiated, because there is already one instance in the system.
     *
     * @see IXMLFormat
     */
    private IXMLFormat marshall(IRequirementAnalysis analysis, XMLFormatType type)
            throws XMLFormatException, SingletonRecreationException
    {
      XMLFormatFactory xmlFactory;
      IXMLFormat xmlData;

      xmlFactory = XMLFormatFactory.getInstance();

      if(xmlFactory == null)
      {
          throw new SingletonRecreationException(xmlFactory);
      }

      xmlData = xmlFactory.xmlFormat(type);

      xmlData.createFragments(analysis);

      return xmlData;
    }

    /**
     * The requirement analysis is written to a XML file.
     * The permission is checked to make sure, if the file already exists, there is write permission for that file.
     * The {@link FileOperator#writeToFile(String, IXMLFormat)} method is used to perform the writing to the
     * file by JAXB.
     * @param address The given address in the filesystem where the XML file should be stored.
     * @param xmlData The requirement analysis in a JAXB conform format.
     * @throws FileNotFoundException Is thrown, when the XML file is not found. Applies only if an existing file
     * should be overwritten.
     * @throws JAXBException Is thrown, when an error occurred while processing the requirement analysis to
     * the file in JAXB
     * @throws SecurityException Is thrown, when there is no write permission for the given file
     */
    private void saveTo(String address, IXMLFormat xmlData)
            throws FileNotFoundException, JAXBException, SecurityException
    {
        /**
         * The {@link SecurityManager} is used to check the permission regarding the given address
         */
        SecurityManager securityManager = new SecurityManager();
        /**
         * A {@link SecurityException} is thrown when there is no read and write permission for the
         * given file.
         */
        securityManager.checkPermission(new FilePermission(address, "read, write"));

        FileOperator fileOperator;

        fileOperator = new FileOperator();
    
        fileOperator.writeToFile(address, xmlData);
    }
}
