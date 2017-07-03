package Model;

import Exceptions.ListOverflowException;
import Model_Interfaces.ITargetDefinition;

public class TargetDefinition
    implements ITargetDefinition
{

    private String description;

    public TargetDefinition()
    {
        this.description = null;

    }

    @Override
    public String getDescription()
    {
        return description;

    }

    public void edit(String description) throws ListOverflowException
    {
        if (description.length() > 20000)
        {
            throw new ListOverflowException(String.class, "Target Definition");
        }
        this.description = description;

    }
}
