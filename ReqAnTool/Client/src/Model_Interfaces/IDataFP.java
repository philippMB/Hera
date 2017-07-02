package Model_Interfaces;

/**
 * Represents a DataFunctionPoint of the requirement analysis.
 * Every requirement analysis can have multiple DataFunctionPoints, everyone consisting of a DET, RET, type and
 * associated requirement.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 * @see IRequirement
 */
public interface IDataFP
{

    /**
     * Get the DET of the DataFunctionPoint.
     * @return An Integer containing the DET.
     */
    public int getDet();

    /**
     * Get the RET of the DataFunctionPoint.
     * @return An Integer containign the RET.
     */
    public int getRet();

    /**
     * Get the associated Requirement of the DataFunctionPoint.
     * @return A Requirement object.
     *
     * @see IRequirement
     */
    public IRequirement getRequirement();

    /**
     * Get the type of the DataFunctionPoint.
     * @return The type as ClassOfDataFP.
     *
     * @see ClassOfDataFP
     */
    public ClassOfDataFP getType();

}
