
package Model_Interfaces;

/**
 * Created by phlippe on 26.04.17.
 */

/**
 * Represents a WeightFactor of the requirement analysis.
 * Every requirement analysis can have multiple WeightFactors, everyone consisting of a title, value and maximum value.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
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
    public String getTitle();

    /**
     * Get the value of the WeightFactor
     * @return An Integer containing the value.
     */
    public int getValue();

    /**
     * Get the maximum value of the WeightFactor
     * @return An Integer containing the maximum value.
     */
    public int getMaxValue();

}
