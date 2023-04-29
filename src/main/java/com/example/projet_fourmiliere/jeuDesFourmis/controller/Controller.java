package com.example.projet_fourmiliere.jeuDesFourmis.controller;

import com.example.projet_fourmiliere.jeuDesFourmis.model.Fourmi;
import com.example.projet_fourmiliere.jeuDesFourmis.model.Fourmiliere;
import com.example.projet_fourmiliere.jeuDesFourmis.vue.Board;
import com.example.projet_fourmiliere.jeuDesFourmis.vue.Interface;
import com.example.projet_fourmiliere.jeuDesFourmis.vue.PopUp;
import com.example.projet_fourmiliere.jeuDesFourmis.vue.Settings;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
    //Attributs
    private Fourmiliere myFourmiliere;
    private Interface myInterface;

    //Constructeur
    public Controller(Fourmiliere fourmi, Interface anInterface){
        myFourmiliere = fourmi;
        myInterface = anInterface;


        //Abonnements
        //Du bouton play/pause
        myInterface.getControlPanel().getButton(3).addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent-> {
            if(myInterface.getControlPanel().getButton(3).getText().equals("Play")){
                // activation/desactivation de composant d'après la consigne
                myInterface.getControlPanel().getButton(3).setText("Pause");
                myInterface.getBoard().setHgap(0);
                myInterface.getBoard().setVgap(0);
                myInterface.getSettings().getTaillePlatJeu().setDisable(true);
                myInterface.getSettings().getCapaCases().setDisable(true);
            }
            else if(myInterface.getControlPanel().getButton(3).getText().equals("Pause")){
                // activation/desactivation de composant d'après la consigne
                myInterface.getControlPanel().getButton(3).setText("Play");
                myInterface.getBoard().setHgap(1);
                myInterface.getBoard().setVgap(1);
                myInterface.getSettings().getTaillePlatJeu().setDisable(false);
                myInterface.getSettings().getCapaCases().setDisable(false);
            }
            else{}
        });

        //Bouton loupe
        myInterface.getControlPanel().getButton(1).addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent->{
            Stage secondStage = new Stage();
            Board board = myInterface.getBoard();

            Board imageView = new Board(11,29); // création d'un tableau de 11 par 11  // new Board(11,29)
                    // SI on clique sur un endroit dans le terrain
            myInterface.getBoard().setOnMouseClicked(mouseEvent -> {
                int X=0;
                int Y=0;
                if(myInterface.getControlPanel().getButton(3).getText().equals("Play")){
                    X = (int) (mouseEvent.getX()/10);
                    Y = (int) (mouseEvent.getY()/10);
                }
                else if(myInterface.getControlPanel().getButton(3).getText().equals("Pause")){ //obliger de differencier due au Hgap et Vgap
                    X = (int) (mouseEvent.getX()/11);
                    Y = (int) (mouseEvent.getY()/11);
                }
                imageView.boardZoom(X,Y); // normalement getX et getY mais pour l'instant il faut trouver comment réglé le OutOfBound
            });
            Scene scene = new Scene(new StackPane(imageView), 330,330);
            secondStage.setScene(scene);
            secondStage.show();
        });
        //Changement de terrain
        myInterface.getBoard().setOnMouseClicked(e -> {
            int x = (int) e.getX() / 11;
            int y = (int) e.getY() / 11;
            //placement mur
            if (myInterface.getControlPanel().getButton(3).getText().equals("Play")) {
                if (this.myFourmiliere.getMur(x, y)){
                    myInterface.detruitMur(x, y);
                }
                else if(!(this.myFourmiliere.getMur(x, y))&&!(this.myFourmiliere.contientFourmi(x,y))){
                    myInterface.placeMur(x, y);
                }
            }
        });

        //placement Fourmi
        myInterface.getBoard().setOnMouseDragged(e -> {
            int x = (int) e.getX() / 11;
            int y = (int) e.getY() / 11;
            if(e.isShiftDown()) {
                myInterface.placeFourmi(x, y);
            }
        });
        // placement graine
        myInterface.getBoard().setOnScroll(event->{
            double deltaY = event.getDeltaY();
            int x = (int) event.getX() / 11;
            int y = (int) event.getY() / 11;
            // Récupération de la couleur de fond actuelle
            Color currentColor = (Color) myInterface.getBoard().getCell(x,y).getBackground().getFills().get(0).getFill();

            // Calcul de la nouvelle couleur en fonction du défilement
            double red = currentColor.getRed() + deltaY / 100;

            // Limitation des valeurs de rouge pour éviter les dépassements
            red = Math.min(Math.max(red, 0.5), 1.0);

            // Création de la nouvelle couleur
            Color newColor = Color.color(red, 0.0, 0.0).interpolate(Color.ORANGERED, red);

            // Affectation de la nouvelle couleur de fond
            myInterface.getBoard().getCell(x,y).setStyle("-fx-background-color: " + newColor.toString().replace("0x", "#") + ";");
        });





        //Boutton quit
        myInterface.getControlPanel().getButton(5).addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent->{
            Platform.exit();
        });

        //Boutton reset
        myInterface.getControlPanel().getButton(2).addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent->{
            Stage secondStage = new Stage();
            PopUp pp= new PopUp("Êtes vous sûr de vouloir\n" +
                    "reset le plateau :");
            Scene scene = new Scene(pp);
            secondStage.setScene(scene);
            secondStage.show();
            pp.getOui().addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent2->{
                myInterface.getBoard().resetBoard();
                secondStage.close();
            });
            pp.getANNULER().addEventHandler(MouseEvent.MOUSE_CLICKED, MouseEvent3->{
                secondStage.close();
            });
        });

        // Paramètre
        myInterface.getControlPanel().getButton(4).addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, MouseEvent2->{
            String taillePlateau = myInterface.getSettings().getTaillePlatJeu().getText();
            Stage secondStage = new Stage();
            PopUp pp= new PopUp("Êtes vous sûr de vouloir\n" +
                "les changements effectuées au plateau :");
            Scene scene2 = new Scene(pp);
            secondStage.setScene(scene2);
            secondStage.show();
            pp.getOui().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, MouseEvent3->{
                myInterface.getBoard().resizeBoard(Integer.parseInt(taillePlateau));
                secondStage.close();

            });
            pp.getANNULER().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, MouseEvent3->{
                secondStage.close();
            });
        });


    }
    //Méthodes

}


