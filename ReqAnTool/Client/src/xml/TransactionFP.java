package xml;

import Model_Interfaces.ClassOfTransactionFP;
import Model_Interfaces.IRequirement;
import Model_Interfaces.ITransactionFP;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

/**
 * Class to hold the TransactionFP of the requirement analysis.
 * This class provides JAXB support and can be accessed via the {@link ITransactionFP} Interface.
 * Getter and Setter must be provided to be JAXB conform.
 * It is implemented in the {@link CustomXMLFormat}.
 *
 * @author 3852430
 * @version 1.0
 *
 * @see ITransactionFP
 * @see CustomXMLFormat
 */
public class TransactionFP
        implements ITransactionFP
{
    private int det;
    private int ftr;
    private ArrayList<String> referenceIDs;
    @XmlElement(name="Transaction_Function_Point")
    private ClassOfTransactionFP type;
    private String reqID;

    /**
     * The constructor for the TransactionFP class.
     * The data from the original TransactionFP instance is copied into this JAXB conform class.
     * @param origin The TransactionFP instance from the original {@link Model_Interfaces.IRequirementAnalysis} which holds
     *               all the data that has to be stored in the XML file.
     */
    public TransactionFP(ITransactionFP origin)
    {
        det = origin.getDet();
        ftr = origin.getFtr();
        referenceIDs = origin.getRequirement().getReferenceIDs();
        referenceIDs = null;
        type = origin.getType();
        reqID = origin.getRequirement().getID();
        reqID = null;
    }

    /**
     * The default constructor for the WeightFactor class.
     * Must be provided to be JAXB conform.
     */
    public TransactionFP()
    {
    }

    public int getDet()
    {
        return det;
    }

    public int getFtr()
    {
        return ftr;
    }

    public ArrayList<String> getReferenceIDs() {
        return referenceIDs;
    }

    public ClassOfTransactionFP getType()
    {
        return type;
    }

    public String getReqID() {
        return reqID;
    }

    public void setDet(int det)
    {
        this.det = det;
    }

    public void setFtr(int ftr)
    {
        this.ftr = ftr;
    }

    public void setReferenceIDs(ArrayList<String> referenceIDs) {
        this.referenceIDs = referenceIDs;
    }

    public void setType(ClassOfTransactionFP type)
    {
        this.type = type;
    }

    public void setReqID(String reqID) {
        this.reqID = reqID;
    }

    /**
     * This method from the {@link ITransactionFP} interface is not implemented, because only the data should be available,
     * no functionality should be provided.
     * @return Always returns null.
     */
    @Override
    public IRequirement getRequirement() {
        return null;
    }
}
