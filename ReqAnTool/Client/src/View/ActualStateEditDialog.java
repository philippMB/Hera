package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;
import Model_Interfaces.IRequirementAnalysis;
import View_Interfaces.IActualStateEditView;
import com.sun.istack.internal.Nullable;

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


	public ActualStateEditDialog(@Nullable JFrame parentView, IModelGetData model)
	{
		super(parentView, TextNameConstants.TITLE_ACTUAL_STATE_EDIT);
		myModel = model;
		myModel.addObserver(this);
		setButtonActions(BUTTON_ACTIONS);

		init();
	}

	@Override
	protected void init()
	{
		String titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_ACTUAL_STATE_EDIT);
		setTitle(titleText);
		myBuilder.addTitle(titleText);
		fieldActualState = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_ACTUAL_STATE),
				"",
				true
		);
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		setActualStateField();
		setActionCommands();
		getContentPane().add(myBuilder.getResult());
		pack();
	}

	private void setActualStateField()
	{
		IRequirementAnalysis requirementAnalysis = myModel.getReqAnalysis();
		double actualState = requirementAnalysis.getActualState();
		if(actualState > 0)
		{
			fieldActualState.setText(myTextBundle.convertDoubleToString(actualState));
		}
		else
		{
			fieldActualState.setText("");
		}
	}

	/**
	 * Dialog is not modal
	 */
	@Override
	public void showView()
	{
		SwingUtilities.invokeLater(
				() -> {
					if(getParent() != null)
					{
						setLocationRelativeTo(getParent());
					}
					setVisible(true);
				}
		);
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

	@Override
	public void destruct()
	{
		super.destruct();
		myModel.deleteObserver(this);
	}
}
