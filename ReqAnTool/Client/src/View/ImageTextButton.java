package View;

import Controller_Interfaces.IViewController;
import Controller_Interfaces.ViewActions;
import Logging.ILogger;
import Logging.ILoggerFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by phlippe on 17.05.17.
 */
public class ImageTextButton
	extends JPanel
{

	private static final Color COLOR_BORDER_SEL = new Color(178, 180, 184);
	private static final Color COLOR_BORDER_CLICKED = new Color(73, 157, 184);
	private static final Border BORDER_SELECTED = BorderFactory.createLineBorder(COLOR_BORDER_SEL, 2, true);
	private static final Border BORDER_CLICKED = BorderFactory.createLineBorder(COLOR_BORDER_CLICKED, 4, true);
	private static final Border BORDER_DEFAULT = BorderFactory.createEmptyBorder(2,2,2,2);

	private Path imagePath;
	private ImageLabel imageLabel;
	private String labelText;
	private ViewActions myViewAction;
	private IViewController myController;
	private ILogger myLogger;


	public ImageTextButton(Path imagePath, String textNextToImage, ViewActions viewActionOnClick)
	{
		super();
		this.imagePath = imagePath;
		labelText = textNextToImage;
		myViewAction = viewActionOnClick;
		myController = null;
		myLogger = ILoggerFactory.getInstance().createLogger();

		init();
	}

	private void init()
	{
		JPanel innerPanel = new JPanel(new BorderLayout());
		innerPanel.setOpaque(false);

		imageLabel = new ImageLabel();
		imageLabel.setScaledImage(imagePath, 50, 50);
		innerPanel.add(BorderLayout.WEST,imageLabel);

		TabTextStyle textStyler = new TabTextStyle();
		JLabel myTextLabel = new JLabel("   "+labelText);
		textStyler.styleAsSubtitle(myTextLabel);
		innerPanel.add(BorderLayout.EAST,myTextLabel);

		setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5,5,5,5);

		add(innerPanel,constraints);
		setBackground(Color.WHITE);
		setBorder(BORDER_DEFAULT);

		addMouseListener(new ImageTextMouseListener());

	}

	public void addController(IViewController controller)
	{
		myController = controller;
	}


	public class ImageTextMouseListener
		implements MouseListener
	{
		private boolean isMouseOn;


		public ImageTextMouseListener()
		{
			isMouseOn = false;
		}

		@Override
		public void mouseClicked(MouseEvent e)
		{
			if(myController != null)
			{
				ActionEvent buttonClickedEvent = new ActionEvent(this, 0, myViewAction.toString());
				myController.actionPerformed(buttonClickedEvent);
			}
			else
			{
				myLogger.warning("ImageTextButton was clicked without having a controller. ViewAction: "+
						myViewAction.toString()+", Text: "+labelText);
			}
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			setBorder(BORDER_CLICKED);
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			if(isMouseOn)
			{
				setBorder(BORDER_SELECTED);
			}
			else
			{
				setBorder(BORDER_DEFAULT);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			setBorder(BORDER_SELECTED);
			isMouseOn = true;
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			setBorder(BORDER_DEFAULT);
			isMouseOn = false;
		}
	}
}
