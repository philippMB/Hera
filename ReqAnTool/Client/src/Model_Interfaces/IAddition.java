package Model_Interfaces;

/**
 * An addition to the requirement analysis.
 * An user can add multiple addition to its requirement analysis, every addition consisting of a description and a
 * title.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface IAddition
{
    /**
     * Get the description of the addition.
     * @return A String containing the description.
     */
    String getDescription();

    /**
     * Get the title of the addition.
     * @return A String containing the title.
     */
    String getTitle();

}

