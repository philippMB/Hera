package Calculations;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.ClassOfTransactionFP;

public class ComplexityWeightMatrix
{
    /*
    Format of Matrix:
            EI  EO  EQ  ILF EIF
    EASY    x   x   x   x   x
    MEDIUM  x   x   x   x   x
    COMPLEX x   x   x   x   x
     */
    private final ClassOfTransactionFP[] myTransactionTypeIndexes;
    private final ClassOfDataFP[] myDataTypeIndexes;
    private final Complexities[] myComplexityIndexes;
    private final int[][] myFPMatrix;

    public ComplexityWeightMatrix(int[][] myFPMatrix)
    {
        this.myTransactionTypeIndexes = new ClassOfTransactionFP[] {ClassOfTransactionFP.EI_INPUT,
                                                                    ClassOfTransactionFP.EO_OUTPUT,
                                                                    ClassOfTransactionFP.EQ_QUERY};
        this.myDataTypeIndexes = new ClassOfDataFP[] {ClassOfDataFP.ILF_INTERNAL_LOGICAL_FILE,
                                                      ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE};
        this.myComplexityIndexes = new Complexities[] {Complexities.EASY, Complexities.MEDIUM, Complexities.COMPLEX};
        this.myFPMatrix = myFPMatrix;
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
                y = j + 3; // +3 for right Index (see Matrix format in class description)
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
