package com.example.andybb.myapplication;

import sheep.game.Layer;
import android.graphics.Canvas;
import sheep.graphics.Image;
import sheep.math.BoundingBox;

/**
 * Created by andybb on 21.01.15.
 */
public class GameLayer extends Layer {
    private Chopper chopper;
    private static int screenHeight, screenWidth;

    public GameLayer() {
        chopper = new Chopper(new Image(R.drawable.chopper));
    }


    public Chopper getChopper() {
        return chopper;
    }

    private static int getScreenHeight() {
        return screenHeight;
    }

    private static int getScreenWidth() {
        return screenWidth;
    }

    @Override
    public void draw(Canvas canvas, BoundingBox box) {
        chopper.draw(canvas);
    }


    @Override
    public void update(float dt) {
        chopper.update(dt);
    }
}
