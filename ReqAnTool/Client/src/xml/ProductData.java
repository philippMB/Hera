package xml;

public class ProductData
{
  private String attribute;
  private String content;
  private String maxCount;
  
  public ProductData(String attribute, String content, String maxCount)
  {
    this.attribute = attribute;
    this.content = content;
    this.maxCount = maxCount;
  }

  public String getAttribute()
  {
    return attribute;
  }

  public String getContent()
  {
    return content;
  }

  public String getMaxCount()
  {
    return maxCount;
  }
}
