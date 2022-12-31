module com.telecomnancy.eu.travelogue {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports com.telecomnancy.eu.travelogue;
    exports com.telecomnancy.eu.travelogue.command;
    exports com.telecomnancy.eu.travelogue.viewController;
    exports com.telecomnancy.eu.travelogue.io;
    exports com.telecomnancy.eu.travelogue.observer;

    opens com.telecomnancy.eu.travelogue.io to com.google.gson, javafx.fxml;
    opens com.telecomnancy.eu.travelogue to com.google.gson, javafx.fxml;
    opens com.telecomnancy.eu.travelogue.command to com.google.gson, javafx.fxml;
    opens com.telecomnancy.eu.travelogue.viewController to com.google.gson, javafx.fxml;
}