package Model;

import Model_Interfaces.IRequirement;

import java.util.ArrayList;
import java.util.List;

public abstract class Requirement
    implements IRequirement
{

    protected String id;

    /**
     * @associates <{Model.Requirement}>
     */
    private ArrayList<Requirement> references;
    
    @Override
    public abstract String getID();

    @Override
    public abstract ArrayList<IRequirement> getReferences();

}
