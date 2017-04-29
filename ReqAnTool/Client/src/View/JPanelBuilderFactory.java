package View;

import javax.swing.*;

public class JPanelBuilderFactory {
    
    private static JPanelBuilderFactory _myFactory;
    
    private JPanelBuilderFactory(){
        
    }
    
    public static JPanelBuilderFactory getInstance(){
        if(_myFactory == null){
            _myFactory = new JPanelBuilderFactory();
        }
        return _myFactory;
    }
    
    public JPanelBuilder createPanelBuilder(JFrame v) {
        //instanceof-Selection
        JPanelBuilder localBuilder = null;
        if( v instanceof FormWindow) {
            localBuilder = new FormulaBuilder();
        }
        return localBuilder;
    }
}
