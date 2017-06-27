package Model;

import Exceptions.ArgumentPatternException;
import Exceptions.PatternType;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.ICustomerData;

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

    CustomerData(String pmName, String pmMail, String pmPhone, String companyName, String city, String companyStreet,
                 String country, String zip, String cName, String cMail, String cPhone)
    {
        this.projectManager = new PersonalData(pmName, pmMail, pmPhone);
        this.companyName = companyName;
        this.city = city;
        this.companyStreet = companyStreet;
        this.country = country;
        this.zip = zip;
        this.customer = new PersonalData(cName, cMail, cPhone);
        this.myValidator = new Validator();
    }

    public void edit(String companyName, String companyCity, String companyStreet, String zip,
                                      String companyCountry, String custName, String custMail, String custPhone,
                                      String pmName, String pmMail, String pmPhone)
            throws Exception
    {
        validateMail(custMail, pmMail);
        validatePhone(custPhone, pmPhone);
        validateAdress(companyCountry, companyCity, companyStreet, zip);

        this.companyName = companyName;
        this.city = companyCity;
        this.companyStreet = companyStreet;
        this.zip = zip;
        this.country = companyCountry;
        this.customer = new PersonalData(custName, custMail, custPhone);
        this.projectManager = new PersonalData(pmName, pmMail, pmPhone);

    }

    private void validateAdress(String companyCountry, String companyCity, String companyStreet, String zip)
            throws Exception
    {
        boolean validCountry = myValidator.isValidCountry(companyCountry);
        boolean validCity = myValidator.isValidCity(companyCity);
        boolean validStreet = myValidator.isValidStreet(companyStreet);
        boolean validZIP = myValidator.isValidZIP(zip);
        if (!(validCountry && validCity && validStreet && validZIP))
        {
            throw new ArgumentPatternException(PatternType.ADDRESS, companyStreet + ", " + zip + " " + companyCity + ", " +
                                            companyCountry, "Mercedesstr. 121, 70546 Stuttgart, Germany" );
        }
    }

    private void validateMail(String custMail, String pmMail) throws Exception
    {
        boolean validCustMail = myValidator.isValidEmail(custMail);
        boolean validpmMail = myValidator.isValidEmail(pmMail);
        if (!validCustMail)
        {
            throw new ArgumentPatternException(PatternType.EMAIL, custMail, "max.mustermann@gmail.com");
        }
        if (!validpmMail)
        {
            throw new ArgumentPatternException(PatternType.EMAIL, pmMail, "max.mustermann@gmail.com");
        }

    }

    private void validatePhone(String custPhone, String pmPhone) throws Exception
    {
        boolean validCustPhone = myValidator.isValidPhone(custPhone);
        boolean validpmPhone = myValidator.isValidPhone(pmPhone);
        if (!validCustPhone)
        {
            throw new ArgumentPatternException(PatternType.TELEPHONE_NUMBER, custPhone, "+49 711 123647");
        }
        if (!validpmPhone)
        {
            throw new ArgumentPatternException(PatternType.TELEPHONE_NUMBER, pmPhone, "+49 711 123647");
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
