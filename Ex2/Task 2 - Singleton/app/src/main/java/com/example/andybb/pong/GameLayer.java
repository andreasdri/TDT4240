package com.example.andybb.pong;

import android.graphics.Canvas;

import sheep.game.Layer;
import sheep.graphics.Image;
import sheep.math.BoundingBox;

/**
 * Created by andybb on 24.01.15.
 */

public class GameLayer extends Layer {

    private Ball ball;
    private Player player1;
    private Player player2;
    private Level level;
    private Scoreboard scoreboard;
    private int height = 700;
    private int width = 700;
    private int offsetX;
    private int offsetY;
    private static GameLayer instance = new GameLayer();


    private GameLayer() {
        this.offsetX = (1080 - this.width) / 2;
        this.offsetY = (1920 - this.height) / 2;
        level = new Level(this.width, this.height, this.offsetX, this.offsetY);
        // Singleton pattern
        scoreboard = Scoreboard.getInstance();
        ball = Ball.getInstance();
        player1 = new Player(new Image(R.drawable.paddle), 200f, 960f);
        player2 = new Player(new Image(R.drawable.paddle), 900f, 960f);

    }

    public static GameLayer getInstance() {
        return instance;
    }

    public Player getPlayer1() {
        return player1;
    }

    @Override
    public void draw(Canvas canvas, BoundingBox box) {
        level.draw(canvas);
        ball.draw(canvas);
        scoreboard.draw(canvas);
        player1.draw(canvas);
        player2.draw(canvas);

    }

    @Override
    public void update(float dt) {

        // Logic for the ball interactions with the environment
        if(ball.getX() > width + offsetX) {
            scoreboard.givePoint("player1");
            if(scoreboard.gameOver()) {
                scoreboard.reset();
            }
            ball.reset();
            player2.reset();
        }

        else if(ball.getX() < offsetX) {
            scoreboard.givePoint("player2");
            if(scoreboard.gameOver()) {
                scoreboard.reset();
            }
            ball.reset();
            player2.reset();
        }
        else if(ball.collides(player1)) {
            ball.setSpeed(-ball.getSpeed().getX(), ball.getSpeed().getY());

        }
        else if(ball.collides(player2)) {
            ball.setSpeed(-ball.getSpeed().getX(), ball.getSpeed().getY());

        }
        else if(ball.getY() < offsetY + 20) {
            ball.setSpeed(ball.getSpeed().getX(), -ball.getSpeed().getY());

        }
        else if(ball.getY() > offsetY + height) {
            ball.setSpeed(ball.getSpeed().getX(), -ball.getSpeed().getY());

        }

        // Logic for the player 2 controlled by the computer
        if(ball.getY() < player2.getY() - 20) {
            player2.setYSpeed(-80);

        }
        else if(ball.getY() > player2.getY() + 20) {
            player2.setYSpeed(80);
        }
        else {
            player2.setYSpeed(0);
        }

        player1.update(dt);
        player2.update(dt);
        ball.update(dt);
        level.update(dt);
        scoreboard.update(dt);
    }
}