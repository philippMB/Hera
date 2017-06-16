package xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;

public class GlossaryEntry
{
  private String term;
  private String sense;
  private String boundary;
  private String label;
  private String validity;
  private String obscurities;
  private ArrayList<String> references;

  public GlossaryEntry(String term, String sense, String boundary, String label, String validity, String obscurities)
  {
    this.term = term;
    this.sense = sense;
    this.boundary = boundary;
    this.label = label;
    this.validity = validity;
    this.obscurities = obscurities;
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
  
  // für JavaBeans
  
  public GlossaryEntry()
  {
    // Default-Constructor
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

  public void setReferences(ArrayList<String> references)
  {
    this.references = references;
  }

  public ArrayList<String> getReferences()
  {
    return references;
  }
}
