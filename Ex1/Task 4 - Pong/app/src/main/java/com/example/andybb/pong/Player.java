package com.example.andybb.pong;


import sheep.game.Sprite;
import android.graphics.Canvas;
import android.graphics.Rect;
import sheep.graphics.Color;
import sheep.graphics.Image;
import android.graphics.drawable.ShapeDrawable;
import 	android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.graphics.drawable.shapes.RectShape;


/**
 * Created by andybb on 24.01.15.
 */
public class Player extends Sprite {

    private boolean up;
    private boolean down;

    public Player(Image img, float x, float y) {
        super(img);
        up = false;
        down = false;
        setScale(0.4f, 0.5f);
        setPosition(x, y);

    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if(up) {
            if(getY() > 700) {
                setPosition(getX(), getY()-20);
            }

        }
        if (down){
            if(getY() < 1250) {
                setPosition(getX(), getY() + 20);

            }
        }

    }

    public void moveUp() {
        up = true;
    }


    public void moveDown() {
        down = true;
    }

    public void stopUp() {
        up = false;
    }


    public void stopDown() {
        down = false;
    }

}