package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IQualityRequirementTab;

/**
 * Created by phlippe on 17.06.17.
 */
public class QualityReqTabController
	extends BasicController<IQualityRequirementTab>
{


	public QualityReqTabController(IModel model, IQualityRequirementTab viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeAddAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeEditAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeShowAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledInfoDialog(DialogConstants.DIALOG_INFO_NOT_IMPLEMENTED);
	}
}
