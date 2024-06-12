package xyz.nahidwin.lot5.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class FenMain extends Stage {
        public FenMain() throws IOException {
                this.setTitle("Liste des reservations");
                this.setMinHeight(200);
                this.setMinWidth(480);
                Scene scene = new Scene(createSceneGraph());
                this.setScene(scene);
        }

        private Pane createSceneGraph() throws IOException {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
                Pane root = fxmlLoader.load();
                fxmlLoader.getController();

                return root;
        }
}
