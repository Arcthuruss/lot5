package xyz.nahidwin.lot5.model;

import java.util.Objects;

public class Facture {
    private String numero;
    private double montantTTC;
    private static final double TauxTVA = 0.2;
    private Paiement paiement;

    public Facture(String numero, double montantTTC, boolean isPaye) {
        this.numero = numero;
        if (montantTTC >= 0) this.montantTTC = montantTTC;
        else throw new IllegalArgumentException("Le montant du billet ne peut pas etre negatif");

        paiement = new Liquide(isPaye); // Pour cause de flemme, on considère que le paiement est fait en liquide
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Facture facture = (Facture) o;
        return Double.compare(getMontantTTC(), facture.getMontantTTC()) == 0 && Objects.equals(getNumero(), facture.getNumero());
    }

    @Override
    public String toString() {
        return "Facture{" +
                "numero='" + numero + '\'' +
                ", montantTTC=" + montantTTC +
                '}';
    }

    public void afficher() {
        System.out.println(this);
    }
}
