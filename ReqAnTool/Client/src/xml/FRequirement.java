package xml;

public class FRequirement
{
  private String title;
  private String actor;
  private String description;
  
  public FRequirement(String title, String actor, String description)
  {
    this.title = title;
    this.actor = actor;
    this.description = description;
  }

  public String getTitle()
  {
    return title;
  }

  public String getActor()
  {
    return actor;
  }

  public String getDescription()
  {
    return description;
  }
  
  // für JavaBeans
  public void setTitle(String title)
  {
    this.title = title;
  }

  public void setActor(String actor)
  {
    this.actor = actor;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}
