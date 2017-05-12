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
        boolean isValid = false;
        if (Pattern.matches("0[1-9][0-9]*", phone))
        {
            isValid = true;
        }
        else if (Pattern.matches("0[1-9][0-9][0-9][0-9] [1-9][0-9][0-9]+", phone))
        {
            isValid = true;
        }
        else if (Pattern.matches("\\+[0-9][0-9][0-9]? [1-9][0-9]+[ ]?[1-9]([0-9]+)", phone))
        {
            isValid = true;
        }
        else if (Pattern.matches("", phone))
        {
            isValid = true;
        }
        return isValid;

    }

    public boolean isValidZIP(String zip)
    {
        return Pattern.matches("(0[1-9][0-9][0-9][0-9])|([1-9][0-9][0-9][0-9])", zip);
        // only validate European ZIPs

    }

    public boolean isValidID(String id)
    {
        return true;
        // suggestion for id Format: return Pattern.matches("/[A-Z][A-Z][1-9]+/", id);

    }

    public boolean isValidCountry(String country)
    {
        return true;
        // for subsequent Applications

    }

    public boolean isValidCity(String city)
    {
        return true;
        // for subsequent Applications

    }

    public boolean isValidStreet(String street)
    {
        return true;
        // for subsequent Applications

    }

    public boolean isValidDET(int det)
    {
        boolean isValid = false;
        if (det >= 0)
        {
            isValid = true;
        }
        return isValid;

    }

    public boolean isValidRET(int ret)
    {
        boolean isValid = false;
        if (ret >= 0)
        {
            isValid = true;
        }
        return isValid;

    }

    public boolean isValidFTR(int ftr)
    {
        boolean isValid = false;
        if (ftr >= 0)
        {
            isValid = true;
        }
        return isValid;

    }

}
