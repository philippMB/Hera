package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IFRequirementEditView;

import java.util.ArrayList;

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
	protected void addRequirementToModel(ArrayList<String> referenceList) throws Exception
	{
		myModel.addFReq(
				myView.getIDEntry(),
				myView.getTitleEntry(),
				myView.getActorEntry(),
				myView.getDescriptionEntry(),
				referenceList
		);
	}

	@Override
	protected void editRequirementFromModel(ArrayList<String> referenceList) throws Exception
	{
		myModel.editFReq(
				myReqID,
				myView.getIDEntry(),
				myView.getTitleEntry(),
				myView.getActorEntry(),
				myView.getDescriptionEntry(),
				referenceList
		);
	}

	@Override
	protected String[] createSaveDataWarningPlaceholder()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_FREQ) + " " + myReqID
		};
	}


}