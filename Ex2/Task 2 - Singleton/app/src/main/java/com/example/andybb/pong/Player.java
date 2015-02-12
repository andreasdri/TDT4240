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
import android.view.MotionEvent;


/**
 * Created by andybb on 24.01.15.
 */
public class Player extends Sprite {

    private boolean up;
    private boolean down;
    private boolean isMoving;

    public Player(Image img, float x, float y) {
        super(img);
        up = false;
        down = false;
        setScale(0.4f, 0.5f);
        setPosition(x, y);

    }

    public void controlPlayer (MotionEvent event) {
        float y = (event.getY() - getY());
        setSpeed(0, getSpeed().getY()+y);

    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if(getY() < 700) {
            setSpeed(0, 0);
        }
        if(getY() > 1250) {
            setSpeed(0, 0);

        }
    }

    public void reset() {
        setPosition(900f, 960f);
    }

    public void isMoving(boolean b) {
        this.isMoving = b;
    }


}