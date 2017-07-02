package Exceptions;

/**
 * Enum which lists all different pattern types which could be requested for {@link ArgumentPatternException}.
 *
 * @author 9045534
 * @version 1.0
 * @see ArgumentPatternException
 */
public enum PatternType
{
	EMAIL,
	TELEPHONE_NUMBER,
	ADDRESS,
	ID,
	UNKNOWN
}
