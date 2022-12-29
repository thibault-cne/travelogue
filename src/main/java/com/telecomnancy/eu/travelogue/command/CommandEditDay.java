package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.SceneController;

public class CommandEditDay implements Command {
    private Receiver receiver;
    private SceneController sceneController;

    public CommandEditDay(Receiver receiver, SceneController sceneController) {
        this.receiver = receiver;
        this.sceneController = sceneController;
    }

    @Override
    public void execute() {
        receiver.editDay(sceneController);
    }
}
