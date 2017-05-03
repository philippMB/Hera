package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import LanguageAndText.TextNameConstants;
import View_Interfaces.IStartView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class StartView
	extends JFrame
	implements IStartView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.NEW_PROJECT,
			ViewActions.OPEN_PROJECT,
			ViewActions.CLOSE
	};

	private PanelBuilder myBuilder;
	private ITextFacade myTextBundle;
	private JButton[] myButtons;


	public StartView()
	{
		super();
		myTextBundle = ITextFacade.getInstance();
		setTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_REQAN_TOOL));
		setSize(500,500);
		myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);

		init();
	}

	private void init()
	{
		setLayout(new GridLayout());

		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_MAIN_MENU));
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		setActionCommands();
		add(myBuilder.getResult(), BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	private void setActionCommands()
	{
		for(int i=0;i<BUTTON_ACTIONS.length;i++)
		{
			myButtons[i].setActionCommand(BUTTON_ACTIONS[i].toString());
		}
	}

	@Override
	public void addController(ActionListener newListener)
	{
		for(JButton b: myButtons)
		{
			b.addActionListener(newListener);
		}
	}

	@Override
	public void destruct()
	{

	}

	@Override
	public void update(Observable o, Object arg)
	{
		//Nothing to be updated
	}

}
