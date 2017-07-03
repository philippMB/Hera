package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.ICustomerTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 16.06.17.
 */
public class CustomerTabController
	extends TabController<ICustomerTab>
{

	private TextFieldController textController;
	private boolean canBeClosed;

	public CustomerTabController(IModel model, IView parentView, ICustomerTab viewToBeControlled)
	{
		super(model, parentView, viewToBeControlled);
		textController = new TextFieldController(viewToBeControlled);
		canBeClosed = true;
	}

	@Override
	public void setView(ICustomerTab viewToBeControlled, boolean showViewAfterwards)
	{
		super.setView(viewToBeControlled, showViewAfterwards);
		if(textController != null)
		{
			textController.setView(viewToBeControlled);
		}
	}

	@Override
	protected void executeSaveAction()
	{
		if(tryToSaveCustomerData())
		{
			controllerManager.createControlledInfoDialog(
					parentView,
					DialogConstants.DIALOG_INFO_SAVING_DATA,
					new String[]{
							myTextBundle.getParameterText(TextNameConstants.PAR_CUSTOMER)
					});
		}
	}

	@Override
	protected void executeResetAction()
	{
		myView.resetData();
		textController.setSaved();
	}

	@Override
	protected boolean canViewBeClosed()
	{
		if(textController.hasTextChangedSinceSaving())
		{
			myView.bringToFront();
			controllerManager.createControlledWarningDialog(
					parentView,
					DialogConstants.DIALOG_SAVE_DATA_WARNING,
					new String[]{
							myTextBundle.getParameterText(TextNameConstants.PAR_CUSTOMER)
					},
					new WarningController(myModel, null)
					{
						@Override
						protected void executeCancelAction()
						{
							canBeClosed = false;
							closeView();
						}

						@Override
						protected void executeSaveAction()
						{
							closeView();
							canBeClosed = tryToSaveCustomerData();
						}

						@Override
						protected void executeDontSaveAction()
						{
							canBeClosed = true;
							closeView();
						}
					}
			);
		}
		else
		{
			canBeClosed = true;
		}
		return canBeClosed;
	}

	private boolean tryToSaveCustomerData()
	{
		boolean isSaved;
		try{
			myModel.editCustData(
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
			isSaved = true;
		}
		catch(Exception custException)
		{
			isSaved = false;
			handleException(custException);
		}
		return isSaved;
	}
}
