package View;

import Logging.ILoggerFactory;
import Logging.TraceLoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Path;
import Logging.ILogger;
import com.sun.istack.internal.Nullable;

/**
 * This class provides a component for simply adding images or GIFs to a view. It is based on {@link JLabel} and
 * supports Retina displays.
 *
 * @author 9045534
 * @version 1.0
 */
public class ImageLabel
	extends JLabel
{

	private ILogger myLogger;


	/**
	 * Default constructor which initialize the {@link JLabel} without image.
	 */
	public ImageLabel()
	{
		this(null);
	}

	/**
	 * Constructor with initializing image without scaling.
	 * @param imagePath Path to image
	 */
	public ImageLabel(@Nullable Path imagePath)
	{
		this(imagePath,0,0);
	}

	/**
	 * Constructor with initializing image with scaling to specified size.
	 * @param imagePath Path to image
	 * @param imageWidth Width to which the image should be scaled.
	 * @param imageHeight Height to which the image should be scaled.
	 */
	public ImageLabel(@Nullable Path imagePath, int imageWidth, int imageHeight)
	{
		this(imagePath, imageWidth, imageHeight, false);
	}

	/**
	 * Constructor with initializing image with scaling to specified size and specifying whether it the image is a GIF or not.
	 * @param imagePath Path to image
	 * @param imageWidth Width to which the image should be scaled.
	 * @param imageHeight Height to which the image should be scaled.
	 * @param isGIF Specifies if image is GIF or not
	 */
	public ImageLabel(@Nullable Path imagePath, int imageWidth, int imageHeight, boolean isGIF)
	{
		super();
		myLogger = ILoggerFactory.getInstance().createLogger();
		if(imagePath != null)
		{
			if (isGIF)
			{
				setGIF(imagePath);
			}
			else
			{
				setScaledImage(imagePath, imageWidth, imageHeight);
			}
		}
	}

	/**
	 * Sets image to given image path and scales it to the given width and height.
	 * @param imagePath Path to image
	 * @param imageWidth Width to which it should be scaled. If its <= 0 the image will be taken by full resolution.
	 * @param imageHeight Height to which it should be scaled. If its <= 0 the image will be taken by full resolution.
	 */
	public void setScaledImage(Path imagePath, int imageWidth, int imageHeight)
	{
		try
		{
			if(!isRetina())
			{
				Image image = ImageIO.read(new File(String.valueOf(imagePath)));
				if (imageWidth > 0 && imageHeight > 0)
				{
					image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
				}
				ImageIcon icon = new ImageIcon(image);
				setIcon(icon);
			}
			else
			{
				ImageIcon icon = getIcon(imagePath);
				setIcon(icon);
				setMinimumSize(new Dimension(imageWidth, imageHeight));
				setPreferredSize(new Dimension(imageWidth, imageHeight));
				setMaximumSize(new Dimension(imageWidth, imageHeight));
			}
		}
		catch (Exception ex)
		{
			printLogInfo(imagePath, ex);
			setText("Kein Bild gefunden");
		}
	}

	/**
	 * Sets image as GIF to given image path.
	 * @param imagePath Path to GIF
	 */
	public void setGIF(Path imagePath)
	{
		try
		{
			ImageIcon icon = getIcon(imagePath);
			setIcon(icon);
			icon.getImage().flush();
		}
		catch(NullPointerException ex)
		{
			printLogInfo(imagePath, ex);
			setText("Kein Bild gefunden");
		}
	}

	private void printLogInfo(Path imagePath, Exception exception)
	{
		String logMessage = "";
		if(imagePath != null)
			logMessage = "Image \""+imagePath.toString()+"\" could not be loaded...";
		else
			logMessage = "Imagepath is null";
		myLogger.warning(logMessage, exception);
	}

	/**
	 * Creates an {@link ImageIcon} object out of the image specified by filePath. Used for retina images.
	 * @param filePath Path to image
	 * @return {@link ImageIcon} of specified image
	 */
	public static ImageIcon getIcon(Path filePath) {
		URL url = null;
		ImageIcon createdIcon;
		try
		{
			url = filePath.toUri().toURL();
		}
		catch (Exception ex)
		{

		}
		if (url != null) {
			createdIcon = new RetinaIcon(Toolkit.getDefaultToolkit().createImage(url));
		}
		else
		{
			createdIcon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(url));
		}
		return createdIcon;
	}

	/**
	 * Inner class for construction retina supporting {@link ImageIcon}s
	 * @author 9045534
	 * @version 1.0
	 */
	private static final class RetinaIcon extends ImageIcon {

		public RetinaIcon(final Image image) {
			super(image);
		}

		public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
			ImageObserver observer = getImageObserver();

			if (observer == null) {
				observer = c;
			}

			Image image = getImage();
			int width = image.getWidth(observer);
			int height = image.getHeight(observer);
			final Graphics2D g2d = (Graphics2D)g.create(x, y, width, height);

			g2d.scale(0.5, 0.5);
			g2d.drawImage(image, 0, height/2, observer);
			g2d.scale(1, 1);
			g2d.dispose();
		}
	}

	//TODO: Get function to specify if it is retina or not
	private static boolean isRetina()
	{
		return true;
	}
/*
	private static boolean isRetina() {
		try {
			final boolean[] isRetina = new boolean[1];
			new apple.awt.CImage.HiDPIScaledImage(1,1,BufferedImage.TYPE_INT_ARGB) {
				@Override
				public void drawIntoImage(BufferedImage image, float v) {
					isRetina[0] = v > 1;
				}
			};
			return isRetina[0];
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}
*/
}
