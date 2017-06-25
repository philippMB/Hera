package xml;

import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.Score;

public class QualityRequirement
    implements IQualityRequirement
{
    private String criteria;
    private Score value;

    public QualityRequirement(IQualityRequirement origin)
    {
        criteria = origin.getCriteria();
        value = origin.getValue();
    }

    public QualityRequirement()
    {
        // Default-Constructor
    }

    public String getCriteria()
  {
    return criteria;
  }

    public Score getValue() {
    return value;
  }

    public void setCriteria(String criteria)
  {
    this.criteria = criteria;
  }

    public void setValue(Score value) {
        this.value = value;
    }
}

