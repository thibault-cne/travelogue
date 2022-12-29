package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.viewController.FormController;
import com.telecomnancy.eu.travelogue.viewController.ViewAddFormController;
import javafx.stage.Stage;

public class CommandSelectPicture implements Command {
    Stage mainStage;
    Receiver receiver;
    FormController formController;

    public CommandSelectPicture(Receiver receiver, Stage mainStage, FormController formController) {
        this.receiver = receiver;
        this.mainStage = mainStage;
        this.formController = formController;
    }

    @Override
    public void execute() {
        receiver.selectPicture(mainStage, formController);
    }
}
