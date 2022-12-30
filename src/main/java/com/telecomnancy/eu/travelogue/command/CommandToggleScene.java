package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.SceneController;

public class CommandToggleScene implements Command {
    private final Receiver receiver;
    private final SceneController sceneController;

    public CommandToggleScene(Receiver receiver, SceneController sceneController) {
        this.receiver = receiver;
        this.sceneController = sceneController;
    }

    @Override
    public void execute() {
        receiver.toggleScene(sceneController);
    }
}
