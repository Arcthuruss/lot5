package xyz.nahidwin.lot5.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import xyz.nahidwin.lot5.Main;
import xyz.nahidwin.lot5.model.Reservation;

public class CtrlBillet {
    @FXML CheckBox cbSelection;
    @FXML Label txtNom;
    @FXML Label txtPrenom;
    @FXML Label txtVille;
    @FXML Label txtPayement;
    @FXML Label txtDateReserv;
    @FXML Label txtDate;
    @FXML Button btnDetail;

    private Reservation reservation;

    public void initialize() {}

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @FXML void ouvrirDetail(ActionEvent event) {
        Main.ouvrirFenDetail(reservation);
    }
}
