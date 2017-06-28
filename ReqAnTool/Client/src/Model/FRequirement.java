package Model;

import Model_Interfaces.IFRequirement;

import Model_Interfaces.IRequirement;

public class FRequirement
    extends Requirement
    implements IFRequirement
{

    private String title;
    private String actor;
    private String description;

    public FRequirement(String id, String title, String actor, String description,
                        RequirementList<IRequirement> references)
    {
        super(id, references);
        this.title = title;
        this.actor = actor;
        this.description = description;
    }

    public void edit(String id, String title, String actor, String description,
                           RequirementList<IRequirement> references)
    {
        super.edit(id, references);
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
