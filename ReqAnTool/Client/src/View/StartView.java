package View;

import Controller_Interfaces.IController;
import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;
import LanguageAndText.TextNameConstants;
import View_Interfaces.IStartView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class StartView
	extends JFrame
	implements IStartView
{

	private static final String WARN_IMAGE_PATH_STRING =
			"/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/loading.gif";
	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.NEW_PROJECT,
			ViewActions.OPEN_PROJECT,
			ViewActions.CLOSE
	};

	private PanelBuilder myBuilder;
	private ITextFacade myTextBundle;
	private JButton[] myButtons;


	public StartView()
	{
		super();
		myTextBundle = ITextFacade.getInstance();
		setTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_REQAN_TOOL));
		setSize(500,500);
		myBuilder = PanelBuilderFactory.getInstance().createPanelBuilder(this);

		init();
	}

	private void init()
	{
		getContentPane().setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
		setUndecorated(true);
		getContentPane().setLayout(new GridLayout());

		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_MAIN_MENU));
		myButtons = myBuilder.addButtonBar(BUTTON_ACTIONS);

		JPanel aPanel = myBuilder.getResult();
		aPanel.setOpaque(false);
		aPanel.add(new ImageTextButton(null));
		setActionCommands();
		getContentPane().add(aPanel, BorderLayout.CENTER);
		getContentPane().setBackground(Color.WHITE);


		try
		{
			Path imagePath = Paths.get(WARN_IMAGE_PATH_STRING);
			Image image = ImageIO.read(new File(String.valueOf(imagePath)));
			if(image == null)
				System.out.println("Image is null");
			setIconImage(image);
		}
		catch (IOException ex)
		{
			System.out.println("Can not set new Icon Image");
		}


		pack();
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void setActionCommands()
	{
		for(int i=0;i<BUTTON_ACTIONS.length;i++)
		{
			myButtons[i].setActionCommand(BUTTON_ACTIONS[i].toString());
		}
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

	@Override
	public void destruct()
	{

	}

	@Override
	public void update(Observable o, Object arg)
	{
		//Nothing to be updated
	}

}
