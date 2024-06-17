package xyz.nahidwin.lot5.model;

public class Groupe extends Tarification{
    public double tarifReduit;

    public Groupe(double tarifReduit) {
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
