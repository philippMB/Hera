package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.ICustomerTab;

import java.util.ArrayList;

/**
 * Created by phlippe on 16.06.17.
 */
public class CustomerTabController
	extends BasicController<ICustomerTab>
{

	public CustomerTabController(IModel model, ICustomerTab viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeSaveAction()
	{
		ArrayList<ErrorCodes> errorCodesList = myModel.editCustData(
				myView.getCompName(),
				myView.getCompCity(),
				myView.getCompStreet(),
				myView.getCompPLZ(),
				myView.getCompCountry(),
				myView.getCustName(),
				myView.getCustEMail(),
				myView.getCustPhoneNumber(),
				myModel.getCustomerData().getPMName(),
				myModel.getCustomerData().getPMEMail(),
				myModel.getCustomerData().getPMPNumber()
		);

		if(errorCodesList.size() != 0)
		{
			handleErrorCode(errorCodesList.get(0));
		}
		else
		{
			//TODO: Info to user that names are saved
			controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_SAVING_DATA,
					new String[]{
						myTextBundle.getParameterText(TextNameConstants.PAR_CUSTOMER)
					});
		}
	}

	@Override
	protected void executeResetAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_SAVING_DATA,
				new String[]{
						myTextBundle.getParameterText(TextNameConstants.PAR_CUSTOMER)
				});
		//myView.resetData();
	}
}
