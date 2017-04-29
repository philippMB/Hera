package Model;

public interface AnforderungsListe {
    public void add(Anforderung a);

    public void delete(Anforderung a);

    public boolean isIDIncluded(String id);

    public Anforderung getAnforderungFromID(String id);
}
