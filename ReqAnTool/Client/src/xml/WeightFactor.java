package xml;

import Model_Interfaces.IWeightFactor;

public class WeightFactor
    implements IWeightFactor
{
    private String title;
    private int value;
    private int maxValue;

    public  WeightFactor(IWeightFactor origin)
    {
        title = origin.getTitle();
        value = origin.getValue();
        maxValue = origin.getMaxValue();
    }

    public WeightFactor()
    {
        // Default-Constructor
    }

    public String getTitle()
  {
    return title;
  }

    public int getValue()
  {
    return value;
  }

    public int getMaxValue()
  {
    return maxValue;
  }
  
    public void setTitle(String title)
  {
    this.title = title;
  }

    public void setValue(int value)
  {
    this.value = value;
  }

    public void setMaxValue(int maxValue)
  {
    this.maxValue = maxValue;
  }
}
