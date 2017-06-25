package xml;

import Model_Interfaces.IProductData;

public class ProductData
        extends Requirement
        implements IProductData
{
  private String attribute;
  private String content;
  private String maxCount;

    public ProductData(IProductData origin)
    {
        attribute = origin.getAttribute();
        content = origin.getContent();
        maxCount = origin.getMaxCount();
    }

    public ProductData()
    {
        // Default-Constructor
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
