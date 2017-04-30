package xml;

import Model_Interfaces.IRequirementAnalysis;

import java.util.ArrayList;

public class CustomXMLFormat
  implements IXMLFormat
{
  private ArrayList<FRequirement> funcRequirementList;
  private ArrayList<DataFP> dataFuncPointList;
  private ArrayList<NFRequirement> nonFuncRequirementList;
  private CustomerData custData;
  private ArrayList<GlossaryEntry> glossary;
  private ArrayList<ProductData> productDataList;
  private ArrayList<QualityRequirement> qualityRequirementList;
  private ArrayList<TransactionFP> transactionFPList;
  private ArrayList<WeightFactor> weightFactorList;
  private ArrayList<CostEstimation> costEstimationList;
  private ArrayList<ProductApplication> productApplicationList;
  private TargetDefinition targetDef;

  @Override
  public int createFragments(IRequirementAnalysis rawData)
  {
    // TODO Implement this method
    return 0;
  }
}
