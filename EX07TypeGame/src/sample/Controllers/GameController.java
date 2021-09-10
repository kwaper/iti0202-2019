package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameController {

    private int score = 0;
    private int time = 60;
    private int scoreMinusTime = 10;
    private List<KeyCode> needToBePressed = new ArrayList<>();
    private Map<KeyCode, Label> checker = new HashMap<>();
    final String chars = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int N = chars.length();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ScorePoints;

    @FXML
    private Label Timer;

    @FXML
    private AnchorPane GameField;

    @FXML
    private AnchorPane GameAll;

    @FXML
    private Button StopButton;

    @FXML
    private Button TimeLaps;


    @FXML
    void setFinalScene(ActionEvent event) {
        System.out.println("STOP!");
        finalScene();
    }

    private void finalScene() {
        System.out.println("Your score : " + score);
        FinalController.setScore(this.score);
        StopButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/Scenes/Final.fxml"));

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

    private int randomInt(int x) {
        Random r = new Random();
        return r.nextInt(x);
    }

    private Font getRandomSize() {
        Random r = new Random();
        return new Font("Bernard MT Condensed", r.nextInt(50) + 40);
    }

    private Color getRandomColor() {
        Random r = new Random();
        Color[] colors = {Color.RED, Color.ROSYBROWN, Color.PINK,
                Color.BLACK, Color.VIOLET, Color.ORANGE, Color.BLUEVIOLET, Color.ORANGERED,
                Color.CADETBLUE, Color.DEEPSKYBLUE};
        int x = colors.length;
        return colors[r.nextInt(x)];
    }


    public void setUniqueChar(Label l) {
        Random r = new Random();
        String x;
        x = String.valueOf(chars.charAt(r.nextInt(N)));
        if (!needToBePressed.contains(KeyCode.getKeyCode(x))) {
            l.setText(x);
        } else setUniqueChar(l);
    }

    public void addRandomChar() {
        Label charNew = new Label();


        setUniqueChar(charNew);

        needToBePressed.add(KeyCode.getKeyCode(charNew.getText()));

        checker.put(KeyCode.getKeyCode(charNew.getText()), charNew);

        charNew.setFont(getRandomSize());

        charNew.resizeRelocate(randomInt(700), randomInt(300), randomInt(1), randomInt(1));

        charNew.setTextFill(getRandomColor());

        GameField.getChildren().addAll(charNew);
    }

    public void timeOut() {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(0.5));
        tt.setNode(TimeLaps);
        tt.setToX(+349);
        tt.setAutoReverse(true);
        tt.setCycleCount(2);
        tt.play();
        tt.setOnFinished(event -> {
            time--;
            scoreMinusTime--;
            Timer.setText(String.valueOf(time));
            if (time == 0) {
                finalScene();
            } else {
                timeOut();
            }
        });
    }


    public void game() {
        GameAll.setOnKeyPressed(e -> {
            if (needToBePressed.contains(e.getCode())) {
                score += scoreMinusTime;
                scoreMinusTime = 10;
                ScorePoints.setText(String.valueOf(score));
                animation(checker.get(e.getCode()), e.getCode());
            } else {
                score -= 5;
                ScorePoints.setText(String.valueOf(score));
            }
        });
    }

    public void animation(Label x, KeyCode k) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(0.2));
        tt.setNode(x);
        tt.setToY(-20);
        tt.setAutoReverse(true);
        tt.setCycleCount(2);
        tt.play();
        tt.setOnFinished(event -> {
            GameField.getChildren().remove(checker.get(k));
            checker.remove(k);
            needToBePressed.remove(k);
            addRandomChar();
        });
    }


    @FXML
    void initialize() {
        ScorePoints.setText(String.valueOf(score));
        Timer.setText(String.valueOf(time));
        timeOut();
        addRandomChar();
        addRandomChar();
        addRandomChar();
        addRandomChar();

        game();
    }
}
