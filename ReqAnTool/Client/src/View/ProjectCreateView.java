package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IProjectCreateView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by phlippe on 03.05.17.
 */
public class ProjectCreateView
	extends FormWindow
	implements IProjectCreateView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.CREATE,
			ViewActions.CANCEL
	};

	private IModelGetData myModel;
	private JTextField fieldProjectTitle;
	private JTextField fieldSuppName;
	private JTextField fieldSuppPhoneNumber;
	private JTextField fieldSuppEMail;
	private JTextField fieldCustName;
	private JTextField fieldCustPhoneNumber;
	private JTextField fieldCustEMail;
	private JTextField fieldCompName;
	private JTextField fieldCompStreet;
	private JTextField fieldCompPLZ;
	private JTextField fieldCompCity;
	private JTextField fieldCompCountry;


	public ProjectCreateView(IModelGetData model)
	{
		super();
		myModel = model;

		setButtonActions(BUTTON_ACTIONS);
		init();
	}

	@Override
	protected void init()
	{
		buildProjectSection();
		myBuilder.addNewSection();
		buildSupplierSection();
		myBuilder.addNewSection();
		buildCustSection();

		myButtons = myBuilder.addButtonBar(myButtonActions);

		add(myBuilder.getResult(), BorderLayout.CENTER);
		setActionCommands();
		pack();
	}

	private void buildProjectSection()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_PROJECT_CREATE)
		);
		fieldProjectTitle = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_TITLE),
				"",
				true
		);
	}

	private void buildSupplierSection()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_SUPPLIER)
		);
		fieldSuppName = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_NAME),
				"",
				true
		);
		fieldSuppPhoneNumber = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_PHONE_NUMBER),
				"",
				true
		);
		fieldSuppEMail = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_EMAIL),
				"",
				true
		);
	}

	private void buildCustSection()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_CUSTOMER_DATA)
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

	@Override
	public void update(Observable o, Object arg)
	{

	}

	@Override
	public String getProjectTitle()
	{
		return fieldProjectTitle.getText();
	}

	@Override
	public String getSuppName()
	{
		return fieldSuppName.getText();
	}

	@Override
	public String getSuppPhoneNumber()
	{
		return fieldSuppPhoneNumber.getText();
	}

	@Override
	public String getSuppEMail()
	{
		return fieldSuppEMail.getText();
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

}
