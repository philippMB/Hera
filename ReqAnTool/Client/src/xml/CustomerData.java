package xml;

public class CustomerData
{
  private String PMName;
  private String PMPNumber;
  private String PMEmail;
  private String CName;
  private String CNumber;
  private String CEMail;
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
    this.CEMail = CEmail;
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

  public String getPMEMail()
  {
    return PMEMail;
  }

  public String getCName()
  {
    return CName;
  }

  public String getCNumber()
  {
    return CNumber;
  }

  public String getCEMail()
  {
    return CEMail;
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
}
