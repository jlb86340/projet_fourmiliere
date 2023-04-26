package com.example.projet_fourmiliere.vue;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Interface extends VBox {
    //Attributs
    private ControlPanel controlPanel;
    private Counter counter;

    private Board board;

    private HBox topPart;

    private Boolean state;

    //Constructeur
    public Interface(){
        board = new Board(20);
        board.setPadding(new Insets(3));
        controlPanel = new ControlPanel();
        counter = new Counter();


        topPart = new HBox(board, counter);
        topPart.setAlignment(Pos.CENTER);
        topPart.setSpacing(20);
        topPart.setPadding(new Insets(3));
        topPart.setMinSize(topPart.getWidth(),topPart.getHeight());
        //topPart.setStyle("-fx-border-color: red");

        this.getChildren().addAll(topPart,controlPanel);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        state = false;
        this.getControlPanel().getButton(4).addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent->{
            if (state == false) {
                Settings test = new Settings();
                this.getChildren().add(1, test);
                this.setAlignment(Pos.CENTER_LEFT);
                state = true;
            } else {
                this.getChildren().remove(1);
                state = false;
            }
        });
    }
    //Méthodes
    public ControlPanel getControlPanel(){
        return controlPanel;
    }
    public Counter getCounter(){
        return counter;
    }

    public Board getBoard(){ return board; }

    public void autoResize(Stage stage, Node node) {

        ChangeListener<Bounds> listener = ((observableValue, oldValue, newValue) -> {
           if (stage.getHeight() < node.getBoundsInParent().getHeight() || stage.getWidth() < node.getBoundsInParent().getWidth()) {
               stage.sizeToScene();
               stage.setMinHeight(stage.getHeight());
           }
        });
        //"boundsInParentProperty()" renvoi les coordonnées et la taille du noeud dans son parent
        node.boundsInParentProperty().addListener(listener);
    }
}
