package xml;

import Model_Interfaces.IRequirement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

/**
 * Created by Philipp on 13.06.17.
 */

@XmlTransient

/**
 * Class to hold the Requirements of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link IRequirement} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IRequirement
 * @see CustomXMLFormat
 */
public class Requirement
        implements IRequirement
{
    @XmlElement(name="ID")
    protected String id;
    protected ArrayList<String> referenceIDs;

    /**
     * The constructor for the Requirement class.
     * The data from the original Requirement instance is copied into this JAXB conform class.
     * @param origin The Requirement instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public Requirement(IRequirement origin)
    {
        id = origin.getID();
        referenceIDs = origin.getReferenceIDs();
    }

    /**
     * The default constructor for the Requirement class.
     * Must be provided to be JAXB conform.
     */
    public Requirement()
    {
    }

    public String getID() {
        return id;
    }

    public ArrayList<String> getReferenceIDs() {
        return referenceIDs;
    }

    public ArrayList<IRequirement> getReferences() {
        // nicht implementiert
        return null;
    }

    public void setReferenceIDs(ArrayList<String> referenceIDs)
    {
        this.referenceIDs = referenceIDs;
    }

    public void setId(String id)
    {
        this.id = id;
    }

}
