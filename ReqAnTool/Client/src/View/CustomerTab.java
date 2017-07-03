package View;

import Controller_Interfaces.ITextController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Model_Interfaces.ICustomerData;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ICustomerTab;
import View_Interfaces.ITab;
import View_Interfaces.ITextView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * This tab provides functionality to edit the saved information about the customer.
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
 * @see TabPanel
 * @see ITextView
 */
public class CustomerTab
	extends TabPanel
	implements ICustomerTab
{

	private static final ViewActions[] BUTTON_ACTIONS =  {
			ViewActions.SAVE,
			ViewActions.RESET
	};

	private JTextField fieldCustName;
	private JTextField fieldCustPhoneNumber;
	private JTextField fieldCustEMail;
	private JTextField fieldCompName;
	private JTextField fieldCompStreet;
	private JTextField fieldCompPLZ;
	private JTextField fieldCompCity;
	private JTextField fieldCompCountry;
	private ILogger myLogger;


	public CustomerTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_CUSTOMER_DATA);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		myLogger = ILoggerFactory.getInstance().createLogger();
		setButtonActions(BUTTON_ACTIONS);

		buildCustomerSection();
		myBuilder.addNewSection();
		buildCompanySection();
		myBuilder.addNewSection();
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		setValuesFromModel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
		setActionCommands();
	}

	/**
	 * Builds up the section for customer text fields
	 */
	private void buildCustomerSection()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_CUSTOMER)
		);
		fieldCustName = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_NAME),
				"",
				true
		);
		fieldCustPhoneNumber = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_PHONE_NUMBER),
				"",
				true
		);
		fieldCustEMail = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_EMAIL),
				"",
				true
		);
	}

	/**
	 * Builds up the section for company text fields
	 */
	private void buildCompanySection()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_COMPANY)
		);
		fieldCompName = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_NAME),
				"",
				true
		);
		fieldCompStreet = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_STREET),
				"",
				true
		);
		fieldCompPLZ = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_PLZ),
				"",
				true
		);
		fieldCompCity = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_CITY),
				"",
				true
		);
		fieldCompCountry = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_COUNTRY),
				"",
				true
		);
	}

	/**
	 * Sets the text fields with the values of the model. Has to prove if {@link IModelGetData#getCustomerData()}
	 * is not null.
	 */
	private void setValuesFromModel()
	{
		ICustomerData myCustomerData = myModel.getCustomerData();
		if(myCustomerData != null)
		{
			fieldCustName.setText(myCustomerData.getCName());
			fieldCustPhoneNumber.setText(myCustomerData.getCNumber());
			fieldCustEMail.setText(myCustomerData.getCEMail());
			fieldCompName.setText(myCustomerData.getCompanyName());
			fieldCompStreet.setText(myCustomerData.getCompanyStreet());
			fieldCompPLZ.setText(myCustomerData.getCompanyPLZ());
			fieldCompCity.setText(myCustomerData.getCompanyCity());
			fieldCompCountry.setText(myCustomerData.getCompanyCountry());
		}
		else
		{
			myLogger.warning("CustomerData are null in CustomerTab");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg)
	{

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCustName()
	{
		return fieldCustName.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCustPhoneNumber()
	{
		return fieldCustPhoneNumber.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCustEMail()
	{
		return fieldCustEMail.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCompName()
	{
		return fieldCompName.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCompStreet()
	{
		return fieldCompStreet.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCompPLZ()
	{
		return fieldCompPLZ.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCompCity()
	{
		return fieldCompCity.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCompCountry()
	{
		return fieldCompCountry.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resetData()
	{
		setValuesFromModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addTextController(ITextController textfieldController)
	{
		TextAreaListener textAreaListener = new TextAreaListener(textfieldController);
		fieldCustName.getDocument().addDocumentListener(textAreaListener);
		fieldCustPhoneNumber.getDocument().addDocumentListener(textAreaListener);
		fieldCustEMail.getDocument().addDocumentListener(textAreaListener);
		fieldCompName.getDocument().addDocumentListener(textAreaListener);
		fieldCompStreet.getDocument().addDocumentListener(textAreaListener);
		fieldCompPLZ.getDocument().addDocumentListener(textAreaListener);
		fieldCompCity.getDocument().addDocumentListener(textAreaListener);
		fieldCompCountry.getDocument().addDocumentListener(textAreaListener);
	}
}
