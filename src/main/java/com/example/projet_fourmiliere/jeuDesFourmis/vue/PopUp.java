package com.example.projet_fourmiliere.jeuDesFourmis.vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import src.exam2023.question3.Spring;

public class PopUp extends VBox {

    private Button Oui;
    private Button ANNULER;
    private Label message;

    private HBox hb;

    public PopUp(String message){
        super();
        this.Oui = new Button("Oui");
        this.ANNULER = new Button("Annuler");
        this.hb = new HBox();
        Spring sp = new Spring();
        this.hb.getChildren().addAll(this.Oui,sp,this.ANNULER);
        this.message = new Label(message);
        super.getChildren().addAll(this.message,this.hb);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(15);
        super.setPadding(new Insets(15));
    }

    public Button getOui() {
        return Oui;
    }

    public Button getANNULER() {
        return ANNULER;
    }
}
