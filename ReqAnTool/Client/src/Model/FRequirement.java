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
    public String getID()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getTitle()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getActor()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getDescription()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<IRequirement> getReferences()
    {
        // TODO Implement this method
        return null;
    }
}
