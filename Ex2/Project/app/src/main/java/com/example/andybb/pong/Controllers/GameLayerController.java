package com.example.andybb.pong.Controllers;

import android.graphics.Canvas;

import com.example.andybb.pong.Views.BallView;
import com.example.andybb.pong.Views.LevelView;
import com.example.andybb.pong.R;
import com.example.andybb.pong.Views.ScoreView;

import sheep.game.Layer;
import sheep.graphics.Image;
import sheep.math.BoundingBox;

/**
 * Created by andybb on 24.01.15.
 */

public class GameLayerController extends Layer {

    // Game properties
    private int height = 700;
    private int width = 700;
    private int offsetX;
    private int offsetY;

    // Views
    private BallView ballView;
    private PlayerController playerController1, playerController2;
    private LevelView levelView;
    private ScoreView scoreView;


    // Controllers
    private ScoreController scoreController;

    // Instance
    private static GameLayerController instance = new GameLayerController();

    // Constructor
    private GameLayerController() {
        this.offsetX = (1080 - this.width) / 2;
        this.offsetY = (1920 - this.height) / 2;
        levelView = new LevelView(this.width, this.height, this.offsetX, this.offsetY);
        ballView = BallView.getInstance();
        scoreController = ScoreController.getInstance(); // Creates scoreboard and Playermodels
        scoreView = ScoreView.getInstance();
        // Lets create playercontrolers and views
        playerController1 = new PlayerController(new Image(R.drawable.paddle), 200f, 960f, scoreController.getPlayer1());
        playerController2 = new PlayerController(new Image(R.drawable.paddle), 900f, 960f, scoreController.getPlayer2());

    }

    public static GameLayerController getInstance() {
        return instance;
    }


    public PlayerController getPlayerController1() {
        return playerController1;
    }

    public PlayerController getPlayerController2() {
        return playerController2;
    }


    @Override
    public void draw(Canvas canvas, BoundingBox box) {
        levelView.draw(canvas);
        ballView.draw(canvas);
        scoreView.draw(canvas);
        playerController1.getPlayerView().draw(canvas);
        playerController2.getPlayerView().draw(canvas);

    }


    @Override
    public void update(float dt) {

        // Logic for the ball interactions with the environment
        if(ballView.getX() > width + offsetX) {
            scoreController.givePoint("Player 1");
            if(scoreController.isGameOver()) {
                scoreController.reset();
            }
            ballView.reset();
            playerController2.getPlayerView().reset();

        }

        else if(ballView.getX() < offsetX) {
            scoreController.givePoint("Player 2");
            if(scoreController.isGameOver()) {
                scoreController.reset();
            }
            ballView.reset();
            playerController2.getPlayerView().reset();
        }
        else if(ballView.collides(playerController1.getPlayerView())) {
            ballView.setSpeed(-ballView.getSpeed().getX(), ballView.getSpeed().getY());

        }
        else if(ballView.collides(playerController2.getPlayerView())) {
            ballView.setSpeed(-ballView.getSpeed().getX(), ballView.getSpeed().getY());

        }
        else if(ballView.getY() < offsetY + 20) {
            ballView.setSpeed(ballView.getSpeed().getX(), -ballView.getSpeed().getY());

        }
        else if(ballView.getY() > offsetY + height) {
            ballView.setSpeed(ballView.getSpeed().getX(), -ballView.getSpeed().getY());

        }

        // Logic for the player 2 controlled by the computer
        if(ballView.getY() < playerController2.getPlayerView().getY() - 20 && playerController2.getPlayerView().getY() > 700) {
            playerController2.getPlayerView().setYSpeed(-80);

        }
        else if(ballView.getY() > playerController2.getPlayerView().getY() + 20 && playerController2.getPlayerView().getY() < 1250) {
            playerController2.getPlayerView().setYSpeed(80);
        }
        else {
            playerController2.getPlayerView().setYSpeed(0);
        }

        playerController1.getPlayerView().update(dt);
        playerController2.getPlayerView().update(dt);
        ballView.update(dt);
        levelView.update(dt);
        scoreView.update(dt);
    }
}