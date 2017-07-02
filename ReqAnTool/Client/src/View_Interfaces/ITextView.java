package View_Interfaces;

import Controller_Interfaces.ITextController;

/**
 * This interface are for views containing text views that should be controlled.
 * <p>
 * If the controller of a view has to check if the entries of text fields have changed views of this interface allow to
 * add a {@link ITextController} to itself. It is informed via {@link ITextController#textChanged()} whenever the
 * content of a text field has changed.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see ITextController
 */
public interface ITextView
{

	/**
	 * Adds a {@link ITextController} to the text field to observe the changes of text. It will be notified whenever
	 * the text is changed by the user in this view.
	 * @param textfieldController Controller which should be notified
	 */
	public void addTextController(ITextController textfieldController);

}
