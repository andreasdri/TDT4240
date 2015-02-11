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


    public GameLayer() {
        this.offsetX = (1080 - this.width) / 2;
        this.offsetY = (1920 - this.height) / 2;
        level = new Level(this.width, this.height, this.offsetX, this.offsetY);
        ball = new Ball(new Image(R.drawable.ball));
        player1 = new Player(new Image(R.drawable.paddle), 200f, 960f);
        player2 = new Player(new Image(R.drawable.paddle), 900f, 960f);
        scoreboard = new Scoreboard();

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

        if(ball.getX() > width + offsetX) {
            scoreboard.givePoint("player1");
            if(scoreboard.gameOver()) {
                scoreboard.reset();
            }
            ball.reset();
        }

        else if(ball.getX() < offsetX) {
            scoreboard.givePoint("player2");
            if(scoreboard.gameOver()) {
                scoreboard.reset();
            }
            ball.reset();
        }
        else if(ball.collides(player1)) {
            ball.setSpeed(-ball.getSpeed().getX(), ball.getSpeed().getY());

        }
        else if(ball.collides(player2)) {
            ball.setSpeed(-ball.getSpeed().getX(), ball.getSpeed().getY());

        }
        else if(ball.getY() < offsetY) {
            ball.setSpeed(ball.getSpeed().getX(), -ball.getSpeed().getY());

        }
        else if(ball.getY() > offsetY + height) {
            ball.setSpeed(ball.getSpeed().getX(), -ball.getSpeed().getY());

        }


//        if(player1.getY() < offsetY + 30) {
//            player1.setPosition(player1.getX(), offsetY+31);
//        }
//
//        if(player1.getY() > offsetY + height - 30) {
//            player1.setPosition(player1.getX(), offsetY + height - 31);
//        }


        player1.update(dt);
        player2.update(dt);
        ball.update(dt);
        level.update(dt);
        scoreboard.update(dt);
    }
}