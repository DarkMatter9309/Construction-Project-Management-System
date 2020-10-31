package MainWindow;


import Database.ConnectionClass;
import Database.Estimated;
import LoginWindow.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ToggleButton tglBtn_FoundationPhase;
    public ToggleButton tglBtn_ShellBuildingPhase;
    public ToggleButton tglBtn_InteriorBuildingPhase;
    public ToggleButton tglBtn_DesignPhase;
    public ToggleGroup tglGrp_Phase;

    public ScrollPane scrlpane_FoundationPhase;
    public ScrollPane scrlpane_Shell_Building_Phase;
    public ScrollPane scrlpane_Interior_Building_Phase;
    public ScrollPane scrlpane_Design_Phase;

    public ScrollPane current_pane;

    public Button btn_Profile;

    public TableView table_Water_bore_estimate;

    public TableColumn colm_material_water_bore_estimate;
    public TableColumn colm_type_water_bore_estimate;
    public TableColumn colm_price_water_bore_estimate;
    public TableColumn colm_location_water_bore_estimate;
    public TableColumn colm_vendor_water_bore_estimate;
    public MenuButton menu_material_water_bore_actual;
    public MenuButton menu_vendor_water_bore_actual;
    public TextField txtfld_price_water_bore_actual;
    public Button btn_add_water_bore_actual;
    public Label label_status_water_bore_actual;

    public TableView table_digging_estimate;
    public TableColumn colm_material_digging_estimate;
    public TableColumn colm_type_digging_estimate;
    public TableColumn colm_vendor_digging_estimate;
    public TableColumn colm_price_digging_estimate;
    public TableColumn colm_location_digging_estimate;
    public MenuButton menu_material_digging_actual;
    public MenuButton menu_vendor_digging_actual;
    public TextField txtfld_price_digging_actual;
    public Button btn_add_digging_actual;
    public Label label_status_digging_actual;


    public TableView table_Pillar_laying_estimate;
    public TableColumn colm_material_pillar_laying_estimate;
    public TableColumn colm_type_pillar_laying_estimate;
    public TableColumn colm_vendor_pillar_laying_estimate;
    public TableColumn colm_price_pillar_laying_estimate;
    public TableColumn colm_location_pillar_laying_estimate;
    public MenuButton menu_material_pillar_laying_actual;
    public MenuButton menu_vendor_pillar_laying_actual;
    public TextField txtfld_price_pillar_laying_actual;
    public Button btn_add_pillar_laying_actual;
    public Label label_status_pillar_laying_actual;


    public TableView table_slab_estimate;
    public TableColumn colm_material_slab_estimate;
    public TableColumn colm_type_slab_estimate;
    public TableColumn colm_vendor_slab_estimate;
    public TableColumn colm_price_slab_estimate;
    public TableColumn colm_location_slab_estimate;
    public MenuButton menu_material_slab_actual;
    public MenuButton menu_vendor_slab_actual;
    public TextField txtfld_price_slab_actual;
    public Button btn_add_slab_actual;
    public Label label_status_slab_actual;


    public TableView table_walls_estimate;
    public TableColumn colm_material_walls_estimate;
    public TableColumn colm_type_walls_estimate;
    public TableColumn colm_vendor_walls_estimate;
    public TableColumn colm_price_walls_estimate;
    public TableColumn colm_location_walls_estimate;
    public MenuButton menu_material_walls_actual;
    public MenuButton menu_vendor_walls_actual;
    public TextField txtfld_price_walls_actual;
    public Button btn_add_walls_actual;
    public Label label_status_walls_actual;


    public TableView table_flooring_estimate;
    public TableColumn colm_material_flooring_estimate;
    public TableColumn colm_type_flooring_estimate;
    public TableColumn colm_vendor_flooring_estimate;
    public TableColumn colm_price_flooring_estimate;
    public TableColumn colm_location_flooring_estimate;
    public MenuButton menu_material_flooring_actual;
    public MenuButton menu_vendor_flooring_actual;
    public TextField txtfld_price_flooring_actual;
    public Button btn_add_flooring_actual;
    public Label label_status_flooring_actual;


    public TableView table_painting_estimate;
    public TableColumn colm_material_painting_estimate;
    public TableColumn colm_type_painting_estimate;
    public TableColumn colm_vendor_painting_estimate;
    public TableColumn colm_price_painting_estimate;
    public TableColumn colm_location_painting_estimate;
    public MenuButton menu_material_painting_actual;
    public MenuButton menu_vendor_painting_actual;
    public TextField txtfld_price_painting_actual;
    public Button btn_add_painting_actual;
    public Label label_status_painting_actual;

    public TableView table_plumbing_estimate;
    public TableColumn colm_material_plumbing_estimate;
    public TableColumn colm_type_plumbing_estimate;
    public TableColumn colm_vendor_plumbing_estimate;
    public TableColumn colm_price_plumbing_estimate;
    public TableColumn colm_location_plumbing_estimate;
    public MenuButton menu_material_plumbing_actual;
    public TextField txtfld_price_plumbing_actual;
    public MenuButton menu_vendor_plumbing_actual;
    public Button btn_add_plumbing_actual;
    public Label label_status_plumbing_actual;

    public TableView table_electricity_estimate;
    public TableColumn colm_material_electricity_estimate;
    public TableColumn colm_type_electricity_estimate;
    public TableColumn colm_vendor_electricity_estimate;
    public TableColumn colm_price_electricity_estimate;
    public TableColumn colm_location_electricity_estimate;
    public MenuButton menu_material_electricity_actual;
    public MenuButton menu_vendor_electricity_actual;
    public TextField txtfld_price_electricity_actual;
    public Button btn_add_electricity_actual;
    public Label label_status_electricity_actual;




    boolean phase1_Foundation = false;
    boolean phase2_ShellBuilding = false;
    boolean phase3_InteriorBuilding = false;
    boolean phase4_Design = false;

    ObservableList<Database.Estimated> water_bore_estimated_budget;
    ObservableList<Database.Estimated> digging_estimated_budget;
    ObservableList<Database.Estimated> pillar_laying_estimated_budget;
    ObservableList<Database.Estimated> slab_estimated_budget;
    ObservableList<Database.Estimated> walls_estimated_budget;
    ObservableList<Database.Estimated> flooring_estimated_budget;
    ObservableList<Database.Estimated> painting_estimated_budget;
    ObservableList<Database.Estimated> plumbing_estimated_budget;
    ObservableList<Database.Estimated> Electricity_estimated_budget;

    public String username = Main.username;
    public String dbName = "BuildingBlocks_" + username;
    public ConnectionClass dbConn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int currentPhase = 1;

        tglBtn_FoundationPhase.setDisable(false);
        tglBtn_ShellBuildingPhase.setDisable(false);
        tglBtn_InteriorBuildingPhase.setDisable(false);
        tglBtn_DesignPhase.setDisable(false);

        tglBtn_FoundationPhase.setSelected(true);
        tglBtn_ShellBuildingPhase.setSelected(false);
        tglBtn_InteriorBuildingPhase.setSelected(false);
        tglBtn_DesignPhase.setSelected(false);

        scrlpane_FoundationPhase.setVisible(true);
        current_pane=scrlpane_FoundationPhase;
