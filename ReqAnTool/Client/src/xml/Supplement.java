package xml;

import Model_Interfaces.IAddition;

public class Supplement
    implements IAddition
{
  private String description;
  private String title;

    public Supplement(IAddition origin)
    {
        description = origin.getDescription();
        title = origin.getTitle();
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
