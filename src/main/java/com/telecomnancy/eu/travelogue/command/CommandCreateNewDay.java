package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.ViewAddFormController;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;

public class CommandCreateNewDay implements Command {
    private Receiver receiver;
    private ViewAddFormController viewAddFormController;
    private TravelogueController travelogueController;

    public CommandCreateNewDay(TravelogueController travelogueController, Receiver receiver, ViewAddFormController viewAddFormController) {
        this.receiver = receiver;
        this.travelogueController = travelogueController;
        this.viewAddFormController = viewAddFormController;
    }

    @Override
    public void execute() {
        try {
            receiver.createNewDay(travelogueController, viewAddFormController);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
