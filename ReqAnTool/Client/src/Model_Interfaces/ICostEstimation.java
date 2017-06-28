package Model_Interfaces;

import Model.ComplexityMatrix;
import Model.ComplexityWeightMatrix;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by phlippe on 26.04.17.
 */

public interface ICostEstimation 
{
    
    void calculateFP();
    
    void calculateManMonth();
    
    double getFunctionPoints();
    
    double getManMonth();
    
    ArrayList<IDataFP> getDataFPs();
    
    ArrayList<ITransactionFP> getTransactionFPs();

    ArrayList<IWeightFactor> getWeightFactors();

    IWeightFactor getWeightFactorByTitle(String title);

    boolean hasIDDataFP(String id);

    boolean hasIDTransactionFP(String id);

    IDataFP getDataFPByID(String id);

    ITransactionFP getTransactionFPByID(String id);

    Map<IClassOfFP, ComplexityMatrix> getComplexityMatrices();

    ComplexityWeightMatrix getComplexityWeightMatrix();
}
