package com.example.projet_fourmiliere.jeuDesFourmis.controller;

import com.example.projet_fourmiliere.jeuDesFourmis.model.Fourmi;
import com.example.projet_fourmiliere.jeuDesFourmis.vue.Board;
import com.example.projet_fourmiliere.jeuDesFourmis.vue.Interface;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
    //Attributs
    private Fourmi myFourmi;
    private Interface myInterface;

    private static ImageView imageView;
    //Constructeur
    public Controller(Fourmi fourmi, Interface anInterface){
        myFourmi = fourmi;
        myInterface = anInterface;

        //Abonnements
        //Du bouton play/pause
        //Bouton loupe
        myInterface.getControlPanel().getButton(1).addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent->{
            Stage secondStage = new Stage();
            Board board = myInterface.getBoard();
            SnapshotParameters parameters = new SnapshotParameters();
            parameters.setFill(Color.TRANSPARENT);
            WritableImage image = board.snapshot(parameters, null);

            //Pour pouvoir zoomer un gridpane, on va devoir l'exploiter sous forme d'image
            imageView = new ImageView(image);
            //Les dimensions de l'image zoomé
            imageView.setFitWidth(330);
            imageView.setFitHeight(330);

            //SI on clique sur un endroit dans le terrain
            myInterface.getBoard().setOnMouseClicked(mouseEvent -> {
                //On veux un zoom *11 sur l'endroit cliqué
                double zoom = 11.0;
                double centerX = mouseEvent.getX();
                double centerY = mouseEvent.getY();
                if (imageView != null){
                    double newWidth = imageView.getBoundsInParent().getWidth() / zoom;
                    double newHeight = imageView.getBoundsInParent().getHeight() / zoom;
                    double newX = centerX - (newWidth / 2.0);
                    double newY = centerY - (newHeight / 2.0);
                    Rectangle2D zoomRect = new Rectangle2D(newX,newY,newWidth,newHeight);

                    imageView.setViewport(zoomRect);
                }
            });
            Scene scene = new Scene(new StackPane(imageView), 330,330);
            secondStage.setScene(scene);
            secondStage.show();

        });
        //Changement de terrain
        //Boutton quit
        myInterface.getControlPanel().getButton(5).addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent->{
            Platform.exit();
        });
    }
    //Méthodes
}
