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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FinalController {

    private static int score;

    public static void setScore(int x) {
        score = x;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ScoreFieldOnFinalScreen;

    @FXML
    private Button StartButtonFromFinal;


    @FXML
    void StartGameAgain(ActionEvent event) {
        System.out.println("START!");
        StartButtonFromFinal.getScene().getWindow().hide();
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
        stage.showAndWait();

    }

    @FXML
    void initialize() {
        ScoreFieldOnFinalScreen.setText(String.valueOf(score));

    }
}
