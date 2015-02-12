package com.example.andybb.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import sheep.input.KeyboardListener;
import android.view.KeyEvent;
import android.util.Log;
import android.view.MotionEvent;

import sheep.game.State;
import sheep.game.World;
import sheep.input.TouchListener;

/**
 * Created by andybb on 24.01.15.
 */
public class GameState extends State implements TouchListener {
    private World gameWorld;
    private GameLayer gameLayer;
    private static GameState instance = new GameState();

    private GameState() {
        gameWorld = new World();
        gameLayer = GameLayer.getInstance();
        gameWorld.addLayer(gameLayer);
    }

    public static GameState getInstance() {
        return instance;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        gameWorld.draw(canvas);
    }

    @Override
    public void update(float dt) {
        gameWorld.update(dt);
    }

    @Override
    public boolean onTouchDown(MotionEvent event) {
        gameLayer.getPlayer1().controlPlayer(event);
        return false;
    }

    @Override
    public boolean onTouchUp(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchMove(MotionEvent event) {
        return false;
    }
}