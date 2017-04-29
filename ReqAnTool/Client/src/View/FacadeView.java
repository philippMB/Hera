package View;

public class FacadeView {
    
    private static FacadeView _myFacade;    

    private FacadeView(){
        
    }
    
    public FormWindow editObjectInView(Object o){
        return EditingFactory.getInstance().editObjectInView(o);
    }
    
    public static FacadeView getInstance(){
        if(_myFacade == null){
            _myFacade = new FacadeView();
        }
        return _myFacade;
    }
    
}
