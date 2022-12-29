package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.SceneController;

public class CommandAddDay implements Command {
    private Receiver receiver;
    private SceneController sceneController;

    public CommandAddDay(Receiver receiver, SceneController sceneController) {
        this.receiver = receiver;
        this.sceneController = sceneController;
    }

    @Override
    public void execute() {
        receiver.addDay(sceneController);
    }
}
