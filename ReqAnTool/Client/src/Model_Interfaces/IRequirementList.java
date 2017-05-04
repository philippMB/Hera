package Model_Interfaces;

import java.util.ArrayList;

public interface IRequirementList<T>
{
    
    public boolean add(T myReq);
    
    public boolean isIncluded(String id);
    
    public T getReqByID(String id);
    
    public ArrayList<T> toArrayList();
    
    public boolean remove(T myReq);
    
}
