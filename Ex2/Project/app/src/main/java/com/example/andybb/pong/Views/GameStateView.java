package com.example.andybb.pong.Views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import com.example.andybb.pong.Controllers.GameStateController;
import sheep.game.State;
import sheep.game.World;
import sheep.input.TouchListener;

/**
 * Created by andybb on 24.01.15.
 */
public class GameStateView extends State implements TouchListener {
    // Controller
    GameStateController gameStateController;
    private static GameStateView instance = new GameStateView(GameStateController.getInstance());

    // Properties
    private World gameWorld;

    private GameStateView(GameStateController gameStateController){
        this.gameStateController = GameStateController.getInstance();
        gameWorld = gameStateController.getGameWorld();
    }

    public static GameStateView getInstance() {
        return instance;
    }

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
        gameStateController.getGameLayerController().getPlayerController1().controlPlayer(event);
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