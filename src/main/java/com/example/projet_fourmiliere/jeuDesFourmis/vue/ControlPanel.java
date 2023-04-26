package com.example.projet_fourmiliere.jeuDesFourmis.vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControlPanel extends VBox {
    //Attributs
    private Button Loupe;
    private Button Quit;
    private Button PlayAndPause;
    private Button Reset;
    private Button Init;
    private Button Settings;
    private Button[] Btns;

    //Constructeur
    public ControlPanel(){
        this.Loupe = new Button("Loupe");
        this.Quit = new Button("Quitter");
        this.PlayAndPause = new Button("Start");
        this.Reset = new Button("Reset");
        this.Init = new Button("Initialiser");
        this.Settings = new Button("Paramètres");

        this.Loupe.setPrefSize(80,30);
        this.Quit.setPrefSize(80,30);
        this.PlayAndPause.setPrefSize(80,30);
        this.Reset.setPrefSize(80,30);
        this.Init.setPrefSize(80,30);
        this.Settings.setPrefSize(80,30);

        //Mettre dans le tableau dans un ordre logique (comme si l'interface) pour ne pas se perdre
        this.Btns = new Button[]{this.Init, this.Loupe, this.Reset, this.PlayAndPause, this.Settings, this.Quit};

        HBox Line1 = new HBox(Init, Loupe, Reset);
        Line1.setAlignment(Pos.CENTER);
        Line1.setSpacing(10);

        HBox Line2 = new HBox(PlayAndPause, Settings, Quit);
        Line2.setAlignment(Pos.CENTER);
        Line2.setSpacing(10);

        this.getChildren().addAll(Line1, Line2);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        this.setPadding(new Insets(20));
    }
    //Méthodes
    public Button getButton(int n){
        return this.Btns[n];
    }

}
