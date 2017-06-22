package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import View_Interfaces.IWarningDialog;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

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


	public WarningDialog(@Nullable JFrame parentView, String warnTitle, String warnDescription){
		this(parentView, warnTitle, warnDescription, null);
	}

	public WarningDialog(@Nullable JFrame parentView, String warnTitle, String warnDescription,
						 @Nullable ViewActions[] warnButtonActions){
		super(parentView, TextNameConstants.TITLE_WARNING);
		title = warnTitle;
		description = warnDescription;
		if(warnButtonActions != null)
		{
			setButtonActions(warnButtonActions);
		}
		else
		{
			setButtonActions(DEFAULT_BUTTON_ACTIONS);
		}

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
