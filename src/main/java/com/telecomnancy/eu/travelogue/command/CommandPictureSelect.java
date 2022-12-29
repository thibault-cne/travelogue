package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.ViewAddFormController;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CommandPictureSelect implements Command {
    Stage mainStage;
    Receiver receiver;
    ViewAddFormController viewAddFormController;

    public CommandPictureSelect(Receiver receiver, Stage mainStage, ViewAddFormController viewAddFormController) {
        this.receiver = receiver;
        this.mainStage = mainStage;
        this.viewAddFormController = viewAddFormController;
    }

    @Override
    public void execute() {
        receiver.selectPicture(mainStage, viewAddFormController);
    }
}
