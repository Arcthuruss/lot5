package xyz.nahidwin.lot5.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import xyz.nahidwin.lot5.Main;
import xyz.nahidwin.lot5.model.Reservation;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.lang.Math;

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
        String nom = reservation.getClient().getNom();
        int index = nom.toUpperCase().indexOf(text);

        Text start = new Text(nom.substring(0,index));
        start.setStyle("-fx-font-weight:regular;");

        Text middle = new Text(nom.substring(index,Math.min(index+text.length(),nom.length())));
        middle.setStyle("-fx-font-weight:bold;");

        Text end = new Text(nom.substring(index+text.length()));
        end.setStyle("-fx-font-weight:regular;");

        txtNom.getChildren().clear();
        txtNom.getChildren().addAll(start, middle, end);
    }

    public void cityToBold(String text){
        String city = reservation.getClient().getAdresse();
        int index = city.toUpperCase().indexOf(text);

        Text start = new Text(city.substring(0,index));
        start.setStyle("-fx-font-weight: regular");

        Text middle = new Text(city.substring(index,Math.min(index+text.length(),city.length())));
        middle.setStyle("-fx-font-weight: bold;");

        Text end = new Text(city.substring(index+text.length()));
        end.setStyle("-fx-font-weight: regular");

        txtVille.getChildren().clear();
        txtVille.getChildren().addAll(start, middle, end);
    }

    public void clearBold(){
        txtNom.getChildren().clear();
        txtNom.getChildren().add(new Text(reservation.getClient().getNom()));

        txtVille.getChildren().clear();
        txtVille.getChildren().add(new Text(reservation.getClient().getAdresse()));
    }

    public void initialize() {}

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @FXML void ouvrirDetail(ActionEvent event) {
        Main.ouvrirFenDetail(reservation);
    }
}
