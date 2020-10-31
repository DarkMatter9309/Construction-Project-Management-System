package LoginWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Scene LoginScene;
    public static Stage LoginStage;
    public static Stage HomeStage;
    public static Stage MainStage;
    public static Stage VendorsStage;
    public static Stage NewProjectStage;

    public static String username;
    public static String Project_Name;

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoginStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/MainWindow/sample.fxml"));
        LoginScene = new Scene(root, 500, 300);
        LoginStage.setTitle("Building Blocks - User Login");
        LoginStage.setScene(LoginScene);
        LoginStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
