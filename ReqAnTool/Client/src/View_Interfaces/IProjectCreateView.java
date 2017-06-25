package View_Interfaces;

/**
 * This view contains text fields for the project title, supplier/project manager data, customer and company data.
 * It is a plain view with following view actions:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#CREATE} - creates the new requirement analysis with the entered data
 *     </li>
 *     <li>{@link Controller_Interfaces.ViewActions#CANCEL} - cancels the action</li>
 * </ul>
 * The controller has to observe these actions and react to them.
 *
 * @author 9045534
 * @version 1.0
 */
public interface IProjectCreateView
	extends IView
{

	public String getProjectTitle();

	public String getSuppName();

	public String getSuppPhoneNumber();

	public String getSuppEMail();

	public String getCustName();

	public String getCustPhoneNumber();

	public String getCustEMail();

	public String getCompName();

	public String getCompStreet();

	public String getCompPLZ();

	public String getCompCity();

	public String getCompCountry();

}
