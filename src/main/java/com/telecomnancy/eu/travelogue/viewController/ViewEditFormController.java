package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.Day;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewEditFormController implements Initializable, Controller {
    private TravelogueController travelogueController;
    private CommandController commandController;
    private SceneController sceneController;
    @FXML
    private DatePicker date;
    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private ImageView oldPicture;
    @FXML
    private Button picture;
    @FXML
    private Button edit;

    public ViewEditFormController(TravelogueController travelogueController, CommandController commandController, SceneController sceneController) {
        this.travelogueController = travelogueController;
        this.commandController = commandController;
        this.sceneController = sceneController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        edit.setOnAction(event -> {
            commandController.saveEditDay();
        });

        Day day = travelogueController.getCurrentDay();
        date.setValue(day.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
        title.setText(day.getTitle());
        description.setText(day.getDescription());
        oldPicture.setImage(day.getPicture());
    }
}
