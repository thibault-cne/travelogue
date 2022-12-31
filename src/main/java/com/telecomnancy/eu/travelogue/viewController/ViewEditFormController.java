package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.Day;
import com.telecomnancy.eu.travelogue.Observer;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ViewEditFormController extends FormControllerWithPic implements Initializable, Controller, Observer {
    private final CommandController commandController;
    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private ImageView previewPicture;
    @FXML
    private Button picture;
    @FXML
    private Button edit;
    @FXML
    private Button previous;

    public ViewEditFormController(TravelogueController travelogueController, CommandController commandController) {
        super(travelogueController);
        this.commandController = commandController;
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
        previous.setOnAction(event -> {
            commandController.previous();
        });

        react();
        updatePreviewPicture();
    }

    public File getPictureFile() {
        return pictureFile;
    }

    public TextField getTitle() {
        return title;
    }

    public TextArea getDescription() {
        return description;
    }

    @Override
    public void setPicture(File file) {
        pictureFile = file;
        updatePreviewPicture();
    }

    private void updatePreviewPicture() {
        Day day = travelogueController.getCurrentDay();
        if (pictureFile != null) {
            previewPicture.setImage(new Image(pictureFile.toURI().toString()));
        } else {
            previewPicture.setImage(day.getPicture());
        }
    }

    @Override
    public void react() {
        Day day = travelogueController.getCurrentDay();
        title.setText(day.getTitle());
        description.setText(day.getDescription());
        updatePreviewPicture();
    }
}
