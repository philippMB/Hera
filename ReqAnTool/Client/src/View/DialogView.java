package View;

import Controller_Interfaces.IController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import View_Interfaces.IView;

import javax.swing.*;
import java.nio.file.Path;
import java.util.Observable;

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

		setSize(300,200);   //approx. size so that the correct factory can be build.
		setResizable(false);


		myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);
		myTextBundle = ITextFacade.getInstance();

		setTitle(myTextBundle.getTitleText(titleConstant));
	}

	protected void buildDefaultStructure(String titleText, String descriptionText, Path imagePath)
	{
		myBuilder.addTitle(titleText);
		myBuilder.addImage(imagePath);
		JTextArea textArea = myBuilder.addText(descriptionText);
		textArea.setColumns((getWidth()-80)/8);
		myButtons = myBuilder.addButtonBar(myButtonActions);
		setActionCommands();
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
			if(myButtons[i] != null)
			{
				myButtons[i].setActionCommand(myButtonActions[i].toString());
			}
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
	public void addController(IController newController)
	{
		for(JButton b: myButtons)
		{
			b.addActionListener(newController);
		}
		addWindowListener(newController);
	}

	/**
	 * Will block the running thread!
	 */
	@Override
	public void showView()
	{
		setModal(true);
		setVisible(true);
	}

	@Override
	public void destruct()
	{
		setVisible(false);
		dispose();
	}

	@Override
	public void bringToFront()
	{
		this.toFront();
	}

	/**
	 * This method is called whenever the observed object is changed. An
	 * application calls an <tt>Observable</tt> object's
	 * <code>notifyObservers</code> method to have all the object's
	 * observers notified of the change.
	 *
	 * @param o   the observable object.
	 * @param arg an argument passed to the <code>notifyObservers</code>
	 */
	@Override
	public void update(Observable o, Object arg)
	{
		//As default dialogs do not have to be updated
	}

	protected abstract void init();

}
