package Model;

import Model_Interfaces.IGlossaryEntry;

import Model_Interfaces.IRequirement;

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
    private ArrayList<IGlossaryEntry> crossReferences;

    @Override
    public String getTerm()
    {
        return term;
    }

    @Override
    public String getSense()
    {
        return sense;
    }

    @Override
    public String getBoundary()
    {
        return boundary;
    }

    @Override
    public String getLabel()
    {
        return label;
    }

    @Override
    public String getValidity()
    {
        return validity;
    }

    @Override
    public String getObscurities()
    {
        return obscurities;
    }

    @Override
    public ArrayList<String> getReferenceTerms()
    {
        ArrayList<String> terms = new ArrayList<String>();
        for (IGlossaryEntry ref : crossReferences)
        {
            terms.add(ref.getTerm());
        }
        return terms;
    }

    @Override
    public ArrayList<IGlossaryEntry> getReferences()
    {
        return crossReferences;
    }
}
