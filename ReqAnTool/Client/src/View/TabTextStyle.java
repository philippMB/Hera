package View;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by phlippe on 28.04.17.
 */
public class TabTextStyle
	implements TextStyleBridge
{

	private Font titleFont;
	private Font tagedToFieldFont;
	private Font tagedToAreaFont;
	private Font informationFont;

	public TabTextStyle()
	{
		String[] allPossibleFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().
				getAvailableFontFamilyNames();
		for(String s : allPossibleFonts)
			System.out.println( s );

		String titleFontName = "Helvetica Neue";
		String tagedToFieldFontName;
		String tagedToAreaFontName;
		String informationFontName;

		if(Arrays.asList(allPossibleFonts).contains(titleFontName)){
			titleFontName = "Sans Serif";
		}

		titleFont = new Font(titleFontName,Font.BOLD,16);
	}

	@Override
	public void styleAsTagedNameToField(JLabel pLabel)
	{

	}

	@Override
	public void styleAsTagedNameToArea(JLabel pLabel)
	{

	}

	@Override
	public void styleAsTitle(JLabel pLabel)
	{
		pLabel.setFont(titleFont);
		pLabel.setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public void styleAsInformation(JTextComponent pLabel)
	{

	}
}
