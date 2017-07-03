package Model_Interfaces;

import Exceptions.NumberOutOfBoundsException;

/**
 * Represents a WeightFactor of the requirement analysis.
 * Every requirement analysis can have multiple WeightFactors, everyone consisting of a title, value and maximum value.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface IWeightFactor 
{

    /**
     * Get the title of the WeightFactor.
     * @return A String containing the title.
     */
    String getTitle();

    /**
     * Get the value of the WeightFactor
     * @return An Integer containing the value.
     */
    int getValue();

    /**
     * Get the exact floating point value of the WeightFactor (needed for optimization)
     * @return An Double containing the value.
     */
    double getExactValue();

    /**
     * Sets the exact value of a weight factor.
     * @param exactValue Value to be set
     */
    void setValue(double exactValue) throws NumberOutOfBoundsException;

    /**
     * Get the maximum value of the WeightFactor
     * @return An Integer containing the maximum value.
     */
    int getMaxValue();

    /**
     * Copies the values of the weight factor into a new one which is returned.
     * @return New weight factor with the same values
     */
    IWeightFactor copy();

}
