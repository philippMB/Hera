package View;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Soll Warnungen und Fehlermeldung entweder Gelb oder Rot umrahmen mit einer Notiz unten rechts (oder oben mittig)
 */
public class BorderDecorater
    extends JPanel
{

    public BorderDecorater(JPanel toDecorate)
	{
		super();
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.add(toDecorate);
	}

    public BorderDecorater(JPanel toDecorate, Color pColor, String pName)
    {
        super();
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(pColor, 5), pName, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, pColor),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        this.add(toDecorate);
    }



}
