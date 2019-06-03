package unbabel.app.tomasz.szypula;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import unbabel.app.tomasz.szypula.controller.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        BorderPane root = new BorderPane();

        Scene theScene = new Scene( root,350, 500 );



        Controller controller = new Controller(root);
        root.prefWidthProperty().bind(theScene.widthProperty());
        root.prefHeightProperty().bind(theScene.heightProperty());

        primaryStage.setTitle("Unbabel App");
        primaryStage.setScene(theScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
