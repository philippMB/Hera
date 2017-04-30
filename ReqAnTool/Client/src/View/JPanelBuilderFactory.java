package View;

import javax.swing.*;
import java.awt.*;

public class JPanelBuilderFactory {
    
    private static JPanelBuilderFactory _myFactory;
    
    private JPanelBuilderFactory(){
        
    }
    
    public static JPanelBuilderFactory getInstance(){
        if(_myFactory == null)
        {
            _myFactory = new JPanelBuilderFactory();
        }
        return _myFactory;
    }
    
    public JPanelBuilder createPanelBuilder(Container v) {
        //instanceof-Selection
        JPanelBuilder localBuilder = null;
        if(v.getWidth() > 300)
        {
            localBuilder = new TabBuilder();
        }
        else{
            if(v.getHeight() <= 300)
            {
                localBuilder = new DialogBuilder();
            }
            else
            {
                localBuilder = new FormulaBuilder();
            }
        }
        return localBuilder;
    }
}
