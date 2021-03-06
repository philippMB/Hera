package Model_Interfaces;


/**
 * Created by phlippe on 26.04.17.
 */

/**
 * Represents a TransactionFunctionPoint of the requirement analysis.
 * Every requirement analysis can have multiple TransactionFunctionPoints, everyone consisting of a DET, FTR, type and
 * associated requirement.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
 * @version 1.0
 *
 * @see IRequirementAnalysis
 * @see IRequirement
 */
public interface ITransactionFP 
{

    /**
     * Get the DET of the TransactionFunctionPoint.
     * @return An Integer containing the DET.
     */
    public int getDet();

    /**
     * Get the FTR of the TranscationFunctionPoint.
     * @return An Integer containing the FTR.
     */
    public int getFtr();

    /**
     * Get the type of the TransactionFunctionPoint.
     * @return The type as ClassOfTransactionFP.
     *
     * @see ClassOfTransactionFP
     */
    public ClassOfTransactionFP getType();

    /**
     * Get the associated Requirement of the TransactionFunctionPoint.
     * @return A Requirement object.
     *
     * @see IRequirement
     */
    public IRequirement getRequirement();
    
}
