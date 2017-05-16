package ru.time2store.dmath;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;


public class Controller {

    String string;

    @FXML
    private TextField textField;

    @FXML
    private TextArea textArea;

    @FXML
    public void generate (ActionEvent actionEvent) {
        string = textArea.getText();
        textArea.setText(string);
    }

}
