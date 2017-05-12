package Model;

public class PersonalData 
{

    private String phoneNumber;
    private String name;
    private String mailAddress;

    PersonalData(String name, String mail, String phone)
    {
        this.name = name;
        this.mailAddress = mail;
        this.phoneNumber = phone;

    }

    public String getName()
    {
        return name;

    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;

    }
    public String getMailAddress()
    {
        return mailAddress;

    }

}
