package Model;

import Model_Interfaces.IQualityRequirement;

/**
 * Created by mbill on 05.05.2017.
 */
interface IQualityRequirementList<IQualReq extends IQualityRequirement>
{

    boolean isIncluded(String criteria);

    IQualReq getQualReqByCriteria(String criteria);

    boolean removeQualReqByCriteria(String criteria);

}
