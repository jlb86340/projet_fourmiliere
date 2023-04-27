package com.example.projet_fourmiliere.jeuDesFourmis.vue;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

//Cette partie est consacrée aux changements de paramètres de la fourmilière
//Taille du plateau
//capacité des cases
//vitesse de simulation
public class Settings extends GridPane {
    //Attributs
    private Slider vitSimulation;
    private TextField taillePlatJeu;
    private TextField capaCases;


    //Constructeur
    public Settings(){

        super();

        Label textTaillePlateau = new Label("Taille du plateau : ");
        Label textCapaCases = new Label("Capacité des cases : ");
        Label textVitesseSimu = new Label("Vitesse : ");

        vitSimulation = new Slider(0.5, 4, 0.25);
        vitSimulation.setShowTickMarks(true);
        vitSimulation.setShowTickLabels(true);

        taillePlatJeu = new TextField();
        capaCases = new TextField();

        taillePlatJeu.setMaxSize(30,30);
        capaCases.setMaxSize(30,30);

        this.addColumn(0,textTaillePlateau,textCapaCases,textVitesseSimu);
        this.addColumn(1, taillePlatJeu, capaCases, vitSimulation);

        this.setAlignment(Pos.CENTER);
    }
    //Méthodes
    public Slider getVitSimulation() {
        return vitSimulation;
    }

    public void setVitSimulation(Slider vitSimulation) {
        this.vitSimulation = vitSimulation;
    }

    public TextField getTaillePlatJeu() {
        return taillePlatJeu;
    }

    public void setTaillePlatJeu(TextField taillePlatJeu) {
        this.taillePlatJeu = taillePlatJeu;
    }

    public TextField getCapaCases() {
        return capaCases;
    }

    public void setCapaCases(TextField capaCases) {
        this.capaCases = capaCases;
    }
}
