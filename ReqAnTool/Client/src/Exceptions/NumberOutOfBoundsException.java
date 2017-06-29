package Exceptions;

/**
 * This exception is thrown if a number is not in the expected boundaries.
 * <p>
 *     To ensure conditions of calculation numbers could have specific boundaries in which they have to be. If a number
 *     is given as a argument and is not in boundaries as expected this exception is thrown.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 */
public class NumberOutOfBoundsException
        extends Exception
{

    /**
     * Message which will be shown in log-files and/or standard output/error. Gives a description why the
     * error is thrown and how to fix it.
     */
    private static String EXCEPTION_MESSAGE = "Number was out of expected bound: ";

    private double givenNumber;
    private double lowerBound;
    private double upperBound;


    /**
     * Public constructor which initialise the message for the exception and saves boundaries for debugging.
     * @param givenNumber Number which was passed but not in the given boundaries
     * @param lowerBound Lower boundary in which the number should be
     * @param upperBound Upper boundary in which the number should be
     */
    public NumberOutOfBoundsException(double givenNumber, double lowerBound, double upperBound)
    {
        super(EXCEPTION_MESSAGE + lowerBound + "-" + upperBound);
        this.givenNumber = givenNumber;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    /**
     * Returns the given number which was not in the boundaries
     * @return Number which was passed but not in the given boundaries
     */
    public double getGivenNumber()
    {
        return givenNumber;
    }

    /**
     * Returns the lower boundary in which the number should be
     * @return Lower boundary in which the number should be
     */
    public double getLowerBound()
    {
        return lowerBound;
    }

    /**
     * Returns the upper boundary in which the number should be
     * @return Upper boundary in which the number should be
     */
    public double getUpperBound()
    {
        return upperBound;
    }
}