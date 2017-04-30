package View;

import Controller_Interfaces.ViewActions;
import View_Interfaces.IProjectTab;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by phlippe on 27.04.17.
 */
public class ProjectTab
	extends TabPanel
	implements IProjectTab
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

		setActionCommands();
	}

	private void setActionCommands()
	{
		buttonSave.setActionCommand(ViewActions.SAVE.toString());
		buttonDelete.setActionCommand(ViewActions.DELETE.toString());
		buttonClose.setActionCommand(ViewActions.CLOSE.toString());
		button2XML.setActionCommand(ViewActions.TO_XML.toString());
		button2PDF.setActionCommand(ViewActions.TO_PDF.toString());
	}

	@Override
	public void addController(ActionListener newListener)
	{
		buttonSave.addActionListener(newListener);
		buttonDelete.addActionListener(newListener);
		buttonClose.addActionListener(newListener);
		button2XML.addActionListener(newListener);
		button2PDF.addActionListener(newListener);
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}
}
