package NewProjectWindow;

import Database.ConnectionClass;
import LoginWindow.*;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.*;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class Controller {


    public Label lbl_Status;
    public HBox hBox_ProjectName;
    public HBox hBox_SuperBuilt;
    public HBox hBox_BuiltArea;
    public TextField txtField_ProjectName;
    public Button btn_Done_ProjectName;
    public TextField txtField_SuperBuilt;
    public Button btn_Done_SuperBuilt;
    public TextField txtField_BuiltArea;
    public Button btn_Done_BuiltArea;
    public HBox hBox_ParkingLot;
    public TextField txtField_ParkingLot;
    public Button btn_Done_ParingLot;
    public HBox hBox_Location;
    public TextField txtField_Location;
    public Button btn_Done_Location;
    public HBox hBox_Floors;
    public TextField txtField_Floors;
    public Button btn_Done_Floors;
    public HBox hBox_FloorPlan;
    public ChoiceBox choiceBox_FloorNumber;
    public TextField txtField_BedRooms;
    public TextField txtField_BathRooms;
    public TextField txtField_ExtraActivities;
    public TextField txtField_AreaForStairs;
    public Button btn_Add_FloorPlan;
    public HBox hBox_DoneCreateProject;
    public Button btn_Done_NewProject;

    public String username = Main.username;
    public String dbName = "BuildingBlocks_" + username;
    public ConnectionClass dbConn;


    public void btn_Done_ProjectName_Clicked(ActionEvent actionEvent) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String sql = "INSERT INTO User_Data (Project_Name) VALUES (?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());


            ps.executeUpdate();
        } catch (SQLException e) {
            flag_Exception = 1;
            lbl_Status.setText("Error occurred");
            System.out.println("Database error occurred");
        } finally {
            if(flag_Exception==0){
                lbl_Status.setText("Vendor is added successfully");
                hBox_ProjectName.setDisable(true);
                hBox_SuperBuilt.setDisable(false);
            }
        }

    }

    public void btn_Done_SuperBuilt_Clicked(ActionEvent actionEvent) {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String sql = "UPDATE User_Data SET Super_Built = ? WHERE User_Data.Project_Name = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(txtField_SuperBuilt.getText()));
            ps.setString(2,txtField_ProjectName.getText());

            ps.executeUpdate();
        } catch (SQLException e) {
            flag_Exception = 1;
            lbl_Status.setText("Error occurred");
            System.out.println("Database error occurred");
        } finally {
            if(flag_Exception==0){
                lbl_Status.setText("Super Built Area is added successfully");
                hBox_SuperBuilt.setDisable(true);
                hBox_BuiltArea.setDisable(false);
            }
        }


    }

    public void btn_Done_BuiltArea_Clicked(ActionEvent actionEvent) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String sql = "UPDATE User_Data SET Built_area = ? WHERE User_Data.Project_Name = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(txtField_BuiltArea.getText()));
            ps.setString(2,txtField_ProjectName.getText());

            ps.executeUpdate();
        } catch (SQLException e) {
            flag_Exception = 1;
            lbl_Status.setText("Error occurred");
            System.out.println("Database error occurred");
        } finally {
            if(flag_Exception==0){
                lbl_Status.setText("Built Area is added successfully");
                hBox_BuiltArea.setDisable(true);
                hBox_ParkingLot.setDisable(false);
            }
        }


    }

    public void btn_Done_ParingLot_Clicked(ActionEvent actionEvent) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String sql = "UPDATE User_Data SET Parking_Lot = ? WHERE User_Data.Project_Name = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(txtField_ParkingLot.getText()));
            ps.setString(2,txtField_ProjectName.getText());

            ps.executeUpdate();
        } catch (SQLException e) {
            flag_Exception = 1;
            lbl_Status.setText("Error occurred");
            System.out.println("Database error occurred");
        } finally {
            if(flag_Exception==0){
                lbl_Status.setText("Parking Lot Area is added successfully");
                hBox_ParkingLot.setDisable(true);
                hBox_Location.setDisable(false);
            }
        }

    }

    public void btn_Done_Location_Clicked(ActionEvent actionEvent) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String sql = "UPDATE User_Data SET Location = ? WHERE User_Data.Project_Name = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_Location.getText());
            ps.setString(2,txtField_ProjectName.getText());

            ps.executeUpdate();
        } catch (SQLException e) {
            flag_Exception = 1;
            lbl_Status.setText("Error occurred");
            System.out.println("Database error occurred");
        } finally {
            if(flag_Exception==0){
                lbl_Status.setText("Location is added successfully");
                hBox_Location.setDisable(true);
                hBox_Floors.setDisable(false);
            }
        }

    }

    public void btn_Done_Floors_Clicked(ActionEvent actionEvent) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String sql = "UPDATE User_Data SET Floors = ? WHERE User_Data.Project_Name = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(txtField_Floors.getText()));
            ps.setString(2,txtField_ProjectName.getText());

            ps.executeUpdate();
        } catch (SQLException e) {
            flag_Exception = 1;
            lbl_Status.setText("Error occurred");
            System.out.println("Database error occurred");
        } finally {
            if(flag_Exception==0){
                lbl_Status.setText("Number of Floors added successfully\nNow add plan of each floor");
                hBox_Floors.setDisable(true);
                hBox_FloorPlan.setDisable(false);
            }
        }

        // Floor Ids are added into Floor_Plan Data table and Choice box

        ConnectionClass dbConn2 = new ConnectionClass();
        Connection connection2 = dbConn2.getConnection(dbName);


        for(int i = 1; (i <= Integer.parseInt(txtField_Floors.getText())); i++){

            //Into the data table
            int flag_Exception2 = 0;
            String sql2 = "INSERT INTO Floor_Plan (Project_Name, Floor_Number) VALUES (?,?)";
            PreparedStatement ps2;
            try {
                ps2 = connection2.prepareStatement(sql2);
                ps2.setString(1,txtField_ProjectName.getText());
                ps2.setInt(2,i);

                ps2.executeUpdate();
            } catch (SQLException e) {
                flag_Exception2 = 1;
                lbl_Status.setText("Error occurred in Floor Numbers");
                System.out.println("Database error occurred in Floor Numbers");
            } finally {
                if(flag_Exception2==0){
                    //No error
                }
            }

            //Into the Choice box
            choiceBox_FloorNumber.getItems().add(i);
        }
    }

    public void btn_Add_FloorPlan_Clicked(ActionEvent actionEvent) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String sql = "UPDATE Floor_Plan SET Bedrooms = ?, Bathrooms = ?, Extra_Activities = ?, Area_for_Stairs = ? WHERE Floor_Plan.Project_Name = ? AND Floor_Plan.Floor_Number = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,Integer.parseInt(txtField_BedRooms.getText()));
            ps.setInt(2,Integer.parseInt(txtField_BathRooms.getText()));
            ps.setInt(3,Integer.parseInt(txtField_ExtraActivities.getText()));
            ps.setInt(4,Integer.parseInt(txtField_AreaForStairs.getText()));
            ps.setString(5,txtField_ProjectName.getText());
            ps.setInt(6,(Integer)choiceBox_FloorNumber.getValue());

            ps.executeUpdate();
        } catch (SQLException e) {
            flag_Exception = 1;
            lbl_Status.setText("Error occurred");
            System.out.println("Database error occurred");
        } finally {
            if(flag_Exception==0){
                lbl_Status.setText("Floor plan of floor:" + choiceBox_FloorNumber.getValue() +" is added successfully");
            }
        }

        choiceBox_FloorNumber.getItems().remove(choiceBox_FloorNumber.getValue());
        txtField_BathRooms.clear();
        txtField_BedRooms.clear();
        txtField_ExtraActivities.clear();
        txtField_AreaForStairs.clear();

        //check if all floor plans are over
        List options = choiceBox_FloorNumber.getItems();
        if(options.size()==0){
            hBox_FloorPlan.setDisable(true);
            hBox_DoneCreateProject.setDisable(false);
            lbl_Status.setText("All floor plans are added\nClick Create Project");
        }

    }

    public void btn_Done_NewProject_Clicked(ActionEvent actionEvent) throws IOException {

        //initialize sub phases in the database

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        String sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Water_Bore");

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Digging");

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

            lbl_Status.setText("Error occurred");
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Pillar_Laying");

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Slab");

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Walls");

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Flooring");

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Painting");

            ps.executeUpdate();
        } catch (SQLException e) {

            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Plumbing");

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Electricity");

            ps.executeUpdate();
        } catch (SQLException e) {

            System.out.println("Database error occurred");
        }
        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Interior_Design");

            ps.executeUpdate();
        } catch (SQLException e) {

            System.out.println("Database error occurred");
        }

        sql = "INSERT INTO Work_Status (Project_Name, Sub_Phase) VALUES (?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_ProjectName.getText());
            ps.setString(2,"Exterior_Design");

            ps.executeUpdate();
        } catch (SQLException e) {

            System.out.println("Database error occurred");
        }

        //load Main Window
        Main.Project_Name = txtField_ProjectName.getText();

        Parent root = FXMLLoader.load(getClass().getResource("/MainWindow/sample.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Building Blocks - Home");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaximized(true);

        Main.MainStage = stage;
        Main.HomeStage.close();
        stage.show();


        //calculate estimated budget
        int floors, built_area, super_built, Parking_Lot, total_bedrooms, total_bathrooms, total_extra, total_stairs;




        try{
            Statement statement= connection.createStatement();
            sql="SELECT * FROM User_Data";
            ResultSet rs= statement.executeQuery(sql);
            floors= rs.getInt(4);
            built_area=rs.getInt(3);
            super_built=rs.getInt(2);
            Parking_Lot= rs.getInt(5);
        }catch (SQLException e) {
            System.out.println("Could not retrieve data from the database " + e.getMessage());
        }

        try{
            Statement statement= connection.createStatement();
            sql="SELECT * FROM Floor_Plan";
            ResultSet rs= statement.executeQuery(sql);
            String bed="SELECT SUM(Bedrooms) FROM Floor_Plan";
            String bathrooms="SELECT SUM(Bathrooms) FROM Floor_Plan ";
            String Extra="SELECT SUM(Extra_Activities) FROM Floor_Plan ";
            String stairs="SELECT SUM(Area_of_Stairs) FROM Floor_Plan ";

            ResultSet rs_1=statement.executeQuery(bed);
            ResultSet rs_2=statement.executeQuery(bathrooms);
            ResultSet rs_3=statement.executeQuery(Extra);
            ResultSet rs_4=statement.executeQuery(stairs);

            total_bedrooms=rs_1.getInt(1);
            total_bathrooms=rs_2.getInt(1);
            total_extra=rs_3.getInt(1);
            total_stairs=rs_4.getInt(1);

        }
        catch (SQLException e) {
            System.out.println("Could not retrieve floorplan data" + e.getMessage());
        }

        // Water Bore
        try{
            Statement vendor= connection.createStatement();
            String Distinct= "SELECT DISTINCT Material FROM Vendor_Details WHERE Sub_Phase='Water_Bore' ";
            ResultSet estimate= vendor.executeQuery(Distinct);

            while(estimate.next()){
                String Parameter= estimate.getString(1);
                String sort= "SELECT TOP FROM Vendor_Details WHERE Material="+Parameter+ "ORDER BY Price ASC";
                ResultSet sorted_list= vendor.executeQuery(sort);


                int operation_cost= (int)Calculation_Class.Foundation_Phase_waterbore();

                String cost= "UPDATE " + sorted_list +" SET Price="+ operation_cost ;

                String push="INSERT INTO ESTIMATED VALUES SELECT * FROM " + sorted_list;
                vendor.executeUpdate(push);

            }

        }catch (SQLException e) {
            System.out.println("Could not retrieve data" + e.getMessage());
        }

    }

}
