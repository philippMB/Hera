package View_Interfaces;

import Controller_Interfaces.ITextController;

/**
 * This interface is a specialisation of {@link ITab} defining a standard structure of editing a big texts.
 * <p>
 * A requirement analysis contains many descriptions which has to be editable. To
 * give such tasks a standard structure all subclasses of this interface are unified on the following points.
 * </p>
 * <p>
 *     <b>View actions in view</b><br>
 *         A text tab provides two different view actions:
 *         <ul>
 *             <li>{@link Controller_Interfaces.ViewActions#SAVE} - saves the written text in the analysis</li>
 *             <li>{@link Controller_Interfaces.ViewActions#RESET} - resets the current text to the saved text in the
 *             analysis</li>
 *         </ul>
 *         Controller of views implementing this interface have to listen to these actions.
 *
 * <p>
 *     <b>Text field</b><br>
 *         In addition to the view actions the view provides a big text field in which the user can enter his text. To
 *         observe the text changes a {@link ITextController} could be added via
 *         {@link ITextView#addTextController(ITextController)}. It will be notified whenever the text is changed by the
 *         user in this view.
 * </p>
 * <p>
 *     The current implementations of this interface are shown below to give a better overview of the tab structure:<br>
 *     <img src="doc-files/TextTabInterfacesDiagram.png" alt="Implementations of text tab">
 * </p>
 * @author 9045534
 * @version 1.0
 * @see ITab
 * @see ITextTab
 */
public interface ITextTab
	extends ITab, ITextView
{

	/**
	 * Returns the entered string/description of the user.
	 * @return Text which user has entered
	 */
	public String getDescription();

	/**
	 * Sets the content of the text area to the saved description and deletes changes which the user could have done.
	 */
	public void resetDescription();

}
