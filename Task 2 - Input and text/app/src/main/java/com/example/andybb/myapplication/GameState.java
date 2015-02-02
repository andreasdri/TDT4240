package com.example.andybb.myapplication;


import sheep.game.State;
import sheep.game.World;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

/**
 * Created by andybb on 21.01.15.
 */

import sheep.game.State;
import sheep.input.TouchListener;

public class GameState extends State  implements TouchListener{
    private World gameWorld;
    private GameLayer gameLayer;
    private DebugInfo debugInfo;

    public GameState() {
        gameWorld = new World();
        gameLayer = new GameLayer();
        gameWorld.addLayer(gameLayer);
        debugInfo = new DebugInfo(gameLayer);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        gameWorld.draw(canvas);
        debugInfo.draw(canvas);
    }

    @Override
    public void update(float dt) {
        gameWorld.update(dt);
        debugInfo.update(dt);
    }


    @Override
    public boolean onTouchDown(MotionEvent event) {
        gameLayer.controlChopper(event);
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
