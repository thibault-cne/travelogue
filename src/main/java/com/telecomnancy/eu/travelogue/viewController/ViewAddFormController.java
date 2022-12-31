package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.Day;
import com.telecomnancy.eu.travelogue.Observer;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAddFormController extends FormControllerWithPic implements Initializable, Controller, Observer {
    private final CommandController commandController;
    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private Button picture;
    @FXML
    private ImageView previewPicture;
    @FXML
    private Button add;
    @FXML
    private Button previous;

    public ViewAddFormController(TravelogueController travelogueController, CommandController commandController) {
        super(travelogueController);
        this.commandController = commandController;
        commandController.setViewAddFormController(this);
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
    public void initialize(URL location, ResourceBundle resources) {
        picture.setOnAction(event -> commandController.selectPicture((Stage)((Node) event.getSource()).getScene().getWindow(), this));
        add.setOnAction(event -> commandController.createNewDay());
        previous.setOnAction(event -> commandController.previous());

        react();
    }

    @Override
    public void react() {
        if (pictureFile != null) {
            previewPicture.setImage(new Image(pictureFile.toURI().toString()));
        } else {
            previewPicture.setImage(Day.getDefaultPicture());
        }
    }

    @Override
    public void setPicture(File picture) {
        pictureFile = picture;
        react();
    }
}
