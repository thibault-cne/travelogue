package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.SceneController;

public class CommandSaveEditDay implements Command {
    private Receiver receiver;
    private SceneController sceneController;

    public CommandSaveEditDay(Receiver receiver, SceneController sceneController) {
        this.receiver = receiver;
        this.sceneController = sceneController;
    }

    @Override
    public void execute() {
        receiver.saveEditDay(sceneController);
    }
}
