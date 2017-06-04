package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IProjectTab;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by phlippe on 27.04.17.
 */
public class ProjectTab
	extends TabPanel
	implements IProjectTab
{

	private final static ViewActions[] BUTTON_ACTIONS = {
			ViewActions.SAVE,
			ViewActions.TO_PDF,
			ViewActions.TO_XML,
			ViewActions.DELETE,
			ViewActions.CLOSE
	};

	public ProjectTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_PROJECT_TAB);
	}

	protected void init(){
		System.out.println(BUTTON_ACTIONS[0].toString());
		setButtonActions(BUTTON_ACTIONS);

		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_PROJECT_TAB));
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		setActionCommands();

		add(myBuilder.getResult());
	}

	@Override
	public void update(Observable o, Object arg)
	{
		//Nothing to be updated
	}

}
