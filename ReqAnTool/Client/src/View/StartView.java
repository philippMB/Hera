package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 29.04.17.
 */
public class StartView
	extends JFrame
{

	private JPanelBuilder myBuilder;


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
		myBuilder.addButtonBar(buttonNames);

		add(myBuilder.getResult(), BorderLayout.CENTER);

		pack();
		setVisible(true);
	}



}
