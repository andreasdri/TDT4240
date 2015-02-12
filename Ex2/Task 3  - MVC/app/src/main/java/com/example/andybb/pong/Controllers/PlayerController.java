package com.example.andybb.pong.Controllers;

import com.example.andybb.pong.Models.PlayerModel;
import com.example.andybb.pong.Views.PlayerView;
import android.view.MotionEvent;
import sheep.graphics.Image;


/**
 * Created by Esso on 24.01.15.
 * Controller for a player
 * Holds all player logic
 */
public class PlayerController  {
    PlayerModel playerModel;
    PlayerView playerView;

    public PlayerController(Image img, float x, float y, PlayerModel p) {
        playerModel = p;
        playerView = new PlayerView(img, x, y, this);
    }

    public void controlPlayer (MotionEvent event) {
        float y = (event.getY() - playerView.getY());
        playerView.setSpeed(0, playerView.getSpeed().getY()+y);

    }

    public PlayerModel getPlayerModel(){
        return playerModel;
    }

    public PlayerView getPlayerView(){
        return playerView;
    }
}