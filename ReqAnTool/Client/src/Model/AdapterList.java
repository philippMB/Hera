package Model;

import Model_Interfaces.IRequirementList;

import java.util.ArrayList;

public class AdapterList<T>
    extends ArrayList
    implements IRequirementList<T>
{

    @Override
    public boolean add()
    {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean isIncluded()
    {
        // TODO Implement this method
        return false;
    }

    public T getReqByID(String id)
    {
    }
}
