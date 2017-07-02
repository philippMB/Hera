package Controller;


import Exceptions.NoItemSelectedException;
import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IFRequirementTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 11.05.17.
 */
public class FRequirementTabController
	extends TableTabController<IFRequirementTab>
{


	public FRequirementTabController(IModel model, IView parentView, IFRequirementTab fRequirementTab)
	{
		super(model, parentView, fRequirementTab);
	}

	@Override
	protected void executeAddAction()
	{
		controllerManager.createControlledFRequirementEditView(null);
	}

	@Override
	protected void executeEditAction()
	{
		String ID = getSelectedIdentifier();

		if(ID != null)
		{
			controllerManager.createControlledFRequirementEditView(ID);
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
			controllerManager.createControlledFRequirementShowView(ID);
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
							myTextBundle.getParameterText(TextNameConstants.PAR_FREQ) + " " + getSelectedIdentifier()
					},
					new DeleteWarningController(myModel, null)
					{
						@Override
						protected void deleteObject()
						{
							closeView();
							tryToDeleteSelFReq();
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

	private void tryToDeleteSelFReq()
	{
		try
		{
			myModel.remFReqByID(getSelectedIdentifier());
		}
		catch(Exception ex)
		{
			handleException(ex);
		}
	}
}
