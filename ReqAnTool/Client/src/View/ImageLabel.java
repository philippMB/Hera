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
 * Created by phlippe on 28.04.17.
 */
public class ImageLabel
	extends JLabel
{

	private ILogger myLogger;


	public ImageLabel()
	{
		this(null);
	}

	public ImageLabel(@Nullable Path imagePath)
	{
		this(imagePath,0,0);
	}

	public ImageLabel(@Nullable Path imagePath, int imageWidth, int imageHeight)
	{
		this(imagePath, imageWidth, imageHeight, false);
	}

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

	public void setScaledImage(Path imagePath, int imageWidth, int imageHeight)
	{
		try
		{
			Image image = ImageIO.read(new File(String.valueOf(imagePath)));
			if(imageWidth > 0 && imageHeight > 0)
			{
				image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_AREA_AVERAGING);
			}
			ImageIcon icon = getIcon(imagePath);//new ImageIcon(image);
			setIcon(icon);
			setMinimumSize(new Dimension(imageWidth,imageHeight));
			setPreferredSize(new Dimension(imageWidth,imageHeight));
			setMaximumSize(new Dimension(imageWidth,imageHeight));
		}
		catch (Exception ex)
		{
			printLogInfo(imagePath, ex);
			setText("Kein Bild gefunden");
		}
	}

	public void setGIF(Path imagePath)
	{
		try
		{
			ImageIcon icon = getIcon(imagePath);//new ImageIcon(imagePath.toString());
			setIcon(icon);
			icon.getImage().flush();
		}
		catch(NullPointerException ex)
		{
			printLogInfo(imagePath, ex);
			setText("Kein Bild gefunden");
		}
	}

	public void setImage(Path imagePath)
	{
		setScaledImage(imagePath,-1,-1);
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

	public static ImageIcon getIcon(Path filePath) {
		URL url = null;
		try
		{
			url = filePath.toUri().toURL();
		}
		catch (Exception ex)
		{

		}
		if (url != null) {
			//url = add2xAtTheEndOfPath(url);
			return new RetinaIcon(Toolkit.getDefaultToolkit().createImage(url));
		}

		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(url));
	}

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
