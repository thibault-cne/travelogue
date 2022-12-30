package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.SceneController;
import com.telecomnancy.eu.travelogue.viewController.ViewEditFormController;

import java.io.IOException;

public class CommandSaveEditDay implements Command {
    private final Receiver receiver;
    private final SceneController sceneController;
    private final TravelogueController travelogueController;
    private final ViewEditFormController viewEditFormController;

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
