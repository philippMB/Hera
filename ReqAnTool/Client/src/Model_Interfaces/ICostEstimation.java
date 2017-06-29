package Model_Interfaces;

import Model.ComplexityMatrix;
import Model.ComplexityWeightMatrix;
import java.util.ArrayList;

/**
 * Created by phlippe on 26.04.17.
 */

/**
 * The CostEstimation for a requirement analysis.
 * Every requirement analysis contains a CostEstimation with the calculated ManMonth and FunctionPoints.
 * To calculate this, the DataFunctionPoints, TransactionFunctionPoints and WeightFactors must be known.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
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
    public void calculateFP();

    /**
     * Calculates the needed ManMonth.
     * A precondition for this calculation is the calculation of the FunctionPoints.
     */
    public void calculateManMonth();

    /**
     * Get the calculated FunctionPoints.
     * @return A Double containing the calculated FunctionPoints.
     */
    public double getFunctionPoints();

    /**
     * Get the calculated ManMonth.
     * @return A Double containing the calculated ManMonth.
     */
    public double getManMonth();

    /**
     * Get the DataFunctionPoints of the requirement analysis.
     * @return An Arraylist containing the DataFunctionPoints.
     *
     * @see IDataFP
     */
    public ArrayList<IDataFP> getDataFPs();

    /**
     * Get the TransactionFunctionPoints of the requirement analysis.
     * @return An Arraylist containing the TransactionFunctionPoints.
     *
     * @see ITransactionFP
     */
    public ArrayList<ITransactionFP> getTransactionFPs();

    /**
     * Get the WeightFactors of the requirement analysis.
     * @return An Arraylist containing the WeightFactors.
     *
     * @see IWeightFactor
     */
    public ArrayList<IWeightFactor> getWeightFactors();

    // TODO: was bei keinem titel?? null?
    /**
     * Get a WeightFactor by its title.
     * @param title The title of the WeightFactor that should be returned.
     * @return The WeightFactor with the given title is returned if the title could be found. If the title could not be
     * found
     */
    public IWeightFactor getWeightFactorByTitle(String title);

    // TODO:
    public boolean hasIDDataFP(String id);

    // TODO:
    public boolean hasIDTransactionFP(String id);

    // TODO: was bei keiner id? null?
    /**
     * Get a DataFunctionPoint by its ID.
     * @param id The id of the DataFunctionPoint that should be returned.
     * @return The DataFunctionPoint with the given id is returned if the id could be found. If the id could not be
     * found
     */
    public IDataFP getDataFPByID(String id);

    // TODO: was bei keiner id? null?
    /**
     * Get a TransactionFunctionPoint by its ID.
     * @param id The id of the TransactionFunctionPoint that should be returned.
     * @return The TransactionFunctionPoint with the given id is returned if the id could be found. If the id could not
     * be found
     */
    public ITransactionFP getTransactionFPByID(String id);

    public Map<IClassOfFP, ComplexityMatrix> getComplexityMatrices();

    public ComplexityWeightMatrix getComplexityWeightMatrix();

}
