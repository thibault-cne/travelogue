package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.Day;
import com.telecomnancy.eu.travelogue.FileWriter;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.viewController.FormController;
import com.telecomnancy.eu.travelogue.viewController.SceneController;
import com.telecomnancy.eu.travelogue.viewController.ViewAddFormController;
import com.telecomnancy.eu.travelogue.viewController.ViewEditFormController;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Receiver {
    public void removeDay(TravelogueController travelogueController) throws IOException {
        travelogueController.removeDay();
        travelogueController.notifyObservers();
    }

    public void nextDay(TravelogueController travelogueController) {
        travelogueController.nextDay();
        travelogueController.notifyObservers();
    }

    public void previousDay(TravelogueController travelogueController) {
        travelogueController.previousDay();
        travelogueController.notifyObservers();
    }

    public void editDay(SceneController sceneController) {
        sceneController.editDayScene();
    }

    public void addDay(SceneController sceneController) {
        sceneController.addDayScene();
    }

    public void selectPicture(Stage mainStage, FormController formController) {
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Images files", "*.jpg", "*.png", "*.gif", "*.jpeg");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(mainStage);

        if (file != null) {
            formController.setPicture(file);
        }
    }

    public void createNewDay(TravelogueController travelogueController, ViewAddFormController viewAddFormController, SceneController sceneController) throws IOException {
        // Convert date from DatePicker to Date
        Calendar c = Calendar.getInstance();
        c.setTime(travelogueController.getEndDay());
        c.add(Calendar.DATE, 1);
        Date date = c.getTime();

        // Get title and description
        String titleString = viewAddFormController.getTitle().getText();
        String descriptionString = viewAddFormController.getDescription().getText();

        // Copy picture to the project folder
        File file = viewAddFormController.getPictureFile();
        if (file == null) {
            return;
        }

        FileWriter.copyFile(file);

        travelogueController.addDay(new Day(date, titleString, descriptionString, "resources/pictures/" + file.getName()));
        travelogueController.notifyObservers();
        sceneController.mainScene();
    }

    public void saveEditDay(SceneController sceneController, TravelogueController travelogueController, ViewEditFormController viewEditFormController) throws IOException {
        // Convert date from DatePicker to Date
        LocalDate localDate = viewEditFormController.getDate().getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);

        // Get title and description
        String titleString = viewEditFormController.getTitle().getText();
        String descriptionString = viewEditFormController.getDescription().getText();

        // Copy picture to the project folder
        File file = viewEditFormController.getPictureFile();
        if (file != null) {
            FileWriter.copyFile(file);
            travelogueController.editDay(date, titleString, descriptionString, "resources/pictures/" + file.getName());
        } else {
            travelogueController.editDay(date, titleString, descriptionString);
        }

        travelogueController.notifyObservers();
        sceneController.mainScene();
    }

    public void showTravelogue(SceneController sceneController) {
        sceneController.globalScene();
    }

    public void toggleScene(SceneController sceneController) {
        sceneController.toggleScene();
    }

    public void togglePresentation(SceneController sceneController) {
        sceneController.presentationScene();
    }

    public void displaySpecificDay(SceneController sceneController, TravelogueController travelogueController, int day) {
        travelogueController.setCurrentDay(day);
        travelogueController.notifyObservers();
        sceneController.mainScene();
    }

    public void copyDay(TravelogueController travelogueController) throws IOException {
        Day dayToCopy = travelogueController.getCurrentDay();

        Calendar c = Calendar.getInstance();
        c.setTime(travelogueController.getEndDate());
        c.add(Calendar.DATE, 1);

        Day newDay = new Day(c.getTime(), dayToCopy.getTitle(), dayToCopy.getDescription(), dayToCopy.getPictureString());
        travelogueController.addDay(newDay);

        travelogueController.notifyObservers();
    }
}
