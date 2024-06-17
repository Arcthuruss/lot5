package xyz.nahidwin.lot5.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import xyz.nahidwin.lot5.model.Billet;
import xyz.nahidwin.lot5.model.Reservation;
import xyz.nahidwin.lot5.Main;

public class CtrlDetail {
    @FXML Label txtNom;
    @FXML Label txtPrenom;
    @FXML Label txtVille;
    @FXML Label txtEtatPayement;
    @FXML Label txtDateReservation;
    @FXML Label txtDateRepresentation;
    @FXML Label txtTotalCA;
    @FXML ListView<Label> listeCA;
    @FXML ListView<Label> listeBillet;

    private Reservation reservation;

    @FXML void supprimerReservation(ActionEvent event) {
        Main.supprimerReservation(reservation);
    }

    public void chargerReservation(Reservation r) {
        this.reservation = r;

        txtNom.setText(reservation.getClient().getNom());
        txtPrenom.setText(reservation.getClient().getPrenom());
        txtVille.setText(reservation.getClient().getAdresse());
        if (reservation.getFacture().getPaiement().isRealise()) {
            txtEtatPayement.setText("Payé");
        } else {
            txtEtatPayement.setText("Non payé");
        }
        txtDateRepresentation.setText(reservation.getRepresentation().getJour());
        txtDateReservation.setText(reservation.getDate().toString());
        txtTotalCA.setText(String.valueOf(reservation.getFacture().getMontantTTC()));

        for (Billet b : reservation.getBillets()) {
            listeBillet.getItems().add(new Label("Billet " + b.getNumero()));
            listeCA.getItems().add(new Label(String.valueOf(b.getPrix())));
        }

    }

    public void clear() {
        listeCA.getItems().clear();
        listeBillet.getItems().clear();
    }

}
