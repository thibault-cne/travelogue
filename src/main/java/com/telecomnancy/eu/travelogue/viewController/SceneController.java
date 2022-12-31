package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.io.JsonParser;
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
    private final Stage stage;
    private int currentScene = 0;
    private ArrayList<Integer> previousScene = new ArrayList<Integer>();

    public SceneController(Stage stage, int width, int height) throws IOException {
        this.stage = stage;

        generateScenes(width, height);

        this.stage.setTitle("Travelogue");
        presentationScene();
    }

    public void show() {
        stage.show();
    }

    private void switchScene() {
        stage.setScene(scenes.get(currentScene));
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
        ViewAddFormController viewAddFormController = new ViewAddFormController(travelogueController,
                commandController);

        // Create edit day view controller
        ViewEditFormController viewEditFormController = new ViewEditFormController(travelogueController,
                commandController);

        // Create view presentation controller
        ViewPresentationController viewPresentationController = new ViewPresentationController(travelogueController,
                commandController);

        // Create global view controller
        ViewGlobalController viewGlobalController = new ViewGlobalController(travelogueController, commandController);

        // Create new travelogue view controller
        ViewNewTravelogue viewNewTravelogue = new ViewNewTravelogue(travelogueController, commandController);

        generateView(viewController, "view.fxml", width, height);
        generateView(viewAddFormController, "addForm.fxml", width, height);
        generateView(viewEditFormController, "editForm.fxml", width, height);
        generateView(viewPresentationController, "presentationView.fxml", width, height);
        generateView(viewGlobalController, "globalView.fxml", width, height);
        generateView(viewNewTravelogue, "newTravelogue.fxml", width, height);
    }

    private void generateView(Controller controller, String fxml, int width, int height) throws IOException {
        FXMLLoader loader = new FXMLLoader(TravelogueApplication.class.getResource(fxml));
        loader.setController(controller);
        Scene scene = new Scene(loader.load(), width, height);
        scenes.add(scene);
    }

    public void mainScene() {
        previousScene.add(currentScene);
        currentScene = 0;
        switchScene();
    }

    public void addDayScene() {
        previousScene.add(currentScene);
        currentScene = 1;
        switchScene();
    }

    public void editDayScene() {
        previousScene.add(currentScene);
        currentScene = 2;
        switchScene();
    }

    public void presentationScene() {
        previousScene.add(currentScene);
        currentScene = 3;
        switchScene();
    }

    public void globalScene() {
        previousScene.add(currentScene);
        currentScene = 4;
        switchScene();
    }

    public void toggleScene() {
        previousScene.add(currentScene);
        if (currentScene == 4) {
            currentScene = 0;
        } else {
            currentScene = 4;
        }
        switchScene();
    }

    public void newTravelogueScene() {
        previousScene.add(currentScene);
        currentScene = 5;
        switchScene();
    }

    public void back() {
        if (previousScene.size() > 0) {
            cleanPreviousScene();
            currentScene = previousScene.get(previousScene.size() - 1);
            previousScene.remove(previousScene.size() - 1);
            switchScene();
        }
    }

    private void cleanPreviousScene() {
        while (previousScene.size() > 10) {
            previousScene.remove(0);
        }
    }
}
