package LanguageAndText;

/**
 * This class contains solely constants for property names in the properties files "title" and "properties". In these
 * properties files the value of the string is used for the property name. For example is in the title-properties file
 * a property saved for "ADDITION" - Constant TITLE_ADDITION. So this file represents a standard for names used
 * in the property files.
 * <p>
 *     Use this in combination with the {@link ITextFacade} as follows:<br>
 *     <code>
 *         ITextFacade myTextFacade = ITextFacade.getInstance(); //creating an ITextFacade object<br>
 *         String titleForAddition = myTextFacade.getTitle(TextNameConstants.TITLE_ADDITION);<br>
 *     </code>
 *     As a result the string <code>titleForAddition</code> has now the value of the title which the property file
 *     contains for "ADDITION".
 * </p>
 * <p>
 *     If you create or edit a property file please confirm that the constant is entered in this class and also
 *     corresponds to the name given in the property file.
 * </p>
 * <p>
 *     For the property file "button" the names are standardized in {@link Controller_Interfaces.ViewActions}.<br>
 *     All the names and more for the "dialog"-property file are specified in an one class {@link DialogConstants},
 *     in which next to the name strings also the standard buttons for each dialog are given. The titles of
 *     dialogs are still defined in the title property file. Due to this the TITLE_... constant in this file
 *     and DIALOG_... in {@link DialogConstants} must be excluding each other.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see ITextFacade
 * @see Controller_Interfaces.ViewActions
 * @see DialogConstants
 */
public abstract class TextNameConstants
{

	/**
	 * Constants for title-properties file
	 */
	public static final String TITLE_ADDITION = "ADDITION";
	public static final String TITLE_COST_ESTIMATION = "COST_ESTIMATION";
	public static final String TITLE_GLOSSARY = "GLOSSARY";
	public static final String TITLE_PRODUCT_ENVIRONMENT = "PRODUCT_ENVIRONMENT";
	public static final String TITLE_FREQ = "FREQ";
	public static final String TITLE_NFREQ = "NFREQ";
	public static final String TITLE_PRODUCTDATA = "PRODUCTDATA";
	public static final String TITLE_FREQ_SHOW = "FREQ_SHOW";
	public static final String TITLE_NFREQ_SHOW = "NFREQ_SHOW";
	public static final String TITLE_PRODUCTDATA_SHOW = "PRODUCTDATA_SHOW";
	public static final String TITLE_FREQ_ADD_NEW = "FREQ_ADD_NEW";
	public static final String TITLE_NFREQ_ADD_NEW = "NFREQ_ADD_NEW";
	public static final String TITLE_PRODUCTDATA_ADD_NEW = "PRODUCTDATA_ADD_NEW";
	public static final String TITLE_FREQ_EDIT = "FREQ_EDIT";
	public static final String TITLE_NFREQ_EDIT = "NFREQ_EDIT";
	public static final String TITLE_PRODUCTDATA_EDIT = "PRODUCTDATA_EDIT";
	public static final String TITLE_PROCESS_CLASSIFICATION = "PROCESS_CLASSIFICATION";
	public static final String TITLE_PRODUCT_APPLICATION = "PRODUCT_APPLICATION";
	public static final String TITLE_PROJECT_TAB = "PROJECT_TAB";
	public static final String TITLE_QUALIRY_REQ = "QUALITY_REQ";
	public static final String TITLE_TARGET_DEFINITION = "TARGET_DEF";
	public static final String TITLE_WEIGHT_FACTOR_EDIT = "WEIGHT_FACTOR_EDIT";
	public static final String TITLE_REQAN_TOOL = "REQAN_TOOL";
	public static final String TITLE_MAIN_MENU = "MAIN_MENU";
	public static final String TITLE_WARNING = "WARNING";
	public static final String TITLE_ERROR = "ERROR";
	public static final String TITLE_OPTIMIZED_WF = "OPTIMIZED_WF";
	public static final String TITLE_ACTUAL_STATE_EDIT = "ACTUAL_STATE_EDIT";
	public static final String TITLE_CUSTOMER_DATA = "CUSTOMER_DATA";
	public static final String TITLE_CUSTOMER = "CUSTOMER";
	public static final String TITLE_COMPANY = "COMPANY";
	public static final String TITLE_PROJECT_CREATE = "PROJECT_CREATE";
	public static final String TITLE_SUPPLIER = "SUPPLIER";
	public static final String TITLE_INFO = "INFO";
	public static final String TITLE_FILE_MENU = "FILE_MENU";
	public static final String TITLE_EDIT_MENU = "EDIT_MENU";

