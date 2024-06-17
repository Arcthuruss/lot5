package xyz.nahidwin.lot5.model;

public class Groupe extends Tarification{

    public Groupe(double tarifReduit) {
        super(tarifReduit);
    }


    @Override
    public String toString() {
        return "Tarif: " + getRedutionStatic();
    }
}
