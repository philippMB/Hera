package View;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ITextTab;

import javax.swing.*;
import java.util.Observable;

/**
 * Created by phlippe on 30.04.17.
 */
public abstract class TextTab
	extends TabPanel
	implements ITextTab
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.SAVE,
			ViewActions.DELETE
	};

	private JTextArea textAreaDescription;
	private boolean isSaved;


	public TextTab(IModelGetData model, String titleConstant)
	{
		super(model, titleConstant);
	}

	protected void buildTextPanel()
	{

		textAreaDescription = myBuilder.addNamedTextArea(
				null,
				getDescriptionFromModel()
		);
		myButtons = myBuilder.addButtonBar(myButtonActions);

		setActionCommands();
		isSaved = true;
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

	@Override
	public String getDescription()
	{
		return textAreaDescription.getText();
	}

	@Override
	public void setSaved(boolean saved)
	{
		isSaved = saved;
	}

	@Override
	public boolean isSaved()
	{
		return isSaved;
	}

	protected abstract String getDescriptionFromModel();
}
