package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import View_Interfaces.IView;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by phlippe on 27.04.17.
 */
public abstract class DialogView
	extends JDialog
	implements IView
{

	protected ViewActions[] myButtonActions;
	protected JButton[] myButtons;
	protected ITextFacade myTextBundle;
	protected PanelBuilder myBuilder;

	public DialogView(String titleConstant){
		super();

		setSize(300,200);   //Ungefähre Größe, damit Factory richtigen Builder erzeugen kann
		setResizable(false);
		setModal(true);

		myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);
		myTextBundle = ITextFacade.getInstance();

		setTitle(myTextBundle.getTitleText(titleConstant));
	}

	protected void setButtonActions(ViewActions[] buttonActions)
	{
		myButtonActions = buttonActions;
		myButtons = new JButton[myButtonActions.length];
	}

	protected void setActionCommands()
	{
		for(int i=0;i<myButtonActions.length;i++)
		{
			myButtons[i].setActionCommand(myButtonActions[i].toString());
		}
	}

	protected String[] getButtonNames()
	{
		String[] buttonNames = new String[myButtonActions.length];

		for(int i=0;i<buttonNames.length;i++)
		{
			buttonNames[i] = myTextBundle.getButtonText(myButtonActions[i]);
		}

		return getButtonNames();
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
	public void destruct()
	{
		setVisible(false);
		dispose();
	}

	protected abstract void init();

}
