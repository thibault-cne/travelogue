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

public class SceneController implements Controller {
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

    private void switchScene(int index) {
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

        // Create add day view controller
        ViewAddFormController viewAddFormController = new ViewAddFormController(travelogueController, commandController, this);

        // Create edit day view controller
        ViewEditFormController viewEditFormController = new ViewEditFormController(travelogueController, commandController, this);

        generateView(viewController, "view.fxml", width, height);
        generateView(viewAddFormController,"addForm.fxml", width, height);
        generateView(viewEditFormController,"editForm.fxml", width, height);
    }

    private void generateView(Controller controller, String fxml, int width, int height) throws IOException {
        FXMLLoader loader = new FXMLLoader(TravelogueApplication.class.getResource(fxml));
        loader.setController(controller);
        Scene scene = new Scene(loader.load(), width, height);
        scenes.add(scene);
    }

    public void editDayScene() {
        switchScene(2);
    }

    public void addDayScene() {
        switchScene(1);
    }

    public void mainScene() {
        switchScene(0);
    }
}
