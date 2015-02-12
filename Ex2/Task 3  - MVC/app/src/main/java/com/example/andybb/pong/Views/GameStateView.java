package com.example.andybb.pong.Views;

import android.graphics.Canvas;
import android.graphics.Color;
import sheep.input.KeyboardListener;
import android.view.KeyEvent;
import android.util.Log;

import com.example.andybb.pong.Controllers.GameStateController;

import sheep.game.State;
import sheep.game.World;

/**
 * Created by andybb on 24.01.15.
 */
public class GameStateView extends State implements KeyboardListener  {
    // Controller
    GameStateController gameStateController;

    // Properties
    private World gameWorld;

    public GameStateView(GameStateController gameStateController){
        this.gameStateController = gameStateController;
        gameWorld = gameStateController.getGameWorld();
        this.addKeyboardListener(this);
    }
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        gameWorld.draw(canvas);
    }

    @Override
    public void update(float dt) {
        gameWorld.update(dt);
    }

    public boolean onKeyDown(KeyEvent event) {
        Log.d("Pong",Integer.toString(event.getKeyCode()));
        if (event.getKeyCode() == 15) {
            gameStateController.getGameLayerController().getPlayerController1().moveUp();
        }
        if (event.getKeyCode() == 12) {
            gameStateController.getGameLayerController().getPlayerController1().moveDown();
        }
        return true;
    }

    public boolean onKeyUp(KeyEvent event) {
        if (event.getKeyCode() == 15) {
            gameStateController.getGameLayerController().getPlayerController1().moveUp();
        }
        if (event.getKeyCode() == 12) {
            gameStateController.getGameLayerController().getPlayerController1().moveDown();
        }
        return true;
    }

}