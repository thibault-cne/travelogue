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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewGlobalController implements Initializable, Observer, Controller {
    private final CommandController commandController;
    private final TravelogueController travelogueController;

    @FXML
    private Button presentation;
    @FXML
    private Button toggle;
    @FXML
    private Label title;
    @FXML
    private Label nbDays;
    @FXML
    private GridPane grid;

    public ViewGlobalController(TravelogueController travelogueController, CommandController commandController) {
        this.travelogueController = travelogueController;
        this.commandController = commandController;
        travelogueController.addObserver(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggle.setOnAction(event -> commandController.toggleScene());
        presentation.setOnAction(event -> commandController.togglePresentation());

        title.setText("Title : " + travelogueController.getTitle());
        nbDays.setText("Number of days : " + travelogueController.getNbDays());

        updateGrid();
    }

    @Override
    public void react() {
        updateGrid();
    }

    private void updateGrid() {
        grid.getChildren().clear();
        int nbDays = travelogueController.getNbDays();

        for (int i = 0; i < nbDays / 4; i++) {
            grid.addRow(i);
            grid.gridLinesVisibleProperty().setValue(true);
            for (int j = 0; j < 4; j++) {
                BorderPane border = new BorderPane();
                border.setStyle("-fx-border-color: black");
                ImageView picture = new ImageView();
                picture.setFitHeight(120);
                picture.setFitWidth(120);
                picture.setPreserveRatio(true);
                picture.setImage(travelogueController.getDay(j + i * 4).getPicture());
                border.setCenter(picture);

                grid.addColumn(j, border);
            }
        }
    }
}
