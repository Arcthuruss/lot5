package xyz.nahidwin.lot5.model;

public class Abonne extends Tarification{

    public Abonne(double tarifReduit) {
        super(tarifReduit);
    }


    @Override
    public String toString() {
        return "Tarif : " + getRedutionStatic();
    }
}
