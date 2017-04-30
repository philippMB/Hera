package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

/**
 * Created by phlippe on 28.04.17.
 */
public class ImageLabel
	extends JLabel
{

	public ImageLabel(Path imagePath){
		this(imagePath,0,0);
	}

	public ImageLabel(Path imagePath, int imageWidth, int imageHeight)
	{
		super();
		try
		{
			Image image = ImageIO.read(new File(String.valueOf(imagePath)));
			if(imageWidth > 0 && imageHeight > 0)
			{
				image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
			}
			ImageIcon icon = new ImageIcon(image);
			setIcon(icon);
		}
		catch (IOException ex)
		{
			System.err.println("Image \""+imagePath.toString()+"\" could not be loaded...");
			ex.printStackTrace();

			setText("Kein Bild gefunden");
		}

	}

}
