package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private TextField sign_username;

    @FXML
    private ToggleGroup level;

    @FXML
    private PasswordField sign_password;

    @FXML
    private TextField register_username;

    @FXML
    private AnchorPane content;

    @FXML
    private PasswordField register_password;
    @FXML
    private RadioButton easy;
    @FXML
    private RadioButton hard;

    DataBase db;

    public void register(ActionEvent actionEvent) throws SQLException {
        db.insert(register_username.getText(), register_password.getText());
    }

    public void login(ActionEvent actionEvent) throws IOException {

        int x = 0;
        ArrayList<user> users = new ArrayList<>();
        users = db.getExpenses();
        for (user u : users) {
            if (sign_username.getText().equals(u.getName())) {
                if (sign_password.getText().equals(u.getPassword())) {
                    if (!hard.isSelected()) {
                        AnchorPane pane = FXMLLoader.load(getClass().getResource("second.fxml"));
                        content.getChildren().setAll(pane);
                    }
                    if (!easy.isSelected()) {
                        AnchorPane pane = FXMLLoader.load(getClass().getResource("fjy.fxml"));
                        content.getChildren().setAll(pane);
                    }

                } else {

                    System.out.println("Worng password");
                }
            } else {
                x++;
            }
        }
        if (x == users.size()) System.out.println("user not found!!");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DataBase();
    }
}
