package View;

import Controller_Interfaces.ViewActions;
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

	private JPanelBuilder myBuilder;
	private JButton buttonNewProject;
	private JButton buttonOpenRA;
	private JButton buttonClose;


	public StartView()
	{
		super("ReqAn-Tool");
		setSize(500,500);
		myBuilder = JPanelBuilderFactory.getInstance().createPanelBuilder(this);

		init();
	}

	private void init()
	{
		String[] buttonNames = {"Neues Projekt anlegen", "Anforderungsanalyse öffnen", "Programm Beenden"};

		setLayout(new GridLayout());

		myBuilder.addTitle("Hauptmenü");
		JButton[] myButtons = myBuilder.addButtonBar(buttonNames);
		buttonNewProject = myButtons[0];
		buttonOpenRA = myButtons[1];
		buttonClose = myButtons[2];

		add(myBuilder.getResult(), BorderLayout.CENTER);

		pack();
		setVisible(true);
	}


	@Override
	public void addController(ActionListener newListener)
	{
		buttonNewProject.addActionListener(newListener);
		buttonNewProject.setActionCommand(ViewActions.NEW.toString());

		buttonOpenRA.addActionListener(newListener);
		buttonOpenRA.setActionCommand(ViewActions.OPEN.toString());

		buttonClose.addActionListener(newListener);
		buttonClose.setActionCommand(ViewActions.CLOSE.toString());
	}

	@Override
	public void destruct()
	{

	}

	@Override
	public void update(Observable o, Object arg)
	{
		//Do nothing
	}
}
