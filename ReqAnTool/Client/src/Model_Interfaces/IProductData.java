
package Model_Interfaces;

/**
 * Created by phlippe on 26.04.17.
 */

/**
 * A ProductData of the requirement analysis.
 * A requirement analysis can contain multiple ProductData, every consisting of an attribute, content and maximum count
 * as well as the attributes of a Requirement.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
 * @version 1.0
 *
 * @see IRequirementAnalysis
 * @see IRequirement
 */
public interface IProductData
    extends IRequirement
{

    /**
     * Get the attribute of the ProductData.
     * @return A String containing the attribute.
     */
    public String getAttribute();

    /**
     * Get the content of the ProductData.
     * @return A String containing the content.
     */
    public String getContent();

    /**
     * Get the maximum count of the ProductData.
     * @return A String containing the maximum count.
     */
    public String getMaxCount();
    
}
