package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.SceneController;
import com.telecomnancy.eu.travelogue.viewController.ViewEditFormController;

import java.io.IOException;

public class CommandSaveEditDay implements Command {
    private Receiver receiver;
    private SceneController sceneController;
    private TravelogueController travelogueController;
    private ViewEditFormController viewEditFormController;

    public CommandSaveEditDay(Receiver receiver, SceneController sceneController, TravelogueController travelogueController, ViewEditFormController viewEditFormController) {
        this.receiver = receiver;
        this.sceneController = sceneController;
        this.travelogueController = travelogueController;
        this.viewEditFormController = viewEditFormController;
    }

    @Override
    public void execute() {
        try {
            receiver.saveEditDay(sceneController, travelogueController, viewEditFormController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
