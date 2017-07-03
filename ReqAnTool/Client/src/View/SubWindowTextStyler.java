package View;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.Arrays;

/**
 * This class is a implementation of {@link TextStyleBridge} and should be used for sub windows. Sub windows include
 * form windows and dialogs.
 *
 * @author 9045534
 * @version 1.0
 */
public class SubWindowTextStyler
		implements TextStyleBridge
{

    private Font titleFont;


    public SubWindowTextStyler()
    {
        String[] allPossibleFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getAvailableFontFamilyNames();
        String titleFontName = "Helvetica Neue";
        if(Arrays.asList(allPossibleFonts).contains(titleFontName)){
            titleFontName = "Sans Serif";
        }

        titleFont = new Font(titleFontName,Font.BOLD,14);
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
    public void styleAsTagedNameToField(JLabel pLabel)
    {
        pLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.setVerticalAlignment(SwingConstants.TOP);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void styleAsTagedNameToArea(JLabel pLabel)
    {
        pLabel.setHorizontalAlignment(SwingConstants.LEFT);
        pLabel.setVerticalAlignment(SwingConstants.TOP);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void styleAsTitle(JLabel pLabel)
    {
        pLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pLabel.setFont(titleFont);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void styleAsSubtitle(JLabel pLabel)
    {
        pLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void styleAsInformation(JTextComponent pLabel)
    {
		// Nothing to be styled. Default style
    }

}
