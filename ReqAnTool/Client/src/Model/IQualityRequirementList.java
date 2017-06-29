package Model;

import Model_Interfaces.IQualityRequirement;

import java.util.ArrayList;

/**
 * Created by mbill on 05.05.2017.
 */
public interface IQualityRequirementList<IQualReq extends IQualityRequirement>
{

    public boolean isIncluded(String criteria);

    public IQualReq getQualReqByCriteria(String criteria);

    public boolean removeQualReqByCriteria(String criteria);

}
