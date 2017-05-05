package Model;

import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.IQualityRequirementList;

import java.util.ArrayList;

/**
 * Created by mbill on 05.05.2017.
 */
public class QualityRequirementList<IQualityRequirement>
    extends ArrayList<IQualityRequirement>
    implements IQualityRequirementList<IQualityRequirement>
{

    @Override
    public boolean isIncluded(String criteria)
    {
        return false;
    }

    @Override
    public IQualityRequirement getQualReqByCriteria(String criteria)
    {
        return null;
    }

    @Override
    public ArrayList<IQualityRequirement> toArrayList()
    {
        return null;
    }
}
