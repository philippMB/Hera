package client;

public class EditingFactory {
    
    private static EditingFactory _myFactory;
    
    private EditingFactory(){
        
    }
    
    public static EditingFactory getInstance(){
        if(_myFactory == null){
            _myFactory = new EditingFactory();
        }
        return _myFactory;
    }
    
    public FormWindow editObjectInView(Object o){
        FormWindow retWindow = null;
        if(o instanceof nichtfunktionaleAnforderung){
            retWindow = new NFABearbeitenView();
        }
        if(o instanceof funktionaleAnforderung){
            retWindow = new FABearbeitenView();
        }
        if(o instanceof Produktdatum){
            retWindow = new PBearbeitenView();
        }
        return retWindow;
    }
}
