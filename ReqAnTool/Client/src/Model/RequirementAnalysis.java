package Model;

import Model_Interfaces.IRequirementAnalysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class RequirementAnalysis
    implements IRequirementAnalysis
{
    private Date createDate;
    private String titel;
    private String customerDescription;
    private double actualState;    
    private ProductApplication myProductApplication;
    private TargetDefinition myTargetDefinition;
    private CustomerData myCustomerData;


    /**
     * @associates <{Model.FRequirement}>
     */
    private ArrayList<FRequirement> myFRequirements;

    /**
     * @associates <{Model.ProductData}>
     */
    private ArrayList<ProductData> myProductData;

    /**
     * @associates <{Model.NFRequirement}>
     */
    private ArrayList<NFRequirement> myNFRequirements;

    /**
     * @associates <{Model.CostEstimation}>
     */
    private ArrayList<CostEstimation> myCostEstimation;

    /**
     * @associates <{Model.Addition}>
     */
    private ArrayList<Addition> myAddition;

    /**
     * @associates <{Model.GlossaryEntry}>
     */
    private ArrayList<GlossaryEntry> myGlossaryEntries;

    /**
     * @associates <{Model.QualityRequirement}>
     */
    private ArrayList<QualityRequirement> myQualityRequirements;

    /**
     * @associates <{Model.WeightFactor}>
     */
    private ArrayList<WeightFactor> myWeightFactors;


    public Status checkReference(String _alteID, String _neueID) {
        return null;
    }

    public boolean isIDunique(String _id) {
        return true;
    }

    public Status optimizeWeightFactor() {
        return null;
    }
}
