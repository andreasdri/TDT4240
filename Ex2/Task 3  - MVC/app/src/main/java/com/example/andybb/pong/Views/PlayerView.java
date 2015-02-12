package com.example.andybb.pong.Views;

import com.example.andybb.pong.Controllers.PlayerController;
import com.example.andybb.pong.Models.PlayerModel;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by esso on 11.02.15.
 */
public class PlayerView extends Sprite {
    // Controllers
    PlayerController playerController;

    // Constructor
    public PlayerView(Image img, float x, float y, PlayerController p) {
        super(img);
        playerController = p;
        setScale(0.4f, 0.5f);
        setPosition(x, y);

    }

    @Override
    public void update(float dt) { // Update a sprite at an instance
        super.update(dt);
        if(playerController.isMovingUp()) {
            if(getY() > 700) {
                setPosition(getX(),  getY()-15);
            }

        }
        if (playerController.isMovingDown()){ // down
            if(getY() < 1250) {
                setPosition(getX(), getY() + 15);

            }
        }

    }

}
