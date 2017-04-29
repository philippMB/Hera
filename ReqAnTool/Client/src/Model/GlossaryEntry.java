package Model;

import Model_Interfaces.IGlossaryEntry;

import java.util.ArrayList;

public class GlossaryEntry
    implements IGlossaryEntry
{
    private String term;
    private String sense;
    private String boundary;
    private String validity;
    private String obscurities;
    private String label;

    /**
     * @associates <{Model.GlossaryEntry}>
     */
    private ArrayList<GlossaryEntry> crossReferences;

    @Override
    public String getTerm()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getSense()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getBoundary()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getLabel()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getValidity()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getObscurities()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public ArrayList<IGlossaryEntry> getReferences()
    {
        // TODO Implement this method
        return null;
    }
}
