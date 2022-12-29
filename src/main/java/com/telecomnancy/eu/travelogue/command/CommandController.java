package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.FormController;
import com.telecomnancy.eu.travelogue.viewController.SceneController;
import com.telecomnancy.eu.travelogue.viewController.ViewAddFormController;
import com.telecomnancy.eu.travelogue.viewController.ViewEditFormController;
import javafx.stage.Stage;

public class CommandController {
    private Invoker invoker;
    private Receiver receiver;
    private TravelogueController travelogueController;
    private ViewAddFormController viewAddFormController;
    private SceneController sceneController;
    private ViewEditFormController viewEditFormController;

    public CommandController(TravelogueController travelogueController, SceneController sceneController) {
        this.invoker = new Invoker();
        this.receiver = new Receiver();
        this.travelogueController = travelogueController;
        this.sceneController = sceneController;
    }

    public void setViewAddFormController(ViewAddFormController viewAddFormController) {
        this.viewAddFormController = viewAddFormController;
    }

    public void setViewEditFormController(ViewEditFormController viewEditFormController) {
        this.viewEditFormController = viewEditFormController;
    }

    public void removeDay() {
        Command command = new CommandRemoveDay(receiver, travelogueController);
        invoker.setCommand(command);
        invoker.executeCommand();
    }

    public void nextDay() {
        Command command = new CommandNextDay(receiver, travelogueController);
        invoker.setCommand(command);
        invoker.executeCommand();
    }

    public void previousDay() {
        Command command = new CommandPreviousDat(receiver, travelogueController);
        invoker.setCommand(command);
        invoker.executeCommand();
    }

    public void addDay() {
        Command command = new CommandAddDay(receiver, sceneController);
        invoker.setCommand(command);
        invoker.executeCommand();
    }

    public void selectPicture(Stage mainStage, FormController formController) {
        Command command = new CommandSelectPicture(receiver, mainStage, formController);
        invoker.setCommand(command);
        invoker.executeCommand();
    }

    public void createNewDay() {
        Command command = new CommandCreateNewDay(travelogueController, receiver, viewAddFormController);
        invoker.setCommand(command);
        invoker.executeCommand();
    }

    public void editDay() {
        Command command = new CommandEditDay(receiver, sceneController);
        invoker.setCommand(command);
        invoker.executeCommand();
    }

    public void saveEditDay() {
        Command command = new CommandSaveEditDay(receiver, sceneController, travelogueController, viewEditFormController);
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}
