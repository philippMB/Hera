package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;

import javax.swing.*;

/**
 * Created by phlippe on 03.05.17.
 */
public class ProcessClassificationFReqView
	extends ProcessClassificationView<IFRequirement>
{

	private JTextField fieldTitle;
	private JTextField fieldActor;
	private JTextArea fieldDescription;

	public ProcessClassificationFReqView(IModelGetData model, String ID)
	{
		super(model, ID);
	}

	@Override
	protected IFRequirement getRequirementFromModel(String ID)
	{
		return myModel.getFReqByID(ID);
	}

	@Override
	protected void buildReqSpecificDescription()
	{
		fieldTitle = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_TITLE),
				"",
				false
		);
		fieldActor = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_ACTOR),
				"",
				false
		);
		fieldDescription = myBuilder.addNamedTextArea(
				myTextBundle.getParameterText(TextNameConstants.PAR_DESC),
				"",
				false
		);

		updateReqSpecificDescription();
	}

	@Override
	protected void updateReqSpecificDescription()
	{
		fieldTitle.setText(myReq.getTitle());
		fieldActor.setText(myReq.getActor());
		fieldDescription.setText(myReq.getDescription());
	}

}
