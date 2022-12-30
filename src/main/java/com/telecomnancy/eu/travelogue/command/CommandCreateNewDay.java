package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.SceneController;
import com.telecomnancy.eu.travelogue.viewController.ViewAddFormController;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;

public class CommandCreateNewDay implements Command {
    private final Receiver receiver;
    private final ViewAddFormController viewAddFormController;
    private final TravelogueController travelogueController;
    private final SceneController sceneController;

    public CommandCreateNewDay(Receiver receiver, TravelogueController travelogueController, ViewAddFormController viewAddFormController, SceneController sceneController) {
        this.receiver = receiver;
        this.travelogueController = travelogueController;
        this.viewAddFormController = viewAddFormController;
        this.sceneController = sceneController;
    }

    @Override
    public void execute() {
        try {
            receiver.createNewDay(travelogueController, viewAddFormController, sceneController);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
