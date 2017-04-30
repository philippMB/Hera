package View;

import Controller_Interfaces.ViewActions;
import View_Interfaces.IWarningDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;

/**
 * Created by phlippe on 27.04.17.
 */
public class WarningDialog
	extends DialogView
	implements IWarningDialog
{

	private static final String WARN_IMAGE_PATH_STRING =
			"/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/Warnschild.png";
	private static final Color WARN_COLOR = new Color(238,190,40);
	private static final String WARN_HEADER_NAME = "Warnung";

	private String title;
	private String description;
	private String[] buttonNames;
	private ViewActions[] buttonActions;
	private JButton[] myButtons;


	public WarningDialog(String warnTitle, String warnDescription){
		super(WARN_HEADER_NAME);
		title = warnTitle;
		description = warnDescription;

		generateDefaultButtons();
		init();
	}

	public WarningDialog(String warnTitle, String warnDescription, String[] warnButtonNames, ViewActions[] warnButtonActions){
		super(WARN_HEADER_NAME);
		title = warnTitle;
		description = warnDescription;
		buttonNames = warnButtonNames;
		buttonActions = warnButtonActions;

		init();
	}

	private void generateDefaultButtons()
	{
		buttonNames = new String[]{"Ok","Abbrechen"};
		buttonActions = new ViewActions[]{ViewActions.OK,ViewActions.CANCEL};
	}

	private Path getWarnImagePath()
	{
		return Paths.get(WARN_IMAGE_PATH_STRING);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(title);
		myBuilder.addImage(getWarnImagePath());
		myBuilder.addText(description);
		myButtons = myBuilder.addButtonBar(buttonNames);

		getContentPane().add(
				new BorderDecorater(
						myBuilder.getResult(), WARN_COLOR,WARN_HEADER_NAME
				)
		);
		setActionCommands();

		pack();
		setVisible(true);
	}

	private void setActionCommands()
	{
		int maxIndex = Math.min(myButtons.length,buttonActions.length);

		for(int i=0;i<maxIndex;i++)
		{
			myButtons[i].setActionCommand(buttonActions.toString());
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
	public void update(Observable o, Object arg)
	{

	}

}
