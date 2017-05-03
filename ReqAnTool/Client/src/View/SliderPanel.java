package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

/**
 * Created by phlippe on 01.05.17.
 */
public class SliderPanel
	extends JPanel

{

	private int initValue;
	private int minimumValue;
	private int maximumValue;
	private JSlider mySlider;


	public SliderPanel(int initValue, int minimumValue, int maximumValue)
	{
		super();

		this.initValue = initValue;
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;

		init();
	}

	private void init()
	{
		GridLayout scrollBarPanelLayout = new GridLayout(1,2);
		setLayout(scrollBarPanelLayout);

		mySlider = new JSlider();
		mySlider.setExtent(1);
		mySlider.setMinimum(minimumValue);
		mySlider.setMaximum(maximumValue);
		mySlider.setValue(initValue);
		mySlider.setOrientation(JSlider.HORIZONTAL);
		mySlider.setMinorTickSpacing(1);
		mySlider.setMajorTickSpacing(5);
		mySlider.setPaintTicks(true);
		mySlider.setPaintLabels(true);
		mySlider.setPaintTrack(true);

		add(mySlider);
	}

	public int getSliderValue()
	{
		return mySlider.getValue();
	}

	public int getInitValue()
	{
		return initValue;
	}

	public int getMinimumValue()
	{
		return minimumValue;
	}

	public int getMaximumValue()
	{
		return maximumValue;
	}

}
