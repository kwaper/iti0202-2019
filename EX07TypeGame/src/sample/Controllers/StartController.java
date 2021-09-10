package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button StartButton;


    @FXML
    void SetGameScene(ActionEvent event) {
        System.out.println("START!");
        StartButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Scenes/Game.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot(); // путь к файлу загрузки
        Stage stage = new Stage();
        stage.setTitle("TypeGame created by kwaper");
        stage.setScene(new Scene(root));
        stage.show();


    }

    @FXML
    void initialize() {


    }
}
