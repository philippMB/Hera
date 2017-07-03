package LanguageAndText;

import Exceptions.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a standard structure to convert exceptions to property names and filling in the correct
 * placeholders to the dialog message.
 * <p>
 *     Due to an {@link View_Interfaces.IErrorDialog} displays exceptions it has to convert a thrown exception to the
 *     correct message. This is realized with this class while using <b>Singleton pattern</b>.
 *
 * @author 9045534
 * @version 1.0
 * @see ITextFacade
 */
public class ExceptionToTextConverter
{

	/**
	 * Property name of default exception
	 */
	private static final String DIALOG_ERROR_DEFAULT = "DEFAULT_ERROR";
	/**
	 * Map of exception class to its belonging property name in title and dialog resource file
	 */
	private static final Map<Class, String> exceptionToPropertyMap =
			Collections.unmodifiableMap(
					new HashMap<Class, String>()
					{{
						put(ArgumentPatternException.class,"EX_WRONG_PATTERN");
						put(DuplicateIDException.class,"EX_DUPLICATE");
						put(DataAccessException.class,"EX_DATA_ACCESS");
						put(MissingCostEstimationException.class,"EX_NO_COST_ESTIMATION");
						put(MissingEntryException.class,"EX_MISSING_ENTRY");
						put(MissingParameterException.class,"EX_MISSING_PARAMETER");
						put(MissingReqAnException.class,"EX_NO_REQAN");
						put(ListOverflowException.class,"EX_LIST_OVERFLOW");
						put(NumberOutOfBoundsException.class,"EX_NUMBER_OOB");
						put(UnknownEPException.class,"EX_UNKNOWN_EP");
						put(UnknownIDException.class,"EX_UNKNOWN_ID");
						put(UnknownReferenceException.class,"EX_UNKNOWN_REF");
						put(StringNoNumberException.class,"EX_STRING_NO_NUMBER");
						put(NoItemSelectedException.class,"EX_NO_ITEM_SELECTED");
					}}
			);

	/**
	 * Map of exception class to its belonging placeholders which are extracted out of the exception message
	 */
	private static final Map<Class, ExToPlaceholderConverter> exceptionToPlaceholderConverterMap =
			Collections.unmodifiableMap(
					new HashMap<Class, ExToPlaceholderConverter>()
					{{
						put(ArgumentPatternException.class, (textFacade, ex) -> new String[]{
								convertPatternTypeToString(textFacade, ((ArgumentPatternException)ex).getPatternType()),
								((ArgumentPatternException)ex).getPattern()
						});
						put(DataAccessException.class, (textFacade, ex) -> new String[]{
								((DataAccessException)ex).getPath()
						});
						put(DuplicateIDException.class, (textFacade, ex) -> new String[]{
								((DuplicateIDException)ex).getDuplicateID()
						});
						put(MissingCostEstimationException.class, (textFacade, ex) -> new String[0]);
						put(MissingParameterException.class, (textFacade, ex) -> new String[]{
								convertParameterTypeToString(textFacade,
										((MissingParameterException)ex).getMissingParameter())
						});
						put(MissingEntryException.class, (textFacade, ex) -> new String[]{
								convertParameterTypeToString(textFacade,
										((MissingEntryException)ex).getMissingEntry())
						});
						put(MissingReqAnException.class, (textFacade, ex) -> new String[0]);
						put(ListOverflowException.class, (textFacade, ex) -> new String[0]);
						put(NumberOutOfBoundsException.class, (textFacade, ex) -> new String[]{
								textFacade.convertDoubleToString(((NumberOutOfBoundsException)ex).getGivenNumber()),
								textFacade.convertDoubleToString(((NumberOutOfBoundsException)ex).getLowerBound()),
								textFacade.convertDoubleToString(((NumberOutOfBoundsException)ex).getUpperBound())
						});
						put(UnknownEPException.class,(textFacade, ex) -> new String[]{
								((UnknownEPException)ex).getGivenRequirementID()
						});
						put(UnknownIDException.class,(textFacade, ex) -> new String[]{
								((UnknownIDException)ex).getUnkownID()
						});
						put(UnknownReferenceException.class,(textFacade, ex) -> new String[]{
								((UnknownReferenceException)ex).getUnkownReferenceID()
						});
						put(StringNoNumberException.class,(textFacade, ex) -> new String[]{
								((StringNoNumberException)ex).getGivenString(),
								convertNumberTypeToString(textFacade,((StringNoNumberException)ex).getNeededNumberType())
						});
						put(NoItemSelectedException.class,((textFacade, ex) -> new String[0]));
					}}
			);
	/**
	 * Singleton object
	 */
	private static ExceptionToTextConverter singleton;


	/**
	 * private constructor for singleton
	 */
	private ExceptionToTextConverter()
	{

	}

