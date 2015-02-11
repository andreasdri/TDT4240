package com.example.andybb.pong;

import android.graphics.Canvas;
import android.graphics.Color;
import sheep.input.KeyboardListener;
import android.view.KeyEvent;
import android.util.Log;

import sheep.game.State;
import sheep.game.World;

/**
 * Created by andybb on 24.01.15.
 */
public class GameState extends State implements KeyboardListener  {
    private World gameWorld;
    private GameLayer gameLayer;

    public GameState() {
        gameWorld = new World();
        gameLayer = new GameLayer();
        gameWorld.addLayer(gameLayer);
        this.addKeyboardListener(this);
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

    public boolean onKeyDown(KeyEvent event) {
        Log.d("MyApp",Integer.toString(event.getKeyCode()));
        if (event.getKeyCode() == 15) {
            gameLayer.getPlayer1().moveUp();
        }
        if (event.getKeyCode() == 12) {
            gameLayer.getPlayer1().moveDown();
        }
        return true;
    }

    public boolean onKeyUp(KeyEvent event) {
        if (event.getKeyCode() == 15) {
            gameLayer.getPlayer1().stopUp();
        }
        if (event.getKeyCode() == 12) {
            gameLayer.getPlayer1().stopDown();
        }
        return true;
    }

}