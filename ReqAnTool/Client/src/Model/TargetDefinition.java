package Model;

import Model_Interfaces.ITargetDefinition;

public class TargetDefinition
    implements ITargetDefinition
{

    private String description;

    @Override
    public String getDescription()
    {
        return description;
    }

}
