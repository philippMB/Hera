package Exceptions;

/**
 * This class represents a basis structure for exceptions which are called by breaking a given pattern for arguments
 * (e.g. email).
 * <p>
 *     To give a basis structure for reacting to wrong pattern dependent arguments this abstract class handles
 *     saving and providing:
 *     <ul>
 *         <li>the type of pattern which was needed (specified by {@link PatternType})</li>
 *         <li>the argument which was given by the user/method/etc. and does not fit to the pattern</li>
 *         <li>the pattern itself in a readable form to display it in an error message for the user</li>
 *     </ul>
 * <p>
 *     Exceptions which inherits from this class just need to provide their own pattern and given argument in the
 *     constructor.
 * </p>
 * @author 9045534
 * @version 1.0
 * @see Exception
 * @see PatternType
 */
public class ArgumentPatternException
        extends Exception
{

    private PatternType myPatternType;
    private String givenArgument;
    private String neededPattern;


    /**
     * Constructor saving the given argument, which does not fit to the needed pattern, and the pattern in a readable
     * form.
     * @param givenArgument argument which does not fit to the needed pattern
     * @param neededPattern needed pattern in a readable form
     */
    public ArgumentPatternException(PatternType patternType, String givenArgument, String neededPattern)
    {
        super(patternType.toString()+" needed pattern "+neededPattern+", but got argument \""+givenArgument+"\"");
        this.myPatternType = patternType;
        this.givenArgument = givenArgument;
        this.neededPattern = neededPattern;
    }

    /**
     * Returns the pattern type which was needed (based on {@link PatternType}).
     * @return Needed pattern type
     */
    public PatternType getPatternType()
    {
        return myPatternType;
    }

    /**
     * Returns the given argument which does not fit to the pattern which was needed.
     * @return Given argument not fitting to the pattern
     */
    public String getGivenArgument()
    {
        return givenArgument;
    }

    /**
     * Returns the pattern which was required for the argument.
     * <p>
     *     The pattern should be represented in a readable form to present it to the user of the GUI-application.
     * </p>
     * @return Pattern in readable form
     */
    public String getPattern()
    {
        return neededPattern;
    }

}