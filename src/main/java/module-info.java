module com.telecomnancy.eu.travelogue {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.telecomnancy.eu.travelogue to com.google.gson, javafx.fxml;
    exports com.telecomnancy.eu.travelogue;
    exports com.telecomnancy.eu.travelogue.command;
    opens com.telecomnancy.eu.travelogue.command to com.google.gson, javafx.fxml;
    exports com.telecomnancy.eu.travelogue.viewController;
    opens com.telecomnancy.eu.travelogue.viewController to com.google.gson, javafx.fxml;
}