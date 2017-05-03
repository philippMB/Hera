package Model;

import Model_Interfaces.INFRequirement;

import Model_Interfaces.IRequirement;

import java.util.ArrayList;
import java.util.List;

public class NFRequirement
    extends Requirement
    implements INFRequirement
{

    private String title;
    private String actor;
    private String description;

    NFRequirement(String id, String title, String actor, String description, ArrayList<IRequirement> references)
    {
        super(id, references);
        this.title = title;
        this.actor = actor;
        this.description = description;
    }


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
