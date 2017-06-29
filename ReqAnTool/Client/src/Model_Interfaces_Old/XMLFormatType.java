package Model_Interfaces;

/**
 * Created by Philipp on 17.06.17.
 */

/**
 * The user can choose between two formats to be used in the XML file.
 * The CUSTOM_XML_FORMAT is a format especially created for the use with the {@link IRequirementAnalysis}.
 * The REQUIREMENT_INTERCHANGE_FORMAT will use the Requirements Interchange Format of the Object Management Group.
 * @see <a href="www.omg.org/spec/ReqIF/">www.omg.org/spec/ReqIF/</a>
 * @see xml.CustomXMLFormat
 */
public enum XMLFormatType
{
    CUSTOM_XML_FORMAT,
    REQUIREMENT_INTERCHANGE_FORMAT
}
