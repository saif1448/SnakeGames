package com.example.snakefx.Handlers;

import javafx.scene.paint.Color;

import java.util.Random;

public class ColorHandler {

    public static Color generateColor(){
        Random rand = new Random();
        double r = rand.nextDouble(0,1);
        double g = rand.nextDouble(0,1);
        double b = rand.nextDouble(0,1);

        return new Color(r,g,b,1);
    }
}
