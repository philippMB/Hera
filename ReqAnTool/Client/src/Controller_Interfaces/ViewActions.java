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
	DONT_SAVE("DONT_SAVE"),
	ADD("ADD"),
	DELETE("DELETE"),
	EDIT("EDIT"),
	CLOSE("CLOSE"),
	BACK("BACK"),
	TABLE_SELECTION_ADD("SELECTION_ADD"),
	TABLE_SELECTION_DELETE("SELECTION_DELETE"),
	OPEN("OPEN"),
	NEW("NEW"),
	SHOW("SHOW"),
	NEW_PROJECT("NEW_PROJECT"),
	OPEN_PROJECT("OPEN_PROJECT"),
	TEXT_CHANGED("TEXT_CHANGED"),
	FROM_XML("FROM_XML"),
	TO_XML("TO_XML"),
	TO_PDF("TO_PDF"),
	RATE("RATE"),
	RATE_WF("RATE_WEIGHT_FACTORS"),
	SHOW_CE("SHOW_CE"),
	EDIT_CE("EDIT_CE"),
	DELETE_CE("DELETE_CE"),
	CALC_FP("CALC_FP"),
	OPTIMIZE_WF("OPTIMIZE_WEIGHT_FACTORS"),
	ENTER_AS("ENTER_AS"),
	EDIT_EP("EDIT_ELEMENTARY_PROCESS"),
	RESET("RESET"),
	CREATE("CREATE"),
	ADD_FREQ("ADD_FREQ"),
	ADD_NFREQ("ADD_NFREQ"),
	ADD_PROD("ADD_PRODUCT_DATA"),
	ADD_QR("ADD_QUALITY_REQUIREMENT"),
	ADD_GLOS("ADD_GLOSSARY_ENTRY"),
	ADD_ADDIT("ADD_ADDITION"),
	CREATE_CE("CREATE_CE");

	private final String propertyName;

	/**
	 * @param propertyName
	 */
	private ViewActions(final String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return propertyName;
	}

	public static ViewActions fromString(String text) {
		ViewActions matchingAction = null;
		for (ViewActions action : ViewActions.values()) {
			if (action.propertyName.equalsIgnoreCase(text)) {
				matchingAction = action;
				break;
			}
		}
		return matchingAction;
	}

}
