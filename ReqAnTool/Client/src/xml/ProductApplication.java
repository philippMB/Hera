package xml;

public class ProductApplication
{
  private String description;
  
  public ProductApplication(String description)
  {
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }
  
  // für JavaBeans
  
  public ProductApplication()
  {
    
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
}
