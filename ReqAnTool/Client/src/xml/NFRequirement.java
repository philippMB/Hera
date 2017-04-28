package xml;

public class NFRequirement
{
  private String id;
  private String title;
  private String actor;
  private String description;
  
  public NFRequirement(String id, String title, String actor, String description)
  {
    this.id = id;
    this.title = title;
    this.actor = actor;
    this.description = description;
  }

  public String getId()
  {
    return id;
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
