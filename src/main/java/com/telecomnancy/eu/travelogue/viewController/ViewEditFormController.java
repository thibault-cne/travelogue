package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.Day;
import com.telecomnancy.eu.travelogue.Observer;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewEditFormController implements Initializable, Controller, FormController, Observer {
    private TravelogueController travelogueController;
    private CommandController commandController;
    private SceneController sceneController;
    private File pictureFile;
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

    public DatePicker getDate() {
        return date;
    }

    public TextField getTitle() {
        return title;
    }

    public TextArea getDescription() {
        return description;
    }

    public ViewEditFormController(TravelogueController travelogueController, CommandController commandController, SceneController sceneController) {
        this.travelogueController = travelogueController;
        this.commandController = commandController;
        this.sceneController = sceneController;
        commandController.setViewEditFormController(this);
        travelogueController.addObserver(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        edit.setOnAction(event -> {
            commandController.saveEditDay();
        });
        picture.setOnAction(event -> {
            commandController.selectPicture((Stage) ((Node) event.getSource()).getScene().getWindow(), this);
        });

        setState();
    }

    @Override
    public void setPicture(File file) {
        this.pictureFile = file;
    }

    public File getPictureFile() {
        return pictureFile;
    }

    @Override
    public void react() {
        setState();
    }

    private void setState() {
        Day day = travelogueController.getCurrentDay();
        date.setValue(day.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
        title.setText(day.getTitle());
        description.setText(day.getDescription());
        oldPicture.setImage(day.getPicture());
        pictureFile = null;
    }
}
