package Model;

import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.Score;

public class QualityRequirement
    implements IQualityRequirement
{

    private String criteria;
    private Score value;

    public QualityRequirement(String criteria, Score value)
    {
        this.criteria = criteria;
        this.value = value;

    }

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

    public void edit(String criteria, Score value)
    {
        this.criteria = criteria;
        this.value = value;

    }
}
