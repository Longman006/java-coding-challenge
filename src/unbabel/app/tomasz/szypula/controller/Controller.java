package unbabel.app.tomasz.szypula.controller;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import unbabel.app.tomasz.szypula.model.Model;
import unbabel.app.tomasz.szypula.view.View;

import java.lang.module.ModuleDescriptor;

public class Controller {
    Model model;
    BorderPane borderPane;
    public Controller(BorderPane borderPane) {

        model = new Model();
        this.borderPane = borderPane;

        View view = new View(model,borderPane);


    }
}
