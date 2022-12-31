package com.telecomnancy.eu.travelogue;

import com.telecomnancy.eu.travelogue.viewController.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TravelogueApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneController sceneController = new SceneController(stage, 1280, 720);
        sceneController.show();
    }

    public static void main(String[] args) throws FileNotFoundException {
        launch();
    }
}