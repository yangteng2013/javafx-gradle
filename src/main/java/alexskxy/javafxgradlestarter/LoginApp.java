package alexskxy.javafxgradlestarter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LoginApp extends Application {

    private Map map = null;

    @Override
    public void init() throws Exception {
        super.init();
        map = new HashMap<String,String>();
        map.put("username","password");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text name = new Text("用户名：");
        Text password = new Text("密码：");

        TextField e_name = new TextField();
        e_name.setPrefWidth(150);

        TextField e_password = new TextField();

        Button clear = new Button("清除");
        Button login = new Button("登录");

        GridPane gridPane = new GridPane();
        gridPane.add(name,0,0);
        gridPane.add(e_name,1,0);
        gridPane.add(password,0,1);
        gridPane.add(e_password,1,1);
        gridPane.add(clear,0,2);
        gridPane.add(login,1,2);
        GridPane.setMargin(login,new Insets(0,0,0,115));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setVgap(10);
        gridPane.setHgap(5);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("登录");
        primaryStage.setHeight(300);
        primaryStage.setWidth(500);

        //无最大最小化，只有关闭按钮
        primaryStage.initStyle(StageStyle.UTILITY);

        primaryStage.show();

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                e_name.setText("");
                e_password.setText("");
            }
        });
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = null;
                String password = null;
                Set set = map.entrySet();
                for (Object o : set) {
                    String[] strs = o.toString().split("=");
                    username = strs[0];
                    password = strs[1];
                }

                if (e_name.getText().equals(username) && e_password.getText().equals(password)) {
                    primaryStage.close();
//                    Stage stage2 = new Stage();
//                    stage2.setHeight(300);
//                    stage2.setWidth(500);
//                    stage2.show();

                    try {
                        MainApp mainApp = new MainApp();
                        mainApp.showWindow();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    System.out.println("密码输入错误");
                }


            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }

}
