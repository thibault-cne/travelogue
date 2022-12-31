package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.*;
import javafx.stage.Stage;

public class CommandController {
    private final Invoker invoker;
    private final Receiver receiver;
    private final TravelogueController travelogueController;
    private final SceneController sceneController;
    private ViewAddFormController viewAddFormController;

    private ViewEditFormController viewEditFormController;
    private ViewPresentationController viewPresentationController;

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

    public void setViewPresentationController(ViewPresentationController viewPresentationController) {
        this.viewPresentationController = viewPresentationController;
    }

    private void executeCommand(Command command) {
        invoker.setCommand(command);
        invoker.executeCommand();
    }

    public void removeDay() {
        executeCommand(new CommandRemoveDay(receiver, travelogueController));
    }

    public void nextDay() {
        executeCommand(new CommandNextDay(receiver, travelogueController));
    }

    public void previousDay() {
        executeCommand(new CommandPreviousDay(receiver, travelogueController));
    }

    public void addDay() {
        executeCommand(new CommandAddDay(receiver, sceneController));
    }

    public void selectPicture(Stage mainStage, FormControllerWithPic formController) {
        executeCommand(new CommandSelectPicture(receiver, mainStage, formController));
    }

    public void createNewDay() {
        executeCommand(new CommandCreateNewDay(receiver, travelogueController, viewAddFormController, sceneController));
    }

    public void editDay() {
        executeCommand(new CommandEditDay(receiver, sceneController));
    }

    public void saveEditDay() {
        executeCommand(new CommandSaveEditDay(receiver, sceneController, travelogueController, viewEditFormController));
    }

    public void showTravelogue() {
        executeCommand(new CommandShowTravelogue(receiver, sceneController));
    }
    public void toggleScene() {
        executeCommand(new CommandToggleScene(receiver, sceneController));
    }

    public void togglePresentation() {
        executeCommand(new CommandTogglePresentation(receiver, sceneController));
    }
    public void displaySpecificDay(int day) {
        executeCommand(new CommandDisplaySpecificDay(receiver, day, sceneController, travelogueController));
    }
    public void copyDay() {
        executeCommand(new CommandCopyDay(receiver, travelogueController));
    }

    public void createTravelogue(TravelogueController travelogueController, ViewNewTravelogue viewNewTravelogue) {
        executeCommand(new CommandNewTravelogue(receiver, travelogueController, viewNewTravelogue, sceneController));
    }
    public void newTravelogueView() {
        executeCommand(new CommandDisplayNewTravelogueView(receiver, sceneController));
    }

    public void previous() {
        executeCommand(new CommandPrevious(receiver, sceneController));
    }
}
