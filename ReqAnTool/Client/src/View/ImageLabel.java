package View;

import Logging.ILoggerFactory;
import Logging.TraceLoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import Logging.ILogger;

/**
 * Created by phlippe on 28.04.17.
 */
public class ImageLabel
	extends JLabel
{

	private ILogger myLogger;


	public ImageLabel()
	{
		super();
		myLogger = ILoggerFactory.getInstance().createLogger();
	}

	public ImageLabel(Path imagePath)
	{
		this(imagePath,0,0);
	}

	public ImageLabel(Path imagePath, int imageWidth, int imageHeight)
	{
		super();
		myLogger = ILoggerFactory.getInstance().createLogger();

		setScaledImage(imagePath,imageWidth,imageHeight);
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
			ImageIcon icon = new ImageIcon(image);
			setIcon(icon);
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
			ImageIcon icon = new ImageIcon(imagePath.toString());
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

}
