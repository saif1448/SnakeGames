package com.example.snakefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class SnakeGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGame.class.getResource("snake-game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500, Color.rgb(206, 245, 221));
        scene.getRoot().requestFocus();

        Image snakeIcon = new Image(getClass().getResourceAsStream("/images/icons/snake.png"));

        AnchorPane rootPane = fxmlLoader.getRoot();
        scene.getRoot().requestFocus();

        stage.setTitle("Snake Game!");
        stage.getIcons().add(snakeIcon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}