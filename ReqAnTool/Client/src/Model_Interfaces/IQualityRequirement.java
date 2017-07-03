package Model_Interfaces;

/**
 * A QualityRequirement of the requirement analysis.
 * Every requirement analysis can contain multiple QualityRequirements, every consisting of a criteria and value.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
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
    String getCriteria();

    /**
     * Get the value of the QualityRequirement.
     * @return A Score representing the value.
     *
     * @see Score
     */
    Score getValue();

}
