package xyz.nahidwin.lot5.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import xyz.nahidwin.lot5.controler.CtrlBillet;
import xyz.nahidwin.lot5.model.Reservation;

import java.io.IOException;
import java.util.Date;

public class FenBillet extends HBox {
        private CtrlBillet ctrl;

        public FenBillet() throws IOException {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("billet.fxml"));
                fxmlLoader.setRoot(this);

                try {
                        fxmlLoader.load();
                } catch (IOException e) {
                        e.printStackTrace();
                }

                ctrl = fxmlLoader.getController();
        }

        public void setLabels(Reservation reservation) {
            ctrl.setLabels(reservation);
        }

        public boolean isChecked(){return ctrl.isChecked();}

        public void setCheck(boolean checked) {
            ctrl.setCheck(checked);
        }

        public Reservation getReservation() {
                return ctrl.getReservation();
        }

        public void nameToBold(String text) {
            ctrl.nameToBold(text);
        }

        public void cityToBold(String text) {
            ctrl.cityToBold(text);
        }

        public void clearBold() {
            ctrl.clearBold();
        }
}
