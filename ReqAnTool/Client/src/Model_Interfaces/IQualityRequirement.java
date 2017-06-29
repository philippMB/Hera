
package Model_Interfaces;


/**
 * Created by phlippe on 26.04.17.
 */

/**
 * A QualityRequirement of the requirement analysis.
 * Every requirement analysis can contain multiple QualityRequirements, every consisting of a criteria and value.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface IQualityRequirement 
{

    /**
     * Get the criteria of the QualityRequirement.
     * @return A String containing the criteria.
     */
    public String getCriteria();

    /**
     * Get the value of the QualityRequirement.
     * @return A Score representing the value.
     *
     * @see Score
     */
    public Score getValue();

}
