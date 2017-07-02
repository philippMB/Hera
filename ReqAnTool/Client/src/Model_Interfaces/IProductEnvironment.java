package Model_Interfaces;

/**
 * The ProductEnvironment of the requirement analysis.
 * Every requirement analysis contains one ProductEnvironment consisting of a description.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface IProductEnvironment
{

    /**
     * Get the description of the ProductEnvironment.
     * @return A String containing the description.
     */
    String getDescription();

}
