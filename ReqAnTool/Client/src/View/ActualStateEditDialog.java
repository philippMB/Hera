package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;
import Model_Interfaces.IRequirementAnalysis;
import View_Interfaces.IActualStateEditView;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by phlippe on 03.05.17.
 */
public class ActualStateEditDialog
	extends DialogView
	implements IActualStateEditView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.SAVE,
			ViewActions.CANCEL
	};

	private JTextField fieldActualState;
	private IModelGetData myModel;


	public ActualStateEditDialog(IModelGetData model)
	{
		super(TextNameConstants.TITLE_ACTUAL_STATE_EDIT);
		myModel = model;
		setButtonActions(BUTTON_ACTIONS);

		init();
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_ACTUAL_STATE_EDIT)
		);
		fieldActualState = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_ACTUAL_STATE),
				"",
				true
		);
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		setActualStateField();
		getContentPane().add(myBuilder.getResult());
	}

	private void setActualStateField()
	{
		IRequirementAnalysis requirementAnalysis = myModel.getReqAnalysis();
		double actualState = requirementAnalysis.getActualState();
		fieldActualState.setText(Double.toString(actualState));
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

	@Override
	public String getActualState()
	{
		return fieldActualState.getText();
	}

}
