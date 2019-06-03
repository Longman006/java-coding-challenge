package unbabel.app.tomasz.szypula.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Translation {
    private StringProperty uid;
    private StringProperty sourceLanguage;
    private StringProperty status;
    private StringProperty targetLanguage;
    private StringProperty originalText;
    private StringProperty translatedText;

    public Translation(String uid, String sourceLanguage, String status, String targetLanguage, String originalText, String translatedText) {
        this.uid = new SimpleStringProperty(uid);
        this.sourceLanguage = new SimpleStringProperty(sourceLanguage);
        this.status = new SimpleStringProperty(status);
        this.targetLanguage = new SimpleStringProperty(targetLanguage);
        this.originalText = new SimpleStringProperty(originalText);
        this.translatedText = new SimpleStringProperty(translatedText);
    }

    public String getUid() {
        return uid.get();
    }

    public StringProperty uidProperty() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid.set(uid);
    }

    public String getSourceLanguage() {
        return sourceLanguage.get();
    }

    public StringProperty sourceLanguageProperty() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage.set(sourceLanguage);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
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

    public String getOriginalText() {
        return originalText.get();
    }

    public StringProperty originalTextProperty() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText.set(originalText);
    }

    public String getTranslatedText() {
        return translatedText.get();
    }

    public StringProperty translatedTextProperty() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText.set(translatedText);
    }
}
