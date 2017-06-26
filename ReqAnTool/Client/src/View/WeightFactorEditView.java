package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IWeightFactor;
import View_Interfaces.IWeightFactorEditView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by phlippe on 01.05.17.
 */
public class WeightFactorEditView
	extends FormWindow
	implements IWeightFactorEditView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.SAVE,
			ViewActions.CANCEL
	};

	private IModelGetData myModel;
	private Map<String, SliderPanel> myScrollBarPanels;


	public WeightFactorEditView(IModelGetData model)
	{
		super();
		myModel = model;
		setButtonActions(BUTTON_ACTIONS);

		init();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		ArrayList<IWeightFactor> myWeightFactors = myModel.getAllWeightFactor();
		myScrollBarPanels = new HashMap<>();

		String titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_WEIGHT_FACTOR_EDIT);
		setTitle(titleText);
		myBuilder.addTitle(titleText);

		for(int i = 0; i<myWeightFactors.size(); i++)
		{
			IWeightFactor factor = myWeightFactors.get(i);
			SliderPanel sliderPanel = myBuilder.addNamedScrollBarPanel(
					factor.getTitle(),
					factor.getValue(),
					0,
					factor.getMaxValue()
			);
			myScrollBarPanels.put(factor.getTitle(), sliderPanel);
		}

		myButtons = myBuilder.addButtonBar(myButtonActions);

		getContentPane().add(myBuilder.getResult());

		pack();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getValueByTitle(String title)
	{
		SliderPanel sliderPanel = myScrollBarPanels.get(title);
		return sliderPanel.getSliderValue();
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
