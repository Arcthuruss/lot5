package xyz.nahidwin.lot5.model;

public class Senior extends Tarification{

    public Senior(double tarifReduit) {
        super(tarifReduit);
    }

    @Override
    public String toString() {
        return "Tarif: " + getRedutionStatic();
    }
}
