package Controller_Interfaces;

/**
 * Created by phlippe on 28.04.17.
 */
public enum ButtonActions
{
	OK("OK"),
	CANCEL("CANCEL"),
	SAVE("SAVE"),
	ADD("ADD"),
	DELETE("DELETE"),
	EDIT("EDIT"),
	CLOSE("CLOSE"),
	TABLE_SELECTION_ADD("SELECTION_ADD"),
	TABLE_SELECTION_DELETE("SELECTION_DELETE");

	private final String text;

	/**
	 * @param text
	 */
	private ButtonActions(final String text) {
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}

}
