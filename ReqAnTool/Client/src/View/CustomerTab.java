package View;

import Controller_Interfaces.ITextController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Model_Interfaces.ICustomerData;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ICustomerTab;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by phlippe on 03.05.17.
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

	@Override
	public void update(Observable o, Object arg)
	{

	}

	@Override
	public String getCustName()
	{
		return fieldCustName.getText();
	}

	@Override
	public String getCustPhoneNumber()
	{
		return fieldCustPhoneNumber.getText();
	}

	@Override
	public String getCustEMail()
	{
		return fieldCustEMail.getText();
	}

	@Override
	public String getCompName()
	{
		return fieldCompName.getText();
	}

	@Override
	public String getCompStreet()
	{
		return fieldCompStreet.getText();
	}

	@Override
	public String getCompPLZ()
	{
		return fieldCompPLZ.getText();
	}

	@Override
	public String getCompCity()
	{
		return fieldCompCity.getText();
	}

	@Override
	public String getCompCountry()
	{
		return fieldCompCountry.getText();
	}

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
