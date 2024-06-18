package xyz.nahidwin.lot5;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import xyz.nahidwin.lot5.model.*;
import xyz.nahidwin.lot5.view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main extends Application {

        static private FenMain fenMain;
        static private FenDetail fenDetail;
        static private final Senior tarifSenior = new Senior(25);
        static private final Abonne tarifAbonne = new Abonne(30);
        static private final Adulte tarifAdulte = new Adulte();
        static private final Jeune tarifJeune = new Jeune(30);
        static private final Groupe tarifGroupe = new Groupe(15);

        /*⠀⠀⣠⣤⣤⣤⣤⣤⣶⣦⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡿⠛⠉⠙⠛⠛⠛⠛⠻⢿⣿⣷⣤⡀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⠋⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⠈⢻⣿⣿⡄⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣸⣿⡏⠀⠀⠀⣠⣶⣾⣿⣿⣿⠿⠿⠿⢿⣿⣿⣿⣄⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣿⣿⠁⠀⠀⢰⣿⣿⣯⠁⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⣷⡄⠀
⠀⠀⣀⣤⣴⣶⣶⣿⡟⠀⠀⠀⢸⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⠀
⠀⢰⣿⡟⠋⠉⣹⣿⡇⠀⠀⠀⠘⣿⣿⣿⣿⣷⣦⣤⣤⣤⣶⣶⣶⣶⣿⣿⣿⠀
⠀⢸⣿⡇⠀⠀⣿⣿⡇⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀
⠀⣸⣿⡇⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠉⠻⠿⣿⣿⣿⣿⡿⠿⠿⠛⢻⣿⡇⠀⠀
⠀⣿⣿⠁⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣧⠀⠀
⠀⣿⣿⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀
⠀⣿⣿⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀
⠀⢿⣿⡆⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀
⠀⠸⣿⣧⡀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠃⠀⠀
⠀⠀⠛⢿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⣰⣿⣿⣷⣶⣶⣶⣶⠶⠀⢠⣿⣿⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⣿⣿⡇⠀⣽⣿⡏⠁⠀⠀⢸⣿⡇⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⣿⣿⡇⠀⢹⣿⡆⠀⠀⠀⣸⣿⠇⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢿⣿⣦⣄⣀⣠⣴⣿⣿⠁⠀⠈⠻⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⠿⠿⠿⠿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀IMPASTA*/

        @Override
        public void start(Stage stage) throws IOException {
                fenMain = new FenMain();
                fenDetail = new FenDetail();

                // Tests
                Client c1 = new Client("Doe", "John", "20 rue de NullPointerException", "073256247243", "test1234.bob@gmail.com", "Z6", (Reservation) null);
                Client c2 = new Client("michel", "ahahaa", "Rennes", "073256247243", "test1234.bob@gmail.com", "Z6", (Reservation) null);
                Billet b1 = new Billet("F7", tarifSenior);
                Billet b2 = new Billet("B5", tarifAdulte);
                Representation representation = new Representation("Dimanche", "1:30");
                Facture f1 = new Facture("72", 45, true);
                Reservation r1 = new Reservation("72", c1, b1, representation, f1);
                Facture f2 = new Facture("426", 60, false);
                Reservation r2 = new Reservation("426", c2, b2, representation, f2);
                c1.addReservation(r1);
                c2.addReservation(r2);

                // Tests
                ajouterReservation(r1);
                ajouterReservation(r2);

                fenMain.show();
        }

        public static void main(String[] args) {
                launch();
        }

        public void ajouterReservation(Reservation reservation){
                fenMain.ajouterReservation(reservation);
        }

        public static void ouvrirFenDetail(Reservation r) {
                fenDetail.clear();
                fenDetail.chargerReservation(r);
                fenDetail.show();
        }

        public static void supprimerReservation(Reservation r) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Êtes-vous sûr de supprimer cette réservation ?");
                confirm.setTitle("Confirmation de suppression");
                confirm.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK){
                                fenDetail.close();
                                fenMain.supprimerReservation(r);
                        }
                });
        }
}
