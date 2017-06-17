package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.ITextFacade;
import Model_Interfaces.IModel;
import View_Interfaces.IFRequirementShowView;
import View_Interfaces.INFRequirementShowView;
import View_Interfaces.IProductDataShowView;
import View_Interfaces.IRequirementShowView;

/**
 * Created by phlippe on 11.06.17.
 */
public abstract class RequirementShowController<ReqShowViewType extends IRequirementShowView>
	extends BasicController<IRequirementShowView>
{


	public RequirementShowController(IModel model, ReqShowViewType viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledWarningDialog(
				DialogConstants.DIALOG_DELETE_WARNING,
				createDeletePlaceholderArray(),
				new DeleteWarningController(myModel, null)
				{
					@Override
					protected void deleteObject()
					{
						closeView();
						deleteRequirement(getReqID());
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
		System.out.println("Edit Action");
		editRequirement(getReqID());
	}

	protected String getReqID()
	{
		return myView.getReq().getID();
	}

	protected void bringViewToFront()
	{
		myView.bringToFront();
	}

	protected abstract void deleteRequirement(String reqID);

	protected abstract void editRequirement(String reqID);

	protected abstract String[] createDeletePlaceholderArray();
}
