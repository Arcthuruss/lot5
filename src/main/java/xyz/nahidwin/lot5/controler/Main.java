package xyz.nahidwin.lot5.controler;

import javafx.application.Application;
import javafx.stage.Stage;
import xyz.nahidwin.lot5.view.FenMain;

public class Main extends Application {
        static private FenMain fMain;

        public void start(Stage primaryStage) {
                fMain = new FenMain();
                fMain.show();
        }

        public static void main(String[] args) {
                launch(args);
        }
}
