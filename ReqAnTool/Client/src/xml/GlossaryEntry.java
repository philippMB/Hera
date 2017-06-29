package xml;

import Model_Interfaces.IGlossaryEntry;

import java.util.ArrayList;

/**
 * Class to hold the GlossaryEntry of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link IGlossaryEntry} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IGlossaryEntry
 * @see CustomXMLFormat
 */
public class GlossaryEntry
        implements IGlossaryEntry
{
    private String term;
    private String sense;
    private String boundary;
    private String label;
    private String validity;
    private String obscurities;
    private ArrayList<String> referenceTerms;

    /**
     * The constructor for the GlossaryEntry class.
     * The data from the original GlossaryEntry instance is copied into this JAXB conform class.
     * @param origin The GlossaryEntry instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public GlossaryEntry(IGlossaryEntry origin)
    {
        term = origin.getTerm();
        sense = origin.getSense();
        boundary = origin.getBoundary();
        label = origin.getLabel();
        validity = origin.getValidity();
        obscurities = origin.getObscurities();
        referenceTerms = origin.getReferenceTerms();
    }

    /**
     * The default constructor for the GlossaryEntry class.
     * Must be provided to be JAXB conform.
     */
    public GlossaryEntry()
    {
    }

    public String getTerm()
    {
        return term;
    }

    public String getSense()
    {
        return sense;
    }

    public String getBoundary()
    {
        return boundary;
    }

    public String getLabel()
    {
        return label;
    }

    public String getValidity()
    {
        return validity;
    }

    public String getObscurities()
    {
        return obscurities;
    }

    public ArrayList<String> getReferenceTerms()
    {
        return referenceTerms;
    }

    public void setTerm(String term)
    {
        this.term = term;
    }

    public void setSense(String sense)
    {
        this.sense = sense;
    }

    public void setBoundary(String boundary)
    {
        this.boundary = boundary;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public void setValidity(String validity)
    {
        this.validity = validity;
    }

    public void setObscurities(String obscurities)
    {
        this.obscurities = obscurities;
    }

    public void setReferenceTerms(ArrayList<String> referenceTerms)
    {
        this.referenceTerms = referenceTerms;
    }

    /**
     * This method from the {@link IGlossaryEntry} interface is not implemented, because only the data should be available,
     * no functionality should be provided.
     * @return Always returns null.
     */
    @Override
    public ArrayList<IGlossaryEntry> getReferences() {
        return null;
    }
}
