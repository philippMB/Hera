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
    addFuncRequirements();
    addDataFP();
    addNonFuncRequirements();
    addCustomerData();
    addGlossary();
    addProductData();
    addQualityRequirements();
    addTransactionFP();
    addWeightFactor();
    addCostEstimation();
    addProductApplication();
    addTargetDefinition();
    
    // Rückgabe?
    return 0;
  }
  
  private void addFuncRequirements()
  {
    
  }

  private void addDataFP()
  {
    
  }
  
  private void addNonFuncRequirements()
  {
    
  }
  
  private void addCustomerData()
  {
    
  }
  
  private void addGlossary()
  {
    
  }
  
  private void addProductData()
  {
    
  }
  
  private void addQualityRequirements()
  {
    
  }
  
  private void addTransactionFP()
  {
    
  }
  
  private void addWeightFactor()
  {
    
  }
  
  private void addCostEstimation()
  {
    
  }
  
  private void addProductApplication()
  {
    
  }
  
  private void addTargetDefinition()
  {
    
  }
  
}
