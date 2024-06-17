package xyz.nahidwin.lot5.model;

public class Adulte extends Tarification{
    public double tarifBase;

    public Adulte(double tarifBase) {
        this.tarifBase = tarifBase;
    }

    public double getTarifBase() {
        return tarifBase;
    }

    public void setTarifBase(double tarifBase) {
        this.tarifBase = tarifBase;
    }

    @Override
    public String toString() {
        return "Tarif: " + tarifBase + "\n";
    }
}
