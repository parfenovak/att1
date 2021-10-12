package Hearts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Julia Connelly
 * June 2016
 *
 * The start of the javaFX application
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainView.fxml"));
        fxmlLoader.load();

        Pane root = fxmlLoader.getRoot();
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hearts");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
