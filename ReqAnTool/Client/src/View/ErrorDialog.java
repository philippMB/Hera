package View;

import Controller_Interfaces.ViewActions;
import View_Interfaces.IErrorDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;

/**
 * Created by phlippe on 27.04.17.
 */
public class ErrorDialog
	extends DialogView
	implements IErrorDialog
{

	private static final String ERROR_IMAGE_PATH_STRING =
			"/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/Fehlerschild.png";

	private String descriptionText;
	private String title;
	private JButton buttonOk;
	private JButton buttonBack;

	public ErrorDialog(String title, String errorDescription){
		super("Fehlermeldung");
		this.title = title;
		descriptionText = errorDescription;

		init();
	}

	private Path getErrorImagePath()
	{
		return Paths.get(ERROR_IMAGE_PATH_STRING);
	}

	@Override
	protected void init()
	{
		String[] buttonNames = {"Ok","Zurück"};

		myBuilder.addTitle(title);
		myBuilder.addImage(getErrorImagePath());
		myBuilder.addText(descriptionText);
		JButton[] myButtons = myBuilder.addButtonBar(buttonNames);
		buttonOk = myButtons[0];
		buttonBack = myButtons[1];

		getContentPane().add(new BorderDecorater(myBuilder.getResult(), Color.RED, "Fehlermeldung"));

		pack();
		setVisible(true);
	}

	private void setActionCommands()
	{
		buttonOk.setActionCommand(ViewActions.OK.toString());
		buttonBack.setActionCommand(ViewActions.BACK.toString());
	}

	@Override
	public void addController(ActionListener newListener)
	{
		buttonOk.addActionListener(newListener);
		buttonBack.addActionListener(newListener);
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

}
