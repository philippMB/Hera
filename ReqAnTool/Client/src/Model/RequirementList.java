package Model;

import Model_Interfaces.IRequirement;

import java.util.ArrayList;

public class RequirementList<T extends IRequirement>
    extends ArrayList<T>
    implements IRequirementList<T>
{

    @Override
    public boolean isIncluded(String id)
    {
        boolean included = false;
        for (T myReq : this)
        {
            if (myReq.getID().equals(id))
            {
                included = true;
            }
        }
        return included;

    }

    @Override
    public T getReqByID(String id)
    {
        T reqToReturn = null;
        for (T myReq : this)
        {
            if (myReq.getID().equals(id))
            {
                reqToReturn = myReq;
            }
        }
        return reqToReturn;

    }

    @Override
    public boolean removeReqByID(String id)
    {
        T reqToRemove = null;
        for (T myReq : this)
        {
            if (myReq.getID().equals(id))
            {
                reqToRemove = myReq;
            }
        }
        return this.remove(reqToRemove);

    }
}
