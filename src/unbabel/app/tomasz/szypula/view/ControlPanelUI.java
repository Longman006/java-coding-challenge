package unbabel.app.tomasz.szypula.view;

import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import javafx.scene.layout.HBox;

import unbabel.app.tomasz.szypula.model.Model;



public class ControlPanelUI implements CreateUI{

    Model model;
    HBox hBox = new HBox(10);
    TextField toTranslateText = new TextField("Type in text to be translated");
    ChoiceBox languagesChoiceBox = new ChoiceBox();
    Button submitButton = new Button();

    public ControlPanelUI(Model model) {
        this.model = model;
        /**
         * text to translate
         */
        toTranslateText.setPromptText("Type in text to be translated");
        toTranslateText.setPrefColumnCount(15);


        /**
         * language selection
         */
        languagesChoiceBox.setItems(FXCollections.observableArrayList("es","pt","en","fr"));
        languagesChoiceBox.setTooltip(new Tooltip("Select a language"));

        /**
         * submit button
         */
        submitButton.setText("Submit");

        hBox.getChildren().addAll(toTranslateText,languagesChoiceBox,submitButton);


    }
    public HBox gethBox(){
        return hBox;
    }


    @Override
    public void createUI(Group parent) {

    }

    @Override
    public void remove(Group parent) {

    }
}
