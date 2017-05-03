package Model_Interfaces;

<<<<<<< HEAD
public interface IModelGetData
{
    IRequirement getReqByID(String ID);

    public ICustomerData getCustomerData();

    IGlossaryEntry getGlossaryEntryByTerm(String term);

    public ICostEstimation getCostEstimation();

    public IAddition getAddition();
=======
import java.util.ArrayList;

public interface IModelGetData
{

    public IFRequirement getFReqByID(String id);

    public ICustomerData getCustomerData();

    public IGlossaryEntry getGlossaryEntryByTerm(String term);

    public ICostEstimation getCostEstimation();

    public IAddition getAdditionByTitle(String title);
>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527

    public IProductApplication getProdApp();

    public IQualityRequirement getQualReqByCriteria(String criteria);

    public ITargetDefinition getTargetDef();

<<<<<<< HEAD
    public IWeightFactor getOptWeightFactor();

    public IWeightFactor getWeightFactor();
=======
    public IWeightFactor getOptWeightFactorByTitle(String title);

    public IWeightFactor getWeightFactorByTitle(String title);

    public ArrayList<IFRequirement> getAllFReq();

    public ArrayList<INFRequirement> getAllNFReq();

    public ArrayList<IProductData> getAllProdData();

    public ArrayList<IGlossaryEntry> getAllGlossEntry();

    public ArrayList<IQualityRequirement> getAllQualReq();

    public ArrayList<IAddition> getAllAddition();

    public ArrayList<IWeightFactor> getAllWeightFactor();
    
    public ArrayList<IWeightFactor> getAllOptWeightFactor();

    public INFRequirement getNFReqByID(String id);

    public IProductData getProductDataByID(String id);
    
>>>>>>> 9cdce7ea87eff28f9af5bcaf7ae45e8b6b35d527
}
