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
    private ArrayList<IRequirement> references;
    
    @Override
    public String getID()
    {
        return id;
    }

    @Override
    public ArrayList<IRequirement> getReferences()
    {
        return references;
    }
    
    @Override
    public String[] getReferenceIDs()
    {
        String[] ids = new String[references.size()];
        int i = 0;
        for (IRequirement req : references)
        {
            ids[i] = req.getID();
            i++;
        }
        return ids;
    }

}
