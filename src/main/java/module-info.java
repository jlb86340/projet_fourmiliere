module com.example.projet_fourmiliere {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projet_fourmiliere.jeuDesFourmis to javafx.fxml;
    exports com.example.projet_fourmiliere.jeuDesFourmis;
    exports com.example.projet_fourmiliere.jeuDesFourmis.controller;
    opens com.example.projet_fourmiliere.jeuDesFourmis.controller to javafx.fxml;
}