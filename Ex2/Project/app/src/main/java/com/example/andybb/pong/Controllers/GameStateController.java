package com.example.andybb.pong.Controllers;

import sheep.game.World;

/**
 * Created by esso on 11.02.15.
 * Controller for the GameLayerView
 */
public class GameStateController {

    private World gameWorld;
    private GameLayerController gameLayerController;
    private static GameStateController instance = new GameStateController();

    private GameStateController() {
        gameWorld = new World();
        gameLayerController = GameLayerController.getInstance();
        gameWorld.addLayer(gameLayerController);

    }

    public static GameStateController getInstance() {
        return instance;
    }


    public World getGameWorld() {
        return gameWorld;
    }

    public GameLayerController getGameLayerController(){
        return gameLayerController;
    }

}
