package ee.taltech.iti0202.geometry.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Controller {
    private String consoleTextMessage = "";
    private String figure;
    private String color;
    private long figureSize;
    private String canvasFigureType;
    private long canvasFigureSize;
    private String canvasFigureColor;
    private boolean clearCanvas = true;

    private static final int MAX_OPACITY = 1;
    private static final double OPACITY_UNFOCUS = 0.9;
    private static final int CANVAS_MAX_W_H = 350;
    private static final double TRIANGLE_MULTIPLIER = 0.5;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuButton geometryButton;

    @FXML
    private MenuItem geometryCircle;

    @FXML
    private MenuItem geometrySquare;

    @FXML
    private MenuItem geometryTriangle;

    @FXML
    private TextField size;

    @FXML
    private Slider slider;

    @FXML
    void sizeSelect(MouseEvent event) {
        size.setText("size : " + String.valueOf(Math.round(slider.getValue())));
        figureSize = Math.round(slider.getValue());
    }

    @FXML
    private TextArea consoleArea;

    @FXML
    private Button clearButton;

    @FXML
    void clearButtonFocus(MouseEvent event) {
        clearButton.setOpacity(MAX_OPACITY);
    }

    @FXML
    void clearButtonUnfocus(MouseEvent event) {
        clearButton.setOpacity(OPACITY_UNFOCUS);
    }

    @FXML
    void clearConsole(ActionEvent event) {
        consoleTextMessage = "";
        consoleArea.setText(consoleTextMessage);
    }

    @FXML
    private MenuButton colorButton;

    @FXML
    private MenuItem colorBlue;

    @FXML
    private MenuItem colorRed;

    @FXML
    private MenuItem colorGreen;

    @FXML
    private MenuItem colorYellow;

    @FXML
    private MenuItem colorBlack;

    @FXML
    private Button confirmButton;

    @FXML
    private Canvas canvas;

    @FXML
    void confirm(ActionEvent event) {
        if (color != null && figure != null) {
            if (clearCanvas || !canvasFigureColor.equals(color) || !canvasFigureType.equals(figure)) {
                switch (figure) {
                    case "square":
                        consoleTextMessage += "Figure : " + figure + " ,number of angles : 4" + " ,color : " + color
                                + " ,figureSize : " + figureSize + ".\n";
                        break;
                    case "triangle":
                        consoleTextMessage += "Figure : " + figure + " ,number of angles : 3" + " ,color : " + color
                                + " ,figureSize : " + figureSize + ".\n";
                        break;
                    case "circle":
                        consoleTextMessage += "Figure : " + figure + " ,number of angles : 0" + " ,color : " + color
                                + " ,figureSize : " + figureSize + ".\n";
                        break;
                }
                consoleArea.setText(consoleTextMessage);
                draw(figure, color, figureSize);
                canvasFigureType = figure;
                canvasFigureColor = color;
                canvasFigureSize = figureSize;
            } else if (figureSize != canvasFigureSize) {
                consoleTextMessage += "Figure " + figure + " resized from " + canvasFigureSize
                        + " to " + figureSize + " points.\n";
                consoleArea.setText(consoleTextMessage);
                draw(figure, color, figureSize);
                canvasFigureType = figure;
                canvasFigureColor = color;
                canvasFigureSize = figureSize;
            }


        } else {
            consoleTextMessage += "Please select all parameters!\n";
            consoleArea.setText(consoleTextMessage);
        }
    }

    @FXML
    void confirmFocus(MouseEvent event) {
        confirmButton.setOpacity(MAX_OPACITY);
    }

    @FXML
    void confirmUnfocus(MouseEvent event) {
        confirmButton.setOpacity(OPACITY_UNFOCUS);
    }

    @FXML
    void selectCircle(ActionEvent event) {
        geometryButton.setText(geometryCircle.getText());
        figure = geometryButton.getText().toLowerCase();
    }

    @FXML
    void selectSquare(ActionEvent event) {
        geometryButton.setText(geometrySquare.getText());
        figure = geometryButton.getText().toLowerCase();
    }

    @FXML
    void selectTriangle(ActionEvent event) {
        geometryButton.setText(geometryTriangle.getText());
        figure = geometryButton.getText().toLowerCase();
    }

    @FXML
    void selectBlack(ActionEvent event) {
        colorButton.setText(colorBlack.getText());
        color = colorButton.getText().toLowerCase();
    }

    @FXML
    void selectBlue(ActionEvent event) {
        colorButton.setText(colorBlue.getText());
        color = colorButton.getText().toLowerCase();
    }

    @FXML
    void selectGreen(ActionEvent event) {
        colorButton.setText(colorGreen.getText());
        color = colorButton.getText().toLowerCase();
    }

    @FXML
    void selectRed(ActionEvent event) {
        colorButton.setText(colorRed.getText());
        color = colorButton.getText().toLowerCase();
    }

    @FXML
    void selectYellow(ActionEvent event) {
        colorButton.setText(colorYellow.getText());
        color = colorButton.getText().toLowerCase();
    }

    private void draw(String f, String c, long s) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, CANVAS_MAX_W_H, CANVAS_MAX_W_H);
        Color color;
        switch (c) {
            case "black":
                graphicsContext.setFill(Color.BLACK);
                graphicsContext.setStroke(Color.BLACK);
                color = Color.BLACK;
                break;
            case "blue":
                graphicsContext.setFill(Color.BLUE);
                graphicsContext.setStroke(Color.BLUE);
                color = Color.BLUE;
                break;
            case "green":
                graphicsContext.setFill(Color.GREEN);
                graphicsContext.setStroke(Color.GREEN);
                color = Color.GREEN;
                break;
            case "red":
                graphicsContext.setFill(Color.RED);
                graphicsContext.setStroke(Color.RED);
                color = Color.RED;
                break;
            case "yellow":
                graphicsContext.setFill(Color.YELLOW);
                graphicsContext.setStroke(Color.YELLOW);
                color = Color.YELLOW;
                break;
            default:
                break;
        }
        switch (f) {
            case "circle":
                graphicsContext.fillOval(0, 0, s, s);
                break;
            case "square":
                graphicsContext.fillRect(0, 0, s, s);
                graphicsContext.stroke();
                break;
            case "triangle":
                graphicsContext.beginPath();
                graphicsContext.moveTo(s * TRIANGLE_MULTIPLIER, 0);
                graphicsContext.lineTo(s, s);
                graphicsContext.lineTo(0, s);
                graphicsContext.lineTo(s * TRIANGLE_MULTIPLIER, 0);
                graphicsContext.stroke();
                break;
            default:
                break;

        }
        clearCanvas = false;
    }

    @FXML
    void initialize() {
        figureSize = Math.round(slider.getValue());
        confirmButton.setOpacity(OPACITY_UNFOCUS);
    }
}
