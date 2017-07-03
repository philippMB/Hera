package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IFRequirementShowView;

/**
 * Created by phlippe on 13.06.17.
 */
public class FRequirementShowController
	extends RequirementShowController<IFRequirementShowView>
{

	public FRequirementShowController(IModel model, IFRequirementShowView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	protected void deleteRequirement(String reqID) throws Exception
	{
		myModel.remFReqByID(reqID);
	}

	protected void startEditReqView(String reqID)
	{
		controllerManager.createControlledFRequirementEditView(reqID);
	}

	@Override
	protected String[] createDeletePlaceholderArray()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_FREQ) + " " + getReqID()
		};
	}

}