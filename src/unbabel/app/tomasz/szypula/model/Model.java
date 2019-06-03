package unbabel.app.tomasz.szypula.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private ObservableList<Translation> data =
            FXCollections.observableArrayList(
                    new Translation("999999", "te", "test", "st", "testing","gintset")
            );
    private StringProperty textToTranslate = new SimpleStringProperty();
    private StringProperty targetLanguage = new SimpleStringProperty();


    public ObservableList<Translation> getData() {
        return data;
    }

    public String getTextToTranslate() {
        return textToTranslate.get();
    }

    public StringProperty textToTranslateProperty() {
        return textToTranslate;
    }

    public void setTextToTranslate(String textToTranslate) {
        this.textToTranslate.set(textToTranslate);
    }

    public String getTargetLanguage() {
        return targetLanguage.get();
    }

    public StringProperty targetLanguageProperty() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage.set(targetLanguage);
    }

    public void sendTranslationRequest() {

    }
}
