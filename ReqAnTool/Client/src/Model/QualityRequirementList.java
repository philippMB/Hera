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
        boolean included = false;
        for (IQualReq myQualReq : this)
        {
            if (myQualReq.getCriteria().equals(criteria))
            {
                included = true;
            }
        }
        return included;

    }

    @Override
    public IQualReq getQualReqByCriteria(String criteria)
    {
        IQualReq qualReqToReturn = null;
        for (IQualReq myQualReq : this)
        {
            if (myQualReq.getCriteria().equals(criteria))
            {
                qualReqToReturn = myQualReq;
            }
        }
        return qualReqToReturn;

    }

    @Override
    public boolean removeQualReqByCriteria(String criteria)
    {
        boolean success = false;
        for (IQualReq myQualReq : this)
        {
            if (myQualReq.getCriteria().equals(criteria))
            {
                success = super.remove(myQualReq);
            }
        }
        return success;

    }

}
