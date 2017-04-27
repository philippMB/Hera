package Model;

import Model_Interfaces.IRequirementAnalysis;

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

    private List myFRequirements;
    /**
     * @associates <{Model.ProductData}>
     */
    private List myProductData;

    /**
     * @associates <{Model.NFRequirement}>
     */
    private List myNFRequirements;
    
    /**
     * @associates <{Model.CostEstimation}>
     */
    private List myCostEstimation;

    /**
     * @associates <{Model.Addition}>
     */
    private List myAddition;

    /**
     * @associates <{Model.GlossaryEntry}>
     */
    private List myGlossaryEntries;

    /**
     * @associates <{Model.QualityRequirement}>
     */
    private List myQualityRequirements;


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
