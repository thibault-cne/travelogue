package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ViewNewTravelogue implements Controller, Initializable {
    private final TravelogueController travelogueController;
    private final CommandController commandController;
    @FXML
    private DatePicker begDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private TextField author;
    @FXML
    private TextField participants;
    @FXML
    private Button create;
    @FXML
    private Button previous;

    private final Callback<DatePicker, DateCell> dayCellFactoryBeg =
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);

                            if (item.isAfter(
                                    endDate.getValue().minusDays(1))
                            ) {
                                setDisable(true);
                                setStyle("-fx-background-color: #ffc0cb;");
                            }
                        }
                    };
                }
            };
    private final Callback<DatePicker, DateCell> dayCellFactoryEnd =
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);

                            if (item.isBefore(
                                    begDate.getValue().plusDays(1))
                            ) {
                                setDisable(true);
                                setStyle("-fx-background-color: #ffc0cb;");
                            }
                        }
                    };
                }
            };

    public ViewNewTravelogue(TravelogueController travelogueController, CommandController commandController) {
        this.travelogueController = travelogueController;
        this.commandController = commandController;
    }

    public LocalDate getBegDate() {
        return begDate.getValue();
    }

    public LocalDate getEndDate() {
        return endDate.getValue();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public String getParticipants() {
        return participants.getText();
    }

    public ArrayList<String> parseParticipants() {
        ArrayList<String> participants = new ArrayList<>();
        String[] participantsArray = getParticipants().split(",");
        for (String participant : participantsArray) {
            participants.add(participant.trim());
        }
        return participants;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        create.setOnAction(event -> commandController.createTravelogue(travelogueController, this));
        previous.setOnAction(event -> commandController.previous());

        begDate.setValue(LocalDate.now());
        endDate.setValue(LocalDate.now().plusDays(1));
        begDate.setDayCellFactory(dayCellFactoryBeg);
        endDate.setDayCellFactory(dayCellFactoryEnd);
    }
}
