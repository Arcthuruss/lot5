package xyz.nahidwin.lot5.model;

import java.util.ArrayList;

public abstract class Tarification {
    private double reductionStatic;
    private final ArrayList<Reservation> reservations;

    public Tarification(double reductionStatic) {
        this.reductionStatic = reductionStatic;
        this.reservations = new ArrayList<>();
    };

    public void setReductionStatic(double tarifReduit) {
        this.reductionStatic = tarifReduit;
    }

    public double getRedutionStatic() {
        return reductionStatic;
    }

    public abstract String toString();

    public void ajouterReservation(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Cette reservation n'existe pas");
        else if (this.contient(reservation)) throw new IllegalArgumentException("Le client a deja fait cette reservation");
        else addReservation(reservation);
    }

    public void retirerReservation(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Cette reservation n'existe pas");
        else removeReservatoin(reservation);
    }

    protected boolean contient(Object o) {
        return this.reservations.contains(o);
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void removeReservatoin(Reservation reservation) {
        this.reservations.remove(reservation);
    }
}
