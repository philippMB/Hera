package Model_Interfaces;

/**
 * The CustomerData of the requirement analysis.
 * Contains the name, phone number, and email of the project manager and the client. Also contains the name, street,
 * postal code, city and country of the company.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
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
    String getPMName();

    /**
     * Get the phone number of the project manager.
     * @return A String containing the phone number.
     */
    String getPMPNumber();

    /**
     * Get the email address of the project manager.
     * @return A String containing the email address.
     */
    String getPMEMail();

    /**
     * Get the name of the client.
     * @return A String containing the name.
     */
    String getCName();

    /**
     * Get the phone number of the client.
     * @return A String containing the phone number.
     */
    String getCNumber();

    /**
     * Get the email address of the client.
     * @return A String containing the email address.
     */
    String getCEMail();

    /**
     * Get the company name.
     * @return A String containing the name.
     */
    String getCompanyName();

    /**
     * Get the street where the company has its headquarter.
     * @return A String containing the street.
     */
    String getCompanyStreet();

    /**
     * Get the postal code of the city where the company has its headquarter.
     * @return A String containing the postal code.
     */
    String getCompanyPLZ();

    /**
     * Get the city where the company has its headquarter.
     * @return A String containing the city.
     */
    String getCompanyCity();

    /**
     * Get the country where the company has its headquarter.
     * @return A String containing the country.
     */
    String getCompanyCountry();

}

