package Model;

import Model_Interfaces.IRequirement;
import Model_Interfaces.IRequirementList;

import java.util.ArrayList;

public class AdapterList<T>
    extends ArrayList<T>
    implements IRequirementList<T>
{

    @Override
    public boolean add(T myReq)
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean isIncluded(String id)
    {
        // TODO Implement this method
        return false;
    }

    public T getReqByID(String id)
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<T> toArrayList()
    {
        return this;
    }
}
