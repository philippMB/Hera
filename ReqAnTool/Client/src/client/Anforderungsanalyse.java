package client;

import java.util.Date;

public class Anforderungsanalyse {
    private Date _erstellungsdatum;
    private String _titel;
    private String _kundenbeschreibung;
    private double _istZustand;

    public Status pruefeVerweise(String _alteID, String _neueID) {
        return null;
    }

    public boolean istIdEinzigartig(String _id) {
        return true;
    }

    public Status optimiereGewichtsfaktoren() {
        return null;
    }
}
