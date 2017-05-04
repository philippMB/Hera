package xml;

import javax.xml.bind.annotation.XmlAttribute;
// Needs refactoring in accessors
public class CustomerData
{
  private String pmName;
  private String pmPNumber;
  private String pmEMail;
  private String cName;
  private String cNumber;
  private String cEMail;
  private String companyName;
  private String companyStreet;
  private int companyPLZ;
  private String companyCity;
  private String companyCountry;
  
  public CustomerData(String pmName, String pmPNumber, String pmEMail, String cName, String cNumber, String cEMail, String companyName, String companyStreet, int companyPLZ, String companyCity, String companyCountry)
  {
    this.pmName = pmName;
    this.pmPNumber = pmPNumber;
    this.pmEMail = pmEMail;
    this.cName = cName;
    this.cNumber = cNumber;
    this.cEMail = cEMail;
    this.companyName = companyName;
    this.companyStreet = companyStreet;
    this.companyPLZ = companyPLZ;
    this.companyCity = companyCity;
    this.companyCountry = companyCountry;
  }

  public String getPmName()
  {
    return pmName;
  }

  public String getPmPNumber()
  {
    return pmPNumber;
  }

  public String getPmEMail()
  {
    return pmEMail;
  }

  public String getCName()
  {
    return cName;
  }

  public String getCNumber()
  {
    return cNumber;
  }

  public String getCEMail()
  {
    return cEMail;
  }

  public String getCompanyName()
  {
    return companyName;
  }

  public String getCompanyStreet()
  {
    return companyStreet;
  }

  public int getCompanyPLZ()
  {
    return companyPLZ;
  }

  public String getCompanyCountry()
  {
    return companyCountry;
  }
  
  // für JavaBeans
  
  public CustomerData()
  {
    
  }

  public void setPmName(String PMName)
  {
    this.pmName = PMName;
  }

  public void setPmPNumber(String PMPNumber)
  {
    this.pmPNumber = PMPNumber;
  }

  public void setPmEMail(String PMEmail)
  {
    this.pmEMail = PMEmail;
  }

  public void setCName(String CName)
  {
    this.cName = CName;
  }

  public void setCNumber(String CNumber)
  {
    this.cNumber = CNumber;
  }

  public void setCEMail(String CEmail)
  {
    this.cEMail = CEmail;
  }

  public void setCompanyName(String CompanyName)
  {
    this.companyName = CompanyName;
  }

  public void setCompanyStreet(String CompanyStreet)
  {
    this.companyStreet = CompanyStreet;
  }

  public void setCompanyPLZ(int CompanyPLZ)
  {
    this.companyPLZ = CompanyPLZ;
  }

  public void setCompanyCity(String Company)
  {
    this.companyCity = Company;
  }

  public String getCompanyCity()
  {
    return companyCity;
  }

  public void setCompanyCountry(String CompanyCountry)
  {
    this.companyCountry = CompanyCountry;
  }
}
