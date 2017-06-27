package xml;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import java.io.*;

/**
 * The FileOperator handles all XML file operations within the system.
 * The {@link FileOperator#writeToFile(String, IXMLFormat)} method is called from the {@link XMLExporter} to write the
 * requirement analysis to the filesystem.<br>
 * The {@link FileOperator#readFromFile(String, Class)} method is called from the {@link XMLImporter} to read a XML file
 * containing a requirement analysis. <br>
 * The <k>FileOperator</k> uses {@link JAXB} to perform the conversion from the requirement analysis to the XML file and
 * back.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see JAXB
 * @see XMLImporter
 * @see XMLExporter
 */
public class FileOperator
{
    /**
     * Default constructor for the FileOperator.
     */
    public FileOperator()
    {
    }

    /**
     * Writes the requirement data to the filesystem.
     * The {@link FileOperator#openFile(String)} opens the file at the given address for reading and the call to
     * {@link JAXB#marshal(Object, OutputStream)} performs the actual writing.
     * @param address The given address where to store the XML file in the filesystem.
     * @param xmlData The requirement analysis in a data format that JAXB can process.
     * @throws FileNotFoundException Is thrown when the given file is not found. Applies only when a file should be
     * overwritten.
     * @throws JAXBException Is thrown when JAXB encounters a problem in processing the data.
     *
     * @see JAXB
     * @see FileOutputStream
     */
    public void writeToFile(String address, IXMLFormat xmlData)
            throws FileNotFoundException, JAXBException
    {
      FileOutputStream out = openFile(address);

      JAXB.marshal(xmlData, out);
    }

    /**
     * Opens the file for writing.
     * @param filename
     * @return If the file could be opened and is ready for writing, the file pointer is returned. If the file could not
     * be found an exception is thrown.
     * @throws FileNotFoundException Is thrown when the file could not be found. Applies only if a file should be
     * overwritten.
     *
     * @see FileOutputStream
     */
    private FileOutputStream openFile(String filename)
            throws FileNotFoundException
    {
        FileOutputStream out = null;

        out = new FileOutputStream(filename);

        return out;
    }

    /**
     * Reads the requirement data from the XML file.
     * The {@link FileOperator#openFileForReading(String)} method opens the file for reading and the call to
     * {@link JAXB#unmarshal(InputStream, Class)} performs the actual reading from the file and the conversion to the
     * given format.
     * @param address The given address of the XML file in the filesystem.
     * @param format The given format of the requirement analysis in the file.
     * @return If the data could be read successfully a {@link IXMLFormat} object containing the data from the file
     * is returned. If the data could not be read an exception is thrown.
     * @throws FileNotFoundException Is thrown if the file at the given path could not be found.
     * @throws JAXBException Is thrown when JAXB encounters an error while reading and converting the data.
     *
     * @see JAXB
     * @see FileInputStream
     */
    public IXMLFormat readFromFile(String address, Class<? extends IXMLFormat> format)
            throws FileNotFoundException, JAXBException
    {
        FileInputStream in;
        IXMLFormat reqData = null;
        in = openFileForReading(address);
        reqData = JAXB.unmarshal(in, format);

        return reqData;
    }

    /**
     * Opens the file for reading.
     * @param filename The given address in the filesystem.
     * @return If the file could be opened for reading the file pointer is returned. If the file could not be found an
     * exception is thrown.
     * @throws FileNotFoundException Is thrown when the file could not be found at the given path.
     *
     * @see FileInputStream
     */
    private FileInputStream openFileForReading(String filename)
            throws FileNotFoundException {
        FileInputStream in = null;

        in = new FileInputStream(filename);

        return in;
    }
}
