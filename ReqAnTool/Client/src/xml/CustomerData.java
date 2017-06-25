package xml;

import Model_Interfaces.ICustomerData;

public class CustomerData
  implements ICustomerData
{
  private String pMName;
  private String pMPNumber;
  private String pMEMail;
  private String cName;
  private String cNumber;
  private String cEMail;
  private String companyName;
  private String companyStreet;
  private int companyPLZ;
  private String companyCity;
  private String companyCountry;

  public CustomerData(ICustomerData origin)
  {
    pMName = origin.getPMName();
    pMPNumber = origin.getPMPNumber();
    pMEMail = origin.getPMEMail();
    cName = origin.getCName();
    cNumber = origin.getCNumber();
    cEMail = origin.getCEMail();
    companyName = origin.getCompanyName();
    companyPLZ = origin.getCompanyPLZ();
    companyCity = origin.getCompanyCity();
    companyCountry = origin.getCompanyCountry();
  }

  public CustomerData()
  {
    // Default Constructor
  }

  public String getPMName()
  {
    return pMName;
  }

  public String getPMPNumber()
  {
    return pMPNumber;
  }

  public String getPMEMail()
  {
    return pMEMail;
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

    public String getCompanyCity()
    {
        return companyCity;
    }

    public String getCompanyCountry()
  {
    return companyCountry;
  }
  
  public void setPMName(String PMName)
  {
    this.pMName = PMName;
  }

  public void setPMPNumber(String PMPNumber)
  {
    this.pMPNumber = PMPNumber;
  }

  public void setPMEMail(String PMEmail)
  {
    this.pMEMail = PMEmail;
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

  public void setCompanyCountry(String CompanyCountry)
  {
    this.companyCountry = CompanyCountry;
  }
}
