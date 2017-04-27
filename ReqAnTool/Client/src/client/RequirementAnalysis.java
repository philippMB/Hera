package client;

import java.util.Date;
import java.util.List;

public class RequirementAnalysis {
    private Date createDate;
    private String titel;
    private String customerDescription;
    private double actualState;

    /**
     * @associates <{client.FRequirement}>
     */
    private List fRequirements;

    /**
     * @associates <{client.NFRequirement}>
     */
    private List nfRequirements;
    private ProductApplication productApplication;


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
