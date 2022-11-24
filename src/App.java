/* ************************************************************************** */
/*                                                                            */
/*                                                                            */
/*   App.java                                                                 */
/*                                                                            */
/*   By: Thibault Cheneviere <thibault.cheneviere@telecomnancy.eu>            */
/*                                                                            */
/*   Created: 2022/11/24 09:50:15 by Thibault Cheneviere                      */
/*   Updated: 2022/11/24 11:51:05 by Thibault Cheneviere                      */
/*                                                                            */
/* ************************************************************************** */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        // root.setTop(/* new VueMenu(game) */);
        root.setCenter(new Label("Hello"));
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
