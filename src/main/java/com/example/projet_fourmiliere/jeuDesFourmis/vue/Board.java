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
    public Board(int size,int cellSize){
        super();

        //this.setGridLinesVisible(true);
        this.setMinSize(200,200);
        this.cells = new Shape[size][size];
        this.size = size;

        //Construction du plateau
        for (int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++) {
                this.cell = new Rectangle(cellSize,cellSize, Paint.valueOf("#FFFFFF"));
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
    public void setCell(Shape cell, int h, int l){
        this.cells[h][l] = cell;
        this.add(cell, h, l);
    }

    public Shape getCell(int h, int l){
        return this.cells[h][l];
    }

    public void resetCell(int h, int l){
        this.cells[h][l] = new Rectangle(10,10, Paint.valueOf("#FFFFFF"));
        this.add(this.cells[h][l], h, l);
    }

    public void resetBoard(){
        resizeBoard(this.size);
    }

    public void resizeBoard(int size){
        for(int i =0; i< size; i++){
            for(int j=0; j< size; j++){
                if(this.cells[i][j]==null) {
                    this.cell = new Rectangle(10, 10, Paint.valueOf("#FFFFFF"));
                    this.cells[i][j] = this.cell;
                    this.add(this.cell, i, j);
                }
            }
        }
    }

    public void boardZoom(int X, int Y){ // X et Y represente respectivement getcellX/Y(mousseClicked)
//        Board board = new Board(11,29);
        for(int i =0; i< 12; i++){
            for(int j=0; j< 12; j++){
                if((X - 6 + i)<0 || (X - 6 + i)>11 || (Y - 6 + j)<0 || (Y - 6 + j)>11) {
                    this.cells[i][j]= new Rectangle(10, 10, Paint.valueOf("#000000"));
                }
                else {
                    this.cells[i][j] = this.getCell(X - 6 + i, Y - 6 + j); // cette formule dans le getCell permet d'assurer qu'on récupère
                    // bien le tableau avec pour cellule de base celle du milieu qui sera [6;6]
                }
            }
        }
        //return board;
    }
}
