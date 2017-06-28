package Model;

import Model_Interfaces.IRequirement;

interface IRequirementList<T extends IRequirement>
{

    boolean isIncluded(String id);
    
    T getReqByID(String id);
    
    boolean removeReqByID(String id);
    
}
