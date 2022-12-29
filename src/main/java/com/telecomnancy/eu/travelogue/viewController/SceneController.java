package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.JsonParser;
import com.telecomnancy.eu.travelogue.Travelogue;
import com.telecomnancy.eu.travelogue.TravelogueApplication;
import com.telecomnancy.eu.travelogue.TravelogueController;
import com.telecomnancy.eu.travelogue.command.CommandController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

import java.io.IOException;

public class SceneController {
    private ArrayList<Scene> scenes = new ArrayList<Scene>();
    private Stage stage;

    public SceneController(Stage stage, int width, int height) throws IOException {
        this.stage = stage;

        generateScenes(width, height);

        this.stage.setTitle("Travelogue");
        this.stage.setScene(scenes.get(0));
    }

    public void show() {
        stage.show();
    }

    public void switchScene(int index) {
        stage.setScene(scenes.get(index));
    }

    private void generateScenes(int width, int height) throws IOException {
        // Load travelogue from file
        JsonParser parser = new JsonParser("resources/travelogue.json");
        Travelogue travelogue = parser.getTravelogue();
        TravelogueController travelogueController = new TravelogueController(travelogue);

        // Create command controller
        CommandController commandController = new CommandController(travelogueController, this);

        // Create view controller
        ViewController viewController = new ViewController(travelogueController, commandController);

        // Load view
        FXMLLoader fxmlLoader = new FXMLLoader(TravelogueApplication.class.getResource("view.fxml"));
        fxmlLoader.setController(viewController);

        scenes.add(new Scene(fxmlLoader.load(), width, height));

        // Load add day view
        ViewAddFormController viewAddFormController = new ViewAddFormController(travelogueController, commandController, this);

        fxmlLoader = new FXMLLoader(TravelogueApplication.class.getResource("addForm.fxml"));
        fxmlLoader.setController(viewAddFormController);

        scenes.add(new Scene(fxmlLoader.load(), width, height));
    }
}
