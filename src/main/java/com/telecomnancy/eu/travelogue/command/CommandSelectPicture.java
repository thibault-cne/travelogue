package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.FormControllerWithPic;
import javafx.stage.Stage;

public class CommandSelectPicture implements Command {
    Stage mainStage;
    Receiver receiver;
    FormControllerWithPic formController;

    public CommandSelectPicture(Receiver receiver, Stage mainStage, FormControllerWithPic formController) {
        this.receiver = receiver;
        this.mainStage = mainStage;
        this.formController = formController;
    }

    @Override
    public void execute() {
        receiver.selectPicture(mainStage, formController);
    }
}
