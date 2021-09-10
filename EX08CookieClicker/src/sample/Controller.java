package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {

    private int cookies = 0;
    private int cursors = 1;
    private int clickers = 0;
    private int grannys = 0;
    private int cursorPrice = 10;
    private int clickerPrice = 50;
    private int grannyPrice = 100;
    private Timeline clickerTimer;
    private Timeline grannyTimer;
    private InnerShadow innerShadow = new InnerShadow();
    private Bloom bloom = new Bloom();

    private static final int INFO_CORDS = 200;
    private static final int CURSOR_PRICE_INCREASE = 10;
    private static final int CLICKER_PRICE_INCREASE = 50;
    private static final int GRANNY_PRICE_INCREASE = 100;
    private static final int MAX_ITEM_COUNT_TO_GET_BONUS = 41;
    private static final int SEC_TO_MILLI = 100;
    private static final int START_TIME = 5000;
    private static final int FIRST_ITEM_MINUS = 1;
    private static final int CLICKER_MULTIPLIER = 1;
    private static final int GRANNY_MULTIPLIER = 2;
    private static final int FONT_SIZE = 30;
    private static final int LABEL_X_CORD = 22;
    private static final int LABEL_Y_CORD = 45;
    private static final int UNFOCUSED_OPACITY = 0;
    private static final int FOCUSED_OPACITY = 1;
    private static final double FT_DURATION = 1.5;
    private static final int TL_DURATION = 2;
    private static final int TL_FINAL_Y = 300;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane MainBack;

    @FXML
    private ImageView CookieClickOnMe;

    @FXML
    private Label Cookies;

    @FXML
    private Button BuyCursorButton;

    @FXML
    private Button BuyClickerButton;

    @FXML
    private Button BuyGrannyButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button InfoButton;

    @FXML
    private Label CursorPrice;

    @FXML
    private Label ClickerPrice;

    @FXML
    private Label GrannyPrice;

    @FXML
    private Label CursorCount;

    @FXML
    private Label ClickerCount;

    @FXML
    private Label GrannysCount;

    @FXML
    void Exit(ActionEvent event) {
        MainBack.getScene().getWindow().hide();
    }

    @FXML
    void ExitFocus(MouseEvent event) {
        ExitButton.setEffect(bloom);
    }

    @FXML
    void ExitUnfocus(MouseEvent event) {
        ExitButton.setEffect(null);
    }

    @FXML
    void InfoMenu(ActionEvent event) {
        Alert infoBox = new Alert(Alert.AlertType.INFORMATION);
        infoBox.setHeaderText("Created by kwaper");
        infoBox.setContentText("TalTech 2019\nIAIB21");
        infoBox.setResizable(false);
        infoBox.initStyle(StageStyle.TRANSPARENT);
        infoBox.setX(MainBack.getScene().getWindow().getX() + INFO_CORDS);
        infoBox.setY(MainBack.getScene().getWindow().getY() + INFO_CORDS);
        infoBox.show();
    }

    @FXML
    void InfoFocus(MouseEvent event) {
        InfoButton.setEffect(innerShadow);
    }

    @FXML
    void InfoUnfocus(MouseEvent event) {
        InfoButton.setEffect(null);
    }

    @FXML
    void BuyCursor(ActionEvent event) {
        if (this.cookies >= cursorPrice) {
            this.cookies -= cursorPrice;
            this.cursorPrice = Math.round(cursorPrice + CURSOR_PRICE_INCREASE);
            this.cursors++;
            buttonRefresher();
            CursorCount.setText("Cursors : " + cursors);
            CursorPrice.setText(String.valueOf(cursorPrice));
            Cookies.setText(String.valueOf(cookies));
        }
    }

    @FXML
    void BuyCursorFocus(MouseEvent event) {
        BuyCursorButton.setEffect(innerShadow);
    }

    @FXML
    void BuyCursorUnfocus(MouseEvent event) {
        BuyCursorButton.setEffect(null);
    }


    @FXML
    void BuyClicker(ActionEvent event) {
        if (this.cookies >= clickerPrice) {
            this.cookies -= clickerPrice;
            this.clickers++;
            this.clickerPrice += CLICKER_PRICE_INCREASE;
            if (clickers <= MAX_ITEM_COUNT_TO_GET_BONUS) {
                int time = START_TIME - ((clickers - FIRST_ITEM_MINUS) * SEC_TO_MILLI);
                setTimer(Duration.millis(time), CLICKER_MULTIPLIER);
            }
            buttonRefresher();
            ClickerPrice.setText(String.valueOf(clickerPrice));
            ClickerCount.setText("Clickers : " + clickers);
            Cookies.setText(String.valueOf(cookies));
        }
    }

    @FXML
    void BuyClickerFocus(MouseEvent event) {
        BuyClickerButton.setEffect(innerShadow);
    }

    @FXML
    void BuyClickerUnfocus(MouseEvent event) {
        BuyClickerButton.setEffect(null);
    }

    @FXML
    void BuyGranny(ActionEvent event) {
        if (this.cookies >= grannyPrice) {
            this.cookies -= grannyPrice;
            this.grannys++;
            this.grannyPrice += GRANNY_PRICE_INCREASE;
            if (grannys <= MAX_ITEM_COUNT_TO_GET_BONUS) {
                int time = START_TIME - ((grannys - FIRST_ITEM_MINUS) * SEC_TO_MILLI);
                setTimer(Duration.millis(time), GRANNY_MULTIPLIER);
            }
            buttonRefresher();
            GrannyPrice.setText(String.valueOf(grannyPrice));
            GrannysCount.setText("Grannys : " + grannys);
            Cookies.setText(String.valueOf(cookies));
        }
    }

    @FXML
    void BuyGrannyFocus(MouseEvent event) {
        BuyGrannyButton.setEffect(innerShadow);
    }

    @FXML
    void BuyGrannyUnfocus(MouseEvent event) {
        BuyGrannyButton.setEffect(null);
    }

    private void setTimer(Duration x, int i) {
        Timeline time = new Timeline();
        time.setCycleCount(Animation.INDEFINITE);
        KeyFrame kf = new KeyFrame(x, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cookies += cursors * i;
                buttonRefresher();
                Cookies.setText(String.valueOf(cookies));
            }
        });
        if (i == CLICKER_MULTIPLIER && clickerTimer == null) {
            time.getKeyFrames().add(kf);
            clickerTimer = time;
            clickerTimer.playFromStart();
        } else if (i == CLICKER_MULTIPLIER) {
            clickerTimer.stop();
            time.getKeyFrames().add(kf);
            clickerTimer = time;
            clickerTimer.playFromStart();
        }
        if (i == GRANNY_MULTIPLIER && grannyTimer == null) {
            time.getKeyFrames().add(kf);
            grannyTimer = time;
            grannyTimer.playFromStart();
        } else if (i == GRANNY_MULTIPLIER) {
            grannyTimer.stop();
            time.getKeyFrames().add(kf);
            grannyTimer = time;
            grannyTimer.playFromStart();
        }
    }

    @FXML
    void CookieMousePressed(MouseEvent event) {
        Image newCookie = new Image("sample/Broken.png");
        CookieClickOnMe.setImage(newCookie);
    }


    @FXML
    void CookieMouseReleased(MouseEvent event) {
        Image newCookie = new Image("sample/cookie.png");
        CookieClickOnMe.setImage(newCookie);
        cookies += cursors;
        Cookies.setText(String.valueOf(cookies));
        buttonRefresher();
        Label l = new Label("+" + Math.round(cursors));
        l.setTextFill(Color.BEIGE);
        Font f = new Font("System Bold", FONT_SIZE);
        l.setFont(f);
        l.setLayoutX(event.getSceneX() - LABEL_X_CORD);
        l.setLayoutY(event.getSceneY() - LABEL_Y_CORD);
        animation(l);
    }


    private void buttonRefresher() {
        if (cookies >= cursorPrice) {
            BuyCursorButton.setOpacity(FOCUSED_OPACITY);
        } else BuyCursorButton.setOpacity(UNFOCUSED_OPACITY);
        if (cookies >= clickerPrice) {
            BuyClickerButton.setOpacity(FOCUSED_OPACITY);
        } else BuyClickerButton.setOpacity(UNFOCUSED_OPACITY);
        if (cookies >= grannyPrice) {
            BuyGrannyButton.setOpacity(FOCUSED_OPACITY);
        } else BuyGrannyButton.setOpacity(UNFOCUSED_OPACITY);
    }


    private void animation(Label l) {
        Timeline tl = new Timeline();
        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.seconds(FT_DURATION));
        ft.setFromValue(FOCUSED_OPACITY);
        ft.setToValue(UNFOCUSED_OPACITY);
        ft.setNode(l);
        MainBack.getChildren().addAll(l);
        ft.play();
        tl.getKeyFrames().add(new KeyFrame(
                Duration.seconds(TL_DURATION),
                new KeyValue(l.layoutYProperty(), l.getLayoutY() - TL_FINAL_Y)
        ));
        tl.setOnFinished(event -> MainBack.getChildren().remove(l));
        tl.play();
    }

    @FXML
    void initialize() {
        Cookies.setText(String.valueOf(cookies));
        CursorCount.setText("Cursors : " + cursors);
        ClickerCount.setText("Clickers : " + clickers);
        GrannysCount.setText("Grannys : " + grannys);
        CursorPrice.setText(String.valueOf(cursorPrice));
        ClickerPrice.setText(String.valueOf(clickerPrice));
        GrannyPrice.setText(String.valueOf(grannyPrice));
        buttonRefresher();
    }
}
