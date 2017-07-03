package Model_Interfaces;

/**
 * A NonFunctionalRequirement of the requirement analysis.
 * A requirement analysis can contain multiple NonFunctionalRequirements, every consisting of a title, actor and
 * description as well as the attributes of a Requirement.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 * @see IRequirement
 */
public interface INFRequirement
    extends IRequirement
{

    /**
     * Get the title of the NonFunctionalRequirement.
     * @return A String containing the title.
     */
    String getTitle();

    /**
     * Get the actor of the NonFunctionalRequirement.
     * @return A String containing the actor.
     */
    String getActor();

    /**
     * Get the description of the NonFunctionalRequirement.
     * @return A String containing the description.
     */
    String getDescription();

}
