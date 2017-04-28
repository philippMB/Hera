package xml;

public class WeightFactor
{
  private String title;
  private int value;
  private int minValue;
  private int maxValue;
  
  public WeightFactor(String title, int value, int minValue, int maxValue)
  {
    this.title = title;
    this.value = value;
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  public String getTitle()
  {
    return title;
  }

  public int getValue()
  {
    return value;
  }

  public int getMinValue()
  {
    return minValue;
  }

  public int getMaxValue()
  {
    return maxValue;
  }
}
