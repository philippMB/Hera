package xml;

public class QualityRequirement
{
  private String criteria;

  public QualityRequirement(String criteria)
  {
    this.criteria = criteria;
  }

  public String getCriteria()
  {
    return criteria;
  }
  
  // für JavaBeans

  public QualityRequirement()
  {
    
  }

  public void setCriteria(String criteria)
  {
    this.criteria = criteria;
  }
}

