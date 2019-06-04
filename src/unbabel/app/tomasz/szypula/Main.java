package unbabel.app.tomasz.szypula;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import unbabel.app.tomasz.szypula.controller.Controller;
import unbabel.app.tomasz.szypula.model.JsonParser;

import java.util.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();

        Scene theScene = new Scene( root,750, 500 );

        List<String> parameters = getParameters().getRaw();
        if (parameters.size() != 2 ) {
            System.out.println("Expecting two arguments \"username\" \"apikey\"");
            System.exit(0);
        }

        Controller controller = new Controller(root,parameters.get(0),parameters.get(1));

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
