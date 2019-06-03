package unbabel.app.tomasz.szypula.view;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import unbabel.app.tomasz.szypula.model.Model;

public class TableUI {
    private TableView table = new TableView();
    private VBox vBox = new VBox(10);
    public TableUI(Model model) {


        Label label = new Label("Translated Content :");

        table.setEditable(false);

        TableColumn fromLangCol = new TableColumn("From Language");
        TableColumn originalTextCol = new TableColumn("Original Text");
        TableColumn toLangCol = new TableColumn("To Language");
        TableColumn translatedTextCol = new TableColumn("Translated Text");
        TableColumn statusCol = new TableColumn("Status");

        table.getColumns().addAll(fromLangCol,originalTextCol,toLangCol,translatedTextCol,statusCol);

        vBox.getChildren().addAll(label,table);

    }
    public VBox getvBox(){
        return vBox;
    }
}
