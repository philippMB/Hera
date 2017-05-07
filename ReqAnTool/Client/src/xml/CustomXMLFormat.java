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
import Model_Interfaces.ITransactionFP;
import Model_Interfaces.IWeightFactor;
import Model_Interfaces.IRequirement;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="RequirementAnalysis")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomXMLFormat
  implements IXMLFormat
{
  // new fehlt?
  @XmlElementWrapper(name="Functional_Requirements")
  @XmlElement(name="Requirement")
  private ArrayList<FRequirement> funcRequirementList;
  
  @XmlElementWrapper(name="Data_FunctionPoints")
  @XmlElement(name="FunctionPoint")
  private ArrayList<DataFP> dataFuncPointList;
  
  @XmlElementWrapper(name="Non-Functional_Requirements")
  @XmlElement(name="Requirement")
  private ArrayList<NFRequirement> nonFuncRequirementList;
  
  @XmlElement(name="CustomerData")
  private CustomerData custData;
  
  @XmlElementWrapper(name="Glossary")
  @XmlElement(name="Glossary_Entry")
  private ArrayList<GlossaryEntry> glossary;
  
  private ArrayList<ProductData> productDataList;
  
  @XmlElementWrapper(name="Quality_Requirements")
  @XmlElement(name="Requirement")
  private ArrayList<QualityRequirement> qualityRequirementList;
  
  @XmlElementWrapper(name="Transaction_FunctionPoints")
  @XmlElement(name="FunctionPoint")
  private ArrayList<TransactionFP> transactionFPList;
  
  @XmlElementWrapper(name="Weightfactors")
  @XmlElement(name="Factor")
  private ArrayList<WeightFactor> weightFactorList;
  
  @XmlElement(name="Cost_Estimation")
  private CostEstimation costEstimation;
  
  @XmlElement(name="Product_Application")
  private ProductApplication productApplication;
  
  @XmlElement(name="Target_Definition")
  private TargetDefinition targetDef;
  private ArrayList<Supplement> supplements;
  private Title reqAnTitle;

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
    ICostEstimation costEst = data.getCostEstimation();
    for(IDataFP obj : costEst.getDataFPs())
    {
      int det = obj.getDET();
      int ret = obj.getRET();
      ArrayList<String> ref = obj.getRequirement();
      DataFP funcPoint = new DataFP(det, ret);
      dataFuncPointList.add(funcPoint);
    }
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
    ICostEstimation costEst = data.getCostEstimation();
    for(ITransactionFP obj : costEst.getTransactionFPs())
    {
      int ftr = obj.getFTR();
      int det = obj.getDET();
      TransactionFP funcPoint = new TransactionFP(det, ftr);
      transactionFPList.add(funcPoint);
    }
  }
  
  private void addWeightFactor(IRequirementAnalysis data)
  {
    for(IWeightFactor obj : data.getWeightFactors())
    {
      String title = obj.getTitle();
      int value = obj.getValue();
      int maxValue = obj.getMaxValue();
      WeightFactor wFac = new WeightFactor(title, value, maxValue);
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

// Um es JavaBeans zu machen, Refaktoring: obere Methoden austauschen
  public void setFuncRequirementList(ArrayList<FRequirement> funcRequirementList)
  {
    this.funcRequirementList = funcRequirementList;
  }

  public ArrayList<FRequirement> getFuncRequirementList()
  {
    return funcRequirementList;
  }

  public void setDataFuncPointList(ArrayList<DataFP> dataFuncPointList)
  {
    this.dataFuncPointList = dataFuncPointList;
  }

  public ArrayList<DataFP> getDataFuncPointList()
  {
    return dataFuncPointList;
  }

  public void setNonFuncRequirementList(ArrayList<NFRequirement> nonFuncRequirementList)
  {
    this.nonFuncRequirementList = nonFuncRequirementList;
  }

  public ArrayList<NFRequirement> getNonFuncRequirementList()
  {
    return nonFuncRequirementList;
  }

  public void setCustData(CustomerData custData)
  {
    this.custData = custData;
  }

  public CustomerData getCustData()
  {
    return custData;
  }

  public void setGlossary(ArrayList<GlossaryEntry> glossary)
  {
    this.glossary = glossary;
  }

  public ArrayList<GlossaryEntry> getGlossary()
  {
    return glossary;
  }

  public void setProductDataList(ArrayList<ProductData> productDataList)
  {
    this.productDataList = productDataList;
  }

  public ArrayList<ProductData> getProductDataList()
  {
    return productDataList;
  }

  public void setQualityRequirementList(ArrayList<QualityRequirement> qualityRequirementList)
  {
    this.qualityRequirementList = qualityRequirementList;
  }

  public ArrayList<QualityRequirement> getQualityRequirementList()
  {
    return qualityRequirementList;
  }

  public void setTransactionFPList(ArrayList<TransactionFP> transactionFPList)
  {
    this.transactionFPList = transactionFPList;
  }

  public ArrayList<TransactionFP> getTransactionFPList()
  {
    return transactionFPList;
  }

  public void setWeightFactorList(ArrayList<WeightFactor> weightFactorList)
  {
    this.weightFactorList = weightFactorList;
  }

  public ArrayList<WeightFactor> getWeightFactorList()
  {
    return weightFactorList;
  }

  public void setCostEstimation(CostEstimation costEstimation)
  {
    this.costEstimation = costEstimation;
  }

  public CostEstimation getCostEstimation()
  {
    return costEstimation;
  }

  public void setProductApplication(ProductApplication productApplication)
  {
    this.productApplication = productApplication;
  }

  public ProductApplication getProductApplication()
  {
    return productApplication;
  }

  public void setTargetDef(TargetDefinition targetDef)
  {
    this.targetDef = targetDef;
  }

  public TargetDefinition getTargetDef()
  {
    return targetDef;
  }

  public void setSupplements(ArrayList<Supplement> supplements)
  {
    this.supplements = supplements;
  }

  public ArrayList<Supplement> getSupplements()
  {
    return supplements;
  }

  public void setReqAnTitle(Title reqAnTitle)
  {
    this.reqAnTitle = reqAnTitle;
  }

  public Title getReqAnTitle()
  {
    return reqAnTitle;
  }
}
