package Model_Interfaces;

public interface IRequirementList<T>
{
    
<<<<<<< HEAD
    public boolean add();
    
    public boolean search();
=======
    public boolean add(T myReq);
    
    public boolean isIncluded(String id);
    
    public T getReqByID(String id);
>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527
    
}
