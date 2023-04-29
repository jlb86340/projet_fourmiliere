package com.example.projet_fourmiliere.jeuDesFourmis;

import com.example.projet_fourmiliere.jeuDesFourmis.controller.Controller;
import com.example.projet_fourmiliere.jeuDesFourmis.model.Fourmi;
import com.example.projet_fourmiliere.jeuDesFourmis.model.Fourmiliere;
import com.example.projet_fourmiliere.jeuDesFourmis.vue.Interface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Fourmiliere anFourmiliere = new Fourmiliere(20,20,4);
        Interface inter = new Interface(anFourmiliere);

        Controller controller = new Controller(anFourmiliere, inter);

        Scene scene  = new Scene(inter);
        stage.setScene(scene);
        stage.show();

        stage.setMinWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        inter.autoResize(stage,inter);
    }
}