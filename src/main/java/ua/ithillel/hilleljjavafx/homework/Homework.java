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


        btn.setOnAction(event -> {
            for (User user : users) {
                if (userLoginField.getText().equals(user.getLogin()) && userPasswordField.getText().equals(user.getPassword())) {
                    gridPane.getChildren().removeAll(password, userName, userLoginField, userPasswordField, btn, text, sceneTitle, hbBtn);
                    sceneTitle.setText("Welcome to app ");
                    gridPane.add(sceneTitle, 0, 0, 2, 1);

                } else if (userLoginField.getText().equals(user.getLogin()) ^ userPasswordField.getText().equals(user.getPassword())) {
                    text.setFill(Color.FIREBRICK);
                    text.setText("Incorrect login");
                }
            }
        });
    }
}
