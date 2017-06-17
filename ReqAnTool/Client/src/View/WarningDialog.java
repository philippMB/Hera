package View;

import Controller_Interfaces.IController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import View_Interfaces.IWarningDialog;

import javax.swing.*;
import java.awt.*;
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
	private static final ViewActions[] DEFAULT_BUTTON_ACTIONS = {
		ViewActions.OK,
		ViewActions.CANCEL
	};

	private String title;
	private String description;


	public WarningDialog(String warnTitle, String warnDescription){
		super(TextNameConstants.TITLE_WARNING);
		title = warnTitle;
		description = warnDescription;
		setButtonActions(DEFAULT_BUTTON_ACTIONS);

		init();
	}

	public WarningDialog(String warnTitle, String warnDescription, ViewActions[] warnButtonActions){
		super(TextNameConstants.TITLE_WARNING);
		title = warnTitle;
		description = warnDescription;
		setButtonActions(warnButtonActions);

		init();
	}

	private Path getWarnImagePath()
	{
		return Paths.get(WARN_IMAGE_PATH_STRING);
	}

	@Override
	protected void init()
	{
		buildDefaultStructure(title, description, getWarnImagePath());
		getContentPane().add(
				new BorderDecorater(
						myBuilder.getResult(),
						WARN_COLOR,
						myTextBundle.getTitleText(TextNameConstants.TITLE_WARNING)
				)
		);

		pack();
	}

}
