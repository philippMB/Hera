package View;

import javax.swing.*;

/**
 * Ist ein Erzeugungsmuster Builder, der komplexere Zusammenhaenge fuer andere Klassen baut.
 * Hier sollen also Text: Textfield und Text | Button Button Button erzeugt werden koennen.
 * Rueckgabe koennen JPanels sein.
 * Quelle: https://sourcemaking.com/design_patterns/builder
 */
public class DialogBuilder extends JPanelBuilder {

    public JButton[] addButtonBar(String[] buttonNames) {

        return new JButton[0];
    }

    public void addText(String s){
        
    }
    
    public void addImage(){
        
    }

    @Override
    public void addTitle(String s) {
        // TODO Implement this method
    }

    @Override
    public JTextField addNamedTextField(String description, String content) {
        // TODO Implement this method

        return null;
    }

    @Override
    public JTextArea addNamedTextArea(String description, String content) {
        // TODO Implement this method

        return null;
    }

    @Override
    public JTable addTable(String[][] elements) {
        // TODO Implement this method
        return null;
    }

    @Override
    public JTable addTableSelection(String description, String[] selectionList, String[] defaultEntries) {
        // TODO Implement this method

        return null;
    }
}
