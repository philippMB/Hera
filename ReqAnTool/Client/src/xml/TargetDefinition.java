package xml;

public class TargetDefinition
{
  private String description;
  
  public TargetDefinition(String description)
  {
    this.description = description ;
  }

  public String getDescription()
  {
    return description;
  }
  
  // für JavaBeans
  public void setDescription(String description)
  {
    this.description = description;
  }
}
