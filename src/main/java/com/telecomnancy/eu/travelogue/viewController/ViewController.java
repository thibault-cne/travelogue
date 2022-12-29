package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.Day;
import com.telecomnancy.eu.travelogue.Observer;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable, Observer, Controller {
    private TravelogueController travelogueController;
    private CommandController commandController;
    @FXML
    private Button nextDay;
    @FXML
    private Button previousDay;
    @FXML
    private Button addDay;
    @FXML
    private Button editDay;
    @FXML
    private Button removeDay;
    @FXML
    private Label title;
    @FXML
    private ImageView picture;
    @FXML
    private Label description;


    public ViewController(TravelogueController travelogueController, CommandController commandController) {
        this.travelogueController = travelogueController;
        this.commandController = commandController;
        travelogueController.addObserver(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        removeDay.setOnAction(event -> {
            commandController.removeDay();
        });
        nextDay.setOnAction(event -> {
            commandController.nextDay();
        });
        previousDay.setOnAction(event -> {
            commandController.previousDay();
        });
        addDay.setOnAction(event -> {
            commandController.addDay();
        });
        editDay.setOnAction(event -> {
            commandController.editDay();
        });

        updatePicture();
    }

    @Override
    public void react() {
        updatePicture();
    }

    private void updatePicture() {
        Day day = travelogueController.getCurrentDay();
        if (day != null) {
            title.setText(day.getTitle());
            description.setText(day.getDescription());
            picture.setImage(day.getPicture());
        }
    }
}