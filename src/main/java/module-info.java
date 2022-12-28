module com.telecomnancy.eu.travelogue {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.telecomnancy.eu.travelogue to javafx.fxml;
    exports com.telecomnancy.eu.travelogue;
}