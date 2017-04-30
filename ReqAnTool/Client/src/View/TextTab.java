package View;

import Controller_Interfaces.ViewActions;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ITextTab;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by phlippe on 30.04.17.
 */
public abstract class TextTab
	extends TabPanel
	implements ITextTab
{

	private JTextArea textAreaDescription;
	private JButton buttonSave;
	private JButton buttonDelete;
	private ActionListener myActionListener;
	private boolean isSaved;	//TODO: DocumentListener auf TextArea


	public TextTab(IModelGetData model, String tabName)
	{
		super(model, tabName);
	}

	protected void buildTextPanel()
	{
		String[] buttonNames = {"Speichern","Löschen"};

		textAreaDescription = myBuilder.addNamedTextArea(null,"");
		JButton[] myButtons = myBuilder.addButtonBar(buttonNames);
		buttonSave = myButtons[0];
		buttonDelete = myButtons[1];

		setActionCommands();
		isSaved = true;
	}

	private void setActionCommands()
	{
		buttonSave.setActionCommand(ViewActions.SAVE.toString());
		buttonDelete.setActionCommand(ViewActions.DELETE.toString());
	}

	@Override
	public void addController(ActionListener actionListener)
	{
		buttonSave.addActionListener(actionListener);
		buttonDelete.addActionListener(actionListener);
		//TODO: DocumentListener auf TextArea
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
