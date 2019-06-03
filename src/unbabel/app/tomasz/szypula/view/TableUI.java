package unbabel.app.tomasz.szypula.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import unbabel.app.tomasz.szypula.model.Model;
import unbabel.app.tomasz.szypula.model.Translation;

public class TableUI {
    private TableView table = new TableView();
    private VBox vBox = new VBox(10);
    private ObservableList<Translation> data =
            FXCollections.observableArrayList(
                    new Translation("999999", "te", "test", "st", "testing","gintset")
            );

    public TableUI(Model model) {


        Label label = new Label("Translated Content :");

        table.setEditable(false);

        TableColumn fromLangCol = new TableColumn("From Language");
        fromLangCol.setMinWidth(100);
        fromLangCol.setCellValueFactory(new PropertyValueFactory<Translation,String>("sourceLanguage"));

        TableColumn originalTextCol = new TableColumn("Original Text");
        originalTextCol.setMinWidth(200);
        originalTextCol.setCellValueFactory(new PropertyValueFactory<Translation,String >("originalText"));

        TableColumn toLangCol = new TableColumn("To Language");
        toLangCol.setMinWidth(100);
        toLangCol.setCellValueFactory(new PropertyValueFactory<Translation,String>("targetLanguage"));

        TableColumn translatedTextCol = new TableColumn("Translated Text");
        translatedTextCol.setMinWidth(200);
        translatedTextCol.setCellValueFactory(new PropertyValueFactory<Translation,String >("translatedText"));

        TableColumn statusCol = new TableColumn("Status");
        statusCol.setMinWidth(100);
        statusCol.setCellValueFactory(new PropertyValueFactory<Translation,String>("status"));

        table.setItems(data);
        table.getColumns().addAll(fromLangCol,originalTextCol,toLangCol,translatedTextCol,statusCol);

        vBox.getChildren().addAll(label,table);

    }
    public VBox getvBox(){
        return vBox;
    }
}
