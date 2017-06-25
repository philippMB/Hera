package xml;

import Model_Interfaces.*;

import java.util.ArrayList;
import java.util.Date;

public class RequirementsInterchangeFormat
  implements IXMLFormat
{
  @Override
  public void createFragments(IRequirementAnalysis rawData)
  {
    // TODO Implement this method
  }

  @Override
  public double getActualState() {
    return 0;
  }

  @Override
  public Date getCreateDate() {
    return null;
  }

  @Override
  public String getCustomerDescription() {
    return null;
  }

  @Override
  public ArrayList<IAddition> getAdditions() {
    return null;
  }

  @Override
  public ICostEstimation getCostEstimation() {
    return null;
  }

  @Override
  public ArrayList<IFRequirement> getFRequirements() {
    return null;
  }

  @Override
  public ArrayList<INFRequirement> getNFRequirements() {
    return null;
  }

  @Override
  public ArrayList<IGlossaryEntry> getGlossaryEntries() {
    return null;
  }

  @Override
  public ArrayList<IProductData> getProductData() {
    return null;
  }

  @Override
  public ArrayList<IQualityRequirement> getQualityRequirements() {
    return null;
  }

  @Override
  public ArrayList<IWeightFactor> getWeightFactors() {
    return null;
  }

  @Override
  public String getTitle() {
    return null;
  }

  @Override
  public ITargetDefinition getTargetDefinition() {
    return null;
  }

  @Override
  public IProductApplication getProductApplication() {
    return null;
  }

  @Override
  public ICustomerData getCustomerData() {
    return null;
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
}
