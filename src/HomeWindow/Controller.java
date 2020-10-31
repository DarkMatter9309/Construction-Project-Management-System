package HomeWindow;

import Database.ConnectionClass;
import LoginWindow.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public String username = Main.username;
    public String dbName = "BuildingBlocks_" + username;
    public ConnectionClass dbConn;
    public ListView<String> listView_RecentProjects;
    ObservableList<String> list_of_projects;
    public Button btn_OpenRecentProject;
    public Button btn_GoToVendors;
    public Button btn_CreateNewProject;

    public void initialize(URL location, ResourceBundle resources) {

        dbConn = new ConnectionClass();

        Connection connection = dbConn.getConnection(dbName);

        list_of_projects = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = connection.createStatement().executeQuery("SELECT Project_Name FROM User_Data");
            while (rs.next()) {
                list_of_projects.add(rs.getString(1));
            }


        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        listView_RecentProjects.setItems(list_of_projects);

        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }

    }

    public void btn_OpenRecentProject_Clicked(ActionEvent actionEvent) throws IOException {

        Main.Project_Name = list_of_projects.get(listView_RecentProjects.getSelectionModel().getSelectedIndex());

        Parent root = FXMLLoader.load(getClass().getResource("/MainWindow/sample.fxml"));
        Scene scene = new Scene(root, 1366, 768);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Building Blocks - Home");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(true);

        Main.MainStage = stage;
        Main.HomeStage.close();
        stage.show();

    }

    public void btn_GoToVendors_Clicked(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/VendorsWindow/sample.fxml"));
        Scene scene = new Scene(root, 1000,600);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Building Blocks - Vendors Data");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        Main.VendorsStage = stage;

//        Main.HomeStage.close();
        stage.show();

    }

    public void btn_CreateNewProject_Clicked(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/NewProjectWindow/sample.fxml"));
        Scene scene = new Scene(root, 1000,600);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Building Blocks - Create New Project");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        Main.NewProjectStage = stage;
        Main.HomeStage.close();
        stage.show();
    }
}
