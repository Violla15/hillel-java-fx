package ua.ithillel.hilleljjavafx.userupp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.util.List;

public class HelloUserUpp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello user upp");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        HBox topPane = buildTopPane();
        HBox bottomPane = buildTopPane();
        VBox centerPane = buildCenterPone();

        Text text = new Text("");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(List.of("Stepan","Ivan","Oleg"));

        Button helloButton = new Button("Say hello");
        helloButton.setPrefSize(90, 20);
        helloButton.getStyleClass().addAll("btn", "btn-success");

        helloButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                text.setText("Hello from " + choiceBox.getValue());
            }
        });

        topPane.getChildren().add(choiceBox);
        centerPane.getChildren().add(text);
        bottomPane.getChildren().add(helloButton);

        root.setTop(topPane);
        root.setCenter(centerPane);
        root.setBottom(bottomPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox buildCenterPone() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color:#beb8b8;");
        return vBox;
    }

    private HBox buildBottomPone() {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setStyle("-fx-background-color:#839d88;");
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        return hBox;
    }

    private HBox buildTopPane() {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setStyle("-fx-background-color:#839d88;");

        Text text = new Text();
        text.setText("Hello user application");
        text.setFont(Font.font("Arial", 15));

        hBox.getChildren().add(text);
        hBox.setAlignment(Pos.CENTER);

        return hBox;
    }
}
