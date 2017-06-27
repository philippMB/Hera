package Model;

import Exceptions.NumberOutOfBoundsException;

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

    public void validateDET(int det) throws Exception
    {
        if (det < 0)
        {
            throw new NumberOutOfBoundsException(det, 0, Double.POSITIVE_INFINITY);
        }

    }

    public void validateRET(int ret) throws Exception
    {
        if (ret < 0)
        {
            throw new NumberOutOfBoundsException(ret, 0, Double.POSITIVE_INFINITY);
        }

    }

    public void validateFTR(int ftr) throws Exception
    {
        if (ftr < 0)
        {
            throw new NumberOutOfBoundsException(ftr, 0, Double.POSITIVE_INFINITY);
        }

    }

}
