package Model_Interfaces;

import Model.ComplexityMatrix;
import Model.ComplexityWeightMatrix;

import java.util.ArrayList;
import java.util.Map;

/**
 * The CostEstimation for a requirement analysis.
 * Every requirement analysis contains a CostEstimation with the calculated ManMonth and FunctionPoints.
 * To calculate this, the DataFunctionPoints, TransactionFunctionPoints and WeightFactors must be known.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
 * @version 1.0
 *
 * @see IRequirementAnalysis
 * @see IDataFP
 * @see ITransactionFP
 * @see IWeightFactor
 */
public interface ICostEstimation 
{

    /**
     * Calculates the FunctionPoints of the whole project.
     * The underlying algorithm is configurable by the model.
     */
    void calculateFP();

    /**
     * Calculates the needed ManMonth.
     * A precondition for this calculation is the calculation of the FunctionPoints.
     */
    void calculateManMonth();

    /**
     * Get the calculated FunctionPoints.
     * @return A Double containing the calculated FunctionPoints.
     */
    double getFunctionPoints();

    /**
     * Get the calculated ManMonth.
     * @return A Double containing the calculated ManMonth.
     */
    double getManMonth();

    /**
     * Get the DataFunctionPoints of the requirement analysis.
     * @return An Arraylist containing the DataFunctionPoints.
     *
     * @see IDataFP
     */
    ArrayList<IDataFP> getDataFPs();

    /**
     * Get the TransactionFunctionPoints of the requirement analysis.
     * @return An Arraylist containing the TransactionFunctionPoints.
     *
     * @see ITransactionFP
     */
    ArrayList<ITransactionFP> getTransactionFPs();

    /**
     * Get the WeightFactors of the requirement analysis.
     * @return An Arraylist containing the WeightFactors.
     *
     * @see IWeightFactor
     */
    ArrayList<IWeightFactor> getWeightFactors();

    /**
     * Get a WeightFactor by its title.
     * @param title The title of the WeightFactor that should be returned.
     * @return The WeightFactor with the given title is returned if the title could be found.
     * Otherwise, it will return null.
     *
     * @see IWeightFactor
     */
    IWeightFactor getWeightFactorByTitle(String title);

    /**
     * Check whether an Requirement is already classified into a Data Function Point.
     * @param id The ID of the Requirement which will be tested.
     * @return True, if the Requirement is already classified.
     *
     * @see IDataFP
     */
    boolean hasIDDataFP(String id);

    /**
     * Check whether an Requirement is already classified into a Transaction Function Point.
     * @param id The ID of the Requirement which will be tested.
     * @return True, if the Requirement is already classified.
     *
     * @see ITransactionFP
     */
    boolean hasIDTransactionFP(String id);

    /**
     * Get a DataFunctionPoint by its ID.
     * @param id The id of the DataFunctionPoint that should be returned.
     * @return The DataFunctionPoint with the given id is returned if the id could be found.
     * Otherwise, it will return null.
     *
     * @see IDataFP
     */
    IDataFP getDataFPByID(String id);

    /**
     * Get a TransactionFunctionPoint by its ID.
     * @param id The id of the TransactionFunctionPoint that should be returned.
     * @return The TransactionFunctionPoint with the given id is returned if the id could be found.
     * Otherwise, it will return null.
     *
     * @see ITransactionFP
     */
    ITransactionFP getTransactionFPByID(String id);

    /**
     * Get the ComplexityMatrices for Function Point Calculation
     * @return The ComplexityMatrix as a Map from the Class of the Function Point to the ComplexityMatrix.
     *
     * @see ComplexityMatrix
     * @see IClassOfFP
     */
    Map<IClassOfFP, ComplexityMatrix> getComplexityMatrices();

    /**
     * Get the ComplexityWeightMatrix for Function Point Calculation
     * @return The ComplexityWeightMatrix object
     *
     * @see ComplexityMatrix
     */
    ComplexityWeightMatrix getComplexityWeightMatrix();
}
