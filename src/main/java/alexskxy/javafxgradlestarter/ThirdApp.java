package alexskxy.javafxgradlestarter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ThirdApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("thirdPage.fxml"));
        primaryStage.setTitle("我是第三页");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }


    public void showWindow() throws IOException {
        start(new Stage());
    }

}
