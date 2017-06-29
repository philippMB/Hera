package xml;

import Model_Interfaces.IRequirementAnalysis;
import Model_Interfaces.XMLFormatType;

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
     * The method {@link XMLImporter#loadFormat(String, XMLFormatType)} is used to get the actual requirement analysis.
     * @param address The address in the filesystem, where the XML file is stored.
     * @param type The type of the XML format in which the file is formatted.
     * @return A requirement analysis confirming to the {@link IRequirementAnalysis} format is returned.
     * @throws FileNotFoundException Is thrown, when the XML file is not found.
     * @throws XMLUnmarschallException Is thrown, when the unmarshalling of the XML file failes.
     * @throws SingletonRecreationException Is thrown, whenever there is an attempt to create two instances of a
     * singleton
     * @throws SecurityException Is thrown, when there is no read permission for the given file
     * @throws JAXBException Is thrown, when an error occurred while processing the file to the
     * requirement analysis in JAXB
     * @throws XMLFormatException Is thrown, when the given format is invalid.
     * @throws SingletonRecreationException Is thrown whenever the {@link XMLFormatFactory} could not
     * be instantiated, because there is already one instance in the system.
     */
    public IRequirementAnalysis loadAnalysis(String address, XMLFormatType type)
            throws FileNotFoundException, XMLUnmarschallException, JAXBException,
            SecurityException, XMLFormatException, SingletonRecreationException
    {
        IRequirementAnalysis reqData = null;
        reqData = loadFormat(address, type);
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
     * @param type The type of the XML format in which the file is formatted.
     * @return A requirement analysis in the {@link IXMLFormat} is returned. This is the universal format used for XML
     * formats in the {@link XMLManager}.
     * @throws FileNotFoundException Is thrown, when the XML file is not found.
     * @throws JAXBException Is thrown, when an error occurred while processing the file to the
     * requirement analysis in JAXB
     * @throws SecurityException Is thrown, when there is no read permission for the given file
     * @throws XMLFormatException Is thrown, when the given format is invalid.
     * @throws SingletonRecreationException Is thrown whenever the {@link XMLFormatFactory} could not
     * be instantiated, because there is already one instance in the system.
     */
    private IXMLFormat loadFormat(String address, XMLFormatType type)
            throws FileNotFoundException, JAXBException, SecurityException, XMLFormatException,
            SingletonRecreationException
    {
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

        Class<? extends IXMLFormat> format = unmarschall(type);

        /**
         * At this point in development only the {@link CustomXMLFormat} is supported, so any other format will cause
         * an error or invalid data.
         */
        customData = fileOperator.readFromFile(address, format);

        return customData;
    }

    /**
     * The format of the given XML file is converted to {@link IXMLFormat} for JAXB to convert the file back.
     * To convert the requirement analysis back by JAXB, the file has to meet certain conditions. JAXB has to know which
     * XML format was used to create the XML file to recreate the data loss free. Therefore the {@link IXMLFormat} is used.
     * @param type The given XML format in which the file is formatted.
     * @return If the XML format could successfully be converted, the class of the XML format is returned. If the format
     * is not supported a {@link XMLFormatException} is thrown.
     * @throws SingletonRecreationException Is thrown whenever the {@link XMLFormatFactory} could not
     * be instantiated, because there is already one instance in the system.
     * @throws XMLFormatException Is thrown, when the given format is invalid.
     *
     * @see IXMLFormat
     * @see XMLFormatFactory
     */
    private Class<? extends IXMLFormat> unmarschall(XMLFormatType type)
            throws SingletonRecreationException, XMLFormatException
    {
        XMLFormatFactory xmlFactory;
        IXMLFormat xmlData;

        xmlFactory = XMLFormatFactory.getInstance();

        if(xmlFactory == null)
        {
            throw new SingletonRecreationException(xmlFactory);
        }

        xmlData = xmlFactory.xmlFormat(type);

        return xmlData.getClass();
    }
}
