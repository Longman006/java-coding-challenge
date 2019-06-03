package unbabel.app.tomasz.szypula.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
    private StringProperty toTranslate = new SimpleStringProperty();
    private StringProperty translated = new SimpleStringProperty();
    private StringProperty history = new SimpleStringProperty();
}
