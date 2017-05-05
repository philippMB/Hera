package Model;

import Model_Interfaces.IRequirement;

import java.util.ArrayList;
import java.util.List;

public abstract class Requirement
    implements IRequirement
{

    private String id;
    /**
     * @associates <{Model.Requirement}>
     */
    private RequirementList<IRequirement> references;

    Requirement(String id, RequirementList<IRequirement> references)
    {
        this.id = id;
        this.references = references;

    }

    @Override
    public String getID()
    {
        return id;
    }

    @Override
    public RequirementList<IRequirement> getReferences()
    {
        return references;
    }
    
    @Override
    public ArrayList<String> getReferenceIDs()
    {
        ArrayList<String> ids = new ArrayList<String>();
        for (IRequirement req : references)
        {
            ids.add(req.getID());
        }
        return ids;
    }

    public void edit(String id, RequirementList<IRequirement> references)
    {
        this.id = id;
        this.references = references;
    }
}
