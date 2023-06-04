package com.example.snakefx.Handlers;

public class ScoreBoardHandler {

    int score ;

    public ScoreBoardHandler(){
        this.score = 0;
    }

    public void increaseScore() {
        score = score+1;
    }

    public String getScore() {
        return String.valueOf(score);
    }


}
