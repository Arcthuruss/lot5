package xyz.nahidwin.lot5.model;

public class Senior extends Tarification{
    public double tarifReduit;

    public Senior(double tarifReduit) {
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
