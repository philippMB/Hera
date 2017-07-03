package Model_Interfaces;

import Model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by mbill on 02.07.2017.
 */
class CalculateFPTest
{
    @BeforeEach
    void setUp()
    {
        ModelTest myModelTester = new ModelTest();
        Model myModel = myModelTester.getModel();
        myModelTester.calcFPCount();
        ICostEstimation myCostEstimation = myModel.getCostEstimation();
        final double fpCount = 7.0; // This Value has to be changed, if the modelTest will be changed!
    }

    @Test
    void ibmMethod()
    {
    }

    @Test
    void sumOfWeightFactors()
    {
    }

    @Test
    void sumDataFP()
    {
    }

    @Test
    void sumTransactionFP()
    {
    }

}