package Model;

import Model_Interfaces.IAddition;

public class Addition 
    implements IAddition
{
    private String title;
    private String description;

    Addition(String title, String description)
    {
        this.title = title;
        this.description = description;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    public void edit(String title, String description)
    {
        this.title = title;
        this.description = description;

    }
}
