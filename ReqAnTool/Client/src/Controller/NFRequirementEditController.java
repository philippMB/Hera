package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.INFRequirementEditView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by phlippe on 18.06.17.
 */
public class NFRequirementEditController
	extends RequirementEditController<INFRequirementEditView>
{


	public NFRequirementEditController(IModel model, INFRequirementEditView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void addRequirementToModel(ArrayList<String> referenceList)
	{
		myModel.addNFReq(
				myView.getIDEntry(),
				myView.getTitleEntry(),
				"", //TODO: Change model that NFReq has no actor
				myView.getDescriptionEntry(),
				referenceList
		);
	}

	@Override
	protected void editRequirementFromModel(ArrayList<String> referenceList)
	{
		myModel.editNFReq(
				myReqID,
				myView.getIDEntry(),
				myView.getTitleEntry(),
				"", //TODO: Change model that NFReq has no actor
				myView.getDescriptionEntry(),
				referenceList
		);
	}

	@Override
	protected String[] createSaveDataWarningPlaceholder()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_NFREQ) + " " + myReqID
		};
	}

}

