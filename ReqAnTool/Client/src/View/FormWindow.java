package View;

import javax.swing.*;
import java.util.Observer;

public abstract class FormWindow <Type>
    extends JFrame
{

    protected Type myReq;
    protected JPanelBuilder myBuilder;


    public FormWindow()
    {
        this(null);
    }

    public FormWindow(Type pReq)
    {
        myReq = pReq;
        setSize(250,500);   //Ungefähre Größe, damit Factory richtigen Builder erzeugen kann
        myBuilder = JPanelBuilderFactory.getInstance().createPanelBuilder(this);
        init();
    }

    protected abstract void init();

}
