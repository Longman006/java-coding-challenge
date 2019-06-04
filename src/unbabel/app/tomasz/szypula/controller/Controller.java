package unbabel.app.tomasz.szypula.controller;

import javafx.scene.layout.BorderPane;
import unbabel.app.tomasz.szypula.model.Model;
import unbabel.app.tomasz.szypula.view.View;



public class Controller {
    Model model;
    BorderPane borderPane;
    public Controller(BorderPane borderPane, String username, String apikey) {

        model = new Model(username,apikey);
        this.borderPane = borderPane;

        View view = new View(model,borderPane);

    }
}
