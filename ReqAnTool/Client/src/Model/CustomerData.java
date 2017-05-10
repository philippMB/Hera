package Model;

import Model_Interfaces.ErrorCodes;
import Model_Interfaces.ICustomerData;

import java.util.ArrayList;

public class CustomerData 
    implements ICustomerData
{
    
    private String companyName;
    private String companyStreet;
    private String zip;
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
        this.zip = null;
        this.customer = null;
        this.myValidator = new Validator();
    }

    public ArrayList<ErrorCodes> edit(String companyName, String companyCity, String companyStreet, String zip, String companyCountry,
                                     String custName, String custMail, String custPhone, String pmName, String pmMail, String pmPhone)
    {
        ArrayList<ErrorCodes> myErrors = new ArrayList<ErrorCodes>();
        boolean error = false;
        if (!validMail(custMail, pmMail))
        {
            error = true;
            myErrors.add(ErrorCodes.INVALID_MAIL);
        }
        if (!validPhone(custPhone, pmPhone))
        {
            error = true;
            myErrors.add(ErrorCodes.INVALID_PHONE);
        }
        if (!validAdress(companyCountry, companyCity, companyStreet, zip))
        {
            error = true;
            myErrors.add(ErrorCodes.INVALID_ADRESS);
        }
        if (!error)
        {
            this.companyName = companyName;
            this.city = companyCity;
            this.companyStreet = companyStreet;
            this.zip = zip;
            this.country = companyCountry;
            this.customer = new PersonalData(custName, custMail, custPhone);
            this.projectManager = new PersonalData(pmName, pmMail, pmPhone);
            myErrors.add(ErrorCodes.NO_ERROR);
        }
        return myErrors;
    }

    private boolean validAdress(String companyCountry, String companyCity, String companyStreet, String zip)
    {
        boolean validCountry = myValidator.isValidCountry(companyCountry);
        boolean validCity = myValidator.isValidCity(companyCity);
        boolean validStreet = myValidator.isValidStreet(companyStreet);
        boolean validZIP = myValidator.isValidZIP(zip);
        if (validCountry && validCity && validStreet && validZIP)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean validMail(String custMail, String pmMail)
    {
        boolean validCustMail = myValidator.isValidEmail(custMail);
        boolean validpmMail = myValidator.isValidEmail(pmMail);
        if (validCustMail && validpmMail)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean validPhone(String custPhone, String pmPhone)
    {
        boolean validCustPhone = myValidator.isValidEmail(custPhone);
        boolean validpmPhone = myValidator.isValidEmail(pmPhone);
        if (validCustPhone && validpmPhone)
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
    public String getCompanyPLZ()
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
