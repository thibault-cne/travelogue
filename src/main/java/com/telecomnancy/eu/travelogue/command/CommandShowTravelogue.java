package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.SceneController;

public class CommandShowTravelogue implements Command {
    private final SceneController sceneController;
    private final Receiver receiver;

    public CommandShowTravelogue(Receiver receiver,SceneController sceneController) {
        this.receiver = receiver;
        this.sceneController = sceneController;
    }

    @Override
    public void execute() {
        receiver.showTravelogue(sceneController);
    }
}
