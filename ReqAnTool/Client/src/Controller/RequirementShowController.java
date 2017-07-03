package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IRequirementShowView;

/**
 * Created by phlippe on 11.06.17.
 */
public abstract class RequirementShowController<ReqShowViewType extends IRequirementShowView>
	extends BasicViewController<IRequirementShowView>
{


	public RequirementShowController(IModel model, ReqShowViewType viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledWarningDialog(
				myView,
				DialogConstants.DIALOG_DELETE_WARNING,
				createDeletePlaceholderArray(),
				new DeleteWarningController(myModel, null)
				{
					@Override
					protected void deleteObject()
					{
						closeView();
						tryToDeleteRequirement();
					}

					@Override
					protected void cancelDeletion()
					{
						closeView();
					}
				}
		);
	}

	@Override
	protected void executeEditAction()
	{
		startEditReqView(getReqID());
		closeView();
	}

	private void tryToDeleteRequirement()
	{
		try{
			deleteRequirement(getReqID());
			closeView();
		}
		catch(Exception ex)
		{
			handleException(ex);
		}
	}

	protected String getReqID()
	{
		String myReqID;
		if(myView.getReq() != null)
		{
			myReqID = myView.getReq().getID();
		}
		else
		{
			myReqID = "";
			myLogger.error("myView.getReq() is null in this view");
		}
		return myReqID;
	}

	protected void bringViewToFront()
	{
		myView.bringToFront();
	}

	protected abstract void deleteRequirement(String reqID) throws Exception;

	protected abstract void startEditReqView(String reqID);

	protected abstract String[] createDeletePlaceholderArray();
}
