package Model;

import Calculations.OptimizedWFFileManager;
import Calculations_Interfaces.IWFOptimizer;
import Exceptions.*;
import Model_Interfaces.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
    implements IModelGetData, IModelSetData, IApplications, IModel
{

    private RequirementAnalysis myReqAn;
    private Configuration myConfig;
    private boolean unsaved;
    private String path;

    public Model()
    {
        myConfig = Configuration.getInstance();
        unsaved = true;
        myReqAn = null;
        path = "";
    }

    @Override
    public synchronized void addObserver(Observer o)
    {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o)
    {
        super.deleteObserver(o);
    }

    @Override
    public synchronized void addAddition(String title, String description)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        if (myReqAn.getAdditions().size() >= 100)
        {
            throw new ListOverflowException(Addition.class, "Additions");
        }
        myReqAn.addAddition(title, description);
        notifyAllObservers();
    }

    @Override
    public synchronized void addCostEstimation() throws MissingReqAnException, DuplicateIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.addCostEstimation(myConfig.getWFOptimizer().getOptimizedWF());
        notifyAllObservers();

    }

    @Override
    public synchronized void addFReq(String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, ArgumentPatternException, UnknownReferenceException,
                    DuplicateIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        if (myReqAn.getFRequirements().size() >= 2000)
        {
            throw new ListOverflowException(FRequirement.class, "FRequirements");
        }
        myReqAn.addFRequirement(id, title, actor, description, references);
        notifyAllObservers();

    }

    @Override
    public synchronized void addGlossEntry(String term, String sense, String boundary, String validity, String obscurities,
                                 String label, ArrayList<String> crossRef)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException, UnknownReferenceException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        if (myReqAn.getGlossaryEntries().size() >= 3000)
        {
            throw new ListOverflowException(GlossaryEntry.class, "GlossaryEntries");
        }
        myReqAn.addGlossaryEntry(term, sense, boundary, validity, obscurities, label, crossRef);
        notifyAllObservers();

    }

    @Override
    public synchronized void addNFReq(String id, String title, String actor, String description, ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException, UnknownReferenceException,
                    ArgumentPatternException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        if (myReqAn.getFRequirements().size() >= 2000)
        {
            throw new ListOverflowException(NFRequirement.class, "NFRequirements");
        }
        myReqAn.addNFRequirement(id, title, actor, description, references);
        notifyAllObservers();

    }

    @Override
    public synchronized void addProdData(String id, String content, String attribute, String maxCount,
                                  ArrayList<String> references)
            throws MissingReqAnException, ListOverflowException, ArgumentPatternException, UnknownReferenceException,
                    DuplicateIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        if (myReqAn.getFRequirements().size() >= 300)
        {
            throw new ListOverflowException(ProductData.class, "ProductData");
        }
        myReqAn.addProductData(id, content, attribute, maxCount, references);
        notifyAllObservers();

    }

    @Override
    public synchronized void addQualReq(String criteria, Score value)
            throws MissingReqAnException, ListOverflowException, DuplicateIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        if (myReqAn.getFRequirements().size() >= 30)
        {
            throw new ListOverflowException(QualityRequirement.class, "QualityRequirements");
        }
        myReqAn.addQualReq(criteria, value);
        notifyAllObservers();

    }

    @Override
    public synchronized void calcManMonth() throws MissingReqAnException, MissingCostEstimationException,
            MissingParameterException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.calcManMonth(myConfig.getMMCalculator());
        notifyAllObservers();
    }

    @Override
    public boolean isReferenceOnID(String id)
    {
        boolean referenced = false;
        if (myReqAn != null)
        {
            referenced = myReqAn.isReferenceOnID(id);
        }
        return referenced;
    }

    @Override
    public synchronized void deleteReqAn() throws MissingReqAnException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        this.myReqAn = null;
        this.myConfig = null;
        notifyAllObservers();
    }

    @Override
    public synchronized void editAddition(String oldTitle, String newTitle, String description)
            throws MissingReqAnException, DuplicateIDException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editAddition(oldTitle, newTitle, description);
        notifyAllObservers();

    }

    @Override
    public synchronized void editCustData(String companyName, String companyCity, String companyStreet, String zip,
                                String companyCountry, String custName, String custMail, String custPhone,
                                String pmName, String pmMail, String pmPhone)
            throws MissingReqAnException, ArgumentPatternException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editCustData(companyName, companyCity, companyStreet, zip, companyCountry, custName, custMail,
                custPhone, pmName, pmMail, pmPhone);
        notifyAllObservers();

    }

    @Override
    public synchronized void editFReq(String oldID, String id, String title, String actor, String description,
                            ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
                    DuplicateIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editFReq(oldID, id, title, actor, description, references);
        notifyAllObservers();

    }

    @Override
    public synchronized void editGlossEntry(String oldTerm, String term, String sense, String boundary, String validity,
                                  String obscurities, String label, ArrayList<String> crossRef)
            throws MissingReqAnException, UnknownIDException, DuplicateIDException, UnknownReferenceException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editGlossEntry(oldTerm, term, sense, boundary, validity, obscurities, label, crossRef);
        notifyAllObservers();

    }

    @Override
    public synchronized void editNFReq(String oldID, String id, String title, String actor, String description,
                             ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
                    DuplicateIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editNFReq(oldID, id, title, actor, description, references);
        notifyAllObservers();

    }

    @Override
    public synchronized void editProdApp(String description) throws MissingReqAnException, ListOverflowException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editProdApp(description);
        notifyAllObservers();

    }

    @Override
    public synchronized void editProdEnv(String description) throws MissingReqAnException, ListOverflowException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editProdEnv(description);
        notifyAllObservers();

    }

    @Override
    public synchronized void editProdData(String oldID, String id, String content, String attribute, String maxCount,
                                ArrayList<String> references)
            throws MissingReqAnException, UnknownIDException, UnknownReferenceException, ArgumentPatternException,
                    DuplicateIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editProdData(oldID, id, content, attribute, maxCount, references);
        notifyAllObservers();

    }

    @Override
    public synchronized void editQualReq(String oldCriteria, String criteria, Score value)
            throws MissingReqAnException, DuplicateIDException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editQualReq(oldCriteria, criteria, value);
        notifyAllObservers();

    }

    @Override
    public synchronized void editTargetDef(String description) throws MissingReqAnException, ListOverflowException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editTargetDef(description);
        notifyAllObservers();

    }

    @Override
    public boolean existsActualState()
    {
        boolean exists = false;
        if (myReqAn != null)
        {
            exists = myReqAn.getActualState() != -1.0;
        }
        return exists;

    }

    @Override
    public boolean existsFPCount()
    {
        boolean exists = false;
        if (myReqAn.getCostEstimation() != null)
        {
            exists = myReqAn.getCostEstimation().getFunctionPoints() != -1.0;
        }
        return exists;

    }

    @Override
    public boolean existsID(String id)
    {
        boolean exists = false;
        if (myReqAn != null)
        {
            exists = myReqAn.isReqIncluded(id);
        }
        return exists;

    }

    @Override
    public boolean existsManMonthCount()
    {
        boolean exists = false;
        if (myReqAn.getCostEstimation() != null)
        {
            exists = myReqAn.getCostEstimation().getManMonth() != -1.0;
        }
        return exists;

    }

    @Override
    public synchronized void optimizeWeightFactors() throws MissingReqAnException, MissingCostEstimationException,
                                            MissingParameterException, NumberOutOfBoundsException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        if (myReqAn.getCostEstimation() == null)
        {
            throw new MissingCostEstimationException();
        }
        IWFOptimizer optimizer = myConfig.getWFOptimizer();
        optimizer.optimizeWF(myReqAn.getCostEstimation(), myReqAn.getActualState());
        ArrayList<IWeightFactor> adjWeightFac = optimizer.getOptimizedWF();
        notifyAllObservers();
    }

    @Override
    public void openReqAnFile(String path) throws DataAccessException
    {
        IXMLManager myXMLManager = IXMLManager.getInstance();
        try
        {
            myReqAn = copyReqAn(myXMLManager.importAnalysis(path, XMLFormatType.CUSTOM_XML_FORMAT));
        }
        catch (Exception e)
        {
            throw new DataAccessException(path);
        }

    }

    @Override
    public ArrayList<IAddition> getAllAddition()
    {
        ArrayList<IAddition> myAdditions = null;
        if (myReqAn != null)
        {
            myAdditions = myReqAn.getAdditions();
        }
        return myAdditions;

    }

    @Override
    public ICostEstimation getCostEstimation()
    {
        ICostEstimation myCostEstimation = null;
        if (myReqAn != null)
        {
            myCostEstimation = myReqAn.getCostEstimation();
        }
        return myCostEstimation;

    }

    @Override
    public ICustomerData getCustomerData()
    {
        ICustomerData myCustomerData = null;
        if (myReqAn != null)
        {
            myCustomerData = myReqAn.getCustomerData();
        }
        return myCustomerData;

    }

    @Override
    public IGlossaryEntry getGlossaryEntryByTerm(String term)
    {
        IGlossaryEntry myEntry = null;
        if (myReqAn != null)
        {
            myEntry = myReqAn.getGlossaryEntriesByTerm(term);
        }
        return myEntry;

    }
    
    @Override
    public IProductApplication getProdApp()
    {
        IProductApplication myProductApplication = null;
        if (myReqAn != null)
        {
            myProductApplication = myReqAn.getProductApplication();
        }
        return myProductApplication;

    }

    @Override
    public IProductEnvironment getProdEnv()
    {
        IProductEnvironment myProdEnv = null;
        if (myReqAn != null)
        {
            myProdEnv = myReqAn.getProductEnvironment();
        }
        return myProdEnv;

    }

    @Override
    public IQualityRequirement getQualReqByCriteria(String criteria)
    {
        IQualityRequirement myQualityRequirement = null;
        if (myReqAn != null)
        {
            myQualityRequirement = myReqAn.getQualityRequirementsByCriteria(criteria);
        }
        return myQualityRequirement;

    }

    @Override
    public ITargetDefinition getTargetDef()
    {
        ITargetDefinition myTargetDefinition = null;
        if (myReqAn != null)
        {
            myTargetDefinition = myReqAn.getTargetDefinition();
        }
        return myTargetDefinition;

    }

    @Override
    public boolean isIDUnique(String id)
    {
        boolean unique = true;
        if (myReqAn != null)
        {
            unique = myReqAn.isIDunique(id);
        }
        return unique;

    }

    @Override
    public boolean isReqAnUnsaved()
    {
        return unsaved;
    }

    @Override
    public boolean isFirstUseOfOpenedReqAn()
    {
        boolean firstUse = false;
        if (myReqAn == null)
        {
            firstUse = false;
        }
        if (this.path == "")
        {
            firstUse = true;
        }
        return firstUse;
    }

    @Override
    public synchronized void rateWeightFactor(Map<String, Integer> myWeightFactors)
            throws MissingReqAnException, NumberOutOfBoundsException, MissingCostEstimationException,
                    ListOverflowException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.rateWeightFactor(myWeightFactors);
        notifyAllObservers();

    }

    @Override
    public synchronized void calcFPCount() throws MissingReqAnException, MissingCostEstimationException,
            MissingParameterException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.calcFPCount(myConfig.getFPCalculator());
        notifyAllObservers();

    }

    @Override
    public synchronized void remAdditionByTitle(String title) throws MissingReqAnException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remAdditionByTitle(title);
        notifyAllObservers();

    }

    @Override
    public synchronized void remCostEstimation() throws MissingReqAnException, MissingCostEstimationException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remCostEstimation();
        notifyAllObservers();

    }

    @Override
    public synchronized void remFReqByID(String id) throws MissingReqAnException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remFReqByID(id);
        notifyAllObservers();

    }

    @Override
    public synchronized void remGlossEntryByTerm(String term) throws MissingReqAnException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remGlossEntryByTerm(term);
        notifyAllObservers();

    }

    @Override
    public synchronized void remNFReqByID(String id) throws MissingReqAnException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remNFReqByID(id);
        notifyAllObservers();

    }

    @Override
    public synchronized void remProdDataByID(String id) throws MissingReqAnException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remProdDataByID(id);
        notifyAllObservers();

    }

    @Override
    public synchronized void remQualReqByCrit(String criteria) throws MissingReqAnException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remQualReqByCrit(criteria);
        notifyAllObservers();

    }

    @Override
    public synchronized void saveReqAn(String path) throws MissingReqAnException, DataAccessException
    {
        IXMLManager myXMLManager = IXMLManager.getInstance();
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        unsaved = false;
        if (!this.path.equals(path))
        {
            this.path = path;
        }
        try
        {
            myXMLManager.exportAnalysis(myReqAn, path, XMLFormatType.CUSTOM_XML_FORMAT);
        }
        catch (Exception e)
        {
            throw new DataAccessException(path);
        }
        notifyAllObservers();

    }

    @Override
    public void saveReqAn() throws MissingReqAnException, DataAccessException
    {
        IXMLManager myXMLManager = IXMLManager.getInstance();
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        unsaved = false;
        try
        {
            myXMLManager.exportAnalysis(myReqAn, path, XMLFormatType.CUSTOM_XML_FORMAT);
        }
        catch (Exception e)
        {
            throw new DataAccessException(path);
        }
        notifyAllObservers();
    }

    @Override
    public void exportToXML(String path, XMLFormatType type) throws MissingReqAnException, xml.XMLMarschallingException,
            FileNotFoundException, xml.XMLFormatException, xml.SingletonRecreationException, SecurityException,
            xml.XMLProcessingException
    {
        IXMLManager myXMLManager = IXMLManager.getInstance();
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myXMLManager.exportAnalysis(myReqAn, path, type);

    }

    @Override
    public void importFromXML(String path, XMLFormatType type) throws FileNotFoundException, xml.XMLUnmarschallException,
            SecurityException, xml.XMLProcessingException, xml.XMLFormatException, xml.SingletonRecreationException,
            NumberOutOfBoundsException, ArgumentPatternException, ListOverflowException, MissingEntryException
    {
        IXMLManager myXMLManager = IXMLManager.getInstance();
        IRequirementAnalysis myIReqAn = myXMLManager.importAnalysis(path, type);
        myReqAn = copyReqAn(myIReqAn);

    }

    private RequirementAnalysis copyReqAn(IRequirementAnalysis myIReqAn)
            throws NumberOutOfBoundsException, ArgumentPatternException, ListOverflowException, MissingEntryException
    {
        RequirementAnalysis tmpReqAn = new RequirementAnalysis(myIReqAn.getTitle(),
                myIReqAn.getCustomerData().getPMName(), myIReqAn.getCustomerData().getPMEMail(),
                myIReqAn.getCustomerData().getPMPNumber(), myIReqAn.getCustomerData().getCompanyName(),
                myIReqAn.getCustomerData().getCompanyCity(), myIReqAn.getCustomerData().getCompanyStreet(),
                myIReqAn.getCustomerData().getCompanyCountry(), myIReqAn.getCustomerData().getCompanyPLZ(),
                myIReqAn.getCustomerData().getCName(), myIReqAn.getCustomerData().getCEMail(),
                myIReqAn.getCustomerData().getCNumber());
        tmpReqAn.setCustomerDescription(myIReqAn.getCustomerDescription());
        tmpReqAn.setAdditions(myIReqAn.getAdditions());
        tmpReqAn.setCostEstimation(myIReqAn.getCostEstimation());
        tmpReqAn.setActualState(myIReqAn.getActualState());
        tmpReqAn.setCreateDate(myIReqAn.getCreateDate());
        tmpReqAn.setProductApplication(myIReqAn.getProductApplication());
        tmpReqAn.setProductData(myIReqAn.getProductData());
        tmpReqAn.setProductEnvironment(myIReqAn.getProductEnvironment());
        tmpReqAn.setTargetDefinition(myIReqAn.getTargetDefinition());
        tmpReqAn.setFRequirements(myIReqAn.getFRequirements());
        tmpReqAn.setNFRequirements(myIReqAn.getNFRequirements());
        tmpReqAn.setGlossaryEntries(myIReqAn.getGlossaryEntries());
        tmpReqAn.setQualityRequirements(myIReqAn.getQualityRequirements());

        return tmpReqAn;
    }

    @Override
    public synchronized void setActualState(double actStat) throws MissingReqAnException, NumberOutOfBoundsException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.setActualState(actStat);
        notifyAllObservers();

    }

    @Override
    public synchronized void setDataFP(ClassOfDataFP type, String id, int det, int ret)
            throws MissingReqAnException, UnknownIDException, NumberOutOfBoundsException, DuplicateIDException,
            MissingCostEstimationException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.setDataFP(type, id, det, ret);
        notifyAllObservers();

    }

    @Override
    public synchronized void setTransactionFP(ClassOfTransactionFP type, String id, int det, int ftr)
            throws MissingReqAnException, UnknownIDException, NumberOutOfBoundsException, DuplicateIDException,
            MissingCostEstimationException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.setTransactionFP(type, id, det, ftr);
        notifyAllObservers();

    }

    @Override
    public synchronized void editDataFPByID(ClassOfDataFP type, String id, int det, int ret)
            throws MissingReqAnException, UnknownIDException, MissingCostEstimationException, NumberOutOfBoundsException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editDataFPByID(type, id, det, ret);
        notifyAllObservers();

    }

    @Override
    public synchronized void editTransactionFPByID(ClassOfTransactionFP type, String id, int det, int ftr)
            throws MissingReqAnException, UnknownIDException, MissingCostEstimationException, NumberOutOfBoundsException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.editTransactionFPByID(type, id, det, ftr);
        notifyAllObservers();

    }

    @Override
    public synchronized void remDataFPByID(String id)
            throws MissingReqAnException, MissingCostEstimationException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remDataFPByID(id);
        notifyAllObservers();

    }

    @Override
    public synchronized void remTransactionFPByID(String id)
            throws MissingReqAnException, MissingCostEstimationException, UnknownIDException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn.remTransactionFPByID(id);
        notifyAllObservers();

    }

    @Override
    public IAddition getAdditionByTitle(String title)
    {
        IAddition myAddition = null;
        if (myReqAn != null)
        {
            myAddition = myReqAn.getAdditionByTitle(title);
        }
        return myAddition;

    }

    @Override
    public ArrayList<IFRequirement> getAllFReq()
    {
        ArrayList<IFRequirement> myFRequirements = null;
        if (myReqAn != null)
        {
            myFRequirements = myReqAn.getFRequirements();
        }
        return myFRequirements;

    }

    @Override
    public ArrayList<IGlossaryEntry> getAllGlossEntries()
    {
        ArrayList<IGlossaryEntry> myEntries = null;
        if (myReqAn != null)
        {
            myEntries = myReqAn.getGlossaryEntries();
        }
        return myEntries;

    }

    @Override
    public ArrayList<INFRequirement> getAllNFReq()
    {
        ArrayList<INFRequirement> myNFRequirements = null;
        if (myReqAn != null)
        {
            myNFRequirements = myReqAn.getNFRequirements();
        }
        return myNFRequirements;

    }

    @Override
    public ArrayList<IProductData> getAllProdData()
    {
        ArrayList<IProductData> myProductData = null;
        if (myReqAn != null)
        {
            myProductData = myReqAn.getProductData();
        }
        return myProductData;

    }

    @Override
    public ArrayList<IQualityRequirement> getAllQualReq()
    {
        ArrayList<IQualityRequirement> myQualityRequirements = null;
        if (myReqAn != null)
        {
            myQualityRequirements = myReqAn.getQualityRequirements();
        }
        return myQualityRequirements;

    }

    @Override
    public ArrayList<IWeightFactor> getAllWeightFactor()
    {
        ArrayList<IWeightFactor> myWeightFactors = null;
        if (myReqAn != null)
        {
            myWeightFactors = myReqAn.getWeightFactors();
        }
        return myWeightFactors;

    }

    @Override
    public IWeightFactor getWeightFactorByTitle(String title)
    {
        IWeightFactor myWeightFactor = null;
        if (myReqAn != null)
        {
            myWeightFactor = myReqAn.getWeightFactorByTitle(title);
        }
        return myWeightFactor;

    }

    @Override
    public ArrayList<IWeightFactor> getAllOptWeightFactor()
    {
        ArrayList<IWeightFactor> myOptWeightFactors = null;
        if (myConfig != null)
        {
            myOptWeightFactors = myConfig.getWFOptimizer().getOptimizedWF();
        }
        return myOptWeightFactors;

    }

    @Override
    public IWeightFactor getOptWeightFactorByTitle(String title)
    {
        IWeightFactor myOptWeightFactor = null;
        if (myConfig != null)
        {
            ArrayList<IWeightFactor> optWeightFactors = getAllOptWeightFactor();
            for(IWeightFactor weightFactor: optWeightFactors)
            {
                if(weightFactor.getTitle().equals(title))
                {
                    myOptWeightFactor = weightFactor;
                }
            }
        }
        return myOptWeightFactor;

    }

    @Override
    public IFRequirement getFReqByID(String id)
    {
        IFRequirement myFRequirement = null;
        if (myReqAn != null)
        {
            myFRequirement = myReqAn.getFRequirementByID(id);
        }
        return myFRequirement;

    }

    @Override
    public INFRequirement getNFReqByID(String id)
    {
        INFRequirement myNFRequirement = null;
        if (myReqAn != null)
        {
            myNFRequirement = myReqAn.getNFRequirementByID(id);
        }
        return myNFRequirement;

    }

    @Override
    public IProductData getProductDataByID(String id)
    {
        IProductData myProductData = null;
        if (myReqAn != null)
        {
            myProductData = myReqAn.getProductDataByID(id);
        }
        return myProductData;

    }

    @Override
    public synchronized boolean makeNewReqAn(String title, String pmName, String pmMail, String pmPhone, String companyName,
                                String city, String companyStreet, String country, String zip, String cName,
                                String cMail, String cPhone)
            throws ArgumentPatternException, MissingEntryException
    {
        boolean success = false;
        if (myReqAn == null)
        {
            this.myReqAn = new RequirementAnalysis(title, pmName, pmMail, pmPhone, companyName, city, companyStreet,
                                                   country, zip, cName, cMail, cPhone );
            success = true;
        }
        notifyAllObservers();
        return success;

    }

    @Override
    public boolean closeReqAn() throws MissingReqAnException
    {
        if (myReqAn == null)
        {
            throw new MissingReqAnException();
        }
        myReqAn = null;
        return true;
    }

    @Override
    public ArrayList<String> getAllReqIDs()
    {
        ArrayList<String> myIDs = null;
        if (myReqAn != null)
        {
            myIDs = myReqAn.getAllReqIDs();
        }
        return myIDs;

    }

    @Override
    public IRequirementAnalysis getReqAnalysis()
    {
        return myReqAn;

    }

    public void notifyAllObservers()
    {
        super.setChanged();
        super.notifyObservers();
    }

}
