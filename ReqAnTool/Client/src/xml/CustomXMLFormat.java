package xml;

import Model_Interfaces.*;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="RequirementAnalysis")
@XmlAccessorType(XmlAccessType.FIELD)
/**
 * The custom XML format which is JAXB conform and stores all the data from the original requirement analysis.
 * The used XML converter {@link JAXB} needs the classes it converts to confirm to given conditions. To meet these
 * conditions this class copies all data from the original requirement analysis loss free and provides it for JAXB.
 * It implements {@link IXMLFormat} and makes its attributes thus also available via the {@link IRequirementAnalysis}
 * interface. The Getter and Setter fot this class are needed to make it JAXB conform. All other Getters must be
 * implemented to make the data available through the IRequirementAnalysis interface.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see IRequirementAnalysis
 * @see IXMLFormat
 * @see javax.xml.bind.JAXB
 */
public class CustomXMLFormat
  implements IXMLFormat
{
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

  @XmlElementWrapper(name="Product_Data_List")
  @XmlElement(name="Product_Data")
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

  @XmlElementWrapper(name="Additions")
  @XmlElement(name="Addition")
  private ArrayList<Supplement> supplements = new ArrayList<>();

  @XmlElement(name="Create_Date")
  private Date createDate;

  @XmlElement(name="Title")
  private String title;

  @XmlElement(name="Actual_State")
  private double actualState;

  @XmlElement(name="Customer_Description")
  private String customerDescription;

  /**
   * The original requirement analysis is separated in its parts and copied into this JAXB conform format.
   * The requirement analysis fragments have to be processed separately to ensure that every part gets converted into
   * the right JAXB conform data structure.
   * @param rawData The original data from the {@link IRequirementAnalysis} object.
   *
   * @see IRequirementAnalysis
   * @see javax.xml.bind.JAXB
   */
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
   * Converts the {@link IAddition} objects to JAXB conform {@link Supplement} objects.
   * An iterator is used.
   * @param additions The Arraylist of the Additions from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
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

  /**
   * Converts the {@link IFRequirement} objects to JAXB conform {@link FRequirement} objects.
   * An iterator is used.
   * @param data The Arraylist of the FRequirements from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see IFRequirement
   */
  private void addFuncRequirements(@NotNull ArrayList<IFRequirement> data)
  {
    for(IFRequirement obj : data)
    {
      FRequirement req = new FRequirement(obj);
      funcRequirementList.add(req);
    }
  }

  /**
   * Converts the {@link IDataFP} objects to JAXB conform {@link DataFP} objects.
   * An iterator is used.
   * @return An Arraylist of the newly created DataFP objects is returned.
   * @param data The Arraylist of the DataFunctionPoints from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see IDataFP
   */
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

  /**
   * Converts the {@link INFRequirement} objects to JAXB conform {@link NFRequirement} objects.
   * An iterator is used.
   * @param data The Arraylist of the NonFunctionalRequirements from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see INFRequirement
   */
  private void addNonFuncRequirements(@NotNull ArrayList<INFRequirement> data)
  {
    for(INFRequirement obj : data)
    {
      NFRequirement req = new NFRequirement(obj);
      nonFuncRequirementList.add(req);
    }
  }

  /**
   * Converts the {@link ICustomerData} object to JAXB conform {@link CustomerData} object.
   * @param data The CustomerData from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see ICustomerData
   */
  private void addCustomerData(@NotNull ICustomerData data)
  {
    custData = new CustomerData(data);
  }

  /**
   * Converts the {@link IGlossaryEntry} objects to JAXB conform {@link GlossaryEntry} objects.
   * An iterator is used.
   * @param data The Arraylist of the GlossaryEntrys from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see IGlossaryEntry
   */
  private void addGlossary(@NotNull ArrayList<IGlossaryEntry> data)
  {
    for(IGlossaryEntry obj : data)
    {
      GlossaryEntry entry = new GlossaryEntry(obj);
      glossary.add(entry);
    }
  }

  /**
   * Converts the {@link IProductData} objects to JAXB conform {@link ProductData} objects.
   * An iterator is used.
   * @param data The Arraylist of the ProductData from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see IProductData
   */
  private void addProductData(@NotNull ArrayList<IProductData> data)
  {
    for(IProductData obj : data)
    {
      ProductData prodData = new ProductData(obj);
      productDataList.add(prodData);
    }
  }

  /**
   * Converts the {@link IQualityRequirement} objects to JAXB conform {@link QualityRequirement} objects.
   * An iterator is used.
   * @param data The Arraylist of the QualityRequirements from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see IQualityRequirement
   */
  private void addQualityRequirements(@NotNull ArrayList<IQualityRequirement> data)
  {
    for(IQualityRequirement obj : data)
    {
      QualityRequirement req = new QualityRequirement(obj);
      qualityRequirementList.add(req);
    }
  }

  /**
   * Converts the {@link ITransactionFP} objects to JAXB conform {@link TransactionFP} objects.
   * An iterator is used.
   * @return An Arraylist of the newly created TransactionFP objects is returned.
   * @param data The Arraylist of the TransactionFunctionPoints from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see ITransactionFP
   */
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

  /**
   * Converts the {@link IWeightFactor} objects to JAXB conform {@link WeightFactor} objects.
   * An iterator is used.
   * @return An Arraylist of the newly created WeightFactor objects is returned.
   * @param data The Arraylist of the WeightFactors from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see IWeightFactor
   */
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

  /**
   * Converts the {@link ICostEstimation} objects to JAXB conform {@link CostEstimation} objects.
   * An iterator is used. To provide {@link DataFP}, {@link TransactionFP} and {@link WeightFactor} they are separately
   * converted by the {@link CustomXMLFormat#addDataFP(ArrayList)}, {@link CustomXMLFormat#addTransactionFP(ArrayList)}
   * and {@link CustomXMLFormat#addWeightFactor(ArrayList)} methods.
   * @param data The Arraylist of the CostEstimation from the original requirement analysis. Null is allowed and will
   *             not cause immediate errors.
   *
   * @see ICostEstimation
   */
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

  /**
   * Converts the {@link IProductApplication} object to JAXB conform {@link ProductApplication} object.
   * @param data The ProduktApplication from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see IProductApplication
   */
  private void addProductApplication(@NotNull IProductApplication data)
  {
    productApplication = new ProductApplication(data);
  }

  /**
   * Converts the {@link ITargetDefinition} objects to JAXB conform {@link TargetDefinition} objects.
   * @param data The TargetDefinition from the original requirement analysis. If null is provided a
   *                  {@link NullPointerException} is thrown.
   *
   * @see ITargetDefinition
   */
  private void addTargetDefinition(@NotNull ITargetDefinition data)
  {
    this.targetDef = new TargetDefinition(data);
  }

  /**
   * Sets the FunctionalRequirements for the CustomXMLFormat.
   * Required by JAXB.
   * @param funcRequirementList Arraylist of FunctionalRequirements.
   */
  public void setFuncRequirementList(ArrayList<FRequirement> funcRequirementList)
  {
    this.funcRequirementList = funcRequirementList;
  }

  /**
   * Get the FunctionalRequirements of the CustomXMLFormat.
   * Required by JAXB.
   * @return Arraylist of FunctionalRequirements.
   */
  public ArrayList<FRequirement> getFuncRequirementList()
  {
    return funcRequirementList;
  }

  /**
   * Sets the NonFunctionalRequirements for the CustomXMLFormat.
   * Required by JAXB.
   * @param nonFuncRequirementList Arraylist of NonFunctionalRequirements.
   */
  public void setNonFuncRequirementList(ArrayList<NFRequirement> nonFuncRequirementList)
  {
    this.nonFuncRequirementList = nonFuncRequirementList;
  }

  /**
   * Get the NonFunctionalRequirements of the CustomXMLFormat.
   * Required by JAXB.
   * @return Arraylist of NonFunctionalRequirements.
   */
  public ArrayList<NFRequirement> getNonFuncRequirementList()
  {
    return nonFuncRequirementList;
  }

  /**
   * Sets the CustomerData for the CustomXMLFormat.
   * Required by JAXB.
   * @param custData CustomerData of the requirement analysis.
   */
  public void setCustData(CustomerData custData)
  {
    this.custData = custData;
  }

  /**
   * Get the CustomerData of the CustomXMLFormat.
   * Required by JAXB.
   * @return CustomerData of the requirement analysis.
   */
  public CustomerData getCustData()
  {
    return custData;
  }

  /**
   * Sets the GlossaryEntries for the CustomXMLFormat.
   * Required by JAXB.
   * @param glossary Arraylist of GlossaryEntries.
   */
  public void setGlossary(ArrayList<GlossaryEntry> glossary)
  {
    this.glossary = glossary;
  }

  /**
   * Get the GlossaryEntries of the CustomXMLFormat.
   * Required by JAXB.
   * @return Arraylist of GlossaryEntries.
   */
  public ArrayList<GlossaryEntry> getGlossary()
  {
    return glossary;
  }

  /**
   * Sets the ProductData for the CustomXMLFormat.
   * Required by JAXB.
   * @param productDataList Arraylist of ProductData.
   */
  public void setProductDataList(ArrayList<ProductData> productDataList)
  {
    this.productDataList = productDataList;
  }

  /**
   * Get the ProductData of the CustomXMLFormat.
   * Required by JAXB.
   * @return Arraylist of ProductData.
   */
  public ArrayList<ProductData> getProductDataList()
  {
    return productDataList;
  }

  /**
   * Sets the QualityRequirements for the CustomXMLFormat.
   * Required by JAXB.
   * @param qualityRequirementList Arraylist of QualityRequirements.
   */
  public void setQualityRequirementList(ArrayList<QualityRequirement> qualityRequirementList)
  {
    this.qualityRequirementList = qualityRequirementList;
  }

  /**
   * Sets the CreateDate for the CustomXMLFormat.
   * Required by JAXB.
   * @param createDate CreateDate of the requirement analysis.
   */
  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  /**
   * Get the QualityRequirements of the CustomXMLFormat.
   * Required by JAXB.
   * @return Arraylist of QualityRequirements.
   */
  public ArrayList<QualityRequirement> getQualityRequirementList()
  {
    return qualityRequirementList;
  }

  /**
   * Sets the CostEstimation for the CustomXMLFormat.
   * Required by JAXB.
   * @param costEstimation CostEstimation of the requirement analysis.
   */
  public void setCostEstimation(CostEstimation costEstimation)
  {
    this.costEstimation = costEstimation;
  }

  /**
   * Get the ActualState of the CustomXMLFormat.
   * Required by JAXB.
   * @return AcutalState of the requirement analysis.
   */
  @Override
  public double getActualState() {
    return actualState;
  }

  /**
   * Sets the ActualState for the CustomXMLFormat.
   * Required by JAXB.
   * @param actualState ActualState of the requirement analysis.
   */
  public void setActualState(double actualState) {
    this.actualState = actualState;
  }

  /**
   * Get the CreateDate of the CustomXMLFormat.
   * Required by JAXB.
   * @return CreateDate of the requirement analysis.
   */
  @Override
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * Get the CustomerDescription of the CustomXMLFormat.
   * Required by JAXB.
   * @return CustomerDescription of the requirement analysis.
   */  @Override
  public String getCustomerDescription() {
    return customerDescription;
  }

  /**
   * Sets the CustomerDescription for the CustomXMLFormat.
   * Required by JAXB.
   * @param customerDescription CustomerDescription of the requirement analysis.
   */
  public void setCustomerDescription(String customerDescription) {
    this.customerDescription = customerDescription;
  }

  /**
   * Get the Additions of the CustomXMLFormat.
   * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
   * @return Arraylist of IAdditions.
   */
  @Override
  public ArrayList<IAddition> getAdditions() {
    ArrayList<IAddition> iAdd = new ArrayList<>();
    for (IAddition obj : supplements)
    {
      iAdd.add(obj);
    }
    return iAdd;
  }

  /**
   * Get the CostEstimation of the CustomXMLFormat.
   * Required by IRequirementAnalysis.
   * @return ICostEstimations.
   */
  public ICostEstimation getCostEstimation()
  {
    return costEstimation;
  }

  /**
   * Get the FunctionalRequirements of the CustomXMLFormat.
   * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
   * @return Arraylist of IFRequirements.
   */
  @Override
    public ArrayList<IFRequirement> getFRequirements() {
      ArrayList<IFRequirement> iFReq = new ArrayList<>();
      for (IFRequirement obj : funcRequirementList)
      {
        iFReq.add(obj);
      }
      return iFReq;
    }

  /**
   * Get the NonFunctionalRequirements of the CustomXMLFormat.
   * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
   * @return Arraylist of INFRequirements.
   */
    @Override
    public ArrayList<INFRequirement> getNFRequirements() {
      ArrayList<INFRequirement> iNFReq = new ArrayList<>();
      for (INFRequirement obj : nonFuncRequirementList)
      {
        iNFReq.add(obj);
      }
      return iNFReq;
    }

  /**
   * Get the GlossaryEntries of the CustomXMLFormat.
   * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
   * @return Arraylist of IGlossaryEntry.
   */
    @Override
    public ArrayList<IGlossaryEntry> getGlossaryEntries() {
      ArrayList<IGlossaryEntry> iGlo = new ArrayList<>();
      for (IGlossaryEntry obj : glossary)
      {
        iGlo.add(obj);
      }
      return iGlo;
    }

  /**
   * Get the ProductData of the CustomXMLFormat.
   * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
   * @return Arraylist of IProductData.
   */
    @Override
    public ArrayList<IProductData> getProductData() {
      ArrayList<IProductData> iProd = new ArrayList<>();
      for (IProductData obj : productDataList)
      {
        iProd.add(obj);
      }
      return iProd;
    }

  /**
   * Get the QualityRequirements of the CustomXMLFormat.
   * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
   * @return Arraylist of IQualityRequirement.
   */
  @Override
  public ArrayList<IQualityRequirement> getQualityRequirements() {
    ArrayList<IQualityRequirement> iQual = new ArrayList<>();
    for (IQualityRequirement obj : qualityRequirementList)
    {
      iQual.add(obj);
    }
    return iQual;  }

    // TODO: null beachten, abfangen oder nur sagen, dass es null sein kann? +datafp + transfp
  /**
   * Get the WeightFactors of the CustomXMLFormat.
   * Required by IRequirementAnalysis. Have to be converted one by one because of the xml binding for JAXB.
   * @return Arraylist of IWeightFactor.
   */
  @Override
  public ArrayList<IWeightFactor> getWeightFactors() {
    return costEstimation.getWeightFactors();
  }

  /**
   * Get the TargetDefinition of the CustomXMLFormat.
   * Required by IRequirementAnalysis.
   * @return ITargetDefinition.
   */
  @Override
  public ITargetDefinition getTargetDefinition() {
    return targetDef;
  }

  /**
   * Set the ProductApplication of the CustomXMLFormat.
   * Required by JAXB.
   * @param  productApplication ProductApplication of the requirement analysis.
   */
  public void setProductApplication(ProductApplication productApplication)
  {
    this.productApplication = productApplication;
  }

  /**
   * Get the ProductApplication of the CustomXMLFormat.
   * Required by IRequirementAnalysis.
   * @return IProductApplication.
   */
  public IProductApplication getProductApplication()
  {
    return productApplication;
  }

  /**
   * Get the CustomerData of the CustomXMLFormat.
   * Required by IRequirementAnalysis.
   * @return ICustomerData.
   */
  @Override
  public ICustomerData getCustomerData() {
    return custData;
  }

  /**
   * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
   * functionality.
   * @param term
   * @return always null
   */
  @Override
  public IGlossaryEntry getGlossaryEntriesByTerm(String term) {
    return null;
  }

  /**
   * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
   * functionality.
   * @param criteria
   * @return always null
   */
  @Override
  public IQualityRequirement getQualityRequirementsByCriteria(String criteria) {
    return null;
  }

  /**
   * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
   * functionality.
   * @param title
   * @return always null
   */
  @Override
  public IAddition getAdditionByTitle(String title) {
    return null;
  }

  /**
   * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
   * functionality.
   * @param title
   * @return always null
   */
  @Override
  public IWeightFactor getWeightFactorByTitle(String title) {
    return null;
  }

  /**
   * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
   * functionality.
   * @param id
   * @return always null
   */
  @Override
  public IFRequirement getFRequirementByID(String id) {
    return null;
  }

  /**
   * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
   * functionality.
   * @param id
   * @return always null
   */
  @Override
  public INFRequirement getNFRequirementByID(String id) {
    return null;
  }

  /**
   * Not implemented, because this class only represents the data structure of {@link IRequirementAnalysis}, not the
   * functionality.
   * @param id
   * @return always null
   */
  @Override
  public IProductData getProductDataByID(String id) {
    return null;
  }

  @Override
  public IProductEnvironment getProductEnvironment()
  {
    return null;
  }

  /**
   * Set the TargetDefinition of the CustomXMLFormat.
   * Required by JAXB.
   * @param  targetDef TargetDefinition of the requirement analysis.
   */
  public void setTargetDef(TargetDefinition targetDef)
  {
    this.targetDef = targetDef;
  }

  /**
   * Get the TargetDefinition of the CustomXMLFormat.
   * Required by JAXB.
   * @return TargetDefinition of the requirement analysis..
   */
  public TargetDefinition getTargetDef()
  {
    return targetDef;
  }

  /**
   * Set the Supplements of the CustomXMLFormat.
   * Required by JAXB.
   * @param  supplements Supplements of the requirement analysis.
   */
  public void setSupplements(ArrayList<Supplement> supplements)
  {
    this.supplements = supplements;
  }

  /**
   * Get the Supplements of the CustomXMLFormat.
   * Required by JAXB.
   * @return Arraylist of Supplements.
   */
  public ArrayList<Supplement> getSupplements()
  {
    return supplements;
  }

  /**
   * Set the Title of the CustomXMLFormat.
   * Required by JAXB.
   * @param  reqAnTitle Title of the requirement analysis.
   */
  public void setTitle(String reqAnTitle)
  {
    this.title = reqAnTitle;
  }

  /**
   * Get the Title of the CustomXMLFormat.
   * Required by JAXB.
   * @return Title of the requirement analysis..
   */
  public String getTitle()
  {
    return title;
  }
}
