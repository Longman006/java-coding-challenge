package unbabel.app.tomasz.szypula.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import javafx.scene.layout.HBox;

import unbabel.app.tomasz.szypula.model.Model;
import unbabel.app.tomasz.szypula.model.Translation;


public class ControlPanelUI implements CreateUI{

    Model model;
    HBox hBox = new HBox(10);
    TextField toTranslateText = new TextField();
    ChoiceBox languagesChoiceBox = new ChoiceBox();
    Button submitButton = new Button();
    ObservableList<String> languages = FXCollections.observableArrayList("es","pt","en","fr");

    public ControlPanelUI(Model model) {
        this.model = model;
        /**
         * text to translate
         */
        toTranslateText.setPromptText("Type in text to be translated");
        toTranslateText.setPrefWidth(400);
        model.textToTranslateProperty().bind(toTranslateText.textProperty());


        /**
         * language selection
         */
        languagesChoiceBox.setItems(languages);
        languagesChoiceBox.setTooltip(new Tooltip("Select a language"));
        languagesChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                model.setTargetLanguage(languages.get(newValue.intValue()));
            }
        });



        /**
         * submit button
         */
        submitButton.setText("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.sendTranslationRequest();
            }
        });

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
