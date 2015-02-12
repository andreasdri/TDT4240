package com.example.andybb.pong.Controllers;

import sheep.game.World;

/**
 * Created by esso on 11.02.15.
 * Controller for the GameLayerView
 */
public class GameStateController {

    private World gameWorld;
    private GameLayerController gameLayerController;

    public GameStateController() {
        gameWorld = new World();
        gameLayerController = new GameLayerController();
        gameWorld.addLayer(gameLayerController);

    }


    public World getGameWorld() {
        return gameWorld;
    }

    public GameLayerController getGameLayerController(){
        return gameLayerController;
    }

}
