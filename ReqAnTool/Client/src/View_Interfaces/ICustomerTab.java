package View_Interfaces;

/**
 * Created by phlippe on 03.05.17.
 */
public interface ICustomerTab
	extends IView
{

	public String getCustName();

	public String getCustPhoneNumber();

	public String getCustEMail();

	public String getCompName();

	public String getCompStreet();

	public String getCompPLZ();

	public String getCompCity();

	public String getCompCountry();

	public void resetData();

}
