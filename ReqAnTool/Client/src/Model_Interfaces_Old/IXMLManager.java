package Model_Interfaces;

import xml.*;

import java.io.FileNotFoundException;

/**
 * The XMLManager provides methods to import or export requirement analysis in XML format.
 * This singleton class lets the user choose in which kind the XML file should be formatted (see {@link XMLFormatType}).
 * A address where to write or read the file has to be provided.
 */
public interface IXMLManager
{
    /**
     * Method to get an instance of the singleton class IXMLManger
     * @return An instance of IXMLManager
     */
    public static IXMLManager getInstance()
    {
        return XMLManager.getInstance();
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
    public void exportAnalysis(IRequirementAnalysis analysis, String address, XMLFormatType type)
            throws XMLMarschallingException, FileNotFoundException, XMLFormatException, SingletonRecreationException,
            SecurityException, XMLProcessingException;

    /**
     * Imports a requirement analysis from a given address.
     * @param address The address in the filesystem, where the XML file is stored.
     * @param type The type of the XML format
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
    public IRequirementAnalysis importAnalysis(String address, XMLFormatType type)
            throws FileNotFoundException, XMLUnmarschallException,
            SecurityException, XMLProcessingException, XMLFormatException, SingletonRecreationException;
}
