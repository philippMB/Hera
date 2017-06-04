package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
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

	private static final String WARN_IMAGE_PATH_STRING =
			"/Users/phlippe/Documents/DHBW Stuttgart/4. Semester/Softwareengineering/Bilder/loading.gif";
	private static final Color COLOR_BORDER = new Color(178, 180, 184);
	private static final Border BORDER_SELECTED = BorderFactory.createLineBorder(COLOR_BORDER, 1, true);
	private static final Border BORDER_DEFAULT = BorderFactory.createEmptyBorder(1,1,1,1);

	private Path imagePath;
	private ImageLabel imageLabel;


	public ImageTextButton(Path imagePath)
	{
		super();
		this.imagePath = Paths.get(WARN_IMAGE_PATH_STRING);

		init();
	}

	private void init()
	{
		JPanel innerPanel = new JPanel(new BorderLayout());
		innerPanel.setOpaque(false);

		imageLabel = new ImageLabel();
		imageLabel.setGIF(imagePath);
		innerPanel.add(BorderLayout.WEST,imageLabel);

		JLabel myText = new JLabel("Hallo");
		innerPanel.add(BorderLayout.EAST,myText);

		setLayout(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5,5,5,5);

		add(innerPanel,constraints);
		setBackground(Color.WHITE);
		setBorder(BORDER_DEFAULT);

		addMouseListener(new ImageTextMouseListener());

	}



	public class ImageTextMouseListener
		implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{

		}

		@Override
		public void mousePressed(MouseEvent e)
		{

		}

		@Override
		public void mouseReleased(MouseEvent e)
		{

		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			setBorder(BORDER_SELECTED);
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			setBorder(BORDER_DEFAULT);
		}
	}
}
