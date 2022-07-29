package ua.ithillel.hilleljjavafx.homework;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ua.ithillel.hilleljjavafx.homework.user.User;

import java.util.ArrayList;
import java.util.List;

import static ua.ithillel.hilleljjavafx.homework.user.UserFileReader.*;

public class Homework extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<User> users = new ArrayList<>();
        getInfoAboutUsers(users);

        primaryStage.setTitle("Login form");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setStyle("-fx-background-color: pink");
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Login");
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
        gridPane.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        gridPane.add(userName, 0, 1);

        Label password = new Label("Password:");
        gridPane.add(password, 0, 2);

        final TextField userLoginField = new TextField();
        gridPane.add(userLoginField, 1, 1);

        final PasswordField userPasswordField = new PasswordField();
        gridPane.add(userPasswordField, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        gridPane.add(hbBtn, 1, 4);
        final Text text = new Text();
        gridPane.add(text, 1, 6);


        Scene scene = new Scene(gridPane, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();


        Stage primaryStage2 = new Stage();
        primaryStage2.setTitle("Login form");
        GridPane gridPane2 = new GridPane();
        gridPane2.setAlignment(Pos.CENTER);
        gridPane2.setHgap(10);
        gridPane2.setVgap(10);
        gridPane2.setStyle("-fx-background-color: #87cefa");
        gridPane2.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle2 = new Text("Welcome to app ");
        sceneTitle2.setFont(Font.font("Arial", FontWeight.NORMAL, 30));
        gridPane2.add(sceneTitle2, 0, 0, 2, 1);

        Scene scene2 = new Scene(gridPane2, 350, 200);
        primaryStage2.setScene(scene2);


        btn.setOnAction(event -> {
            for (User user : users) {
                if (userLoginField.getText().equals(user.getLogin()) && userPasswordField.getText().equals(user.getPassword())) {
                    primaryStage2.show();
                } else {
                    text.setFill(Color.FIREBRICK);
                    text.setText("Incorrect login");
                }
            }
        });
    }
}
