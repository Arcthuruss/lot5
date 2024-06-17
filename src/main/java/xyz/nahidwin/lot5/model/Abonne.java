package xyz.nahidwin.lot5.model;

public class Abonne extends Tarification{
    public double tarifReduit;

    public Abonne(double tarifReduit) {
        this.tarifReduit = tarifReduit;
    }

    public double getTarifReduit() {
        return tarifReduit;
    }

    public void setTarifReduit(double tarifReduit) {
        this.tarifReduit = tarifReduit;
    }

    @Override
    public String toString() {
        return "Tarif : " + tarifReduit;
    }
}
