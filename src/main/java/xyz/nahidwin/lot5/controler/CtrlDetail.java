package xyz.nahidwin.lot5.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import xyz.nahidwin.lot5.model.Billet;
import xyz.nahidwin.lot5.model.Reservation;
import xyz.nahidwin.lot5.Main;

import java.util.ArrayList;

public class CtrlDetail {
    @FXML Label txtNom;
    @FXML Label txtPrenom;
    @FXML Label txtVille;
    @FXML Label txtEtatPaymenent;
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
        for (Billet b : reservation.getBillets()) {
            listeBillet.getItems().add(new Label("Billet " + b.getNumero()));
        }

    }
}
