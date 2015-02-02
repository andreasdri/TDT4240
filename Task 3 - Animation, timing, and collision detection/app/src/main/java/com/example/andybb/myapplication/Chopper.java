package com.example.andybb.myapplication;

import sheep.game.Sprite;
import sheep.graphics.Image;

/**
 * Created by andybb on 21.01.15.
 */
public class Chopper extends Sprite {

    private static final float velocity = 150.0f;
    private boolean moveRight;
    private boolean moveLeft;
    private float height;
    private float width;

    public Chopper(Image image) {
        super(image);
        setPosition(500.0f, 500.0f);
        setScale(0.5f, 0.5f);
        height = image.getHeight();
        width = image.getWidth();

        moveLeft = true;
        moveRight = false;


    }

    @Override
    public void update(float dt) {
        super.update(dt);
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
