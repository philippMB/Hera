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

	private static final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.OK
	};

	private String descriptionText;
	private String titleText;


	public InfoDialog(JFrame parentView, String dialogPropertyName)
	{
		super(parentView, TextNameConstants.TITLE_INFO);

		initText(
				myTextBundle.getTitleText(dialogPropertyName),
				myTextBundle.getDialogText(dialogPropertyName)
		);
		init();
	}

	public InfoDialog(JFrame parentView, String dialogPropertyName, String[] placeholderInText)
	{
		super(parentView, TextNameConstants.TITLE_INFO);

		initText(
				myTextBundle.getTitleText(dialogPropertyName),
				myTextBundle.getDialogText(dialogPropertyName, placeholderInText)
		);
		init();
	}

	public InfoDialog(JFrame parentView, String title, String informationMessage)
	{
		super(parentView, TextNameConstants.TITLE_INFO);

		initText(title, informationMessage);
		init();
	}

	private void initText(String titleText, String descriptionText)
	{
		this.titleText = titleText;
		this.descriptionText = descriptionText;
	}

	private Path getInfoImagePath()
	{
		return Paths.get(ImagePathConstants.INFO_IMAGE_PATH_STRING);
	}

	@Override
	protected void init()
	{
		setButtonActions(BUTTON_ACTIONS);
		buildDefaultDialogStructure(titleText, descriptionText, getInfoImagePath());
		getContentPane().add(
				new BorderDecorater(myBuilder.getResult())
		);
		pack();
	}

}
