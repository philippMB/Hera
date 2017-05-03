package View;

import java.awt.*;

public class PanelBuilderFactory
{
    
    private static PanelBuilderFactory _myFactory;


    private PanelBuilderFactory()
	{
        
    }
    
    public static PanelBuilderFactory getInstance()
	{
        if(_myFactory == null)
        {
            _myFactory = new PanelBuilderFactory();
        }
        return _myFactory;
    }
    
    public PanelBuilder createPanelBuilder(Container v)
	{
        PanelBuilder localBuilder = null;

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
