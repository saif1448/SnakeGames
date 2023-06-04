package com.example.snakefx.controllers;

import com.example.snakefx.Handlers.FoodHandler;
import com.example.snakefx.Handlers.ScoreBoardHandler;
import com.example.snakefx.Handlers.SnakeHandler;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameLoopController implements Initializable {

    @FXML
    AnchorPane rootPane;
    @FXML
    Label score_id;
    @FXML
    AnchorPane gameOverPane;

    AnimationTimer gameLoop;

    FoodHandler fc = new FoodHandler();
    SnakeHandler sc = new SnakeHandler();
    ScoreBoardHandler scoreBoard = new ScoreBoardHandler();

    Circle currentFood;
    private int keyCode = 39;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootPane.setFocusTraversable(true);
        rootPane.requestFocus();

        score_id.setText(scoreBoard.getScore());

        sc.generateSnake();
        rootPane.getChildren().addAll(sc.getSnakeBody());

        currentFood = fc.generateFood();
        rootPane.getChildren().add(currentFood);



        gameLoop = new AnimationTimer() {

            @Override
            public void handle(long l) {
//                sc.moveSnake();
//                if() stop();

                if (isFoodConsumed(sc.getSnakeBody().get(0), currentFood)) {
                    handleFoodConsume();
                }
                if(sc.moveSnake() || isWallHit(sc.getSnakeBody().get(0))){
                    stop();
                    gameOverPane.setVisible(true);
                    gameOverPane.toFront();
                }

            }
        };
        gameLoop.start();

    }

    @FXML
    public void handle(KeyEvent event){
        int keyCode = event.getCode().getCode();
        sc.setSnakeDirection(keyCode);

    }

    private boolean isFoodConsumed(Rectangle snakeHead, Circle food) {
        return snakeHead.getBoundsInParent().intersects(food.getBoundsInParent());
    }

    private boolean isWallHit(Rectangle snakeHead){
        return !rootPane.getLayoutBounds().contains(snakeHead.getBoundsInParent());
    }

    private  void handleFoodConsume(){
        rootPane.getChildren().remove(currentFood);

        currentFood = fc.generateFood();
        rootPane.getChildren().add(currentFood);

        scoreBoard.increaseScore();
        score_id.setText(scoreBoard.getScore());

        for(Rectangle r: sc.getSnakeBody()){
            rootPane.getChildren().remove(r);
        }

        sc.addSnakeBodyPart();
        rootPane.getChildren().addAll(sc.getSnakeBody());

    }

}
