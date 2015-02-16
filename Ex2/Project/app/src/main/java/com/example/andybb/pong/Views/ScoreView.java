package com.example.andybb.pong.Views;

import android.graphics.Canvas;
import com.example.andybb.pong.Controllers.ScoreController;
import sheep.graphics.Color;

/**
 * Created by esso on 11.02.15.
 */
public class ScoreView {
    protected ScoreController scoreController;
    private static ScoreView instance = new ScoreView(ScoreController.getInstance());

    private ScoreView(ScoreController scoreController){
        this.scoreController = scoreController;
    }

    public static ScoreView getInstance() {
        return instance;
    }

    public void update(float dt) {    }

    public void draw(Canvas canvas) {

        Color color = Color.WHITE;
        color.setTextSize(45);
        canvas.drawText(Integer.toString(scoreController.getPlayer1().getScore()), 350, 750, color);
        canvas.drawText(Integer.toString(scoreController.getPlayer2().getScore()), 650, 750, color);

        if(scoreController.isGameOver()) {
            canvas.drawText("Game over.", 500, 900, color);
        }
    }
}
