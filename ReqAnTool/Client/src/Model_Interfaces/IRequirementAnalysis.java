package Model_Interfaces;

import java.util.ArrayList;
import java.util.Date;

/**
 * The RequirementAnalysis that holds all attributes and is the main object that is worked on.
 * Every RequirementAnalysis consists of an ActualState, CreateDate, CustomerDescription, multiple Additions, a
 * CostEstimation, multiple FunctionalRequirements, multiple NonFunctionalRequirements, multiple GlossaryEntries,
 * multiple ProductData, multiple QualityRequirements, multiple WeightFactors, a Title, TargetDefinition,
 * ProductApplication and CustomerData.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author 7532274
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
    double getActualState();

    /**
     * Get the CreateDate of the RequirementAnalysis.
     * @return A Date object containing the date the requirement analysis was created.
     *
     * @see Date
     */
    Date getCreateDate();

    /**
     * Get the CustomerDescription of the RequirementAnalysis.
     * @return A String containing the CustomerDescription.
     */
    String getCustomerDescription();

    /**
     * Get a list of the Additions of the RequirementAnalysis.
     * @return An Arraylist of IAddition objects containing the Additions.
     *
     * @see IAddition
     */
    ArrayList<IAddition> getAdditions();

    /**
     * Get a list of the CostEstimation of the RequirementAnalysis.
     * @return An Arraylist of ICostEstimation objects containing the CostEstimation.
     *
     * @see ICostEstimation
     */
    ICostEstimation getCostEstimation();

    /**
     * Get a list of the FunctionalRequirements of the RequirementAnalysis.
     * @return An Arraylist of IFRequirement objects containing the FunctionalRequirements.
     *
     * @see IFRequirement
     */
    ArrayList<IFRequirement> getFRequirements();

    /**
     * Get a list of the NonFunctionalRequirements of the RequirementAnalysis.
     * @return An Arraylist of INFRequirement objects containing the NonFunctionalRequirements.
     *
     * @see INFRequirement
     */
    ArrayList<INFRequirement> getNFRequirements();

    /**
     * Get a list of the GlossaryEntries of the RequirementAnalysis.
     * @return An Arraylist of IGlossaryEntry objects containing the GlossaryEntries.
     *
     * @see IGlossaryEntry
     */
    ArrayList<IGlossaryEntry> getGlossaryEntries();

    /**
     * Get a list of the ProductData of the RequirementAnalysis.
     * @return An Arraylist of IProductData objects containing the ProductData.
     *
     * @see IProductData
     */
    ArrayList<IProductData> getProductData();

    /**
     * Get a list of the QualityRequirements of the RequirementAnalysis.
     * @return An Arraylist of IQualityRequirements objects containing the QualityRequirements.
     *
     * @see IQualityRequirement
     */
    ArrayList<IQualityRequirement> getQualityRequirements();

    /**
     * Get a list of the WeightFactors of the RequirementAnalysis.
     * @return An Arraylist of IWeightFactor objects containing the WeightFactors.
     *
     * @see IWeightFactor
     */
    ArrayList<IWeightFactor> getWeightFactors();

    /**
     * Get the title of the RequirementAnalysis.
     * @return A String containing the title.
     */
    String getTitle();

    /**
     * Get the TargetDefinition of the RequirementAnalysis.
     * @return An ITargetDefinition object containing the TargetDefinition.
     *
     * @see ITargetDefinition
     */
    ITargetDefinition getTargetDefinition();

    /**
     * Get the ProductApplication of the RequirementAnalysis.
     * @return An IProductApplication object containing the ProductApplication.
     *
     * @see IProductApplication
     */
    IProductApplication getProductApplication();

    /**
     * Get the CustomerData of the RequirementAnalysis.
     * @return An ICustomerData object containing the CustomerData.
     *
     * @see ICustomerData
     */
    ICustomerData getCustomerData();

    /**
     * Get the GlossaryEntry by its term.
     * @param term The term of the GlossaryEntry.
     * @return If the term could be found an IGlossaryEntry object containing the GlossaryEntry is returned.
     * Otherwise, it will return null.
     *
     * @see IGlossaryEntry
     */
    IGlossaryEntry getGlossaryEntriesByTerm(String term);

    /**
     * Get the QualityRequirement by its criteria.
     * @param criteria The criteria of the QualityRequirement.
     * @return If the criteria could be found the IQualityRequirement object is returned.
     * Otherwise, it will return null.
     *
     * @see IQualityRequirement
     */
    IQualityRequirement getQualityRequirementsByCriteria(String criteria);

    /**
     * Get the Addition by its title.
     * @param title The title of the addition.
     * @return If the title could be found the IAddition object is returned.
     * Otherwise, it will return null.
     *
     * @see IAddition
     */
    IAddition getAdditionByTitle(String title);

    /**
     * Get the optimized WeightFactor by its title.
     * @param title The title of the optimized WeightFactor.
     * @return If the title could be found the optimized IWeightFactor object is returned.
     * Otherwise, it will return null.
     *
     * @see IWeightFactor
     */
    IWeightFactor getWeightFactorByTitle(String title);

    /**
     * Get a FunctionRequirement by its id.
     * @param id The id of the FunctionRequirement.
     * @return If the id could be found the IFRequirement object is returned.
     * Otherwise, it will return null.
     *
     * @see IFRequirement
     */
    IFRequirement getFRequirementByID(String id);

    /**
     * Get the NonFunctionalRequirement by its id.
     * @param id The id of the NonFunctionalRequirement.
     * @return If the id could be found the INFRequirement object is returned.
     * Otherwise, it will return null.
     *
     * @see INFRequirement
     */
    INFRequirement getNFRequirementByID(String id);

    /**
     * Get the ProductData by its id.
     * @param id The id of the ProductData.
     * @return If the id could be found the IProductData object is returned.
     * Otherwise, it will return null.
     *
     * @see IProductData
     */
    IProductData getProductDataByID(String id);

    /**
     * Get the Product Environment of the RequirementAnalysis.
     * @return An IProductEnvironment object containing the ProductEnvironment.
     *
     * @see IProductEnvironment
     */
    IProductEnvironment getProductEnvironment();

}
