package xml;

public class NFRequirement
{
  private String title;
  private String actor;
  private String description;
  
  public NFRequirement(String title, String actor, String description)
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
}
