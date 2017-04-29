package View;

import javax.swing.*;
import java.util.Observable;

public class FABearbeitenView extends FormWindow {

    JTextField _fieldID;
    JTextField _fieldActor;

    public FABearbeitenView(Object pReq){
        super(pReq);
        init();
    }

    private void init(){
        setSize(500,500);
        setResizable(false);
        _myBuilder.addTitle("Edit Requirement");
        _fieldID = _myBuilder.addNamedTextField("ID", "");
        _fieldActor = _myBuilder.addNamedTextField("Actor", "");
        _myBuilder.addNamedTextField("ABC", "");
        getContentPane().add(_myBuilder.getResult());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void update(Observable pObservable, Object pObject){

    }

    public String getID(){
        return _fieldID.getName();
    }

}
