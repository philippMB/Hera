package Model_Interfaces;

/**
 * The TargetDefinition of the RequirementAnalysis.
 * Every RequirementAnalysis contains one TargetDefinition, consisiting of a description.
 *
 * @author 7532274
 * @version 1.0
 */
public interface ITargetDefinition 
{

    /**
     * Get the description of the TargetDefinition.
     * @return A String containing the description.
     */
    String getDescription();

}