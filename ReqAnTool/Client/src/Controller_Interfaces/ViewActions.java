package Controller_Interfaces;

/**
 * Created by phlippe on 28.04.17.
 */
public enum ViewActions
{
	OK("OK"),
	CANCEL("CANCEL"),
	SAVE("SAVE"),
	SAVE_AS("SAVE_AS"),
	ADD("ADD"),
	DELETE("DELETE"),
	EDIT("EDIT"),
	CLOSE("CLOSE"),
	BACK("BACK"),
	TABLE_SELECTION_ADD("SELECTION_ADD"),
	TABLE_SELECTION_DELETE("SELECTION_DELETE"),
	OPEN("OPEN"),
	NEW("NEW"),
	TEXT_CHANGED("TEXT_CHANGED"),
	TO_XML("2XML"),
	TO_PDF("2PDF");

	private final String text;

	/**
	 * @param text
	 */
	private ViewActions(final String text) {
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
