package xml;

import Model_Interfaces.ICustomerData;

/**
 * Class to hold the CustomerData of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link ICustomerData} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see ICustomerData
 * @see CustomXMLFormat
 */
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
  private String companyPLZ;
  private String companyCity;
  private String companyCountry;

    /**
     * The constructor for the CustomerData class.
     * The data from the original CustomerData instance is copied into this JAXB conform class.
     * @param origin The CustomerData instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
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

    /**
     * The default constructor for the CustomerData class.
     * Must be provided to be JAXB conform.
     */
    public CustomerData()
    {
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

    public String getCompanyPLZ()
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

    public void setCompanyPLZ(String CompanyPLZ)
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
