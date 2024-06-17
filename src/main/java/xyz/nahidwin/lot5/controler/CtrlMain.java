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

        private ArrayList<Integer> indexSelected = new ArrayList<Integer>();

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
                int i=0;
                while (i<listResa.getChildren().size()){
                        if (((FenBillet) listResa.getChildren().get(i)).isChecked()) {
                                listResa.getChildren().remove(i);
                        } else{
                                i++;
                        }
                }

                if (listResa.getChildren().size() <= 0){
                        cbSelection.setSelected(false);
                }
        }

        @FXML public void checkAll(){
                for (int i = 0; i < listResa.getChildren().size(); i++) {
                        ((FenBillet) listResa.getChildren().get(i)).setCheck(cbSelection.isSelected());
                }
        }

        public void supprimerReservation(int index) {
                listResa.getChildren().remove(index);
        }

        public void clicRechercher(){
                String nom = tfNom.getText().toLowerCase();
                String ville = tfVille.getText().toLowerCase();

                for (int i = 0; i < listResa.getChildren().size(); i++) {
                        listResa.getChildren().get(i).setVisible(true);
                        listResa.getChildren().get(i).setManaged(true);
                        ((FenBillet) listResa.getChildren().get(i)).clearBold();
                }

                for (int i = 0; i < listResa.getChildren().size(); i++) {
                        if (!(((FenBillet) listResa.getChildren().get(i)).getReservation().getClient().getNom().toLowerCase().startsWith(nom)) || !(((FenBillet) listResa.getChildren().get(i)).getReservation().getClient().getAdresse().toLowerCase().startsWith(ville))){
                                listResa.getChildren().get(i).setVisible(false);
                                listResa.getChildren().get(i).setManaged(false);
                        } else{
                                ((FenBillet) listResa.getChildren().get(i)).nameToBold(nom);
                                ((FenBillet) listResa.getChildren().get(i)).cityToBold(ville);
                        }
                }
        }

        public void initialize() {

        }
}
