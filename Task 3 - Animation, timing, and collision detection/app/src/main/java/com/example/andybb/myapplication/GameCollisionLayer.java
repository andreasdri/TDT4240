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
    public Chopper getChopper1() {
        return chopper1;
    }

    public Chopper getChopper2() {
        return chopper2;
    }

    private Chopper chopper1, chopper2;
    private static int screenHeight, screenWidth;

    public GameCollisionLayer() {
        addSprites();
    }

    private void addSprites() {
        chopper1 = new Chopper(new Image(R.drawable.chopper));
        chopper1.setPosition(new Vector2(100, 100));
        chopper1.setSpeed(new Vector2(40, 40));
        chopper1.addCollisionListener(this);
        addSprite(chopper1);

        chopper2 = new Chopper(new Image(R.drawable.chopper));
        chopper2.setPosition(new Vector2(170, 400));
        chopper2.setSpeed(new Vector2(40, 40));
        chopper2.addCollisionListener(this);
        addSprite(chopper2);
    }


    private static int getScreenHeight() {
        return screenHeight;
    }

    private static int getScreenWidth() { return screenWidth; }


    @Override
    public void update(float dt) {
        chopper1.update(dt);
        chopper2.update(dt);
    }


    protected void controlChopper1(MotionEvent event) {
		float x = (event.getX() - chopper1.getX());
        float y = (event.getY() - chopper1.getY());
        chopper1.setSpeed(chopper1.getSpeed().getX()+x ,chopper1.getSpeed().getY()+y);
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