	/**
	 * Constants for parameter-properties file
	 */
	public static final String PAR_ADDITION = "ADDITION";
	public static final String PAR_COST_EST = "COST_ESTIMATION";
	public static final String PAR_DFP = "DATA_FUNCTION_POINT";
	public static final String PAR_TFP = "TRANSACTION_FUNCTION_POINT";
	public static final String PAR_CUSTOMER = "CUSTOMER";
	public static final String PAR_TITLE = "TITLE";
	public static final String PAR_ACTOR = "ACTOR";
	public static final String PAR_DESC = "DESC";
	public static final String PAR_FP = "FUNCTION_POINT";
	public static final String PAR_MM = "MANMONTH";
	public static final String PAR_CUSTOMER_PM = "CUSTOMER_PM";
	public static final String PAR_CUSTOMER_CUST = "CUSTOMER_CUST";
	public static final String PAR_CUSTOMER_COMP = "CUSTOMER_COMP";
	public static final String PAR_NAME = "NAME";
	public static final String PAR_PHONE_NUMBER = "PHONE_NUMBER";
	public static final String PAR_EMAIL = "EMAIL";
	public static final String PAR_STREET = "STREET";
	public static final String PAR_PLZ = "PLZ";
	public static final String PAR_CITY = "CITY";
	public static final String PAR_COUNTRY = "COUNTRY";
	public static final String PAR_DET = "DET";
	public static final String PAR_RET = "RET";
	public static final String PAR_FTR = "FTR";
	public static final String PAR_TERM = "TERM";
	public static final String PAR_SENSE = "SENSE";
	public static final String PAR_BOUNDARY = "BOUNDARY";
	public static final String PAR_LABEL = "LABEL";
	public static final String PAR_VALIDITY = "VALIDITY";
	public static final String PAR_OBSCURITIES = "OBSCURITIES";
	public static final String PAR_ATTRIBUTES = "ATTRIBUTES";
	public static final String PAR_CONTENT = "CONTENT";
	public static final String PAR_MAX_COUNT = "MAX_COUNT";
	public static final String PAR_CRITERIA = "CRITERIA";
	public static final String PAR_VALUE = "VALUE";
	public static final String PAR_VALUATION = "VALUATION";
	public static final String PAR_ID = "ID";
	public static final String PAR_TYP = "TYP";
	public static final String PAR_EI = "EI";
	public static final String PAR_EO = "EO";
	public static final String PAR_EQ = "EQ";
	public static final String PAR_ILF = "ILF";
	public static final String PAR_EIF = "EIF";
	public static final String PAR_REFERENCES = "REFERENCES";
	public static final String PAR_CREATE_DATA = "CREATE_DATA";
	public static final String PAR_ELEMENTARY_PROCESSES = "ELEMENTARY_PROCESS";
	public static final String PAR_OPTIMIZED = "OPTIMIZED";
	public static final String PAR_CURRENT = "CURRENT";
	public static final String PAR_ACTUAL_STATE = "ACTUAL_STATE";
	public static final String PAR_WEIGHT_FACTORS = "WEIGHT_FACTORS";
	public static final String PAR_NOT_CALCULATED = "NOT_CALCULATED";
	public static final String PAR_NORMAL = "NORMAL";
	public static final String PAR_IMPORTANT = "IMPORTANT";
	public static final String PAR_VERY_IMPORTANT = "VERY_IMPORTANT";
	public static final String PAR_NOT_RELEVANT = "NOT_RELEVANT";
	public static final String PAR_XML_FORMAT = "XML_FORMAT";
	public static final String PAR_REQAN_FORMAT = "REQAN_FORMAT";
	public static final String PAR_FREQ = "FREQ";
	public static final String PAR_NFREQ = "NFREQ";
	public static final String PAR_PRODUCTDATA = "PROD_DATA";
	public static final String PAR_REQAN = "REQAN";
	public static final String PAR_INTEGER = "INTEGER";
	public static final String PAR_DOUBLE = "DOUBLE";
	public static final String PAR_PRODUCT_APPLICATION = "PRODUCT_APPLICATION";
	public static final String PAR_PRODUCT_ENVIRONMENT = "PRODUCT_ENVIRONMENT";
	public static final String PAR_TARGET_DEFINITION = "TARGET_DEFINITION";

}
