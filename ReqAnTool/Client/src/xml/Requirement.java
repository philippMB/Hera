package xml;

import Model_Interfaces.IRequirement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

/**
 * Created by Philipp on 13.06.17.
 */
@XmlTransient
public class Requirement implements IRequirement
{
    @XmlElement(name="ID")
    protected String id;
    protected ArrayList<String> referenceIDs;

    public Requirement()
    {
        // Default Constructor
    }

    public Requirement(IRequirement origin)
    {
        id = origin.getID();
        referenceIDs = origin.getReferenceIDs();
    }

    public void setReferenceIDs(ArrayList<String> referenceIDs)
    {
        this.referenceIDs = referenceIDs;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public ArrayList<IRequirement> getReferences() {
        return null;
    }

    @Override
    public ArrayList<String> getReferenceIDs() {
        return null;
    }
}
