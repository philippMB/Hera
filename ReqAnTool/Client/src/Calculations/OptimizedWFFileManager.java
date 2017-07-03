package Calculations;

import Model.WeightFactor;
import Model.WeightFactorList;
import Model_Interfaces.IWeightFactor;

import java.util.ArrayList;

import static Model.StringOperations.StringToInt;

public class OptimizedWFFileManager
	extends FileOperator
{

	private static final String FILE_NAME = "optWeightFactor.init";
	private static OptimizedWFFileManager singleton;


    private OptimizedWFFileManager()
    {

    }

    public static OptimizedWFFileManager getInstance()
	{
		if(singleton == null)
		{
			singleton = new OptimizedWFFileManager();
		}
		return singleton;
	}

    public WeightFactorList<IWeightFactor> readOptWeightFactorFromInit()
    {
        WeightFactorList<IWeightFactor> optWeightFactors = new WeightFactorList<IWeightFactor>();
        ArrayList<String> lines = readLinesFromOuterFile(FILE_NAME);
        if(lines == null)
		{
			lines = readLinesFromInnerFile(FILE_NAME);
		}
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

    public void writeOptWeightFactorsToInit(ArrayList<IWeightFactor> optWeightFactors)
    {
        ArrayList<String> lines = new ArrayList<String>();
        for (IWeightFactor optFactor : optWeightFactors)
        {
            String line = "";
            line = line + optFactor.getTitle() + "; ";
            line = line + optFactor.getValue() + "; ";
            line = line + optFactor.getMaxValue();
            lines.add(line);
        }
        writeLinesToFile(FILE_NAME, lines);
    }

}
