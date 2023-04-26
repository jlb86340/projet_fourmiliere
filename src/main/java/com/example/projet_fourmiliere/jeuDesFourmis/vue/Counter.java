package com.example.projet_fourmiliere.jeuDesFourmis.vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Counter extends VBox {
    //Attributs
    private Label labelNbSeed;
    private Label labelNbAnt;
    private Label labelNbIteration;
    private int nbSeed;
    private int nbAnt;
    private int nbIteration;

    //Constructeur
    public Counter(){
        super();

        this.labelNbSeed = new Label("Nombre de graines : " + this.nbSeed);
        this.labelNbAnt = new Label("Nombre de fourmis : " + this.nbAnt);
        this.labelNbIteration = new Label("Nombre d'itérations : " + this.nbIteration);

        this.getChildren().addAll(this.labelNbSeed, this.labelNbAnt, this.labelNbIteration);
        this.setSpacing(10);
        this.setPadding(new Insets(30));
        this.setStyle("-fx-border-color: red");
    }
    //Méthodes
}
