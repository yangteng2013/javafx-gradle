package alexskxy.javafxgradlestarter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    Stage stage = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("personOverView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("个人信息概览");
        stage.show();
    }


    public void showWindow() throws IOException {
        start(stage);
    }

}
