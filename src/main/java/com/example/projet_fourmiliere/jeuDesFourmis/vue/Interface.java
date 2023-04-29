package com.example.projet_fourmiliere.jeuDesFourmis.vue;

import com.example.projet_fourmiliere.jeuDesFourmis.model.Fourmiliere;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Interface extends VBox {
    //Attributs
    private ControlPanel controlPanel;
    private Counter counter;
    private Fourmiliere myFourmiliere;
    private Board board;

    private HBox topPart;

    private Boolean state;

    private Settings settings;

    //Constructeur
    public Interface(Fourmiliere model){
        board = new Board(20);
        board.setPadding(new Insets(3));
        controlPanel = new ControlPanel();
        counter = new Counter();
        settings = new Settings();
        myFourmiliere = model;

        topPart = new HBox(board, counter);
        topPart.setAlignment(Pos.CENTER);
        topPart.setSpacing(20);
        topPart.setPadding(new Insets(3));
        topPart.setMinSize(topPart.getWidth(),topPart.getHeight());
        //topPart.setStyle("-fx-border-color: red");

        this.getChildren().addAll(topPart,settings,controlPanel);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }
    //Méthodes
    public ControlPanel getControlPanel(){
        return controlPanel;
    }
//    public Settings getSettings(){
//        return settings;
//    }
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

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Settings getSettings() {
        return settings;
    }

    public void detruitMur(int x, int y) {
        this.getBoard().getCell(x, y).setStyle("-fx-background-color: white");
        this.myFourmiliere.setMur(x,y,false); // peut etre qui faut mettre -1 ou +2
    }

    public void placeMur(int x, int y) {
        this.getBoard().getCell(x, y).setStyle("-fx-background-color: black");
        this.myFourmiliere.setMur(x,y,true); // peut etre qui faut mettre -1 ou +2
    }

    public void placeFourmi(int x, int y) {
        Circle Fourmi = new Circle(3, Paint.valueOf("green"));
        Fourmi.setCenterY(5);
        Fourmi.setCenterX(5);
        this.getBoard().getCell(x, y).getChildren().add(Fourmi);
        this.myFourmiliere.ajouteFourmi(x,y); // peut etre qui faut mettre -1 ou +2
    }
}
