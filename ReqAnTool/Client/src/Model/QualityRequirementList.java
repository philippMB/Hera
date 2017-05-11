package Model;

import Model_Interfaces.IQualityRequirement;

import java.util.ArrayList;

/**
 * Created by mbill on 05.05.2017.
 */
public class QualityRequirementList<IQualReq extends IQualityRequirement>
    extends ArrayList<IQualReq>
    implements IQualityRequirementList<IQualReq>
{

    @Override
    public boolean isIncluded(String criteria)
    {
        for (IQualReq myQualReq : this)
        {
            if (myQualReq.getCriteria().equals(criteria))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public IQualReq getQualReqByCriteria(String criteria)
    {
        for (IQualReq myQualReq : this)
        {
            if (myQualReq.getCriteria().equals(criteria))
            {
                return myQualReq;
            }
        }
        return null;
    }

    @Override
    public boolean removeQualReqByCriteria(String criteria)
    {
        for (IQualReq myQualReq : this)
        {
            if (myQualReq.getCriteria().equals(criteria))
            {
                return super.remove(myQualReq);
            }
        }
        return false;
    }

}
