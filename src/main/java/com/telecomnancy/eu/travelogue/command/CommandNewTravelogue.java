package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.SceneController;
import com.telecomnancy.eu.travelogue.viewController.ViewNewTravelogue;

import java.io.IOException;

public class CommandNewTravelogue implements Command {
    private final Receiver receiver;
    private final TravelogueController travelogueController;
    private final ViewNewTravelogue viewNewTravelogue;
    private final SceneController sceneController;

    public CommandNewTravelogue(Receiver receiver, TravelogueController travelogueController, ViewNewTravelogue viewNewTravelogue, SceneController sceneController) {
        this.receiver = receiver;
        this.travelogueController = travelogueController;
        this.viewNewTravelogue = viewNewTravelogue;
        this.sceneController = sceneController;
    }

    @Override
    public void execute() {
        try {
            receiver.newTravelogue(travelogueController, viewNewTravelogue, sceneController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
