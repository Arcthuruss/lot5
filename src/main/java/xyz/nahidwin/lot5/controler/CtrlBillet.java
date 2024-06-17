package xyz.nahidwin.lot5.controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import xyz.nahidwin.lot5.model.Reservation;

import java.util.Date;

public class CtrlBillet {
    @FXML CheckBox cbSelection;
    @FXML TextFlow txtNom;
    @FXML Label txtPrenom;
    @FXML TextFlow txtVille;
    @FXML Label txtPayement;
    @FXML Label txtDateReserv;
    @FXML Label txtDate;
    @FXML Button btnDetail;

    private Reservation reservation;

    public void setLabels(Reservation reservation) {
        this.reservation = reservation;

        txtNom.getChildren().add(new Text(reservation.getClient().getNom()));
        txtPrenom.setText(reservation.getClient().getPrenom());
        txtVille.getChildren().add(new Text(reservation.getClient().getAdresse()));

        if (reservation.getFacture().getPaiement().isRealise()) {
            txtPayement.setText("Paye");
        } else {
            txtPayement.setText("Non paye");
        }

        if (reservation.getDateEnvoiConf()==null){
            txtDateReserv.setText("En attente");
        } else {
            txtDateReserv.setText(reservation.getDateEnvoiConf().toString());
        }

        txtDate.setText(reservation.getDate().toString());
    }

    public boolean isChecked(){return cbSelection.isSelected();}

    public void setCheck(boolean isCheck){
        cbSelection.setSelected(isCheck);
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void nameToBold(String text){
        Text start = new Text(text);
        start.setStyle("-fx-font-weight: bold");

        Text end = new Text(reservation.getClient().getNom().substring(text.length()));
        end.setStyle("-fx-font-weight: regular");

        txtNom.getChildren().clear();
        txtNom.getChildren().addAll(start, end);
    }

    public void cityToBold(String text){
        Text start = new Text(text);
        start.setStyle("-fx-font-weight: bold");

        Text end = new Text(reservation.getClient().getAdresse().substring(text.length()));
        end.setStyle("-fx-font-weight: regular");

        txtVille.getChildren().clear();
        txtVille.getChildren().addAll(start, end);
    }

    public void clearBold(){
        txtNom.getChildren().clear();
        txtNom.getChildren().add(new Text(reservation.getClient().getNom()));

        txtVille.getChildren().clear();
        txtVille.getChildren().add(new Text(reservation.getClient().getAdresse()));
    }

    public void initialize() {}
}
