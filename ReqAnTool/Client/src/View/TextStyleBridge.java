package View;

import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

/**
 * This class separates the text style from the {@link PanelBuilder} using the bridge pattern.
 * <p>
 *     Due to the {@link PanelBuilder} builds up a panel with its components the styling of the text is independent of
 *     their real implementation although it belongs together. This is why it is separated by a bridge pattern using this
 *     interface as the specialisation side of the text styler.
 * <p>
 *     <h2>Basic functionality</h2><br>
 *         To style a text this interface provides five different type of styles:
 *         <ul>
 *             <li>{@link TextStyleBridge#styleAsInformation(JTextComponent)} - text only for information</li>
 *             <li>{@link TextStyleBridge#styleAsTagedNameToArea(JLabel)} - name tag to text areas</li>
 *             <li>{@link TextStyleBridge#styleAsTagedNameToField(JLabel)} - name tag to text fields</li>
 *             <li>{@link TextStyleBridge#styleAsTitle(JLabel)} - style for title</li>
 *             <li>{@link TextStyleBridge#styleAsSubtitle(JLabel)} - style for subtitles</li>
 *         </ul>
 *
 *
 * @author 9045534
 * @version 1.0
 * @see PanelBuilder
 * @see MainWindowTextStyler
 * @see SubWindowTextStyler
 */
public interface TextStyleBridge {

	/**
	 * Styles the given label as name tag to text field
	 * @param pLabel Label to be styled
	 */
    public void styleAsTagedNameToField(JLabel pLabel);

	/**
	 * Styles the given label as name tag to text area
	 * @param pLabel Label to be styled
	 */
    public void styleAsTagedNameToArea(JLabel pLabel);

	/**
	 * Styles the given label as title
	 * @param pLabel Label to be styled
	 */
	public void styleAsTitle(JLabel pLabel);


	/**
	 * Styles the given label as subtitle
	 * @param pLabel Label to be styled
	 */
	public void styleAsSubtitle(JLabel pLabel);

	/**
	 * Styles the given label as information text
	 * @param pLabel Label to be styled
	 */
	public void styleAsInformation(JTextComponent pLabel);
    
    
}
