package View;

import javax.swing.*;
import java.util.Observer;

public abstract class FormWindow extends JFrame implements Observer{
    
    protected boolean _changedID;
    protected Object _myReq;
    protected JPanelBuilder _myBuilder;

    public FormWindow(){
        this(null);
    }

    public FormWindow(Object pReq){
        _myReq = pReq;
        _changedID = false;
        _myBuilder = JPanelBuilderFactory.getInstance().createPanelBuilder(this);
    }

}
