package Model;

import Model_Interfaces.ErrorCodes;
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

    public FRequirement(String id, String title, String actor, String description, ArrayList<IRequirement> references)
    {
        super(id, references);
        this.title = title;
        this.actor = actor;
        this.description = description;
    }

    public ErrorCodes edit(String id, String title, String actor, String description, ArrayList<IRequirement> references)
    {
        super.edit(id, references);
        this.title = title;
        this.actor = actor;
        this.description = description;
        return ErrorCodes.NO_ERROR;
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
