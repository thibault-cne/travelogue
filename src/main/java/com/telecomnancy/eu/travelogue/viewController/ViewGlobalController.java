package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.observer.Observer;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URISyntaxException;
import java.net.URL;
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
    @FXML
    private Button addDay;

    public ViewGlobalController(TravelogueController travelogueController, CommandController commandController) {
        this.travelogueController = travelogueController;
        this.commandController = commandController;
        travelogueController.addObserver(this);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        toggle.setOnAction(event -> commandController.toggleScene());
        presentation.setOnAction(event -> commandController.togglePresentation());
        addDay.setOnAction(event -> commandController.addDay());

        react();
    }

    @Override
    public void react() {
        title.setText("Title : " + travelogueController.getTitle());
        nbDays.setText("Number of days : " + travelogueController.getNbDays());
        updateGrid();
    }

    private void updateGrid() {
        grid.getChildren().clear();
        grid.setHgap(10);
        grid.setVgap(10);
        int nbDays = travelogueController.getNbDays();

        for (int i = 0; i < (nbDays / 4) + 1; i++) {
            grid.addRow(i);
            for (int j = 0; j < 4; j++) {
                int index = j + i * 4;

                if (index >= nbDays) {
                    break;
                }
                Button btn = new Button();
                btn.setOnAction(event -> commandController.displaySpecificDay(index));

                btn.setStyle("-fx-background-fill: black, white; -fx-background-insets: 0, 0 1 1 0;");
                btn.setPrefWidth(120);
                btn.setPrefHeight(120);
                ImageView picture = new ImageView();
                picture.setFitHeight(120);
                picture.setFitWidth(120);
                picture.setPreserveRatio(true);
                try {
                    picture.setImage(travelogueController.getDay(index).getPicture());
                } catch (URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                btn.setGraphic(picture);

                grid.addColumn(j, btn);
            }
        }
    }
}
