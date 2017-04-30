package View;

import Controller_Interfaces.ButtonActions;

import java.awt.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by phlippe on 27.04.17.
 */
public class WarningDialog
	extends DialogView
{

	private String title;
	private String description;
	private String[] buttonNames;
	private ButtonActions[] buttonActions;

	public WarningDialog(String warnTitle, String warnDescription){
		super("Warnung");
		title = warnTitle;
		description = warnDescription;
		buttonNames = new String[2];
		buttonNames[0] = "Ok";
		buttonNames[1] = "Abbrechen";
		buttonActions = new ButtonActions[2];
		buttonActions[0] = ButtonActions.OK;
		buttonActions[1] = ButtonActions.CANCEL;

		init();
	}

	public WarningDialog(String warnTitle, String warnDescription, String[] warnButtonNames, ButtonActions[] warnButtonActions){
		super("Warnung");
		title = warnTitle;
		description = warnDescription;
		buttonNames = warnButtonNames;
		buttonActions = warnButtonActions;

		init();
	}

	@Override
	protected void init()
	{
		Path warnSignURL = null;
		warnSignURL = Paths.get("/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/Warnschild.png");

		myBuilder.addTitle(title);
		myBuilder.addImage(warnSignURL);
		myBuilder.addText(description);
		myBuilder.addButtonBar(buttonNames);
		getContentPane().add(new BorderDecorater(myBuilder.getResult(), new Color(238,190,40),"Warnung"));


		pack();
		setVisible(true);
	}
}
