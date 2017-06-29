package Model_Interfaces;

public interface IRequirementList<T>
{

    public boolean add(T myReq);

    public boolean isIncluded(String id);

    public T getReqByID(String id);

}