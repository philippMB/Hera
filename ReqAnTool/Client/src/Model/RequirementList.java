package Model;

import Model_Interfaces.IFRequirement;
import Model_Interfaces.IRequirement;
import Model_Interfaces.IRequirementList;

import java.util.ArrayList;

public class RequirementList<T extends IRequirement>
    extends ArrayList<T>
    implements IRequirementList<T>
{

    @Override
    public boolean isIncluded(String id)
    {
        for (T myReq : this)
        {
            if (myReq.getID().equals(id))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public T getReqByID(String id)
    {
        for (T myReq : this)
        {
            if (myReq.getID().equals(id))
            {
                return myReq;
            }
        }
        return null;
    }

    @Override
    public boolean removeReqByID(String id)
    {
        for (T myReq : this)
        {
            if (myReq.getID().equals(id))
            {
                return super.remove(myReq);
            }
        }
        return false;
    }
}
