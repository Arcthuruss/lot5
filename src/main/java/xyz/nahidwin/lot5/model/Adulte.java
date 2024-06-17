package xyz.nahidwin.lot5.model;

public class Adulte extends Tarification{

    public Adulte() {
        super(0);
    }

    @Override
    public String toString() {
        return "Tarif: " + getRedutionStatic() + "\n";
    }
}
