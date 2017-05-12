package Model;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.ClassOfTransactionFP;

public class ComplexityWeightMatrix
{
    private ClassOfTransactionFP[] myTransactionTypeIndexes;
    private ClassOfDataFP[] myDataTypeIndexes;
    private Complexities[] myComplexityIndexes;
    private int[][] myFPMatrix;

    public ComplexityWeightMatrix(ClassOfTransactionFP[] myTransactionTypeIndexes, ClassOfDataFP[] myDataTypeIndexes,
                                  Complexities[] myComplexityIndexes, int[][] myFPMatrix)
    {
        this.myTransactionTypeIndexes = myTransactionTypeIndexes;
        this.myDataTypeIndexes = myDataTypeIndexes;
        this.myFPMatrix = myFPMatrix;
        this.myComplexityIndexes = myComplexityIndexes;
    }

    public int getFPvalue(Complexities myComplexity, ClassOfTransactionFP type)
    {
        int x = -1, y = -1, fPValue = -1;
        for (int i = 0; i < myComplexityIndexes.length; i++)
        {
            if (myComplexityIndexes[i] == myComplexity)
            {
                x = i;
                break;
            }
        }
        for (int j = 0; j < myTransactionTypeIndexes.length; j++)
        {
            if (myTransactionTypeIndexes[j].equals(type))
            {
                y = j;
                break;
            }
        }
        if (!(x == -1 || y == -1))
        {
            fPValue = myFPMatrix[x][y];
        }
        return fPValue;
    }

    public int getFPvalue(Complexities myComplexity, ClassOfDataFP type)
    {
        int x = -1, y = -1, fPValue = -1;
        for (int i = 0; i < myComplexityIndexes.length; i++)
        {
            if (myComplexityIndexes[i] == myComplexity)
            {
                x = i;
                break;
            }
        }
        for (int j = 0; j < myTransactionTypeIndexes.length; j++)
        {
            if (myDataTypeIndexes[j].equals(type))
            {
                y = j;
                break;
            }
        }
        if (!(x == -1 || y == -1))
        {
            fPValue = myFPMatrix[x][y];
        }
        return fPValue;
    }
}
