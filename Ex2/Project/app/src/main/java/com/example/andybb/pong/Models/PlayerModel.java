package com.example.andybb.pong.Models;

/**
 * Created by esso on 11.02.15.
 * Model for a player
 * Holds score, name and location
 * Methods for handling the player properties in short
 */
public class PlayerModel {
    private String name;
    private int score;

    public PlayerModel(String n){
        setName(n);
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public void resetScore(){
        score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
