
package Model_Interfaces;

/**
 * Created by phlippe on 26.04.17.
 */

/**
 * A FunctionalRequirement of the requirement analysis.
 * A requirement analysis can contain multiple FunctionalRequirements, every consisting of a title, actor and
 * description as well as the attributes of a Requirement.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
 * @version 1.0
 *
 * @see IRequirementAnalysis
 * @see IRequirement
 */
public interface IFRequirement
    extends IRequirement
{

    /**
     * Get the title of the FunctionRequirement.
     * @return A String containing the title.
     */
    public String getTitle();

    /**
     * Get the actor of the FunctionalRequirement.
     * @return A String containing the actor.
     */
    public String getActor();

    /**
     * Get the description of the FunctionalRequirement.
     * @return A String containing the description.
     */
    public String getDescription();

}
