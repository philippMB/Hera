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
					factor.getMaxValue() + 1
			);
			myScrollBarPanels.put(factor.getTitle(), sliderPanel);
		}

		myButtons = myBuilder.addButtonBar(myButtonActions);

		setActionCommands();
		getContentPane().add(myBuilder.getResult());

		pack();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getValueByTitle(String title)
	{
		int value;
		SliderPanel sliderPanel = myScrollBarPanels.get(title);
		if(sliderPanel == null)
		{
			value = -1;
		}
		else
		{
			value = sliderPanel.getSliderValue();
		}
		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Integer> getAllWeightFactorValues()
	{
		Map<String, Integer> weightFactorToValueMap = new HashMap<>();

		for(String weightFactorTitle: myScrollBarPanels.keySet())
		{
			weightFactorToValueMap.put(weightFactorTitle, getValueByTitle(weightFactorTitle));
		}
		return weightFactorToValueMap;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		//Nothing to be updated
	}

	@Override
	public void destruct()
	{
		super.destruct();
		myModel.deleteObserver(this);
	}
}
