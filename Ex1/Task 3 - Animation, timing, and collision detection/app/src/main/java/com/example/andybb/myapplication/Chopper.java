package com.example.andybb.myapplication;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by andybb on 21.01.15.
 */
public class Chopper extends AnimatedSprite {

    private static final float velocity = 150.0f;
    private boolean moveRight;
    private boolean moveLeft;
    private float height;
    private float width;

    public Chopper(Image[] images) {
        super(images, 1);

        // setPosition(500.0f, 500.0f); // Done somewhere else now
        // setScale(0.5f, 0.5f);

        height = (int) images[0].getHeight();
        width = (int) images[0].getWidth();

        moveLeft = true;
        moveRight = false;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
         // Should check for walls etc
        if (moveLeft) {
            float x = getX();
            float y = getY();
            //float dx = dt * velocity;
            setXSpeed(-velocity);
            if(x < width/2) {
                moveRight = true;
                moveLeft = false;
                setScale(-0.5f, 0.5f);
                //setPosition(x + width, y);
            }
        }
        if (moveRight) {
            float x = getX();
            float y = getY();
            //float dx = dt * velocity;
            setXSpeed(velocity);
            if(x > 1080 + width/2) {
                moveLeft = true;
                moveRight = false;
                setScale(0.5f, 0.5f);
                //setPosition(x-width, y);
            }
        }

    }



}
