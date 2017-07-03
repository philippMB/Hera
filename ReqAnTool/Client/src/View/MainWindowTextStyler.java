package View;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.Arrays;

/**
 * This class is a implementation of {@link TextStyleBridge} and should be used for main windows. Main windows include
 * tabs and start views.
 *
 * @author 9045534
 * @version 1.0
 */
public class MainWindowTextStyler
	implements TextStyleBridge
{

	private Font titleFont;
	private Font subtitleFont;


	public MainWindowTextStyler()
	{
		String[] allPossibleFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().
				getAvailableFontFamilyNames();
		String titleFontName = "Helvetica Neue";
		if(Arrays.asList(allPossibleFonts).contains(titleFontName)){
			titleFontName = "Sans Serif";
		}

		titleFont = new Font(titleFontName,Font.BOLD,16);
		subtitleFont = new Font(titleFontName,Font.BOLD,14);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void styleAsTagedNameToField(JLabel pLabel)
	{
		//Nothing to style. Should stay default
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void styleAsTagedNameToArea(JLabel pLabel)
	{
		//Nothing to style. Should stay default
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void styleAsTitle(JLabel pLabel)
	{
		pLabel.setFont(titleFont);
		pLabel.setHorizontalAlignment(JLabel.CENTER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void styleAsSubtitle(JLabel pLabel)
	{
		pLabel.setFont(subtitleFont);
		pLabel.setHorizontalAlignment(JLabel.LEFT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void styleAsInformation(JTextComponent pLabel)
	{
		//Nothing to style. Should stay default
	}
}
