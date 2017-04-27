package Model;

import java.util.List;

public abstract class Requirement 
{

    protected String id;

    /**
     * @associates <{Model.Requirement}>
     */
    private List references;
}
