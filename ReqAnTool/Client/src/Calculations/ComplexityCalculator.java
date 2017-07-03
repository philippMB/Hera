package Calculations;

import Model_Interfaces.IClassOfFP;
import Model_Interfaces.IDataFP;
import Model_Interfaces.ITransactionFP;

import java.util.Map;

/**
 * Created by phlippe on 02.07.17.
 */
public class ComplexityCalculator
{

	private Map<IClassOfFP, ComplexityMatrix> myComplexityMatrices;
	private ComplexityWeightMatrix myComplexityWeightMatrix;


	public ComplexityCalculator(Map<IClassOfFP, ComplexityMatrix> complexityMatrices, ComplexityWeightMatrix complexityWeightMatrix)
	{
		myComplexityMatrices = complexityMatrices;
		myComplexityWeightMatrix = complexityWeightMatrix;
	}

	private Complexities calculateDFPComplexity(IDataFP dataFP)
	{
		Complexities complexity = myComplexityMatrices.get(dataFP.getType()).getDetRetValue(dataFP.getDet(), dataFP.getRet());
		return complexity;
	}

	public int calcFPForDFP(IDataFP dataFP)
	{
		Complexities complexity = calculateDFPComplexity(dataFP);
		int fPvalue = myComplexityWeightMatrix.getFPvalue(complexity, dataFP.getType());
		return fPvalue;
	}

	private Complexities calculateTFPComplexity(ITransactionFP transactionFP)
	{
		Complexities complexity = myComplexityMatrices.get(transactionFP.getType()).getDetFtrValue(
				transactionFP.getDet(), transactionFP.getFtr());
		return complexity;
	}

	public int calcFPForTFP(ITransactionFP transactionFP)
	{
		Complexities complexity = calculateTFPComplexity(transactionFP);
		int fPvalue = myComplexityWeightMatrix.getFPvalue(complexity, transactionFP.getType());
		return fPvalue;
	}


}
