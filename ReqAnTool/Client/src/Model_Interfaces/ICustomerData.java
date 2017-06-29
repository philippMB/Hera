package Model_Interfaces;

/**
 * Created by phlippe on 26.04.17.
 */

/**
 * The CustomerData of the requirement analysis.
 * Contains the name, phone number, and email of the project manager and the client. Also contains the name, street,
 * postal code, city and country of the company.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface ICustomerData 
{

    /**
     * Get the name of the project manager.
     * @return A String containing the name.
     */
    public String getPMName();

    /**
     * Get the phone number of the project manager.
     * @return A String containing the phone number.
     */
    public String getPMPNumber();

    /**
     * Get the email address of the project manager.
     * @return A String containing the email address.
     */
    public String getPMEMail();

    /**
     * Get the name of the client.
     * @return A String containing the name.
     */
    public String getCName();

    /**
     * Get the phone number of the client.
     * @return A String containing the phone number.
     */
    public String getCNumber();

    /**
     * Get the email address of the client.
     * @return A String containing the email address.
     */
    public String getCEMail();

    /**
     * Get the company name.
     * @return A String containing the name.
     */
    public String getCompanyName();

    /**
     * Get the street where the company has its headquarter.
     * @return A String containing the street.
     */
    public String getCompanyStreet();

    /**
     * Get the postal code of the city where the company has its headquarter.
     * @return A String containing the postal code.
     */
    public String getCompanyPLZ();

    /**
     * Get the city where the company has its headquarter.
     * @return A String containing the city.
     */
    public String getCompanyCity();

    /**
     * Get the country where the company has its headquarter.
     * @return A String containing the country.
     */
    public String getCompanyCountry();

}
