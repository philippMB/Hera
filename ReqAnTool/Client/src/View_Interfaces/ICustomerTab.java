package View_Interfaces;

/**
 * This tab interface provides functionality to edit the saved information about the customer.
 * The tab has multiple text fields in which the user can enter information about the customer of this project. In
 * addition this view has two view actions which the user can take:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#SAVE} - saves the new information in the requirement analysis</li>
 *     <li>{@link Controller_Interfaces.ViewActions#EDIT_CE} - resets all text fields to the saved information
 *     (use {@link ICustomerTab#resetData()}</li>
 * </ul>
 * Besides being a tab views of this interface could also be controlled on changes in text fields. This is done by
 * extending {@link ITextView} that allow {@link Controller_Interfaces.ITextController} to observe these fields and
 * being notified whenever there is a change.
 *
 *
 * @author 9045534
 * @version 1.0
 * @see ITab
 * @see ITextView
 */
public interface ICustomerTab
	extends ITab, ITextView
{

	/**
	 * Returns the entry of the text field for the customer name.
	 * @return Entry for customer name
	 */
	public String getCustName();

	/**
	 * Returns the entry of the text field for the customer phone number.
	 * @return Entry for customer phone number
	 */
	public String getCustPhoneNumber();

	/**
	 * Returns the entry of the text field for the customer email.
	 * @return Entry for customer email
	 */
	public String getCustEMail();

	/**
	 * Returns the entry of the text field for the company name.
	 * @return Entry for company name
	 */
	public String getCompName();

	/**
	 * Returns the entry of the text field for the company street.
	 * @return Entry for company street
	 */
	public String getCompStreet();

	/**
	 * Returns the entry of the text field for the company PLZ/ZIP.
	 * @return Entry for company PLZ/ZIP
	 */
	public String getCompPLZ();

	/**
	 * Returns the entry of the text field for the company city.
	 * @return Entry for company city
	 */
	public String getCompCity();

	/**
	 * Returns the entry of the text field for the company country.
	 * @return Entry for company country.
	 */
	public String getCompCountry();

	/**
	 * Resets data to saved information in the requirement analysis.
	 */
	public void resetData();

}
