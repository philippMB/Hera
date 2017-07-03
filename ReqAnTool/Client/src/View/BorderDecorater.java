package View;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * This class represents a decorator of a JPanel extending it with a border.
 * <p>
 *     For warning and exception dialogs the user should also have a visual feedback. This is why this class provides
 *     a <b>Decorator pattern</b> for creating a colored border around a given panel. In addition a text will be
 *     displayed in the left upper corner.<br>
 *     As an alternative the default constructor creates a empty border used for separating different objects.
 *
 * @author 9045534
 * @version 1.0
 */
public class BorderDecorater
    extends JPanel
{

	/**
	 * Default constructor which creates an empty border around the given panel
	 * @param toDecorate {@link JPanel} which should be decorated with the border
	 */
	public BorderDecorater(JPanel toDecorate)
	{
		super();
		setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.add(toDecorate);
	}

	/**
	 * Constructor for creating a colored border with a given name in the upper left corner around the panel.
	 * @param toDecorate {@link JPanel} which should be decorated with the border
	 * @param pColor Color of the border
	 * @param pName Text which should be displayed in the upper left corner
	 */
	public BorderDecorater(JPanel toDecorate, Color pColor, String pName)
    {
        super();
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(pColor, 5), pName, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, pColor),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        this.add(toDecorate);
    }



}
