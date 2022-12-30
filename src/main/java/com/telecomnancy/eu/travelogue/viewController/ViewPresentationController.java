package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.Participant;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ViewPresentationController implements Initializable, Controller {
    private final TravelogueController travelogueController;
    private final CommandController commandController;
    @FXML
    private Label author;
    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label begDate;
    @FXML
    private Label endDate;
    @FXML
    private Label participants;
    @FXML
    private Button show;

    public ViewPresentationController(TravelogueController travelogueController, CommandController commandController) {
        this.travelogueController = travelogueController;
        this.commandController = commandController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show.setOnAction(event -> commandController.showTravelogue());

        author.setText("Author : " + travelogueController.getAuthor());
        title.setText("Title : " + travelogueController.getTitle());
        description.setText("Description : " + travelogueController.getDescription());
        begDate.setText("Beginning date : " + formatDate(travelogueController.getBegDate()));
        endDate.setText("End date : " + formatDate(travelogueController.getEndDate()));
        participants.setText("Participants : " + participantsToString());
    }

    private String participantsToString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Participant> participants = travelogueController.getParticipants();
        for (int i = 0; i < participants.size(); i++) {
            sb.append(participants.get(i).toString());
            if (i != participants.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}
