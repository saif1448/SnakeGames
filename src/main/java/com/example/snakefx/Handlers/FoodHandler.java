package com.example.snakefx.Handlers;


import javafx.animation.ScaleTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.Random;


public class FoodHandler  {

    public Circle generateFood(){
        Circle foodCircle = new Circle();
//        foodCircle.setCenterX(new Random().nextDouble(100));
        foodCircle.setLayoutX(new Random().nextDouble(50,400));
        foodCircle.setLayoutY(new Random().nextDouble(50,400));
//        foodCircle.setCenterY(new Random().nextDouble(100));
        foodCircle.setRadius(15);
        foodCircle.fillProperty().set(ColorHandler.generateColor());
        foodCircle.setStroke(Color.WHITE);
        foodCircle.setStrokeWidth(1);


        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.35), foodCircle);
        scaleTransition.setFromX(4);
        scaleTransition.setFromY(4);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);

        scaleTransition.play();

        return foodCircle;
    }


}
