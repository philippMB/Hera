package Model_Interfaces;

import java.util.ArrayList;
import java.util.Observer;

// TODO:
/**
 *
 *
 * @author
 * @version 1.0
 */
public interface IModelGetData
{

    public void addObserver(Observer o);

    /**
     * Get the whole requirement analysis.
     * @return An object of type IRequirementAnalysis containing the whole requirement analysis.
     *
     * @see IRequirementAnalysis
     */
    public IRequirementAnalysis getReqAnalysis();

    // TODO: wenn id nicht gefunden?
    /**
     * Get a FunctionRequirement by its id.
     * @param id The id of the FunctionRequirement.
     * @return If the id could be found the IFRequirement object is returned.
     *
     * @see IFRequirement
     */
    public IFRequirement getFReqByID(String id);

    // TODO: wenn id nicht gefunden?
    /**
     * Get the NonFunctionalRequirement by its id.
     * @param id The id of the NonFunctionalRequirement.
     * @return If the id could be found the INFRequirement object is returned.
     *
     * @see INFRequirement
     */
    public INFRequirement getNFReqByID(String id);

    // TODO: wenn id nicht gefunden?
    /**
     * Get the ProductData by its id.
     * @param id The id of the ProductData.
     * @return If the id could be found the IProductData object is returned.
     *
     * @see IProductData
     */
    public IProductData getProductDataByID(String id);

    /**
     * Get the CustomerData of the requirement analysis.
     * @return The ICustomerData object.
     *
     * @see ICustomerData
     */
    public ICustomerData getCustomerData();

    /**
     * Get the ProductApplication of the requirement analysis.
     * @return The IProductApplication object.
     *
     * @see IProductApplication
     */
    public IProductApplication getProdApp();

    public IProductEnvironment getProdEnv();

    // TODO: wenn term nicht gefunden?
    /**
     * Get the GlossaryEntry by its term.
     * @param term The term of the GlossaryEntry.
     * @return If the term could be found the GlossaryEntry object is returned.
     *
     * @see IGlossaryEntry
     */
    public IGlossaryEntry getGlossaryEntryByTerm(String term);

    /**
     * Get the CostEstimation of the requirement analysis.
     * @return An ICostEstimation object containing the CostEstimation.
     *
     * @see ICostEstimation
     */
    public ICostEstimation getCostEstimation();

    // TODO: wenn title nicht gefunden?
    /**
     * Get the Addition by its title.
     * @param title The title of the addition.
     * @return If the title could be found the IAddition object is returned.
     *
     * @see IAddition
     */
    public IAddition getAdditionByTitle(String title);

    // TODO: wenn criteria nicht gefunden?
    /**
     * Get the QualityRequirement by its criteria.
     * @param criteria The criteria of the QualityRequirement.
     * @return If the criteria could be found the IQualityRequirement object is returned.
     *
     * @see IQualityRequirement
     */
    public IQualityRequirement getQualReqByCriteria(String criteria);

    /**
     * Get the TargetDefinition of the requirement analysis.
     * @return An ITargetDefinition object containing the TargetDefinition.
     *
     * @see ITargetDefinition
     */
    public ITargetDefinition getTargetDef();

    // TODO: wenn title nicht gefunden?
    /**
     * Get the optimized WeightFactor by its title.
     * @param title The title of the optimized WeightFactor.
     * @return If the title could be found the optimized IWeightFactor object is returned.
     *
     * @see IWeightFactor
     */
    public IWeightFactor getOptWeightFactorByTitle(String title);

    // TODO: wenn title nicht gefunden?
    /**
     * Get the WeightFactor by its title.
     * @param title The title of the WeightFactor.
     * @return If the title could be found the IWeightFactor object is returned.
     *
     * @see IWeightFactor
     */
    public IWeightFactor getWeightFactorByTitle(String title);

    /**
     * Get the list of all FunctionalRequirements of the requirement analysis.
     * @return An Arraylist containing all IFRequirement objects.
     *
     * @see IFRequirement
     */
    public ArrayList<IFRequirement> getAllFReq();

    /**
     * Get the list of all NonFunctionalRequirements of the requirement analysis.
     * @return An Arraylist containing all INFRequirement objects.
     *
     * @see INFRequirement
     */
    public ArrayList<INFRequirement> getAllNFReq();

    /**
     * Get the list of all ProductData of the requirement analysis.
     * @return An Arraylist containing all IProductData objects.
     *
     * @see IProductData
     */
    public ArrayList<IProductData> getAllProdData();

    /**
     * Get the list of all GlossaryEntries of the requirement analysis.
     * @return An Arraylist containing all IGlossaryEntry objects.
     *
     * @see IGlossaryEntry
     */
    public ArrayList<IGlossaryEntry> getAllGlossEntries();

    /**
     * Get the list of all QualityRequirements of the requirement analysis.
     * @return An Arraylist containing all IQualityRequirement objects.
     *
     * @see IQualityRequirement
     */
    public ArrayList<IQualityRequirement> getAllQualReq();

    /**
     * Get the list of all Additions of the requirement analysis.
     * @return An Arraylist containing all IAddition objects.
     *
     * @see IAddition
     */
    public ArrayList<IAddition> getAllAddition();

    /**
     * Get the list of all WeightFactors of the requirement analysis.
     * @return An Arraylist containing all IWeightFactor objects.
     *
     * @see IWeightFactor
     */
    public ArrayList<IWeightFactor> getAllWeightFactor();

    /**
     * Get the list of all optimized WeightFactors of the requirement analysis.
     * @return An Arraylist containing all optimized IWeightFactor objects.
     *
     * @see IWeightFactor
     */
    public ArrayList<IWeightFactor> getAllOptWeightFactor();

    /**
     * Get the list of all Requirement IDs of the requirement analysis.
     * @return An Arraylist containing all Requirement IDs as String.
     *
     * @see IRequirement
     */
    public ArrayList<String> getAllReqIDs();
    
}
