package xml;

import Model_Interfaces.INFRequirement;

public class NFRequirement
        extends Requirement
        implements INFRequirement
{
    private String title;
    private String actor;
    private String description;

    public NFRequirement(INFRequirement origin)
    {
        super(origin);
        title = origin.getTitle();
        actor = origin.getActor();
        description = origin.getDescription();
    }

    public NFRequirement()
    {
        // Default-Constructor
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
