package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import View_Interfaces.IInfoDialog;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by phlippe on 16.06.17.
 */
public class InfoDialog
	extends DialogView
	implements IInfoDialog
{

	private static final String INFO_IMAGE_PATH_STRING =
			"/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/Fehlerschild.png";
	private static final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.OK
	};

	private String descriptionText;
	private String titleText;


	public InfoDialog(String dialogPropertyName)
	{
		super(TextNameConstants.TITLE_INFO);

		titleText = myTextBundle.getTitleText(dialogPropertyName);
		descriptionText = myTextBundle.getDialogText(dialogPropertyName);
		init();
	}

	public InfoDialog(String dialogPropertyName, String[] placeholderInText)
	{
		super(TextNameConstants.TITLE_INFO);

		titleText = myTextBundle.getTitleText(dialogPropertyName);
		descriptionText = myTextBundle.getDialogText(dialogPropertyName, placeholderInText);
		init();
	}

	public InfoDialog(String title, String informationMessage)
	{
		super(TextNameConstants.TITLE_INFO);

		titleText = title;
		descriptionText = informationMessage;
		init();
	}

	private Path getInfoImagePath()
	{
		return Paths.get(INFO_IMAGE_PATH_STRING);
	}

	@Override
	protected void init()
	{
		setButtonActions(BUTTON_ACTIONS);
		buildDefaultStructure(titleText, descriptionText, getInfoImagePath());
		getContentPane().add(
				new BorderDecorater(myBuilder.getResult())
		);
		pack();
	}

}
