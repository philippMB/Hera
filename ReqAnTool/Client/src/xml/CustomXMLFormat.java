package xml;

import Model_Interfaces.*;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

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
  private ArrayList<FRequirement> funcRequirementList = new ArrayList<>();

  @XmlElementWrapper(name="Non-Functional_Requirements")
  @XmlElement(name="Requirement")
  private ArrayList<NFRequirement> nonFuncRequirementList = new ArrayList<>();

  @XmlElement(name="CustomerData")
  private CustomerData custData;

  @XmlElementWrapper(name="Glossary")
  @XmlElement(name="Glossary_Entry")
  private ArrayList<GlossaryEntry> glossary = new ArrayList<>();

  private ArrayList<ProductData> productDataList = new ArrayList<>();

  @XmlElementWrapper(name="Quality_Requirements")
  @XmlElement(name="Requirement")
  private ArrayList<QualityRequirement> qualityRequirementList = new ArrayList<>();

  @XmlElement(name="Cost_Estimation")
  private CostEstimation costEstimation;

  @XmlElement(name="Product_Application")
  private ProductApplication productApplication;

  @XmlElement(name="Target_Definition")
  private TargetDefinition targetDef;

  private ArrayList<Supplement> supplements = new ArrayList<>();

  private Date createDate;

  private String title;

  private double actualState;

  private String customerDescription;

  // TODO: @NotNull für den alles
  // TODO: docu sagen dass nicht null sonst null-pointer-exception(interface & hier)
  @Override
  public void createFragments(IRequirementAnalysis rawData)
  {
    addFuncRequirements(rawData.getFRequirements());
    addNonFuncRequirements(rawData.getNFRequirements());
    addCustomerData(rawData.getCustomerData());
    addGlossary(rawData.getGlossaryEntries());
    addProductData(rawData.getProductData());
    addQualityRequirements(rawData.getQualityRequirements());
    addCostEstimation(rawData.getCostEstimation());
    addProductApplication(rawData.getProductApplication());
    addTargetDefinition(rawData.getTargetDefinition());
    setCreateDate(rawData.getCreateDate());
    setTitle(rawData.getTitle());
    setActualState(rawData.getActualState());
    setCustomerDescription(rawData.getCustomerDescription());
    addSupplements(rawData.getAdditions());
  }

  /**
   * Was ich mache.
   * @param additions wer ich bin.
   * @see IAddition
   */
  private void addSupplements(@NotNull  ArrayList<IAddition> additions)
  {
    for (IAddition obj : additions)
    {
      Supplement sup = new Supplement(obj);
      supplements.add(sup);
    }
  }

  private void addFuncRequirements(@NotNull ArrayList<IFRequirement> data)
  {
    for(IFRequirement obj : data)
    {
      FRequirement req = new FRequirement(obj);
      funcRequirementList.add(req);
    }
  }

  private ArrayList<DataFP> addDataFP(@NotNull ArrayList<IDataFP> data)
  {
    ArrayList<DataFP> dataFuncPointList = new ArrayList<>();
    for(IDataFP obj : data)
    {
      DataFP funcPoint = new DataFP(obj);
        dataFuncPointList.add(funcPoint);
    }

    return dataFuncPointList;
  }

  private void addNonFuncRequirements(@NotNull ArrayList<INFRequirement> data)
  {
    for(INFRequirement obj : data)
    {
      NFRequirement req = new NFRequirement(obj);
      nonFuncRequirementList.add(req);
    }
  }

  private void addCustomerData(@NotNull ICustomerData data)
  {
    custData = new CustomerData(data);
  }
  
  private void addGlossary(@NotNull ArrayList<IGlossaryEntry> data)
  {
    for(IGlossaryEntry obj : data)
    {
      GlossaryEntry entry = new GlossaryEntry(obj);
      glossary.add(entry);
    }
  }
  
  private void addProductData(@NotNull ArrayList<IProductData> data)
  {
    for(IProductData obj : data)
    {
      ProductData prodData = new ProductData(obj);
      productDataList.add(prodData);
    }
  }
  
  private void addQualityRequirements(@NotNull ArrayList<IQualityRequirement> data)
  {
    for(IQualityRequirement obj : data)
    {
      QualityRequirement req = new QualityRequirement(obj);
      qualityRequirementList.add(req);
    }
  }
  
  private ArrayList<TransactionFP> addTransactionFP(@NotNull ArrayList<ITransactionFP> data)
  {
    ArrayList<TransactionFP> transactionFPList = new ArrayList<>();
    for(ITransactionFP obj : data)
    {
      TransactionFP funcPoint = new TransactionFP(obj);
      transactionFPList.add(funcPoint);
    }

    return transactionFPList;
  }

  private ArrayList<WeightFactor> addWeightFactor(@NotNull ArrayList<IWeightFactor> data)
  {
    ArrayList<WeightFactor> weightFactorList = new ArrayList<>();
    for(IWeightFactor obj : data)
    {
      WeightFactor wFac = new WeightFactor(obj);
      weightFactorList.add(wFac);
    }

    return weightFactorList;
  }
  
  private void addCostEstimation(@Nullable ICostEstimation data)
  {
    if(data != null)
    {
      ArrayList<DataFP> dataFuncPointList = addDataFP(data.getDataFPs());
      ArrayList<TransactionFP> transactionFPList = addTransactionFP(data.getTransactionFPs());
      ArrayList<WeightFactor> weightFactorList = addWeightFactor(data.getWeightFactors());
      costEstimation = new CostEstimation(data, dataFuncPointList, transactionFPList, weightFactorList);
    }
    else
    {
      costEstimation = null;
    }
  }
  
  private void addProductApplication(@NotNull IProductApplication data)
  {
    productApplication = new ProductApplication(data);
  }
  
  private void addTargetDefinition(@NotNull ITargetDefinition data)
  {
    this.targetDef = new TargetDefinition(data);
  }

  public void setFuncRequirementList(ArrayList<FRequirement> funcRequirementList)
  {
    this.funcRequirementList = funcRequirementList;
  }

  public ArrayList<FRequirement> getFuncRequirementList()
  {
    return funcRequirementList;
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

  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  public ArrayList<QualityRequirement> getQualityRequirementList()
  {
    return qualityRequirementList;
  }

  public void setCostEstimation(CostEstimation costEstimation)
  {
    this.costEstimation = costEstimation;
  }

  @Override
  public double getActualState() {
    return actualState;
  }

  public void setActualState(double actualState) {
    this.actualState = actualState;
  }

  // TODO:
  @Override
  public Date getCreateDate() {
    return createDate;
  }

  // TODO:
  @Override
  public String getCustomerDescription() {
    return customerDescription;
  }

  public void setCustomerDescription(String customerDescription) {
    this.customerDescription = customerDescription;
  }

  // TODO:
  @Override
  public ArrayList<IAddition> getAdditions() {
    ArrayList<IAddition> iAdd = new ArrayList<>();
    for (IAddition obj : supplements)
    {
      iAdd.add(obj);
    }
    return iAdd;
  }

  public ICostEstimation getCostEstimation()
  {
    return costEstimation;
  }

  @Override
    public ArrayList<IFRequirement> getFRequirements() {
      ArrayList<IFRequirement> iFReq = new ArrayList<>();
      for (IFRequirement obj : funcRequirementList)
      {
        iFReq.add(obj);
      }
      return iFReq;
    }

    @Override
    public ArrayList<INFRequirement> getNFRequirements() {
      ArrayList<INFRequirement> iNFReq = new ArrayList<>();
      for (INFRequirement obj : nonFuncRequirementList)
      {
        iNFReq.add(obj);
      }
      return iNFReq;
    }

    @Override
    public ArrayList<IGlossaryEntry> getGlossaryEntries() {
      ArrayList<IGlossaryEntry> iGlo = new ArrayList<>();
      for (IGlossaryEntry obj : glossary)
      {
        iGlo.add(obj);
      }
      return iGlo;
    }

    @Override
    public ArrayList<IProductData> getProductData() {
      ArrayList<IProductData> iProd = new ArrayList<>();
      for (IProductData obj : productDataList)
      {
        iProd.add(obj);
      }
      return iProd;
    }

  @Override
  public ArrayList<IQualityRequirement> getQualityRequirements() {
    ArrayList<IQualityRequirement> iQual = new ArrayList<>();
    for (IQualityRequirement obj : qualityRequirementList)
    {
      iQual.add(obj);
    }
    return iQual;  }

    // TODO: null beachten
  @Override
  public ArrayList<IWeightFactor> getWeightFactors() {
    return costEstimation.getWeightFactors();
  }

  @Override
  public ITargetDefinition getTargetDefinition() {
    return targetDef;
  }

  public void setProductApplication(ProductApplication productApplication)
  {
    this.productApplication = productApplication;
  }

  public IProductApplication getProductApplication()
  {
    return productApplication;
  }

  @Override
  public ICustomerData getCustomerData() {
    return custData;
  }

  @Override
  public IGlossaryEntry getGlossaryEntriesByTerm(String term) {
    return null;
  }

  @Override
  public IQualityRequirement getQualityRequirementsByCriteria(String criteria) {
    return null;
  }

  @Override
  public IAddition getAdditionByTitle(String title) {
    return null;
  }

  @Override
  public IWeightFactor getWeightFactorByTitle(String title) {
    return null;
  }

  @Override
  public IFRequirement getFRequirementByID(String id) {
    return null;
  }

  @Override
  public INFRequirement getNFRequirementByID(String id) {
    return null;
  }

  @Override
  public IProductData getProductDataByID(String id) {
    return null;
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

  public void setTitle(String reqAnTitle)
  {
    this.title = reqAnTitle;
  }

  public String getTitle()
  {
    return title;
  }
}
