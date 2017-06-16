package xml;

import Model_Interfaces.IProductData;

public class ProductData
        extends Requirement
        implements IProductData
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
  
  // für JavaBeans
  
  public ProductData()
  {
    // Default-Constructor
  }

  public void setAttribute(String attribute)
  {
    this.attribute = attribute;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  public void setMaxCount(String maxCount)
  {
    this.maxCount = maxCount;
  }
}
