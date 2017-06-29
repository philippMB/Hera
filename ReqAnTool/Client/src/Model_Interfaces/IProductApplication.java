package Model_Interfaces;

/**
 * Created by phlippe on 26.04.17.
 */

/**
 * The ProductApplication of the requirement analysis.
 * Every requirement analysis contains one ProductApplication consisting of a description.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
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
    public String getDescription();

}