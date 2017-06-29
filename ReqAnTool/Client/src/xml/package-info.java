/**
 * The XML-Converter package allows to export an {@link Model_Interfaces.IRequirementAnalysis} to a XML file and
 * import a {@link Model_Interfaces.IRequirementAnalysis} from a XML file.
 * <p>
 * The {@link xml.XMLManager} provides two methods to perform export and import actions.
 * </p>
 * <b>Export</b><br>
 * The
 * {@link xml.XMLManager#exportAnalysis(Model_Interfaces.IRequirementAnalysis, java.lang.String, Model_Interfaces.XMLFormatType)}
 * method exports the given {@link Model_Interfaces.IRequirementAnalysis} in the given
 * {@link Model_Interfaces.XMLFormatType} to the provided address in the filesystem. Internally the
 * {@link xml.XMLExporter} is called and converts the {@link Model_Interfaces.IRequirementAnalysis} to the JAXB conform
 * {@link xml.IXMLFormat}. Depending on the choice of the {@link Model_Interfaces.XMLFormatType} in the
 * {@link xml.XMLManager} either the XML file will be formatted in the {@link xml.CustomXMLFormat} or the
 * {@link xml.RequirementsInterchangeFormat}. The file operations are executed by the {@link xml.FileOperator} that
 * uses JAXB underneath to perform the writing and reading actions. Each file operation is watched by a
 * {@link java.lang.SecurityManager} to ensure that the user has the necessary permissions to access and modify the
 * XML files.
 * <p>
 *     <b>Import</b><br>
 *     The {@link xml.XMLManager#importAnalysis(java.lang.String, Model_Interfaces.XMLFormatType)} method imports a
 * {@link Model_Interfaces.IRequirementAnalysis} from the given address in the filesystem which is formatted in the
 * given {@link Model_Interfaces.XMLFormatType}. Internally the {@link xml.XMLImporter} is called and uses the
 * {@link xml.FileOperator} to perform the read and converting actions. Underneath JAXB reads the XML file and
 * recreates the requirement analysis in the given {@link Model_Interfaces.XMLFormatType}.
 * </p>
 *
 * <img src="doc-files/package_class_diagram.png" alt="Class Diagram XML">
 */
package xml;

