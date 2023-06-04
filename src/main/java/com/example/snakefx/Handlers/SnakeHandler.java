package com.example.snakefx.Handlers;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class SnakeHandler {

    List<Rectangle> snakeBody = new ArrayList<>();

    private int snakeDirection = 39;

    public List<Rectangle> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeDirection(int snakeDirection) {
        this.snakeDirection = snakeDirection;
    }

    public void generateSnake() {
        Rectangle initPart = createRectangle(300, 300);
        snakeBody.add(initPart);
    }

    public void addSnakeBodyPart() {
        Rectangle tail = snakeBody.get(snakeBody.size() - 1);
        Rectangle newPart = createRectangle(tail.getX(), tail.getY());
        snakeBody.add(newPart);
    }

    private Rectangle createRectangle(double x, double y) {
        Rectangle rectangle = new Rectangle(x, y, 20, 20);
        rectangle.setFill(ColorHandler.generateColor());
        rectangle.setArcWidth(5);
        rectangle.setArcHeight(5);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);
        setRectangleAnimation(rectangle);
        return rectangle;
    }


    public boolean moveSnake() {
        try {
            Thread.sleep(75);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double speed = 20.0; // Adjust the speed of the snake

        // Move the head of the snake based on the current direction
        Rectangle head = snakeBody.get(0);
        switch (snakeDirection) {
            case 37: // Left
//                if(snakeDirection == 39)
//                    head.setX(head.getX() + speed);
                head.setX(head.getX() - speed);
                break;
            case 38: // Up
//                if(snakeDirection == 40) head.setY(head.getY() + speed);
                head.setY(head.getY() - speed);
                break;
            case 39: // Right
//                if(snakeDirection != 37) head.setX(head.getX() - speed);
                head.setX(head.getX() + speed);
                break;
            case 40: // Down
//                if(snakeDirection == 38) head.setY(head.getY() - speed);
                head.setY(head.getY() + speed);
                break;
        }

        for(int i = 1; i<snakeBody.size(); i++){
            if(head.getX() == snakeBody.get(i).getX() && head.getY() == snakeBody.get(i).getY()){
                System.out.println(true);
                return true;
            }
        }

        for (int i = snakeBody.size() - 1; i > 0; i--) {
            Rectangle currentPart = snakeBody.get(i);
            Rectangle previousPart = snakeBody.get(i - 1);
            currentPart.setX(previousPart.getX());
            currentPart.setY(previousPart.getY());
        }
        return  false;
    }

    public  void setRectangleAnimation(Node node){
        TranslateTransition transition = new TranslateTransition();
        transition.setByX(-100);
        transition.setDuration(Duration.millis(2000));
        transition.setRate(5);
        transition.setNode(node);
        transition.play();
    }
    private void resetSnake(){
        snakeBody.clear();
    }

}