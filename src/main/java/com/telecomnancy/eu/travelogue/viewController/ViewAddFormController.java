package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewAddFormController implements Initializable {
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
    private Button picture;
    @FXML
    private Button add;

    public ViewAddFormController(TravelogueController travelogueController, CommandController commandController, SceneController sceneController) {
        this.travelogueController = travelogueController;
        this.commandController = commandController;
        this.sceneController = sceneController;
        commandController.setViewAddFormController(this);
    }

    public File getPictureFile() {
        return pictureFile;
    }

    public DatePicker getDate() {
        return date;
    }

    public TextField getTitle() {
        return title;
    }

    public TextArea getDescription() {
        return description;
    }

    public void setFile(File file) {
        this.pictureFile = file;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        picture.setOnAction(event -> commandController.selectPicture((Stage)((Node) event.getSource()).getScene().getWindow()));
        add.setOnAction(event -> {
            commandController.createNewDay();
            sceneController.switchScene(0);
        });
    }
}
