package xml;

public class WeightFactor
{
  private String title;
  private int value;
  private int maxValue;
  
  public WeightFactor(String title, int value, int maxValue)
  {
    this.title = title;
    this.value = value;
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

  public int getMaxValue()
  {
    return maxValue;
  }
  
  // für JavaBeans
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
