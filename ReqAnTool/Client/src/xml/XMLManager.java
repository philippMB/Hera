package xml;

import Model_Interfaces.IXMLManager;
import Model_Interfaces.IRequirementAnalysis;
import Model_Interfaces.XMLFormatType;
import com.sun.istack.internal.NotNull;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * The XMLManager provides methods to import or export requirement analysis in XML format.
 * This singleton class lets the user choose in which kind the XML file should be formatted (see {@link XMLFormatType}).
 * A address where to write or read the file has to be provided.
 *<p>
 *   API:<br>
 *       <code>
 *           // Creating an instance of XMLManager <br>
 *           XMLManager manager = XMLManager.getInstance(); <br>
 *           // export a requirement analysis <br>
 *           manager.export(analysis, address, type) <br>
 *           // import a requirement analysis <br>
 *           IRequirementAnalysis = manager.import(address) <br>
 *       </code>
 *</p>
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IXMLManager
 * @see XMLExporter
 * @see XMLImporter
 */
public final class XMLManager
  implements IXMLManager
{
    /**
     * Exports requirement analysis to given address in given format.
     *
     * @param analysis Was sage ich aus und was soll übergeben werden
     * @param address
     * @param type
     * @return Was gebe ich zurück und was bedeutet das? Null vs not null
     * wenn ich auf irgendas anderes verweisen möchte, dann mache ich  {@link XMLExporter}
     * @see XMLExporter#save(IRequirementAnalysis, String, XMLFormatType)
     */

    private static XMLManager instance = null;
    private XMLManager() {
        /**
         * Exists only to defeat instantiation.
         */
    }
    public static XMLManager getInstance() {
        if(instance == null) {
            instance = new XMLManager();
        }
        return instance;
    }

    /**
     * Exports requirement analysis to given address in given format.
     * To performe the export process, the method {@link XMLExporter#save(IRequirementAnalysis, String, XMLFormatType)}
     * is used.
     * @param analysis The requirement analysis that should be exported in xml format.
     * @param address The address in the filesystem, where the XML file should be stored.
     * @param type The type of the XML Format.
     * @throws XMLMarschallingException Is thrown, when the given requirement analysis could not be parsed to the given
     * type
     * @throws FileNotFoundException Is thrown, when the XML file is not found.
     * @throws XMLFormatException Is thrown, when the given format is invalid.
     * @throws SingletonRecreationException Is thrown, whenever there is an attempt to create two instances of a
     * singleton
     * @throws SecurityException Is thrown, when there is no write permission for the given file
     * @throws XMLProcessingException Is thrown, when an error occurred while processing the requirement analysis to
     * the file
     *
     * @see XMLFormatType
     */
    @Override
    public void exportAnalysis(@NotNull IRequirementAnalysis analysis, @NotNull String address,
                               @NotNull XMLFormatType type)
            throws XMLMarschallingException, FileNotFoundException, XMLFormatException, SingletonRecreationException,
            SecurityException, XMLProcessingException
    {
        XMLExporter exporter = new XMLExporter();
        try {
            exporter.save(analysis, address, type);
        } catch (JAXBException e) {
            throw new XMLProcessingException(e);
        }
    }

    /**
     * Imports a requirement analysis from a given address.
     * @param address The address in the filesystem, where the XML file is stored.
     * @param type The type of the XML format.
     * @return A requirement analysis confirming to the {@link IRequirementAnalysis} format is returned.
     * @throws FileNotFoundException Is thrown, when the XML file is not found.
     * @throws XMLUnmarschallException Is thrown, when the unmarshalling of the XML file failes.
     * @throws SingletonRecreationException Is thrown, whenever there is an attempt to create two instances of a
     * singleton
     * @throws SecurityException Is thrown, when there is no read permission for the given file
     * @throws XMLProcessingException Is thrown, when an error occurred while processing the file to the
     * requirement analysis
     * @throws XMLFormatException Is thrown, when the given format is invalid.
     * @throws SingletonRecreationException Is thrown whenever the {@link XMLFormatFactory} could not
     * be instantiated, because there is already one instance in the system.
     */
    @Override
    public IRequirementAnalysis importAnalysis(@NotNull String address, XMLFormatType type)
            throws FileNotFoundException, XMLUnmarschallException,
            SecurityException, XMLProcessingException, XMLFormatException, SingletonRecreationException
    {
        IRequirementAnalysis requirementAnalysis;
        XMLImporter importer = new XMLImporter();

        /**
         * Underneath JAXB is used to read the XML file and import it into the requirement analysis. Whenever JAXB
         * encounters an error, this error is converted into a {@link XMLProcessingException} to hide the actual
         * implementation.
         */
        try {
            requirementAnalysis = importer.loadAnalysis(address, type);
        } catch (JAXBException e) {
            throw new XMLProcessingException(e);
        }
        return requirementAnalysis;
    }

}
