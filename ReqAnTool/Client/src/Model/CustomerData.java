package Model;

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

    @Override
    public String getPMName()
    {
        // TODO Implement this method
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
