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
    public boolean search()
    {
        // TODO Implement this method
        return false;
    }
}
