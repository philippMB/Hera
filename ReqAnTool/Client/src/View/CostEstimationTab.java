package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import View_Interfaces.*;

import java.util.Observable;

/**
 * This tab provides functionality to edit the current cost estimation. For this the following six view actions
 * are provided to the user:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#SHOW_CE} - creates a {@link ICostEstimationShowView} to present
 *     the cost estimation to the user</li>
 *     <li>{@link Controller_Interfaces.ViewActions#CALC_FP} - calculates the function points</li>
 *     <li>{@link Controller_Interfaces.ViewActions#EDIT_CE} - creates a {@link ICostEstimationEditView} to edit the
 *     cost estimation by the user</li>
 *     <li>{@link Controller_Interfaces.ViewActions#OPTIMIZE_WF} - optimizes the weight factors</li>
 *     <li>{@link Controller_Interfaces.ViewActions#DELETE_CE} - deletes the cost estimation</li>
 *     <li>{@link Controller_Interfaces.ViewActions#ENTER_AS} - creates a {@link IActualStateEditView} to edit the
 *     actual state of the project</li>
 * </ul>
 * The controller has to observe these six actions and react to them.
 *
 * @author 9045534
 * @version 1.0
 * @see TabPanel
 */
public class CostEstimationTab
	extends TabPanel
	implements ICostEstimationTab
{

	private static final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.SHOW_CE,
			ViewActions.CALC_FP,
			ViewActions.EDIT_CE,
			ViewActions.OPTIMIZE_WF,
			ViewActions.DELETE_CE,
			ViewActions.ENTER_AS
	};


	public CostEstimationTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_COST_ESTIMATION);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		setButtonActions(BUTTON_ACTIONS);

		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_COST_ESTIMATION));
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		setActionCommands();

		add(myBuilder.getResult());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		//Nothing to be updated
	}

}
