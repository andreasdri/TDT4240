package com.example.andybb.pong;

import android.graphics.Canvas;



import sheep.graphics.Color;

/**
 * Created by andybb on 25.01.15.
 */
public class Scoreboard {

    private int score1;
    private int score2;
    private boolean gameOver;


    public Scoreboard () {
        this.score1 = 0;
        this.score2 = 0;
    }


    public void reset() {
        score1 = 0;
        score2 = 0;
    }

    public boolean gameOver() {
        if(score1 == 21 || score2 == 21) {
            gameOver = true;
            return true;
        }
        gameOver = false;
        return false;
    }

    public void update(float dt) {
    }

    public void setScore1(int score) {
        this.score1 = score;
    }

    public void setScore2(int score) {
        this.score2 = score;
    }

    public void givePoint(String player) {
        if(player.equals("player2")) {
            this.score2++;

        }
        else if(player.equals("player1")) {
            this.score1++;
        }

    }


    public void draw(Canvas canvas) {

        Color color = Color.WHITE;
        color.setTextSize(45);
        canvas.drawText(Integer.toString(score1), 350, 750, color);
        canvas.drawText(Integer.toString(score2), 650, 750, color);

        if(this.gameOver) {
            canvas.drawText("Game over.", 500, 900, color);
        }





    }
}
