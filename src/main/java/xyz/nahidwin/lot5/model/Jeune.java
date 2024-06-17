package xyz.nahidwin.lot5.model;

public class Jeune extends Tarification{

    public Jeune(double tarifReduit) {
        super(tarifReduit);
    }

    @Override
    public String toString() {
        return "Tarif: " + getRedutionStatic();
    }
}
