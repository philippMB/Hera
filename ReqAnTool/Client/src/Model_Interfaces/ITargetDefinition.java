package Model_Interfaces;

/**
 * Created by phlippe on 26.04.17.
 */

/**
 * The TargetDefinition of the RequirementAnalysis.
 * Every RequirementAnalysis contains one TargetDefinition, consisiting of a description.
 */
public interface ITargetDefinition 
{

    /**
     * Get the description of the TargetDefinition.
     * @return A String containing the description.
     */
    public String getDescription();

}