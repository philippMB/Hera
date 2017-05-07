package Model;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.ICustomerData;

public class CustomerData 
    implements ICustomerData
{
    
    private String companyName;
    private String companyStreet;
    private int zip;
    private String city;
    private String country;
    private PersonalData customer;
    private PersonalData projectManager;
    private Validator myValidator;

    CustomerData(String pmName, String pmMail, String pmPhone)
    {
        this.projectManager = new PersonalData(pmName, pmMail, pmPhone);
        this.companyName = null;
        this.city = null;
        this.companyStreet = null;
        this.country = null;
        this.zip = -1;
        this.customer = null;
        this.myValidator = new Validator();
    }

    public ErrorCodes edit(String companyName, String companyCity, String companyStreet, int zip, String companyCountry,
                    String custName, String custMail, String custPhone, String pmName, String pmMail, String pmPhone)
    {
        if(validMailAndPhone(custMail, custPhone, pmMail, pmPhone))
        {
            this.companyName = companyName;
            this.city = companyCity;
            this.companyStreet = companyStreet;
            this.zip = zip;
            this.country = companyCountry;
            this.customer = new PersonalData(custName, custMail, custPhone);
            this.projectManager = new PersonalData(pmName, pmMail, pmPhone);
            return ErrorCodes.NO_ERROR;
        }
        else
        {
            return ErrorCodes.FORMAT_MISMATCH;
        }
    }

    private boolean validMailAndPhone(String custMail, String custPhone, String pmMail, String pmPhone)
    {
        boolean validCustMail = myValidator.isValidEmail(custMail);
        boolean validpmMail = myValidator.isValidEmail(pmMail);
        boolean validCustPhone = myValidator.isValidPhone(custPhone);
        boolean validpmPhone = myValidator.isValidPhone(pmPhone);
        if (validCustMail && validCustPhone && validpmMail && validpmPhone)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String getPMName()
    {
        return projectManager.getName();
    }

    @Override
    public String getPMPNumber()
    {
        return projectManager.getPhoneNumber();
    }

    @Override
    public String getPMEMail()
    {
        return projectManager.getMailAddress();
    }

    @Override
    public String getCName()
    {
        return customer.getName();
    }

    @Override
    public String getCNumber()
    {
        return customer.getPhoneNumber();
    }

    @Override
    public String getCEMail()
    {
        return customer.getMailAddress();
    }

    @Override
    public String getCompanyName()
    {
        return companyName;
    }

    @Override
    public String getCompanyStreet()
    {
        return companyStreet;
    }

    @Override
    public int getCompanyPLZ()
    {
        return zip;
    }

    @Override
    public String getCompanyCity()
    {
        return city;
    }

    @Override
    public String getCompanyCountry()
    {
        return country;
    }

}
