package xml;

import javax.xml.bind.annotation.XmlAttribute;

public class CustomerData
{
  private String PMName;
  private String PMPNumber;
  private String PMEmail;
  private String CName;
  private String CNumber;
  private String CEmail;
  private String CompanyName;
  private String CompanyStreet;
  private int CompanyPLZ;
  private String Company;
  private String CompanyCountry;
  
  public CustomerData(String PMName, String PMPNumber, String PMEmail, String CName, String CNumber, String CEmail, String CompanyName, String CompanyStreet, int CompanyPLZ, String Company, String CompanyCountry)
  {
    this.PMName = PMName;
    this.PMPNumber = PMPNumber;
    this.PMEmail = PMEmail;
    this.CName = CName;
    this.CNumber = CNumber;
    this.CEmail = CEmail;
    this.CompanyName = CompanyName;
    this.CompanyStreet = CompanyStreet;
    this.CompanyPLZ = CompanyPLZ;
    this.Company = Company;
    this.CompanyCountry = CompanyCountry;
  }

  public String getPMName()
  {
    return PMName;
  }

  public String getPMPNumber()
  {
    return PMPNumber;
  }

  public String getPMEmail()
  {
    return PMEmail;
  }

  public String getCName()
  {
    return CName;
  }

  public String getCNumber()
  {
    return CNumber;
  }

  public String getCEmail()
  {
    return CEmail;
  }

  public String getCompanyName()
  {
    return CompanyName;
  }

  public String getCompanyStreet()
  {
    return CompanyStreet;
  }

  public int getCompanyPLZ()
  {
    return CompanyPLZ;
  }

  public String getCompanyCountry()
  {
    return CompanyCountry;
  }
  
  // für JavaBeans
  
  public CustomerData()
  {
    
  }

  public void setPMName(String PMName)
  {
    this.PMName = PMName;
  }

  public void setPMPNumber(String PMPNumber)
  {
    this.PMPNumber = PMPNumber;
  }

  public void setPMEmail(String PMEmail)
  {
    this.PMEmail = PMEmail;
  }

  public void setCName(String CName)
  {
    this.CName = CName;
  }

  public void setCNumber(String CNumber)
  {
    this.CNumber = CNumber;
  }

  public void setCEmail(String CEmail)
  {
    this.CEmail = CEmail;
  }

  public void setCompanyName(String CompanyName)
  {
    this.CompanyName = CompanyName;
  }

  public void setCompanyStreet(String CompanyStreet)
  {
    this.CompanyStreet = CompanyStreet;
  }

  public void setCompanyPLZ(int CompanyPLZ)
  {
    this.CompanyPLZ = CompanyPLZ;
  }

  public void setCompany(String Company)
  {
    this.Company = Company;
  }

  public String getCompany()
  {
    return Company;
  }

  public void setCompanyCountry(String CompanyCountry)
  {
    this.CompanyCountry = CompanyCountry;
  }
}
