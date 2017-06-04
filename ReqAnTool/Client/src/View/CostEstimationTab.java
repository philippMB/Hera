package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ICostEstimationTab;

import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
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

	@Override
	protected void init()
	{
		setButtonActions(BUTTON_ACTIONS);

		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_COST_ESTIMATION));
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		setActionCommands();

		add(myBuilder.getResult());
	}

	@Override
	public void update(Observable o, Object arg)
	{
		//Nothing to be updated
	}

}
