package View;

import javax.swing.*;

/**
 * Created by phlippe on 27.04.17.
 */
public class ProjectTab
	extends TabPanel
{

	JButton buttonSave;
	JButton button2PDF;
	JButton button2XML;
	JButton buttonDelete;
	JButton buttonClose;

	public ProjectTab()
	{
		super("Projektmenü");
	}

	protected void init(){
		String[] buttonNames = {"Projekt speichern", "Projekt als PDF drucken", "Projekt als XML exportieren", "Bestehendes Projekt löschen", "Projekt schließen"};
		myBuilder.addTitle("Projektmenü");
		JButton[] myButtons = myBuilder.addButtonBar(buttonNames);
		buttonSave = myButtons[0];
		button2PDF = myButtons[1];
		button2XML = myButtons[2];
		buttonDelete = myButtons[3];
		buttonClose = myButtons[4];

		add(myBuilder.getResult());
	}
}
