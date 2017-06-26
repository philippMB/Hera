package xml;

import Model_Interfaces.IRequirementAnalysis;

/**
 * Interface for requirement analysis classes that provide XML conversion support.
 *This interface is implemented by every requirement analysis class that provides XML conversion support.
 * This is needed to make import and export methods generic and provide more flexibility.
 * The {@link IXMLFormat#createFragments(IRequirementAnalysis)} method is used to convert the original data into the
 * new requirement analysis format whoch provides XML conversion support.
 * The interface extends the {@link IRequirementAnalysis} to make this XML conversion supporting classes also available
 * via the interface of the IRequirementAnalysis.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IRequirementAnalysis
 */
public interface IXMLFormat
    extends IRequirementAnalysis
{
    /**
     * Method to convert the original data into the XML conversion supporting format
     * @param rawData The original data from the {@link IRequirementAnalysis} object.
     */
    void createFragments(IRequirementAnalysis rawData);
}
