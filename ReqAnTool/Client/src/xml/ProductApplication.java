package xml;

import Model_Interfaces.IProductApplication;

public class ProductApplication
    implements IProductApplication
{
    private String description;

    public ProductApplication(IProductApplication origin)
    {
        description = origin.getDescription();
    }

    public ProductApplication()
    {
        // Default-Constructor
    }

    public String getDescription()
  {
    return description;
  }

    public void setDescription(String description)
  {
    this.description = description;
  }
}
