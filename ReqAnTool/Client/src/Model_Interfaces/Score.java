package Model_Interfaces;

/**
 * For the QualityRequirements, the user can choose between different Scores for the importance of the
 * QualityRequirement.
 * It is staggered into four classes, starting with NOTRELEVANT over NORMAL and IMPORTANT to VERYIMPORTANT.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IQualityRequirement
 */
public enum Score
{
    VERYIMPORTANT,
    IMPORTANT,
    NORMAL,
    NOTRELEVANT
}
