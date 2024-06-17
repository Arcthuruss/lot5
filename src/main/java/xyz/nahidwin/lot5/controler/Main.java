package xyz.nahidwin.lot5.controler;

import javafx.application.Application;
import javafx.stage.Stage;
import xyz.nahidwin.lot5.model.*;
import xyz.nahidwin.lot5.view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main extends Application {

        static private FenMain fenMain;

        @Override
        public void start(Stage stage) throws IOException {
                // Tests
                Client c1 = new Client("Lair", "Vivit", "20 rue de NullPointerException", "073256247243", "test1234.bob@gmail.com", "Z6", (Reservation) null);
                Client c2 = new Client("michel", "ahahaa", "Rennes", "073256247243", "test1234.bob@gmail.com", "Z6", (Reservation) null);
                Billet b1 = new Billet("F7");
                Billet b2 = new Billet("B5");
                Representation representation = new Representation("Dimanche", "1:30");
                Facture f1 = new Facture("72", 20.99, true);
                Reservation r1 = new Reservation("72", c1, b1, representation, f1);
                Facture f2 = new Facture("426", 15.99, false);
                Reservation r2 = new Reservation("426", c2, b2, representation, f2);
                c1.addReservation(r1);
                c2.addReservation(r2);

                fenMain = new FenMain();

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
}
