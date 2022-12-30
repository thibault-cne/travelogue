package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.SceneController;

public class CommandDisplaySpecificDay implements Command {
    private final Receiver receiver;
    private final int day;
    private final SceneController sceneController;
    private final TravelogueController travelogueController;

    public CommandDisplaySpecificDay(Receiver receiver, int day, SceneController sceneController, TravelogueController travelogueController) {
        this.receiver = receiver;
        this.day = day;
        this.sceneController = sceneController;
        this.travelogueController = travelogueController;

    }

    @Override
    public void execute() {
        receiver.displaySpecificDay(sceneController, travelogueController, day);
    }
}
