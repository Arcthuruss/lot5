package xyz.nahidwin.lot5.model;

public class Jeune extends Tarification{
    public double tarifReduit;

    public Jeune(double tarifReduit) {
        this.tarifReduit = tarifReduit;
    }

    public void setTarifReduit(double tarifReduit) {
        this.tarifReduit = tarifReduit;
    }

    public double getTarifReduit() {
        return tarifReduit;
    }

    @Override
    public String toString() {
        return "Tarif: " + tarifReduit;
    }
}
