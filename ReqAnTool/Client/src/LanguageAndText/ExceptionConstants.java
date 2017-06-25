package LanguageAndText;

import Exceptions.*;
import Model_Interfaces.IAddition;
import Model_Interfaces.IFRequirement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 9045534
 * @version 1.0
 * @see ITextFacade
 */
public class ExceptionConstants
{

	private static Map<Class, String> exceptionToPropertyMap =
			Collections.unmodifiableMap(
					new HashMap<Class, String>()
					{{
						put(ArgumentPatternException.class,"EX_WRONG_PATTERN");
						put(DuplicateIDException.class,"EX_DUPLICATE");
						put(MissingCostEstimationException.class,"EX_NO_COST_ESTIMATION");
						put(MissingFPException.class,"EX_NO_FP");
						put(MissingReqAnException.class,"EX_NO_REQAN");
						put(ListOverflowException.class,"EX_LIST_OVERFLOW");
						put(NumberOutOfBoundsException.class,"EX_NUMBER_OOB");
						put(UnknownEPException.class,"EX_UNKNOWN_EP");
						put(UnknownIDException.class,"EX_UNKNOWN_ID");
						put(UnknownReferenceException.class,"EX_UNKNOWN_REF");
					}}
			);

	private static Map<Class, ExToPlaceholderConverter> exceptionToPlaceholderConverterMap =
			Collections.unmodifiableMap(
					new HashMap<Class, ExToPlaceholderConverter>()
					{{
						put(ArgumentPatternException.class, (textFacade, ex) -> new String[]{
								convertPatternTypeToString(textFacade, ((ArgumentPatternException)ex).getPatternType()),
								((ArgumentPatternException)ex).getPattern()
						});
						put(DuplicateIDException.class, (textFacade, ex) -> new String[]{
								((DuplicateIDException)ex).getDuplicateID()
						});
						put(MissingCostEstimationException.class, (textFacade, ex) -> new String[0]);
						put(MissingFPException.class, (textFacade, ex) -> new String[0]);
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
					}}
			);


	public static String getExTitleProperty(Exception ex)
	{
		String propertyName;
		if(exceptionToPropertyMap.containsKey(ex.getClass()))
		{
			propertyName = exceptionToPropertyMap.get(ex.getClass());
		}
		else
		{
			propertyName = null;
		}
		return propertyName;
	}

	public static String getExMessageProperty(Exception ex)
	{
		String propertyName;
		if(exceptionToPropertyMap.containsKey(ex.getClass()))
		{
			propertyName = exceptionToPropertyMap.get(ex.getClass());
		}
		else
		{
			propertyName = null;
		}
		return propertyName;
	}

	public static String[] getExPlaceholders(ITextFacade textFacade, Exception ex)
	{
		String[] placeholder;
		if(exceptionToPropertyMap.containsKey(ex.getClass()))
		{
			ExToPlaceholderConverter converter = exceptionToPlaceholderConverterMap.get(ex.getClass());
			placeholder = converter.createPlaceholder(textFacade, ex);
		}
		else
		{
			placeholder = null;
		}
		return placeholder;
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



	private interface ExToPlaceholderConverter
	{

		public String[] createPlaceholder(ITextFacade textFacade, Exception ex);

	}

}
