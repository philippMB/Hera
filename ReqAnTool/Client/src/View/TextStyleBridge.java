package View;

import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public interface TextStyleBridge {

    /**
     * @param pLabel
     */
    public void styleAsTagedNameToField(JLabel pLabel);

    /**
     * @param pLabel
     */
    public void styleAsTagedNameToArea(JLabel pLabel);

    /**
     * @param pLabel
     */
    public void styleAsTitle(JLabel pLabel);


    public void styleAsInformation(JTextComponent pLabel);
    
    
}
