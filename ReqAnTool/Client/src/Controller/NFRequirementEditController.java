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
	protected boolean tryToSaveReq()
	{
		boolean reqIsSaved = false;
		ErrorCodes saveError;
		ArrayList<String> referenceList = new ArrayList<>( Arrays.asList(myView.getRefEntry()) );

		if(myReqID == null || myReqID.equals(""))
		{
			saveError = myModel.addNFReq(
					myView.getIDEntry(),
					myView.getTitleEntry(),
					"", //TODO: Change model that NFReq has no actor
					myView.getDescriptionEntry(),
					referenceList
			);
		}
		else
		{
			saveError = myModel.editNFReq(
					myReqID,
					myView.getIDEntry(),
					myView.getTitleEntry(),
					"", //TODO: Change model that NFReq has no actor
					myView.getDescriptionEntry(),
					referenceList
			);
		}

		if(saveError == ErrorCodes.NO_ERROR)
		{
			reqIsSaved = true;
		}
		else
		{
			reqIsSaved = false;
			handleException(saveError);
		}
		return reqIsSaved;
	}

	@Override
	protected String[] createSaveDataWarningPlaceholder()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_NFREQ) + " " + myReqID
		};
	}

}

