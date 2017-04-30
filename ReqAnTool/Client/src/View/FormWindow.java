package View;

import javax.swing.*;
import java.util.Observer;

public abstract class FormWindow
    extends JFrame
{
    protected JPanelBuilder myBuilder;

    public FormWindow()
    {
        setSize(250,500);   //Ungefähre Größe, damit Factory richtigen Builder erzeugen kann
        myBuilder = JPanelBuilderFactory.getInstance().createPanelBuilder(this);
    }

    protected abstract void init();

}
