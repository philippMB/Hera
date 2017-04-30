package xml;

public class GlossaryEntry
{
  private String term;
  private String sense;
  private String boundary;
  private String label;
  private String validity;
  private String obscurities;
  
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
}
