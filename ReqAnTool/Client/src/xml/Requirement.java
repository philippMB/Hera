package xml;

import Model_Interfaces.IRequirement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

/**
 * Created by Philipp on 13.06.17.
 */
@XmlTransient
public class Requirement
        implements IRequirement
{
    @XmlElement(name="ID")
    protected String id;
    protected ArrayList<String> referenceIDs;

    public Requirement(IRequirement origin)
    {
        id = origin.getID();
        referenceIDs = origin.getReferenceIDs();
    }

    public Requirement()
    {
        // Default Constructor
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
