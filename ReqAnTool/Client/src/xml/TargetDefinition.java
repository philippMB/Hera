package xml;

import Model_Interfaces.ITargetDefinition;

public class TargetDefinition
    implements ITargetDefinition
{
  private String description;

    public TargetDefinition(ITargetDefinition origin)
    {
        description = origin.getDescription();
    }

    public TargetDefinition()
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
