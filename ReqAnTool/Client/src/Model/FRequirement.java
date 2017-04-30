package Model;

import Model_Interfaces.IFRequirement;

import Model_Interfaces.IRequirement;

import java.util.ArrayList;
import java.util.List;

public class FRequirement
    extends Requirement
    implements IFRequirement
{

    private String title;
    private String actor;
    private String description;


    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public String getActor()
    {
        return actor;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

}
