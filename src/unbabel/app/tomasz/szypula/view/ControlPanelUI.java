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



public class ControlPanelUI implements CreateUI{

    Model model;
    HBox hBox = new HBox(10);
    TextField toTranslateText = new TextField();
    ChoiceBox languagesChoiceBox = new ChoiceBox();
    Button submitButton = new Button();
    Button refresh = new Button();
    /**
     * This should be implemented in some other way for example using Enum for scalability, this is an easy and quick solution
     */
    ObservableList<String> languages = FXCollections.observableArrayList("es","pt","en","fr","zh-CN","de","ja","ru","it","hi");

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

        /**
         * refresh button
         */
        refresh.setText("Refresh");
        refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.refreshTranslations();
            }
        });

        hBox.getChildren().addAll(toTranslateText,languagesChoiceBox,submitButton,refresh);


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
