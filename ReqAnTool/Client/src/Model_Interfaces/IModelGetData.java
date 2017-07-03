package Model_Interfaces;

import java.util.ArrayList;
import java.util.Observer;

public interface IModelGetData
{

    void addObserver(Observer o);

    void deleteObserver(Observer o);

    /**
     * Get the whole requirement analysis.
     * @return An object of type IRequirementAnalysis containing the whole requirement analysis.
     *
     * @see IRequirementAnalysis
     */
    IRequirementAnalysis getReqAnalysis();

    /**
     * Get a FunctionalRequirement by its id.
     * @param id The id of the FunctionRequirement.
     * @return If the id could be found the IFRequirement object is returned. Otherwise, it will return null.
     *
     * @see IFRequirement
     */
    IFRequirement getFReqByID(String id);

    /**
     * Get a NonFunctionalRequirement by its id.
     * @param id The id of the NonFunctionalRequirement.
     * @return If the id could be found the INFRequirement object is returned. Otherwise, it will return null.
     *
     * @see INFRequirement
     */
    INFRequirement getNFReqByID(String id);

    /**
     * Get the ProductData by its id.
     * @param id The id of the ProductData.
     * @return If the id could be found the IProductData object is returned. Otherwise, it will return null.
     *
     * @see IProductData
     */
    IProductData getProductDataByID(String id);

    /**
     * Get the ProductApplication of the requirement analysis.
     * @return The IProductApplication object.
     *
     * @see IProductApplication
     */
    ICustomerData getCustomerData();

    /**
     * Get the ProductApplication of the requirement analysis.
     * @return The IProductApplication object.
     *
     * @see IProductApplication
     */
    IProductApplication getProdApp();

    /**
     * Get the ProductEnvironment of the requirement analysis.
     * @return The IProductEnvironment object.
     *
     * @see IProductEnvironment
     */
    IProductEnvironment getProdEnv();

    /**
     * Get the GlossaryEntry by its term.
     * @param term The term of the GlossaryEntry.
     * @return If the term could be found the GlossaryEntry object is returned. Otherwise, it will return null.
     *
     * @see IGlossaryEntry
     */
    IGlossaryEntry getGlossaryEntryByTerm(String term);

    /**
     * Get the CostEstimation of the requirement analysis.
     * @return An ICostEstimation object containing the CostEstimation.
     *
     * @see ICostEstimation
     */
    ICostEstimation getCostEstimation();

    /**
     * Get the Addition by its title.
     * @param title The title of the addition.
     * @return If the title could be found the IAddition object is returned. Otherwise, it will return null.
     *
     * @see IAddition
     */
    IAddition getAdditionByTitle(String title);

    /**
     * Get the QualityRequirement by its criteria.
     * @param criteria The criteria of the QualityRequirement.
     * @return If the criteria could be found the IQualityRequirement object is returned. Otherwise, it will return null.
     *
     * @see IQualityRequirement
     */
    IQualityRequirement getQualReqByCriteria(String criteria);

    /**
     * Get the TargetDefinition of the requirement analysis.
     * @return An ITargetDefinition object containing the TargetDefinition.
     *
     * @see ITargetDefinition
     */
    ITargetDefinition getTargetDef();

    /**
     * Get the optimized WeightFactor by its title.
     * @param title The title of the optimized WeightFactor.
     * @return If the title could be found the optimized IWeightFactor object is returned.
     * Otherwise, it will return null.
     *
     * @see IWeightFactor
     */
    IWeightFactor getOptWeightFactorByTitle(String title);

    /**
     * Get the WeightFactor by its title.
     * @param title The title of the WeightFactor.
     * @return If the title could be found the IWeightFactor object is returned.
     * Otherwise, it will return null.
     *
     * @see IWeightFactor
     */
    IWeightFactor getWeightFactorByTitle(String title);

    /**
     * Get the list of all FunctionalRequirements of the requirement analysis.
     * @return An Arraylist containing all IFRequirement objects.
     *
     * @see IFRequirement
     */
    ArrayList<IFRequirement> getAllFReq();

    /**
     * Get the list of all NonFunctionalRequirements of the requirement analysis.
     * @return An Arraylist containing all INFRequirement objects.
     *
     * @see INFRequirement
     */
    ArrayList<INFRequirement> getAllNFReq();

    /**
     * Get the list of all ProductData of the requirement analysis.
     * @return An Arraylist containing all IProductData objects.
     *
     * @see IProductData
     */
    ArrayList<IProductData> getAllProdData();

    /**
     * Get the list of all GlossaryEntries of the requirement analysis.
     * @return An Arraylist containing all IGlossaryEntry objects.
     *
     * @see IGlossaryEntry
     */
    ArrayList<IGlossaryEntry> getAllGlossEntries();

    /**
     * Get the list of all QualityRequirements of the requirement analysis.
     * @return An Arraylist containing all IQualityRequirement objects.
     *
     * @see IQualityRequirement
     */
    ArrayList<IQualityRequirement> getAllQualReq();

    /**
     * Get the list of all Additions of the requirement analysis.
     * @return An Arraylist containing all IAddition objects.
     *
     * @see IAddition
     */
    ArrayList<IAddition> getAllAddition();

    /**
     * Get the list of all WeightFactors of the requirement analysis.
     * @return An Arraylist containing all IWeightFactor objects.
     *
     * @see IWeightFactor
     */
    ArrayList<IWeightFactor> getAllWeightFactor();

    /**
     * Get the list of all optimized WeightFactors of the requirement analysis.
     * @return An Arraylist containing all optimized IWeightFactor objects.
     *
     * @see IWeightFactor
     */
    ArrayList<IWeightFactor> getAllOptWeightFactor();

    /**
     * Get the list of all Requirement IDs of the requirement analysis.
     * @return An Arraylist containing all Requirement IDs as String.
     *
     * @see IRequirement
     */
    ArrayList<String> getAllReqIDs();
    
}
