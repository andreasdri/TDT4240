package com.example.andybb.myapplication;

import sheep.collision.CollisionLayer;
import sheep.collision.CollisionListener;

import android.view.MotionEvent;

import java.util.ArrayList;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.math.Vector2;

/**
 * Created by esso on 02.02.15.
 */
public class GameCollisionLayer extends CollisionLayer  {
    private ArrayList<Chopper> choppers;
    private int numOfChoppers = 4;
    private static int screenHeight, screenWidth;

    public Chopper getPlayerChopper(){
        return  choppers.get(0);
    }

    public GameCollisionLayer() {
        choppers = new ArrayList<Chopper>();
        createChoppers();
    }

    private void createChoppers() {
        // Creates a few choppers and adds them to the layer.
        for (int i = 0 ; i < numOfChoppers; i++){
            Chopper newChopper = new Chopper(new Image(R.drawable.chopper));
            newChopper.setPosition(new Vector2(10*i, 20*i));
            newChopper.setSpeed(new Vector2(40, 40));
            choppers.add(newChopper);
            addSprite(newChopper);
        }
    }


    private static int getScreenHeight() {
        return screenHeight;
    }

    private static int getScreenWidth() { return screenWidth; }


    @Override
    public void update(float dt) {
        for (int i = 0; i < choppers.size(); i++){ // Update all choppers
            Chopper c1 = choppers.get(i);
            c1.update(dt);
            for (int j = 0; j < choppers.size(); j++){ // Check for collisions
                Chopper c2 = choppers.get(j);
                if(c1.collides(c2)){ // Switch speed
                    Vector2 C1Speed = c1.getSpeed();
                    c1.setSpeed(c2.getSpeed());
                    c2.setSpeed(C1Speed);
                }
            }
        }
    }


    protected void controlPlayerChopper(MotionEvent event) {
        Chopper chopper1 = getPlayerChopper();
		float x = (event.getX() - chopper1.getX());
        float y = (event.getY() - chopper1.getY());
        chopper1.setSpeed(chopper1.getSpeed().getX()+x ,chopper1.getSpeed().getY()+y);
    }

}
