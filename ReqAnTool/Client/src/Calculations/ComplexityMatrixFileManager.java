package Calculations;

import Model_Interfaces.ClassOfDataFP;
import Model_Interfaces.ClassOfTransactionFP;
import Model_Interfaces.IClassOfFP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Model.StringOperations.StringToInt;

/**
 * Created by phlippe on 02.07.17.
 */
public class ComplexityMatrixFileManager
	extends FileOperator
{

	public ComplexityMatrixFileManager()
	{

	}

	public ComplexityWeightMatrix readComWeightMatrixFromInit()
	{
		ArrayList<String> lines = readLinesFromInnerFile("ComplexityWeightMatrix.init");
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

	public Map<IClassOfFP, ComplexityMatrix> readComplexityMatrixFromInit()
	{
		Map<IClassOfFP, ComplexityMatrix> tempComplexityMatrices = new HashMap<IClassOfFP, ComplexityMatrix>();
		ArrayList<String> lines = readLinesFromInnerFile("ComplexityMatrix.init");
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

}
