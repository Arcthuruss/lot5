package xyz.nahidwin.lot5.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import xyz.nahidwin.lot5.controler.CtrlDetail;
import xyz.nahidwin.lot5.model.Reservation;

import java.io.IOException;

public class FenDetail extends Stage {

    private CtrlDetail ctrl;

    public FenDetail() throws IOException {
        this.setTitle("Liste des reservations");
        this.setMinHeight(200);
        this.setMinWidth(480);
        Scene scene = new Scene(createSceneGraph());
        this.setScene(scene);
    }

    private Pane createSceneGraph() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detail.fxml"));
        Pane root = fxmlLoader.load();
        ctrl = fxmlLoader.getController();

        return root;
    }

    public void chargerReservation(Reservation r) {
        ctrl.chargerReservation(r);
    }

}
