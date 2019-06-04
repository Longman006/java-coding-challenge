package unbabel.app.tomasz.szypula.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
    private ObservableList<Translation> data =
            FXCollections.observableArrayList(
                    new Translation(null, "pl", "completed", "en", "To jest przykład","This is an example")
            );
    private StringProperty textToTranslate = new SimpleStringProperty();
    private StringProperty targetLanguage = new SimpleStringProperty();
    private HttpURLConnectionHandler httpURLConnectionHandler;


    public Model(String username, String apikey) {
        httpURLConnectionHandler = new HttpURLConnectionHandler(username,apikey);
    }

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
        Translation translation = new Translation();
        translation.setOriginalText(getTextToTranslate());
        translation.setTargetLanguage(getTargetLanguage());
        translation.setStatus("sending");

        data.add(translation);

        try {
            httpURLConnectionHandler.sendPost(translation);
        } catch (Exception e) {
            e.printStackTrace();
            translation.setStatus("failed");
        }
    }

    public void refreshTranslations() {
        for (Translation translation : data){
            if (translation.getStatus().equals("error") || translation.getStatus().equals("failed")) {
                try {
                    httpURLConnectionHandler.sendPost(translation);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (!translation.getStatus().equals("completed")){
                System.out.println("status ="+translation.getStatus());
                try {
                    httpURLConnectionHandler.sendGet(translation);
                } catch (Exception e) {
                    e.printStackTrace();
                    translation.setStatus("error");
                }
            }
        }
    }
}
