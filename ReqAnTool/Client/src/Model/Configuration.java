package Model;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.ClassOfTransactionFP;
import Model_Interfaces.IClassOfFP;
import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Model.StringOperations.StringToInt;

public class Configuration
{
    private final String workDir;
    private final Map<IClassOfFP, ComplexityMatrix> myComplexityMatrices;
    private final ComplexityWeightMatrix myComplexityWeightMatrix;
    /**
     * @associates <{Model.WeightFactor}>
     */
    private ArrayList<IWeightFactor> optWeightFactor;

    public Configuration()
    {
        workDir = System.getProperty("user.dir") + "\\ReqAnTool\\Client\\src\\Model\\";
        System.out.println(workDir);
        myComplexityMatrices = readComplexityMatrixFromInit();
        myComplexityWeightMatrix = readComWeightMatrixFromInit();
        optWeightFactor = readOptWeightFactorFromInit();
    }

    private ArrayList<IWeightFactor> readOptWeightFactorFromInit()
    {
        ArrayList<IWeightFactor> optWeightFactors = new ArrayList<IWeightFactor>();
        ArrayList<String> lines = FileOperations.readLinesFromFile(workDir +"optWeightFactor.init");
        for (String line : lines)
        {
            String[] fields = line.split(";");
            String title = fields[0];
            int score = StringToInt(fields[1]);
            int maxValue = StringToInt(fields[2]);
            WeightFactor myWeightFactor = new WeightFactor(title, score, maxValue);
            optWeightFactors.add(myWeightFactor);
        }
        return optWeightFactors;

    }

    private ComplexityWeightMatrix readComWeightMatrixFromInit()
    {
        ArrayList<String> lines = FileOperations.readLinesFromFile(workDir + "ComplexityWeightMatrix.init");
        int i = 0;
        int[][] fPMatrix = new int[3][];
        for (String line : lines)
        {
            String[] fields = line.split(";");
            int row[] = new int[5];
            int j = 0;
            for (String field : fields)
            {
                row[j] = StringToInt(field);
                j++;
            }
            fPMatrix[i] = row;
            i++;
        }
        return new ComplexityWeightMatrix(fPMatrix);

    }

    private Map<IClassOfFP, ComplexityMatrix> readComplexityMatrixFromInit()
    {
        Map<IClassOfFP, ComplexityMatrix> tempComplexityMatrices = new HashMap<IClassOfFP, ComplexityMatrix>();
        ArrayList<String> lines = FileOperations.readLinesFromFile(workDir +"ComplexityMatrix.init");
        int i = 0;
        String line = lines.get(i);
        while (!line.equals("EOF"))
        {
            String matrixName = line.split(" ")[0];
            IClassOfFP type = null;
            for (ClassOfTransactionFP value : ClassOfTransactionFP.values())
            {
                String name = value.name().split("_")[0];
                if (name.matches(matrixName) )
                {
                    type = value;
                }
            }
            for (ClassOfDataFP value : ClassOfDataFP.values())
            {
                String name = value.name().split("_")[0];
                if (name.matches(matrixName))
                {
                    type = value;
                }
            }
            if (type == null)
            {
                throw new NullPointerException("FunctionPoint type of ComplexityMatrix_init does not match any Type");
            }
            i++;
            line = lines.get(i);
            String[] fields = line.split(";");
            int detValue[] = {0,0};
            detValue[0] = StringToInt(fields[0]);
            detValue[1] = StringToInt(fields[1]);
            i++;
            line = lines.get(i);
            fields = line.split(";");
            int ftrValue[] = {-1,-1};
            int retValue[] = {-1,-1};
            if (fields[2].matches("[fF][tT][rR]"))
            {
                ftrValue[0] = StringToInt(fields[0]);
                ftrValue[1] = StringToInt(fields[1]);
            }
            else
            {
                retValue[0] = StringToInt(fields[0]);
                retValue[1] = StringToInt(fields[1]);
            }
            tempComplexityMatrices.put(type, new ComplexityMatrix(detValue, ftrValue, retValue));
            i++;
            i++;
            if(i >= lines.size())
            {
                line = "EOF";
            }
            else
            {
                line = lines.get(i);
            }
        }
        return tempComplexityMatrices;
    }

    public Map<IClassOfFP, ComplexityMatrix> getComplexityMatrices()
    {
        return myComplexityMatrices;
    }

    public ComplexityWeightMatrix getComplexityWeightMatrix()
    {
        return myComplexityWeightMatrix;
    }

    public ArrayList<IWeightFactor> getOptWeightFactors()
    {
        return optWeightFactor;
    }
    
    public IWeightFactor getOptWeightFactorsByTitle(String title)
    {
        IWeightFactor weightFactorToReturn = null;
        for (IWeightFactor myWeightFactor : optWeightFactor)
        {
            if (myWeightFactor.getTitle().equals(title))
            {
                weightFactorToReturn = myWeightFactor;
            }
        }
        return weightFactorToReturn;

    }

    public void adjustOptWeightFactors()
    {

    }
}
