package com.example.andybb.myapplication;

import sheep.collision.CollisionLayer;
import sheep.collision.CollisionListener;
import android.graphics.Canvas;
import android.view.MotionEvent;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.math.BoundingBox;
import sheep.math.Vector2;

/**
 * Created by esso on 02.02.15.
 */
public class GameCollisionLayer extends CollisionLayer implements CollisionListener {
    private Chopper chopper;
    private Chopper chopper2;
    private static int screenHeight, screenWidth;

    public GameCollisionLayer() {
        addSprites();
    }

    private void addSprites() {
        chopper = new Chopper(new Image(R.drawable.chopper));
        chopper.setPosition(new Vector2(100, 100));
        chopper.setSpeed(new Vector2(40, 40));
        chopper.addCollisionListener(this);
        addSprite(chopper);

        chopper2 = new Chopper(new Image(R.drawable.chopper));
        chopper2.setPosition(new Vector2(170, 400));
        chopper2.setSpeed(new Vector2(40, 40));
        chopper2.addCollisionListener(this);
        addSprite(chopper2);
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
    public void update(float dt) {
        chopper.update(dt);
    }


    protected void controlChopper (MotionEvent event) {
		float x = (event.getX() - chopper.getX());
        float y = (event.getY() - chopper.getY());
        chopper.setSpeed(chopper.getSpeed().getX()+x ,chopper.getSpeed().getY()+y);
    }


    @Override
    public void collided(Sprite s1, Sprite s2) {
        // Bounce the sprites on collision
        Vector2 AccS1Old = s1.getAcceleration();
        Vector2 AccS2Old = s2.getAcceleration();

        // opposite accelaration
        s1.setAcceleration(AccS2Old.getX(), AccS2Old.getY());
        s2.setAcceleration(AccS1Old.getX(), AccS1Old.getY());
    }
}
