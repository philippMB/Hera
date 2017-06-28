    package Model_Interfaces;

import java.util.ArrayList;

public interface IRequirement
{
    
    String getID();
    
    ArrayList<IRequirement> getReferences();

    ArrayList<String> getReferenceIDs();

}
