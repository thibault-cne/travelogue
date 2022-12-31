package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.SceneController;

public class CommandDisplayNewTravelogueView implements Command {
    private final Receiver receiver;
    private final SceneController sceneController;

    public CommandDisplayNewTravelogueView(Receiver receiver, SceneController sceneController) {
        this.receiver = receiver;
        this.sceneController = sceneController;
    }

    @Override
    public void execute() {
        receiver.displayNewTravelogueView(sceneController);
    }
}
