package Model;

import Model_Interfaces.IAddition;

public class Addition 
    implements IAddition
{
    private String title;
    private String description;

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
}
