package View;

import Controller_Interfaces.ITextController;
import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ITextTab;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Observable;

/**
 * Created by phlippe on 30.04.17.
 */
public abstract class TextTab
	extends TabPanel
	implements ITextTab
{

	private static final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.SAVE,
			ViewActions.RESET
	};

	private JTextArea textAreaDescription;


	public TextTab(IModelGetData model, String titleConstant)
	{
		super(model, titleConstant);
	}

	protected void buildTextPanel()
	{
		setButtonActions(BUTTON_ACTIONS);

		textAreaDescription = myBuilder.addNamedTextArea(
				null,
				getDescriptionFromModel()
		);
		myButtons = myBuilder.addButtonBar(myButtonActions);

		setActionCommands();
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription()
	{
		return textAreaDescription.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resetDescription()
	{
		textAreaDescription.setText(getDescriptionFromModel());
	}

	protected abstract String getDescriptionFromModel();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addTextController(ITextController textfieldController)
	{
		if(textAreaDescription != null)
		{
			TextAreaListener textAreaListener = new TextAreaListener(textfieldController);
			textAreaDescription.getDocument().addDocumentListener(textAreaListener);
		}
	}

}
