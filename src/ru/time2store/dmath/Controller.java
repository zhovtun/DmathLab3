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
    MyArray array = new MyArray();


    @FXML
    private TextField textField;

    @FXML
    Label qString;

    @FXML
    private TextArea textArea;

    @FXML
    public void generate(ActionEvent actionEvent) {
        array.setArray(textField.getText(), "123");
        array.lexSort(textArea);
        qString.setText("" + array.fatctorial());
    }

}
