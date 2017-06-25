package View;

import Controller_Interfaces.ITextController;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Created by phlippe on 24.06.17.
 */
public class TextAreaListener
		implements DocumentListener
{

	private ITextController controllerToNotify;


	public TextAreaListener(ITextController controllerToNotify)
	{
		this.controllerToNotify = controllerToNotify;
	}

	/**
	 * Gives notification that there was an insert into the document.  The
	 * range given by the DocumentEvent bounds the freshly inserted region.
	 *
	 * @param e the document event
	 */
	@Override
	public void insertUpdate(DocumentEvent e)
	{
		controllerToNotify.textChanged();
	}

	/**
	 * Gives notification that a portion of the document has been
	 * removed.  The range is given in terms of what the view last
	 * saw (that is, before updating sticky positions).
	 *
	 * @param e the document event
	 */
	@Override
	public void removeUpdate(DocumentEvent e)
	{
		controllerToNotify.textChanged();
	}

	/**
	 * Gives notification that an attribute or set of attributes changed.
	 *
	 * @param e the document event
	 */
	@Override
	public void changedUpdate(DocumentEvent e)
	{
		controllerToNotify.textChanged();
	}
}
