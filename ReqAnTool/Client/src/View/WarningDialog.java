package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
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

	private final ViewActions[] BUTTON_ACTIONS = {
		ViewActions.OK,
		ViewActions.CANCEL
	};

	private String title;
	private String description;
	private ViewActions[] myButtonActions;
	private JButton[] myButtons;


	public WarningDialog(String warnTitle, String warnDescription){
		super(TextNameConstants.TITLE_WARNING);
		title = warnTitle;
		description = warnDescription;
		myButtonActions = BUTTON_ACTIONS;

		init();
	}

	public WarningDialog(String warnTitle, String warnDescription, ViewActions[] warnButtonActions){
		super(TextNameConstants.TITLE_WARNING);
		title = warnTitle;
		description = warnDescription;
		myButtonActions = warnButtonActions;

		init();
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
		myButtons = myBuilder.addButtonBar(myButtonActions);

		getContentPane().add(
				new BorderDecorater(
						myBuilder.getResult(),
						WARN_COLOR,
						myTextBundle.getTitleText(TextNameConstants.TITLE_WARNING)
				)
		);
		setActionCommands();

		pack();
		setVisible(true);
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
