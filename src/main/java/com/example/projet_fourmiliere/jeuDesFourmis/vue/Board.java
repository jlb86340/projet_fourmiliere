package com.example.projet_fourmiliere.jeuDesFourmis.vue;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Board extends GridPane {
    //Attributs
    private Pane[][] cells;

    private int size;
    private Pane cell;
    private Circle seed;
    private Circle ant;
    //Constructeur
    public Board(int size,int cellSize){
        super();

        //this.setGridLinesVisible(true);
        this.setMinSize(200,200);
        this.cells = new Pane[size][size];
        this.size = size;

        //Construction du plateau
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++) {
                this.cell = new Pane();
                this.cell.setPrefSize(cellSize,cellSize);
                this.cell.setStyle("-fx-background-color: white");
                this.cells[i][j] = this.cell;
                this.add(this.cell,i,j);
            }
        }
        this.setAlignment(Pos.CENTER);
        this.setHgap(1);
        this.setVgap(1);
        this.setStyle("-fx-background-color: black");
    }
    public Board(int size){
        this(size,10);
        //Vérification de la taille du plateau
        if(size<20) size=20;
        resizeBoard(20);
    }
    //Méthodes
    public void setCell(Pane cell, int h, int l){
        this.cells[h][l] = cell;
        this.add(cell, h, l);
    }

    public Pane getCell(int h, int l){
        return this.cells[h][l];
    }

    public void resetCell(int h, int l){
        this.cells[h][l].setStyle("-fx-background-color: white");

    }

    public void resetBoard(){
        resizeBoard(this.size);
    }

    public void resizeBoard(int size){
        for(int i =0; i< size; i++){
            for(int j=0; j< size; j++){
                if(this.cells[i][j]==null) {
                    this.cell = new Pane();
                    this.cell.setPrefSize(10,10);
                    this.cell.setStyle("-fx-background-color: white");
                    this.cells[i][j] = this.cell;
                    this.add(this.cell, i, j);
                }
            }
        }
    }

    public void boardZoom(int X, int Y){ // X et Y represente respectivement getcellX/Y(mousseClicked)
//        Board board = new Board(11,29);
        for(int i =0; i< 11; i++){
            for(int j=0; j< 11; j++){
                if((X - 5 + i)<0 || (X - 5 + i)>11 || (Y - 5 + j)<0 || (Y - 5 + j)>11) {
                    this.cells[i][j]= new Pane();
                    this.cells[i][j].setPrefSize(10,10);
                    this.cells[i][j].setStyle("-fx-background-color: black");
                }
                else {
                    this.cells[i][j] = this.getCell(X - 5 + i, Y - 5 + j); // cette formule dans le getCell permet d'assurer qu'on récupère
                    // bien le tableau avec pour cellule de base celle du milieu qui sera [6;6]
                }
            }
        }
        //return board;
    }
}