//
//        //remaining anchor panes visibility = false
//
//        if(phase1_Foundation) {
//            tglBtn_ShellBuildingPhase.setDisable(false);
//            currentPhase = 2;
//            if(phase2_ShellBuilding) {
//                tglBtn_InteriorBuildingPhase.setDisable(false);
//                currentPhase = 3;
//                if(phase3_InteriorBuilding) {
//                    tglBtn_DesignPhase.setDisable(false);
//                    currentPhase = 4;
//                    if(phase4_Design){
//                        currentPhase = 0;
//                    }
//                }
//            }
//
//        }
//
//
//
//        if(currentPhase == 0){
//            //all phases are completed.
//        }
//        else{
//            //show current phase on the screen
//            if(currentPhase==1){
//                tglBtn_FoundationPhase.setSelected(true);
//            }
//            if(currentPhase==1){
//                tglBtn_FoundationPhase.setSelected(true);
//            }
//            if(currentPhase==1){
//                tglBtn_FoundationPhase.setSelected(true);
//            }
//            else if(currentPhase==4){
//                tglBtn_FoundationPhase.setSelected(true);
//            }
//
//        }

        //System.out.println(Main.Project_Name);

        String Parameter = Main.Project_Name;


        //water_bore_estimated_budget_table

        water_bore_estimated_budget= FXCollections.observableArrayList();
        ResultSet rs;

        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Water_Bore' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                water_bore_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_water_bore_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_water_bore_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_water_bore_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_water_bore_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_water_bore_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_Water_bore_estimate.setItems(water_bore_estimated_budget);


        //Digging_estimated_budget_table

        digging_estimated_budget= FXCollections.observableArrayList();

        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Digging' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                digging_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_digging_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_digging_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_digging_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_digging_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_digging_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_digging_estimate.setItems(null);
        table_digging_estimate.setItems(digging_estimated_budget);

        //Pillar_laying_estimated_budget_table

        pillar_laying_estimated_budget= FXCollections.observableArrayList();

        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Pillar_Laying' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                pillar_laying_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_pillar_laying_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_pillar_laying_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_pillar_laying_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_pillar_laying_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_pillar_laying_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_Pillar_laying_estimate.setItems(null);
        table_Pillar_laying_estimate.setItems(pillar_laying_estimated_budget);


        //Slab_estimated_budget_table

        slab_estimated_budget= FXCollections.observableArrayList();

        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Slab' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                slab_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_slab_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_slab_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_slab_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_slab_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_slab_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_slab_estimate.setItems(null);
        table_slab_estimate.setItems(slab_estimated_budget);


        //Walls_estimated_budget_table

        walls_estimated_budget= FXCollections.observableArrayList();


        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Walls' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                walls_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_walls_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_walls_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_walls_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_walls_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_walls_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_walls_estimate.setItems(null);
        table_walls_estimate.setItems(walls_estimated_budget);

        //Flooring_estimated_budget_table

        flooring_estimated_budget= FXCollections.observableArrayList();


        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Flooring' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                flooring_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_flooring_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_flooring_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_flooring_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_flooring_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_flooring_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_flooring_estimate.setItems(null);
        table_flooring_estimate.setItems(flooring_estimated_budget);


        //Painting_estimated_budget_table

        painting_estimated_budget= FXCollections.observableArrayList();

        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Painting' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                painting_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_painting_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_painting_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_painting_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_painting_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_painting_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_painting_estimate.setItems(null);
        table_painting_estimate.setItems(painting_estimated_budget);


        //Plumbing_estimated_budget_table

        plumbing_estimated_budget= FXCollections.observableArrayList();
        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Plumbing' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                plumbing_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_plumbing_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_plumbing_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_plumbing_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_plumbing_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_plumbing_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_plumbing_estimate.setItems(null);
        table_plumbing_estimate.setItems(plumbing_estimated_budget);


        //Electricity_estimated_budget_table

        Electricity_estimated_budget= FXCollections.observableArrayList();

        try
        {
            rs = connection.createStatement().executeQuery("SELECT * FROM ESTIMATED WHERE Sub_Phase = 'Electricity' AND Project_Name = '"+Parameter+"'");
            while(rs.next())
            {
                Electricity_estimated_budget.add(new Estimated(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4), rs.getString(5)));
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

        colm_material_electricity_estimate.setCellValueFactory(new PropertyValueFactory<>("material"));
        colm_type_electricity_estimate.setCellValueFactory(new PropertyValueFactory<>("type"));
        colm_vendor_electricity_estimate.setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        colm_price_electricity_estimate.setCellValueFactory(new PropertyValueFactory<>("price"));
        colm_location_electricity_estimate.setCellValueFactory(new PropertyValueFactory<>("location"));

        table_electricity_estimate.setItems(null);
        table_electricity_estimate.setItems(Electricity_estimated_budget);



        //populating Actual drop down menus
//        menu_vendor_water_bore_actual.setDisable(true);
//        txtfld_price_water_bore_actual.setDisable(true);
//        btn_add_water_bore_actual.setDisable(true);

        ObservableList<String> materials_list = FXCollections.observableArrayList();

        try
        {
            rs = connection.createStatement().executeQuery("SELECT DISTINCT Material FROM Vendor_Details");
            while(rs.next())
            {
                materials_list.add(rs.getString(1));
                MenuItem mi = new MenuItem(rs.getString(1));
                menu_material_water_bore_actual.getItems().add(mi);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }


    }

    public void btn_add_water_bore_material_clicked(ActionEvent actionEvent)
    {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);


        int flag_Exception = 0;
        String material = menu_material_water_bore_actual.getItems().get(0).getText();
        String vendor = menu_vendor_water_bore_actual.getItems().get(0).getText();
        int price = Integer.parseInt(txtfld_price_water_bore_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Water_Bore";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";

        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_water_bore_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_water_bore_actual.setText("Entry added Successfully");
                btn_add_water_bore_actual.setDisable(true);
            }
        }
    }

    public void btn_add_digging_material_clicked(ActionEvent actionEvent)
    {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String material = menu_material_digging_actual.getText();
        String vendor = menu_vendor_digging_actual.getText();
        int price = Integer.parseInt(txtfld_price_digging_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Digging";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_digging_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_digging_actual.setText("Entry added Successfully");
                btn_add_digging_actual.setDisable(true);
            }
        }
    }

    public void btn_add_pillar_laying_material_clicked(ActionEvent actionEvent)
    {

        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String material = menu_material_pillar_laying_actual.getText();
        String vendor = menu_vendor_pillar_laying_actual.getText();
        int price = Integer.parseInt(txtfld_price_pillar_laying_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Pillar_Laying";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";

        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_pillar_laying_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_pillar_laying_actual.setText("Entry added Successfully");
                btn_add_pillar_laying_actual.setDisable(true);
            }
        }
    }


    public void btn_add_slab_material_clicked(ActionEvent actionEvent)
    {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String material = menu_material_slab_actual.getText();
        String vendor = menu_vendor_slab_actual.getText();
        int price = Integer.parseInt(txtfld_price_slab_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Slab";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";

        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_slab_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_slab_actual.setText("Entry added Successfully");
                btn_add_slab_actual.setDisable(true);
            }
        }
    }

    public void btn_add_walls_material_clicked(ActionEvent actionEvent)
    {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String material = menu_material_walls_actual.getText();
        String vendor = menu_vendor_walls_actual.getText();
        int price = Integer.parseInt(txtfld_price_walls_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Walls";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";

        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_walls_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_walls_actual.setText("Entry added Successfully");
                btn_add_walls_actual.setDisable(true);
            }
        }
    }

    public void btn_add_flooring_material_clicked(ActionEvent actionEvent)
    {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String material = menu_material_flooring_actual.getText();
        String vendor = menu_vendor_flooring_actual.getText();
        int price = Integer.parseInt(txtfld_price_flooring_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Flooring";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";

        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_flooring_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_flooring_actual.setText("Entry added Successfully");
                btn_add_flooring_actual.setDisable(true);
            }
        }
    }

    public void btn_add_painting_material_clicked(ActionEvent actionEvent)
    {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String material = menu_material_painting_actual.getText();
        String vendor = menu_vendor_painting_actual.getText();
        int price = Integer.parseInt(txtfld_price_painting_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Painting";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";

        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_painting_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_painting_actual.setText("Entry added Successfully");
                btn_add_painting_actual.setDisable(true);
            }
        }
    }

    public void btn_add_plumbing_material_clicked(ActionEvent actionEvent)
    {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String material = menu_material_plumbing_actual.getText();
        String vendor = menu_vendor_plumbing_actual.getText();
        int price = Integer.parseInt(txtfld_price_plumbing_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Plumbing";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";

        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_plumbing_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_plumbing_actual.setText("Entry added Successfully");
                btn_add_plumbing_actual.setDisable(true);
            }
        }
    }

    public void btn_add_electricity_material_clicked(ActionEvent actionEvent)
    {
        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        int flag_Exception = 0;
        String material = menu_material_electricity_actual.getText();
        String vendor = menu_vendor_electricity_actual.getText();
        int price = Integer.parseInt(txtfld_price_electricity_actual.getText());
        String project_name = Main.Project_Name;
        String sub_phase = "Electricity";

        String sql = "INSERT INTO ACTUAL(Material, Vendor, Price, Project_Name, Sub_Phase) VALUES (?,?,?,?,?)";

        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1,material);
            ps.setString(2,vendor);
            ps.setInt(3,price);
            ps.setString(4,project_name);
            ps.setString(5, sub_phase);

            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            flag_Exception=1;
            label_status_electricity_actual.setText("Error Occured, try again!");
        }
        finally {
            if (flag_Exception == 0) {
                label_status_electricity_actual.setText("Entry added Successfully");
                btn_add_electricity_actual.setDisable(true);
            }
        }
    }

    public void tglBtn_FoundationPhase_clicked(ActionEvent actionEvent) {

        if(tglBtn_FoundationPhase.isSelected()){
            current_pane.setVisible(false);
            scrlpane_FoundationPhase.setVisible(true);
            current_pane=scrlpane_FoundationPhase;
            if(phase1_Foundation){
                //anchorPane_FoundationPhase.setDisable(true);
                //disable all the active elements present in this phase. i.e., text fields, update info kind of things.
            }
        }
        else if(tglBtn_InteriorBuildingPhase.isSelected()){
            current_pane.setVisible(false);
            scrlpane_Interior_Building_Phase.setVisible(true);
            current_pane=scrlpane_Interior_Building_Phase;
            if(phase1_Foundation){
                //anchorPane_FoundationPhase.setDisable(true);
                //disable all the active elements present in this phase. i.e., text fields, update info kind of things.
            }
        }
        else if(tglBtn_ShellBuildingPhase.isSelected()){
            current_pane.setVisible(false);
            scrlpane_Shell_Building_Phase.setVisible(true);
            current_pane=scrlpane_Shell_Building_Phase;
            if(phase1_Foundation){
                //anchorPane_FoundationPhase.setDisable(true);
                //disable all the active elements present in this phase. i.e., text fields, update info kind of things.
            }
        }
        else if(tglBtn_DesignPhase.isSelected()){
            current_pane.setVisible(false);
            scrlpane_Design_Phase.setVisible(true);
            current_pane=scrlpane_Design_Phase;
            if(phase1_Foundation){
                //anchorPane_FoundationPhase.setDisable(true);
                //disable all the active elements present in this phase. i.e., text fields, update info kind of things.
            }
        }
    }

    public void menu_material_water_bore_actual_Clicked(ActionEvent actionEvent) {

        menu_vendor_water_bore_actual.setDisable(false);
        txtfld_price_water_bore_actual.setDisable(false);
        btn_add_water_bore_actual.setDisable(false);



        dbConn = new ConnectionClass();
        Connection connection = dbConn.getConnection(dbName);

        ObservableList<String> materials_list = FXCollections.observableArrayList();
        ResultSet rs;
        try
        {
            rs = connection.createStatement().executeQuery("SELECT Vendor_Name FROM Vendor_Details WHERE Material = '" + menu_material_water_bore_actual.getItems().get(0).getText()+ "'");
            while(rs.next())
            {
                materials_list.add(rs.getString(1));
                MenuItem mi = new MenuItem(rs.getString(1));
                menu_vendor_water_bore_actual.getItems().add(mi);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Database error occured");
        }

    }
}
