module com.example.projet_fourmiliere {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projet_fourmiliere to javafx.fxml;
    exports com.example.projet_fourmiliere;
}