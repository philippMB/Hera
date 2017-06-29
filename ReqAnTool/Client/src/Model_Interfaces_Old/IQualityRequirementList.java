package Model_Interfaces;

import java.util.ArrayList;

/**
 * Created by mbill on 05.05.2017.
 */
public interface IQualityRequirementList<IQualityRequirement>
{

    public boolean add(IQualityRequirement myQualReq);

    public boolean isIncluded(String criteria);

    public IQualityRequirement getQualReqByCriteria(String criteria);

    public ArrayList<IQualityRequirement> toArrayList();

    public boolean remove(IQualityRequirement myQualReq);

}
