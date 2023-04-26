package com.example.projet_fourmiliere.jeuDesFourmis.vue;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Board extends GridPane {
    //Attributs
    private Shape[][] cells;

    private int size;
    private Shape cell;
    private Circle seed;
    private Circle ant;
    //Constructeur
    public Board(int size){
        super();
        //Vérification de la taille du plateau
        if(size<20)size=20;

        //this.setGridLinesVisible(true);
        this.setMinSize(200,200);
        this.cells = new Shape[size][size];
        this.size = size;

        //Construction du plateau
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++) {
                this.cell = new Rectangle(10,10, Paint.valueOf("#FFFFFF"));
                this.cells[i][j] = this.cell;
                this.add(this.cell,i,j);
            }
        }
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-start-margin: 5");
    }
    //Méthodes
    public void setCell(Shape cell, int h, int l){
        this.cells[h][l] = cell;
        this.add(cell, h, l);
    }

    public void resetCell(int h, int l){
        this.cells[h][l] = new Rectangle(10,10, Paint.valueOf("#FFFFFF"));
        this.add(this.cells[h][l], h, l);
    }

    public void resetBoard(){
        for (int i = 0 ; i < this.size ; i++){
            for (int j = 0 ; j < this.size ; j++) {
                this.cell = new Rectangle(10,10, Paint.valueOf("#FFFFFF"));
                this.cells[i][j] = this.cell;
                this.add(this.cell,i,j);
            }
        }
    }
}