	/**
	 * Returns singleton object of this class
	 * @return singleton object of this class
	 */
	public static ExceptionToTextConverter getInstance()
	{
		if(singleton == null)
		{
			singleton = new ExceptionToTextConverter();
		}
		return singleton;
	}

	/**
	 * Determines the belonging title property to the given exception
	 * @param ex Exception for which the title property should be determined
	 * @return Property name which was found for the given exception
	 */
	public String getExTitleProperty(Exception ex)
	{
		String propertyName;
		if(exceptionToPropertyMap.containsKey(ex.getClass()))
		{
			propertyName = exceptionToPropertyMap.get(ex.getClass());
		}
		else
		{
			propertyName = DIALOG_ERROR_DEFAULT;
		}
		return propertyName;
	}

	/**
	 * Determines the belonging dialog property to the given exception
	 * @param ex Exception for which the dialog property should be determined
	 * @return Property name which was found for the given exception
	 */
	public String getExMessageProperty(Exception ex)
	{
		String propertyName;
		if(exceptionToPropertyMap.containsKey(ex.getClass()))
		{
			propertyName = exceptionToPropertyMap.get(ex.getClass());
		}
		else
		{
			propertyName = DIALOG_ERROR_DEFAULT;
		}
		return propertyName;
	}

	/**
	 * Determines the belonging placeholders for the dialog message of the given exception
	 * @param ex Exception for which the placeholders should be calculated
	 * @return Placeholders which were found for the given exception
	 */
	public String[] getExPlaceholders(ITextFacade textFacade, Exception ex)
	{
		String[] placeholder;
		if(exceptionToPropertyMap.containsKey(ex.getClass()))
		{
			ExToPlaceholderConverter converter = exceptionToPlaceholderConverterMap.get(ex.getClass());
			placeholder = converter.createPlaceholder(textFacade, ex);
		}
		else
		{
			placeholder = createPlaceholderForDefaultError(ex);
		}
		return placeholder;
	}

	private String[] createPlaceholderForDefaultError(Exception thrownException)
	{
		return new String[]{
				thrownException.toString()
		};
	}

	private static String convertPatternTypeToString(ITextFacade textFacade, PatternType patternType)
	{
		String convertedPatternType;
		switch(patternType)
		{
			case ID:
				convertedPatternType = textFacade.getParameterText(TextNameConstants.PAR_ID);
				break;
			case EMAIL:
				convertedPatternType = textFacade.getParameterText(TextNameConstants.PAR_EMAIL);
				break;
			case TELEPHONE_NUMBER:
				convertedPatternType = textFacade.getParameterText(TextNameConstants.PAR_PHONE_NUMBER);
				break;
			case ADDRESS:
				convertedPatternType = textFacade.getParameterText(TextNameConstants.PAR_STREET);
				break;
			default:
				convertedPatternType = null;
				break;
		}
		return convertedPatternType;
	}

	private static String convertNumberTypeToString(ITextFacade textFacade, NumberType numberType)
	{
		String convertedNumberType;
		switch(numberType)
		{
			case INTEGER:
				convertedNumberType = textFacade.getParameterText(TextNameConstants.PAR_INTEGER);
				break;
			case DOUBLE:
				convertedNumberType = textFacade.getParameterText(TextNameConstants.PAR_DOUBLE);
				break;
			default:
				convertedNumberType = null;
				break;
		}
		return convertedNumberType;
	}

	private static String convertParameterTypeToString(ITextFacade textFacade, MissingParameter missingParameter)
	{
		String convertedParameter;
		switch(missingParameter)
		{
			case MAN_MONTH:
				convertedParameter = textFacade.getParameterText(TextNameConstants.PAR_MM);
				break;
			case ACTUAL_STATE:
				convertedParameter = textFacade.getParameterText(TextNameConstants.PAR_ACTUAL_STATE);
				break;
			case FUNCTION_POINTS:
				convertedParameter = textFacade.getParameterText(TextNameConstants.PAR_FP);
				break;
			case PROJECT_TITLE:
				convertedParameter = textFacade.getParameterText(TextNameConstants.PAR_TITLE);
				break;
			case PM_NAME:
				convertedParameter = textFacade.getParameterText(TextNameConstants.PAR_PM_NAME);
				break;
			case PM_EMAIL:
				convertedParameter = textFacade.getParameterText(TextNameConstants.PAR_PM_EMAIL);
				break;
			case PM_PHONE_NUMBER:
				convertedParameter = textFacade.getParameterText(TextNameConstants.PAR_PM_PHONE_NUMBER);
				break;
			default:
				convertedParameter = null;
				break;
		}
		return convertedParameter;
	}


	/**
	 * Inner class for converting exception to placeholder. Needed for
	 * {@link ExceptionToTextConverter#exceptionToPlaceholderConverterMap}.
	 *
	 * @author 9045534
	 * @version 1.0
	 */
	private interface ExToPlaceholderConverter
	{

		public String[] createPlaceholder(ITextFacade textFacade, Exception ex);

	}

}
