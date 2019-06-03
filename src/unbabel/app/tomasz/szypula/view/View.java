package unbabel.app.tomasz.szypula.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import unbabel.app.tomasz.szypula.model.Model;

public class View {
    Model model;
    ControlPanelUI controlPanelUI;
    TableUI tableUI ;

    public View(Model model, BorderPane pane) {


        /**
         * Center
         */
        VBox centerPane = new VBox(20);
        controlPanelUI = new ControlPanelUI(model);
        tableUI = new TableUI(model);
        centerPane.getChildren().addAll(controlPanelUI.gethBox(),tableUI.getvBox());
        pane.setCenter(centerPane);


        /**
         * Top
         */
        MenuBar menuBar = new MenuBar();
        Menu helpMenu = new Menu("Help");
        helpMenu.getItems().add(new MenuItem("UnBabel"));
        menuBar.getMenus().add(helpMenu);
        pane.setTop(menuBar);



    }
}
