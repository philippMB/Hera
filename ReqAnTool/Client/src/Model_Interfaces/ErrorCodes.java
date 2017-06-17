package Model_Interfaces;

/**
 * @author 7532274
 * @author 9045534
 * @version 2.0
 */
public enum ErrorCodes
{
    NO_ERROR("EC_NO_ERROR"),
    REFERENCES_NOT_SOLVED("EC_REF_NOT_SOLVED"),
    LIST_OVERFLOW("EC_LIST_OVERFLOW"),
    DUPLICATE("EC_DUPLICATE"),
    NOT_EXISTENT("EC_NOT_EXISTENT"),
    NO_COST_ESTIMATION("EC_NO_COST_ESTIMATION"),
    INVALID_ARGUMENT("EC_INVALID_ARGUMENT"),
    INVALID_MAIL("EC_INVALID_MAIL"),
    INVALID_PHONE("EC_INVALID_PHONE"),
    INVALID_ADDRESS("EC_INVALID_ADDRESS"),
    INVALID_ID("EC_INVALID_ID"),
    REFERENCES_ON_ITEM_DELETED("EC_REF_ON_ITEM_DELETED"),
    NO_REQAN("EC_NO_REQAN"),
    FP_NOT_EXISTENT("EC_FP_NOT_EXISTENT"),
    NULL_POINTER("EC_NULL_POINTER");

    private final String text;

    /**
     * @param text
     */
    private ErrorCodes(final String text) {
        this.text = text;
    }

    /**
	 * @see java.lang.Enum#toString()
	 */
    @Override
    public String toString() {
        return text;
    }

}
