package Controller;


import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IFRequirementTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 11.05.17.
 */
public class FRequirementTabController
	extends TableTabController <IFRequirementTab>
{


	public FRequirementTabController(IModel model, IFRequirementTab fRequirementTab)
	{
		super(model,fRequirementTab);
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
			//TODO: ERROR-DIALOG - Nothing selected
		}
	}

	@Override
	protected void executeShowAction()
	{
		String ID = getSelectedIdentifier();
		System.out.println("Show "+ID);
		if(ID != null)
		{
			controllerManager.createControlledFRequirementShowView(ID);
		}
		else
		{
			//TODO: ERROR-DIALOG - Nothing selected
		}
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledWarningDialog(
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
						myModel.remFReqByID(getSelectedIdentifier());
					}

					@Override
					protected void cancelDeletion()
					{
						//Do nothing
					}
				}
		);
	}
}
