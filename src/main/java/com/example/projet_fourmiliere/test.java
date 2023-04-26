package com.example.projet_fourmiliere;

import com.example.projet_fourmiliere.controller.Controller;
import com.example.projet_fourmiliere.model.Fourmi;
import com.example.projet_fourmiliere.vue.Board;
import com.example.projet_fourmiliere.vue.Interface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class test extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Interface inter = new Interface();
        Fourmi anFourmi = new Fourmi();
        Controller controller = new Controller(anFourmi, inter);

        Scene scene  = new Scene(inter);
        stage.setScene(scene);
        stage.show();

        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        inter.autoResize(stage,inter);
    }
}