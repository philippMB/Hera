    package Model_Interfaces;

import java.util.ArrayList;

public interface IRequirement
{
    
    public String getID();
    
    public ArrayList<IRequirement> getReferences();

    public String[] getReferenceIDs();
}
