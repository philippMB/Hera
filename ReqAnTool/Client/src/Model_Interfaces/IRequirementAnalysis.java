
package Model_Interfaces;

//import MatthiasModel.RequirementList;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by phlippe on 26.04.17.
 */

/**
 * The RequirementAnalysis that holds all attributes and is the main object that is worked on.
 * Every RequirementAnalysis consists of an ActualState, CreateDate, CustomerDescription, multiple Additions, a
 * CostEstimation, multiple FunctionalRequirements, multiple NonFunctionalRequirements, multiple GlossaryEntries,
 * multiple ProductData, multiple QualityRequirements, multiple WeightFactors, a Title, TargetDefinition,
 * ProductApplication and CustomerData.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
 * @version 1.0
 *
 * @see IAddition
 * @see ICostEstimation
 * @see IFRequirement
 * @see INFRequirement
 * @see IGlossaryEntry
 * @see IProductData
 * @see IProductData
 * @see IQualityRequirement
 * @see IWeightFactor
 * @see ITargetDefinition
 * @see IProductApplication
 * @see ICustomerData
 */
public interface IRequirementAnalysis 
{

    /**
     * Get the ActualState of the RequirementAnalysis.
     * @return A Double containing the ActualState
     */
    public double getActualState();

    /**
     * Get the CreateDate of the RequirementAnalysis.
     * @return A Date object containing the date the requirement analysis was created.
     *
     * @see Date
     */
    public Date getCreateDate();

    /**
     * Get the CustomerDescription of the RequirementAnalysis.
     * @return A String containing the CustomerDescription.
     */
    public String getCustomerDescription();

    /**
     * Get a list of the Additions of the RequirementAnalysis.
     * @return An Arraylist of IAddition objects containing the Additions.
     *
     * @see IAddition
     */
    public ArrayList<IAddition> getAdditions();

    /**
     * Get a list of the CostEstimation of the RequirementAnalysis.
     * @return An Arraylist of ICostEstimation objects containing the CostEstimation.
     *
     * @see ICostEstimation
     */
    public ICostEstimation getCostEstimation();

    /**
     * Get a list of the FunctionalRequirements of the RequirementAnalysis.
     * @return An Arraylist of IFRequirement objects containing the FunctionalRequirements.
     *
     * @see IFRequirement
     */
    public ArrayList<IFRequirement> getFRequirements();

    /**
     * Get a list of the NonFunctionalRequirements of the RequirementAnalysis.
     * @return An Arraylist of INFRequirement objects containing the NonFunctionalRequirements.
     *
     * @see INFRequirement
     */
    public ArrayList<INFRequirement> getNFRequirements();

    /**
     * Get a list of the GlossaryEntries of the RequirementAnalysis.
     * @return An Arraylist of IGlossaryEntry objects containing the GlossaryEntries.
     *
     * @see IGlossaryEntry
     */
    public ArrayList<IGlossaryEntry> getGlossaryEntries();

    /**
     * Get a list of the ProductData of the RequirementAnalysis.
     * @return An Arraylist of IProductData objects containing the ProductData.
     *
     * @see IProductData
     */
    public ArrayList<IProductData> getProductData();

    /**
     * Get a list of the QualityRequirements of the RequirementAnalysis.
     * @return An Arraylist of IQualityRequirements objects containing the QualityRequirements.
     *
     * @see IQualityRequirement
     */
    public ArrayList<IQualityRequirement> getQualityRequirements();

    /**
     * Get a list of the WeightFactors of the RequirementAnalysis.
     * @return An Arraylist of IWeightFactor objects containing the WeightFactors.
     *
     * @see IWeightFactor
     */
    public ArrayList<IWeightFactor> getWeightFactors();

    /**
     * Get the title of the RequirementAnalysis.
     * @return A String containing the title.
     */
    public String getTitle();

    /**
     * Get the TargetDefinition of the RequirementAnalysis.
     * @return An ITargetDefinition object containing the TargetDefinition.
     *
     * @see ITargetDefinition
     */
    public ITargetDefinition getTargetDefinition();

    /**
     * Get the ProductApplication of the RequirementAnalysis.
     * @return An IProductApplication object containing the ProductApplication.
     *
     * @see IProductApplication
     */
    public IProductApplication getProductApplication();

    /**
     * Get the CustomerData of the RequirementAnalysis.
     * @return An ICustomerData object containing the CustomerData.
     *
     * @see ICustomerData
     */
    public ICustomerData getCustomerData();

    // TODO: was wenn term nicht gefunden?
    /**
     * Get the GlossaryEntry by its term.
     * @param term The term of the GlossaryEntry.
     * @return If the term could be found an IGlossaryEntry object containing the GlossaryEntry is returned.
     *
     * @see IGlossaryEntry
     */
    public IGlossaryEntry getGlossaryEntriesByTerm(String term);

    // TODO: wenn criteria nicht gefunden?
    /**
     * Get the QualityRequirement by its criteria.
     * @param criteria The criteria of the QualityRequirement.
     * @return If the criteria could be found the IQualityRequirement object is returned.
     *
     * @see IQualityRequirement
     */
    public IQualityRequirement getQualityRequirementsByCriteria(String criteria);

    // TODO: wenn title nicht gefunden?
    /**
     * Get the Addition by its title.
     * @param title The title of the addition.
     * @return If the title could be found the IAddition object is returned.
     *
     * @see IAddition
     */
    public IAddition getAdditionByTitle(String title);

    // TODO: wenn title nicht gefunden?
    /**
     * Get the optimized WeightFactor by its title.
     * @param title The title of the optimized WeightFactor.
     * @return If the title could be found the optimized IWeightFactor object is returned.
     *
     * @see IWeightFactor
     */
    public IWeightFactor getWeightFactorByTitle(String title);

    // TODO: wenn id nicht gefunden?
    /**
     * Get a FunctionRequirement by its id.
     * @param id The id of the FunctionRequirement.
     * @return If the id could be found the IFRequirement object is returned.
     *
     * @see IFRequirement
     */
    public IFRequirement getFRequirementByID(String id);

    // TODO: wenn id nicht gefunden?
    /**
     * Get the NonFunctionalRequirement by its id.
     * @param id The id of the NonFunctionalRequirement.
     * @return If the id could be found the INFRequirement object is returned.
     *
     * @see INFRequirement
     */
    public INFRequirement getNFRequirementByID(String id);

    // TODO: wenn id nicht gefunden?
    /**
     * Get the ProductData by its id.
     * @param id The id of the ProductData.
     * @return If the id could be found the IProductData object is returned.
     *
     * @see IProductData
     */
    public IProductData getProductDataByID(String id);

    public IProductEnvironment getProductEnvironment();
}
