package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller4 implements Initializable {

    @FXML
    private Label Escore;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Escore.setText(String.valueOf(Controller2.scoree));
        Escore.setText(String.valueOf((Controller3.scoree)));
    }
}
