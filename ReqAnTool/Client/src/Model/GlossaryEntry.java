package Model;

import Model_Interfaces.ErrorCodes;
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
    private GlossaryList<IGlossaryEntry> crossReferences;

    GlossaryEntry(String term, String sense, String boundary, String validity, String obscurities, String label,
                  GlossaryList<IGlossaryEntry> crossRef)
    {
        this.term = term;
        this.sense = sense;
        this.boundary = boundary;
        this.validity = validity;
        this.obscurities = obscurities;
        this.label = label;
        this.crossReferences = crossRef;
    }

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

    public ErrorCodes edit(String term, String sense, String boundary, String validity, String obscurities,
                           String label, GlossaryList<IGlossaryEntry> crossRef)
    {
        this.term = term;
        this.sense = sense;
        this.boundary = boundary;
        this.validity = validity;
        this.obscurities = obscurities;
        this.label = label;
        this.crossReferences = crossRef;
        return ErrorCodes.NO_ERROR;
    }

    public void remReference(String term)
    {
        crossReferences.removeEntryByTerm(term);
    }
}
