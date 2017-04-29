package View;

import javax.swing.JLabel;

public interface TextStyleBridge {

    /**
     * @param pLabel
     */
    public void styleAsTagedName(JLabel pLabel);

    /**
     * @param pLabel
     */
    public void styleAsTitle(JLabel pLabel);


    public void styleAsInformation(JLabel pLabel);
    
    
}
