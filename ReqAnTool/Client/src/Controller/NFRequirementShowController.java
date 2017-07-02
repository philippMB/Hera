package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IFRequirementShowView;
import View_Interfaces.INFRequirementShowView;

/**
 * Created by phlippe on 18.06.17.
 */
public class NFRequirementShowController
		extends RequirementShowController<INFRequirementShowView>
{

	public NFRequirementShowController(IModel model, INFRequirementShowView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void deleteRequirement(String reqID) throws Exception
	{
		myModel.remNFReqByID(reqID);
	}

	@Override
	protected void startEditReqView(String reqID)
	{
		controllerManager.createControlledNFRequirementEditView(reqID);
	}

	@Override
	protected String[] createDeletePlaceholderArray()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_NFREQ) + " " + getReqID()
		};
	}

}

