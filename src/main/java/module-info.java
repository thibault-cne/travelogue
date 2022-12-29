module com.telecomnancy.eu.travelogue {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.telecomnancy.eu.travelogue to com.google.gson, javafx.fxml;
    exports com.telecomnancy.eu.travelogue;
}