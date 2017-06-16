package xml;

import Model_Interfaces.IFRequirement;

import java.util.ArrayList;


public class FRequirement
        extends Requirement
        implements IFRequirement
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

  public FRequirement(IFRequirement origin)
  {
    super(origin);
    title = origin.getTitle();
    actor = origin.getActor();
    description = origin.getDescription();
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
  
  public FRequirement()
  {
    // Default-Constructor
  }
  
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
