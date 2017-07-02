package Model_Interfaces;

/**
 * The ProductApplication of the requirement analysis.
 * Every requirement analysis contains one ProductApplication consisting of a description.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface IProductApplication
{

    /**
     * Get the description of the ProductApplication.
     * @return A String containing the description.
     */
    String getDescription();

}