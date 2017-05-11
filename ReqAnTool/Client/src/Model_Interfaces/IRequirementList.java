package Model_Interfaces;

import java.util.ArrayList;

public interface IRequirementList<T extends IRequirement>
{

    public boolean isIncluded(String id);
    
    public T getReqByID(String id);
    
    public boolean removeReqByID(String id);
    
}
