package View;

import javax.swing.*;

public class DialogTextStyle implements TextStyleBridge {
    @Override
    public void styleAsTagedName(JLabel pLabel) {
        // TODO Implement this method
        pLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    public void styleAsTitle(JLabel pLabel) {
        // TODO Implement this method
    }

    @Override
    public void styleAsInformation(JLabel pLabel) {

    }
}
