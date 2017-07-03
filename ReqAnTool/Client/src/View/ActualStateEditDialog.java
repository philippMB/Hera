package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirement;
import Model_Interfaces.IRequirementAnalysis;
import View_Interfaces.IActualStateEditView;
import View_Interfaces.IView;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.util.Observable;

/**
 * In this view the user can change the actual state of the cost estimation.
 * <p>
 *     This view provides a way to enter the actual state and change it. For the controller this interface
 *     contains a method to get the string entered from the user. It is based on {@link DialogView}, but does not block
 *     other views or the running thread.<p>
 * <b>View actions on view</b><br>
 *         The standard buttons of this dialog are:
 *         <ul>
 *             <li>{@link ViewActions#SAVE} - Saves the edited state</li>
 *             <li>{@link ViewActions#CANCEL} - Cancel and ignores the entry of the user</li>
 *         </ul>
 *			Further this view contains one text field where the user can edit the actual state.
 *
 * @author 9045534
 * @version 1.0
 * @see DialogView
 * @see IActualStateEditView
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

	/**
	 * {@inheritDoc}
	 */
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
	 * {@inheritDoc}
	 * This dialog is not modal and does not block the running thread.
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg)
	{

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getActualState()
	{
		return fieldActualState.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void destruct()
	{
		super.destruct();
		myModel.deleteObserver(this);
	}
}
