package ru.time2store.dmath;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class frame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Controller.fxml"));
        primaryStage.setTitle("Лабораторная работа по Дискретной математике №4");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
