package Controller;

import Exceptions.NoItemSelectedException;
import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.INFRequirementTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 18.06.17.
 */
public class NFRequirementTabController
	extends TableTabController<INFRequirementTab>
{


	public NFRequirementTabController(IModel model, IView parentView, INFRequirementTab nfRequirementTab)
	{
		super(model, parentView, nfRequirementTab);
	}

	@Override
	protected void executeAddAction()
	{
		controllerManager.createControlledNFRequirementEditView(null);
	}

	@Override
	protected void executeEditAction()
	{
		String ID = getSelectedIdentifier();

		if(ID != null)
		{
			controllerManager.createControlledNFRequirementEditView(ID);
		}
		else
		{
			handleException(new NoItemSelectedException(getClass().getName()));
		}
	}

	@Override
	protected void executeShowAction()
	{
		String ID = getSelectedIdentifier();
		if(ID != null)
		{
			controllerManager.createControlledNFRequirementShowView(ID);
		}
		else
		{
			handleException(new NoItemSelectedException(getClass().getName()));
		}
	}

	@Override
	protected void executeDeleteAction()
	{
		if(getSelectedIdentifier() != null)
		{
			controllerManager.createControlledWarningDialog(
					parentView,
					DialogConstants.DIALOG_DELETE_WARNING,
					new String[]{
							myTextBundle.getParameterText(TextNameConstants.PAR_NFREQ) + " " + getSelectedIdentifier()
					},
					new DeleteWarningController(myModel, null)
					{
						@Override
						protected void deleteObject()
						{
							closeView();
							tryToDeleteSelNFReq();
						}

						@Override
						protected void cancelDeletion()
						{
							closeView();
						}
					}
			);
		}
		else
		{
			handleException(new NoItemSelectedException(getClass().getName()));
		}
	}

	private void tryToDeleteSelNFReq()
	{
		try
		{
			myModel.remNFReqByID(getSelectedIdentifier());
		}
		catch(Exception ex)
		{
			handleException(ex);
		}
	}
}