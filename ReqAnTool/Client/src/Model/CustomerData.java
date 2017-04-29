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
        return null;
    }

    @Override
    public String getPMPNumber()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getPMEMail()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getCName()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getCNumber()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getCEMail()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getCompanyName()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getCompanyStreet()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public int getCompanyPLZ()
    {
        // TODO Implement this method
        return 0;
    }

    @Override
    public String getCompany()
    {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getCompanyCountry()
    {
        // TODO Implement this method
        return null;
    }

}
