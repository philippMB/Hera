package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.IFRequirementEditView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by phlippe on 04.06.17.
 */
public class FRequirementEditController
	extends RequirementEditController<IFRequirementEditView>
{

	private String myReqID;


	public FRequirementEditController(IModel model, IFRequirementEditView viewToBeControlled)
	{
		super(model, viewToBeControlled);
		myReqID = myView.getIDEntry();
	}

	@Override
	protected boolean tryToSaveReq()
	{
		boolean reqIsSaved;
		ErrorCodes saveError;
		ArrayList<String> referenceList = new ArrayList<>( Arrays.asList(myView.getRefEntry()) );

		if(myReqID == null || myReqID.equals(""))
		{
			saveError = myModel.addFReq(
					myView.getIDEntry(),
					myView.getTitleEntry(),
					myView.getActorEntry(),
					myView.getDescriptionEntry(),
					referenceList
			);
		}
		else
		{
			saveError = myModel.editFReq(
					myReqID,
					myView.getIDEntry(),
					myView.getTitleEntry(),
					myView.getActorEntry(),
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
				myTextBundle.getParameterText(TextNameConstants.PAR_FREQ) + " " + myReqID
		};
	}


}
