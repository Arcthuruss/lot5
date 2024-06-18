package xyz.nahidwin.lot5.controler;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import xyz.nahidwin.lot5.model.Reservation;
import xyz.nahidwin.lot5.view.FenBillet;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlMain {
        @FXML private Button bnRechercher;
        @FXML private Button bnSupprimer;
        @FXML private TextField tfNom;
        @FXML private TextField tfVille;
        @FXML private CheckBox cbSelection;
        @FXML private VBox listResa;

        private ArrayList<Integer> indexSelected = new ArrayList<>();

        public void ajouterReservation(Reservation reservation){
                try{
                        FenBillet nouveauBillet = new FenBillet();
                        nouveauBillet.setLabels(reservation);

                        listResa.getChildren().add(nouveauBillet);
                } catch (IOException e){
                        System.out.println("Erreur lors de l'ajout de la reservation");
                }
        }

        @FXML public void supprimerReservations(){

                int count=0;
                int j=0;
                while (j<listResa.getChildren().size()){
                        if (((FenBillet) listResa.getChildren().get(j)).isChecked()) {
                                count++;
                        }
                        j++;
                }
                if (count==0) return;

                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Êtes-vous sûr de supprimer " + count + " réservation(s) ?");
                confirm.setTitle("Confirmation de suppression");
                confirm.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK){
                                int i=0;
                                while (i<listResa.getChildren().size()){
                                        if (((FenBillet) listResa.getChildren().get(i)).isChecked()) {
                                                listResa.getChildren().remove(i);
                                        } else{
                                                i++;
                                        }
                                }

                                if (listResa.getChildren().isEmpty()){
                                        cbSelection.setSelected(false);
                                }
                        }
                });
        }

        @FXML public void checkAll(){
                for (int i = 0; i < listResa.getChildren().size(); i++) {
                        ((FenBillet) listResa.getChildren().get(i)).setCheck(cbSelection.isSelected());
                }
        }

        public void supprimerReservation(int index) {
                listResa.getChildren().remove(index);
        }

        public void supprimerReservation(Reservation r) {
                int i=0;
                while (r != ((FenBillet) listResa.getChildren().get(i)).getReservation()) i++;
                listResa.getChildren().remove(i);
        }

        public void clicRechercher(){
                String nom = tfNom.getText();
                String ville = tfVille.getText();

                for (int i = 0; i < listResa.getChildren().size(); i++) {
                        listResa.getChildren().get(i).setVisible(true);
                        listResa.getChildren().get(i).setManaged(true);
                        ((FenBillet) listResa.getChildren().get(i)).clearBold();
                }

                for (int i = 0; i < listResa.getChildren().size(); i++) {
                        if (!(((FenBillet) listResa.getChildren().get(i)).getReservation().getClient().getNom().toUpperCase().contains(nom.toUpperCase()))
                                || !(((FenBillet) listResa.getChildren().get(i)).getReservation().getClient().getAdresse().toUpperCase().contains(ville.toUpperCase()))) {

                                listResa.getChildren().get(i).setVisible(false);
                                listResa.getChildren().get(i).setManaged(false);

                        } else {
                                if (!nom.isEmpty()) {
                                        ((FenBillet) listResa.getChildren().get(i)).nameToBold(nom.toUpperCase());
                                }
                                if (!ville.isEmpty()) {
                                        ((FenBillet) listResa.getChildren().get(i)).cityToBold(ville.toUpperCase());
                                }
                        }
                }
        }

        public void initialize() {

        }
}
