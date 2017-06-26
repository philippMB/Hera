package View;

import Controller_Interfaces.IViewController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import LanguageAndText.TextNameConstants;
import View.ImageTextButton.ImageTextMouseListener;
import View_Interfaces.IMenuBar;
import View_Interfaces.IStartView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.nio.file.Paths;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class StartView
	extends JFrame
	implements IStartView
{

	private PanelBuilder myBuilder;
	private ITextFacade myTextBundle;
	private ImageTextButton[] myButtons;
	private MenuBar myMenuBar;


	public StartView()
	{
		super();
		myTextBundle = ITextFacade.getInstance();
		setTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_REQAN_TOOL));
		setSize(500,500);
		myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);
		myMenuBar = new StandardMenuBar(false);

		setJMenuBar(myMenuBar);
		init();
	}

	private void init()
	{
		initializeImageTextButtons();
		setUndecorated(true);
		getContentPane().setLayout(new GridLayout());

		String titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_MAIN_MENU);
		setTitle(titleText);
		myBuilder.addImage(Paths.get(ImagePathConstants.LOGO_IMAGE_PATH_STRING));
		myBuilder.addTitle(titleText);
		for(ImageTextButton buttonPanel: myButtons)
		{
			myBuilder.addPanel(buttonPanel);
		}

		JPanel aPanel = myBuilder.getResult();
		aPanel.setOpaque(false);
		getContentPane().add(aPanel, BorderLayout.CENTER);
		getContentPane().setBackground(Color.WHITE);

		pack();
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	private void initializeImageTextButtons()
	{
		myButtons = new ImageTextButton[4];
		myButtons[0] = new ImageTextButton(
						Paths.get(ImagePathConstants.NEW_PROJECT_IMAGE_PATH_STRING),
						myTextBundle.getButtonText(ViewActions.NEW_PROJECT),
						ViewActions.NEW_PROJECT
				);
		myButtons[1] = new ImageTextButton(
						Paths.get(ImagePathConstants.OPEN_PROJECT_IMAGE_PATH_STRING),
						myTextBundle.getButtonText(ViewActions.OPEN_PROJECT),
						ViewActions.OPEN_PROJECT
				);
		myButtons[2] = new ImageTextButton(
						Paths.get(ImagePathConstants.IMPORT_IMAGE_PATH_STRING),
						myTextBundle.getButtonText(ViewActions.FROM_XML),
						ViewActions.FROM_XML
				);
		myButtons[3] = new ImageTextButton(
						Paths.get(ImagePathConstants.CLOSE_IMAGE_PATH_STRING),
						myTextBundle.getButtonText(ViewActions.CLOSE),
						ViewActions.CLOSE
				);
	}

	@Override
	public void addController(IViewController newController)
	{
		for(ImageTextButton b: myButtons)
		{
			b.addController(newController);
		}
		addWindowListener(newController);
	}

	@Override
	public void showView()
	{
		SwingUtilities.invokeLater(
				() -> setVisible(true)	// Runnable -> run(){...}
		);
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
		toFront();
	}

	@Override
	public void update(Observable o, Object arg)
	{
		//Nothing to be updated
	}

	/**
	 * Returns the belonging menu bar
	 *
	 * @return Menu bar which belongs to the view
	 */
	@Override
	public IMenuBar getViewMenu()
	{
		return myMenuBar;
	}
}
