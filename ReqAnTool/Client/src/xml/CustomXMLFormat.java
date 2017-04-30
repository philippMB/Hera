package xml;

import Model_Interfaces.ICostEstimation;
import Model_Interfaces.ICustomerData;
import Model_Interfaces.IDataFP;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IGlossaryEntry;
import Model_Interfaces.INFRequirement;
import Model_Interfaces.IProductApplication;
import Model_Interfaces.IProductData;
import Model_Interfaces.IQualityRequirement;
import Model_Interfaces.IRequirementAnalysis;
import Model_Interfaces.ITargetDefinition;
import Model_Interfaces.IWeightFactor;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

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
  private CostEstimation costEstimation;
  private ProductApplication productApplication;
  private TargetDefinition targetDef;

  @Override
  public int createFragments(IRequirementAnalysis rawData)
  {
    addFuncRequirements(rawData);
    addDataFP(rawData);
    addNonFuncRequirements(rawData);
    addCustomerData(rawData);
    addGlossary(rawData);
    addProductData(rawData);
    addQualityRequirements(rawData);
    addTransactionFP(rawData);
    addWeightFactor(rawData);
    addCostEstimation(rawData);
    addProductApplication(rawData);
    addTargetDefinition(rawData);
    
    // Rückgabe?
    return 0;
  }
  
  private void addFuncRequirements(IRequirementAnalysis data)
  {
    for(IFRequirement obj : data.getFRequirements())
    {
      String title = obj.getTitle();
      String actor = obj.getActor();
      String description = obj.getDescription();
      FRequirement req = new FRequirement(title, actor, description);
      funcRequirementList.add(req);
    }
  }

  private void addDataFP(IRequirementAnalysis data)
  {

  }
  
  private void addNonFuncRequirements(IRequirementAnalysis data)
  {
    for(INFRequirement obj : data.getNFRequirements())
    {
      String title = obj.getTitle();
      String actor = obj.getActor();
      String description = obj.getDescription();
      NFRequirement req = new NFRequirement(title, actor, description);
      nonFuncRequirementList.add(req);
    }
  }
  
  private void addCustomerData(IRequirementAnalysis data)
  {
    ICustomerData custData = data.getCustomerData();
    String PMName = custData.getPMName();
    String PMPNumber = custData.getPMPNumber();
    String PMEmail = custData.getPMEMail();
    String CName = custData.getCName();
    String CNumber = custData.getCNumber();
    String CEmail = custData.getCEmail();
    String CompanyName = custData.getCompanyName();
    String CompanyStreet = custData.getCompanyStreet();
    int CompanyPLZ = custData.getCompanyPLZ();
    String Company = custData.getCompany();
    String CompanyCountry = custData.getCompanyCountry();
    this.custData = new CustomerData(PMName, PMPNumber, PMEmail, CName, CNumber, CEmail, CompanyName, CompanyStreet, CompanyPLZ, Company, CompanyCountry);
  }
  
  private void addGlossary(IRequirementAnalysis data)
  {
    for(IGlossaryEntry obj : data.getGlossaryEntries())
    {
      String term = obj.getTerm();
      String sense = obj.getSense();
      String boundary = obj.getBoundary();
      String label = obj.getLabel();
      String validity = obj.getValidity();
      String obscurities = obj.getObscurities();
      GlossaryEntry entry = new GlossaryEntry(term, sense, boundary, label, validity, obscurities);
      glossary.add(entry);
    }
  }
  
  private void addProductData(IRequirementAnalysis data)
  {
    for(IProductData obj : data.getProductData())
    {
      String attribute = obj.getAttribute();
      String content = obj.getContent();
      String maxCount = obj.getMaxCount();
      ProductData prodData = new ProductData(attribute, content, maxCount);
      productDataList.add(prodData);
    }
  }
  
  private void addQualityRequirements(IRequirementAnalysis data)
  {
    for(IQualityRequirement obj : data.getQualityRequirements())
    {
      String criteria = obj.getCriteria();
      QualityRequirement req = new QualityRequirement(criteria);
      qualityRequirementList.add(req);
    }
  }
  
  private void addTransactionFP(IRequirementAnalysis data)
  {
    
  }
  
  private void addWeightFactor(IRequirementAnalysis data)
  {
    for(IWeightFactor obj : data.getWeightFactors())
    {
      String title = obj.getTitle();
      int value = obj.getValue();
      int minValue = obj.getMinValue();
      int maxValue = obj.getMaxValue();
      WeightFactor wFac = new WeightFactor(title, value, minValue, maxValue);
      weightFactorList.add(wFac);
    }
  }
  
  private void addCostEstimation(IRequirementAnalysis data)
  {
    ICostEstimation cEst = data.getCostEstimation();
    double functionPoints = cEst.getFunctionPoints();
    double manMonth = cEst.getManMonth();
    costEstimation = new CostEstimation(functionPoints, manMonth);
  }
  
  private void addProductApplication(IRequirementAnalysis data)
  {
    IProductApplication prodApp = data.getProductApplication();
    String description = prodApp.getDescription();
    productApplication = new ProductApplication(description);
  }
  
  private void addTargetDefinition(IRequirementAnalysis data)
  {
    ITargetDefinition targetDef = data.getTargetDefinition();
    String description = targetDef.getDescription();
    this.targetDef = new TargetDefinition(description);
  }
  
}
