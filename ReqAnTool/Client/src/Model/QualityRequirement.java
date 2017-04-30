package Model;

import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.Score;

public class QualityRequirement
    implements IQualityRequirement
{

    private String criteria;
    private Score value;

    @Override
    public String getCriteria()
    {
        return criteria;
    }

    @Override
    public Score getValue()
    {
        return value;
    }
}
