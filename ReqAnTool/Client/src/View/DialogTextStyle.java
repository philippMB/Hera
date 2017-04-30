package View;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.Arrays;

public class DialogTextStyle implements TextStyleBridge {

    private Font titleFont;
    private Font tagedToFieldFont;
    private Font tagedToAreaFont;
    private Font informationFont;


    public DialogTextStyle()
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

        titleFont = new Font(titleFontName,Font.BOLD,14);
    }

    @Override
    public void styleAsTagedNameToField(JLabel pLabel)
    {
        // TODO Implement this method
        pLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pLabel.setVerticalAlignment(SwingConstants.TOP);
    }

    @Override
    public void styleAsTagedNameToArea(JLabel pLabel)
    {
        // TODO Implement this method
        pLabel.setHorizontalAlignment(SwingConstants.LEFT);
        pLabel.setVerticalAlignment(SwingConstants.TOP);
    }

    @Override
    public void styleAsTitle(JLabel pLabel)
    {
        // TODO Implement this method
        pLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pLabel.setFont(titleFont);
    }

    @Override
    public void styleAsInformation(JTextComponent pLabel) {

    }

}
