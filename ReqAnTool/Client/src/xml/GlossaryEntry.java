package xml;

import Model_Interfaces.IGlossaryEntry;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;

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

  public GlossaryEntry()
  {
    // Default-Constructor
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

  @Override
  public ArrayList<IGlossaryEntry> getReferences() {
    // nicht implementiert
    return null;
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

}
