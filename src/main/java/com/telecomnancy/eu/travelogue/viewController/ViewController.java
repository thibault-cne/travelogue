package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.Day;
import com.telecomnancy.eu.travelogue.observer.Observer;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable, Observer, Controller {
    private final TravelogueController travelogueController;
    private final CommandController commandController;
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
    private Button toggle;
    @FXML
    private Label title;
    @FXML
    private ImageView picture;
    @FXML
    private Label description;
    @FXML
    private Button presentation;
    @FXML
    private Button copyDay;

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
        toggle.setOnAction(event -> commandController.toggleScene());
        presentation.setOnAction(event -> commandController.togglePresentation());
        copyDay.setOnAction(event -> commandController.copyDay());

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
            try {
                picture.setImage(day.getPicture());
            } catch (URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}