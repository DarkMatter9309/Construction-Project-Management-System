package LoginWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller
{

    public Label lbl_status;
    public TextField txtField_username;
    public PasswordField txtField_password;
    public Button btn_login;
    public Hyperlink hyp_forgotPassword;
    public Hyperlink hyp_register;

    public void btn_login_clicked(ActionEvent actionEvent) throws IOException {


        if(txtField_username.getText().equals("root")){
            if(txtField_password.getText().equals("pass")){

                Main.username = txtField_username.getText();

                Parent root = FXMLLoader.load(getClass().getResource("/HomeWindow/sample.fxml"));
                Scene scene = new Scene(root, 1000, 800);
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("Building Blocks - Home");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);

                Main.HomeStage = stage;

                Main.LoginStage.close();
                stage.show();
            }
            else{
                lbl_status.setText("Incorrect username or password");
            }
        }
        else{
            lbl_status.setText("Incorrect username or password");
        }

    }
}