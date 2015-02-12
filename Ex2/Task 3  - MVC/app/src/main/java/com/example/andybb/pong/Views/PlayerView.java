package com.example.andybb.pong.Views;

import com.example.andybb.pong.Controllers.PlayerController;
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

    public void reset() {
        setPosition(900f, 960f);
    }


    @Override
    public void update(float dt) { // Update a sprite at an instance
        super.update(dt);
        if(getY() < 700) {
            setYSpeed(0);
        }
        if(getY() > 1250) {
            setYSpeed(0);

        }

    }

}
