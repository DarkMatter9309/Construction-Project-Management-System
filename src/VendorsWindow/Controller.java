package VendorsWindow;

import Database.ConnectionClass;
import Database.VendorDetails;
import LoginWindow.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField txtField_VendorName;
    public TextField txtField_MaterialType;
    public TextField txtField_Material;
    public TextField txtField_Price;
    public TextField txtField_Contact;
    public TextField txtField_Location;

    public Button btn_AddVendor;
    public Label lbl_Status1;

    public TableView<VendorDetails> tblView_Vendors;
    public TableColumn<VendorDetails, String> tblColumn_VendorName;
    public TableColumn<VendorDetails, String> tblColumn_MaterialType;
    public TableColumn<VendorDetails, String> tblColumn_Material;
    public TableColumn<VendorDetails, Integer> tblColumn_Price;
    public TableColumn<VendorDetails, String> tblColumn_Contact;
    public TableColumn<VendorDetails, String> tblColumn_Location;
    public Tab tab_VendorsTable;
    public Button btn_Refresh;
    public Button btn_Clear;
    public VBox vBox_TextFields;
    ObservableList<VendorDetails> list_of_vendors;

    public Button btn_DeleteVendor;
    public Label lbl_Status2;

    public String username = Main.username;
    public String dbName = "BuildingBlocks_" + username;
    public ConnectionClass dbConn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lbl_Status1.setText("");
        lbl_Status2.setText("");
        btn_DeleteVendor.setDisable(true);

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        list_of_vendors = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM Vendor_Details");
            while (rs.next()) {
                list_of_vendors.add(new VendorDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6)));
            }


        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        tblColumn_VendorName.setCellValueFactory(new PropertyValueFactory<>("vendor_Name"));
        tblColumn_MaterialType.setCellValueFactory(new PropertyValueFactory<>("material_Type"));
        tblColumn_Material.setCellValueFactory(new PropertyValueFactory<>("material"));
        tblColumn_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tblColumn_Contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblColumn_Location.setCellValueFactory(new PropertyValueFactory<>("location"));

        tblView_Vendors.setItems(null);
        tblView_Vendors.setItems(list_of_vendors);


        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
    }

    public void btn_AddVendor_Clicked(ActionEvent actionEvent) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String sql = "INSERT INTO Vendor_Details (Vendor_Name, Material_Type, Material, Price, Contact, Location) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,txtField_VendorName.getText());
            ps.setString(2,txtField_MaterialType.getText());
            ps.setString(3,txtField_Material.getText());
            ps.setInt(4,Integer.parseInt(txtField_Price.getText()));
            ps.setString(5,txtField_Contact.getText());
            ps.setString(6,txtField_Location.getText());

            ps.executeUpdate();
        } catch (SQLException e) {
            flag_Exception = 1;
            lbl_Status1.setText("Error occurred");
            System.out.println("Database error occurred");
        } finally {
            if(flag_Exception==0){
                lbl_Status1.setText("Vendor is added successfully");
                btn_AddVendor.setDisable(true);
                vBox_TextFields.setDisable(true);
            }
        }

    }


    public void btn_Clear_Clicked(ActionEvent actionEvent) {

        txtField_VendorName.clear();
        txtField_MaterialType.clear();
        txtField_Material.clear();
        txtField_Price.clear();
        txtField_Contact.clear();
        txtField_Location.clear();
        lbl_Status1.setText("");

        vBox_TextFields.setDisable(false);
        btn_AddVendor.setDisable(false);
    }


    public void btn_DeleteVendor_Clicked(ActionEvent actionEvent) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        VendorDetails vd = tblView_Vendors.getSelectionModel().getSelectedItem();


        String sql = "DELETE FROM Vendor_Details WHERE Vendor_Details.Contact = ?";
        PreparedStatement ps;
        try {

            ps = connection.prepareStatement(sql);
            ps.setString(1,vd.getContact());
            ps.executeUpdate();

        } catch (SQLException e) {

            flag_Exception = 1;
            lbl_Status2.setText("Error occurred");
            tblView_Vendors.getSelectionModel().clearSelection();
            btn_DeleteVendor.setDisable(true);
            System.out.println("Database error occurred");

        } finally {
            if(flag_Exception==0){
                lbl_Status2.setText("Vendor is deleted successfully");
                tblView_Vendors.getSelectionModel().clearSelection();
                btn_DeleteVendor.setDisable(true);

                //Refresh the table view
                list_of_vendors = FXCollections.observableArrayList();
                ResultSet rs;

                try {
                    rs = connection.createStatement().executeQuery("SELECT * FROM Vendor_Details");
                    while (rs.next()) {
                        list_of_vendors.add(new VendorDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6)));
                    }


                } catch (SQLException e) {
                    System.out.println("Database error occurred");
                }

                tblColumn_VendorName.setCellValueFactory(new PropertyValueFactory<>("vendor_Name"));
                tblColumn_MaterialType.setCellValueFactory(new PropertyValueFactory<>("material_Type"));
                tblColumn_Material.setCellValueFactory(new PropertyValueFactory<>("material"));
                tblColumn_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
                tblColumn_Contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
                tblColumn_Location.setCellValueFactory(new PropertyValueFactory<>("location"));

                tblView_Vendors.setItems(null);
                tblView_Vendors.setItems(list_of_vendors);


                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Database error: " + e);
                }

            }
        }

    }

    public void tab_VendorsTable_Clicked(Event event) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        list_of_vendors = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM Vendor_Details");
            while (rs.next()) {
                list_of_vendors.add(new VendorDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6)));
            }


        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        tblColumn_VendorName.setCellValueFactory(new PropertyValueFactory<>("vendor_Name"));
        tblColumn_MaterialType.setCellValueFactory(new PropertyValueFactory<>("material_Type"));
        tblColumn_Material.setCellValueFactory(new PropertyValueFactory<>("material"));
        tblColumn_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tblColumn_Contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblColumn_Location.setCellValueFactory(new PropertyValueFactory<>("location"));

        tblView_Vendors.setItems(null);
        tblView_Vendors.setItems(list_of_vendors);


        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }

    }

    public void btn_Refresh_Clicked(ActionEvent actionEvent) {

        lbl_Status2.setText("");
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        list_of_vendors = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = connection.createStatement().executeQuery("SELECT * FROM Vendor_Details");
            while (rs.next()) {
                list_of_vendors.add(new VendorDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6)));
            }


        } catch (SQLException e) {
            System.out.println("Database error occurred");
        }

        tblColumn_VendorName.setCellValueFactory(new PropertyValueFactory<>("vendor_Name"));
        tblColumn_MaterialType.setCellValueFactory(new PropertyValueFactory<>("material_Type"));
        tblColumn_Material.setCellValueFactory(new PropertyValueFactory<>("material"));
        tblColumn_Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tblColumn_Contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblColumn_Location.setCellValueFactory(new PropertyValueFactory<>("location"));

        tblView_Vendors.setItems(null);
        tblView_Vendors.setItems(list_of_vendors);


        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database error: " + e);
        }
    }

    public void tblView_Vendors_MouseClicked(MouseEvent mouseEvent) {
        btn_DeleteVendor.setDisable(false);
    }
}
