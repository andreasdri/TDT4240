package com.example.andybb.pong.Controllers;


import android.graphics.Canvas;

import com.example.andybb.pong.Models.PlayerModel;
import com.example.andybb.pong.Views.PlayerView;

import sheep.game.Sprite;
import sheep.graphics.Image;


/**
 * Created by Esso on 24.01.15.
 * Controller for a player
 * Holds all player logic
 */
public class PlayerController  {
    PlayerModel playerModel;
    PlayerView playerView;
    private boolean moveUp, moveDown;

    public PlayerController(Image img, float x, float y, PlayerModel p) {
        playerModel = p;
        playerView = new PlayerView(img, x, y, this);
    }

    public void moveUp() {
        moveUp = true;
        moveDown = false;
    }


    public void moveDown() {
        moveUp = false;
        moveDown = true;
    }

    public void stopMovement(){
        moveDown = false;
        moveUp = false;
    }

    public boolean isMovingUp(){
        return moveUp;
    }

    public boolean isMovingDown(){
        return moveDown;
    }

    public PlayerModel getPlayerModel(){
        return playerModel;
    }

    public PlayerView getPlayerView(){
        return playerView;
    }
}