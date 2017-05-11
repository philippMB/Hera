package Model;

import java.util.regex.Pattern;

/**
 * Created by mbill on 04.05.2017.
 */
public class Validator
{

    public boolean isValidEmail(String mail)
    {
        return Pattern.matches("[0-9a-zA-Z_.~-]+@[0-9a-zA-Z_.~-]\\.[a-zA-Z]" , mail);
    }

    public boolean isValidPhone(String phone)
    {

        if (Pattern.matches("0[1-9][0-9]*", phone))
        {
            return true;
        }
        else if (Pattern.matches("0[1-9][0-9][0-9][0-9] [1-9][0-9][0-9]+", phone))
        {
            return true;
        }
        else if (Pattern.matches("\\+[0-9][0-9][0-9]? [1-9][0-9]+[ ]?[1-9]([0-9]+)", phone))
        {
            return true;
        }
        else if (Pattern.matches("", phone))
        {
            return true;
        }
        return false;
    }

    public boolean isValidZIP(String zip)
    {
        return Pattern.matches("(0[1-9][0-9][0-9][0-9])|([1-9][0-9][0-9][0-9])", zip);
        // only validate European ZIPs
    }

    public boolean isValidID(String id)
    {
        return Pattern.matches("/[1-9]+/", id);
    }

    public boolean isValidCountry(String country)
    {
        return true;
    }

    public boolean isValidCity(String city)
    {
        return true;
    }

    public boolean isValidStreet(String street)
    {
        return true;
    }

    public boolean areValidValues(int det, int ftrOrRet)
    {
        if (det >= 0 && ftrOrRet >= 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
